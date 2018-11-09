package com.kfi.dgl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.util.Key;
import com.kfi.dgl.util.MailUtil;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.MySkinCoverDao;
import com.kfi.jyi.dao.MySkinDao;
import com.kfi.jyi.dao.MySkinProfileDao;
import com.kfi.jyi.vo.MySkinCoverVo;
import com.kfi.jyi.vo.MySkinProfileVo;
import com.kfi.jyi.vo.MySkinVo;

@Service
public class MembersService {
	@Autowired
	private MembersDao dao;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MySkinDao msdao;
	@Autowired
	private MySkinCoverDao mscdao;
	@Autowired
	private MySkinProfileDao mspdao;
	
	public void setDao(MembersDao dao) {
		this.dao = dao;
	}

	public int join(MembersVo vo) {
		return dao.join(vo);
	}

	public MembersVo login(HashMap<String, Object> map) {
		return dao.login(map);

	}

	public int getMaxnum() {
		return dao.getMaxnum();
	}

	public int getCnt(HashMap<String, Object> map) {
		return dao.getCnt(map);
	}

	public int getverify(String user_email) {
		return dao.verify(user_email);
	}

	public int createKey(String user_email) {
		return dao.createKey(user_email);
	}

	public int idCheck(String user_id) {
		return dao.idCheck(user_id);
	}

	public int nickCheck(String user_nickname) {
		return dao.nickCheck(user_nickname);
	}

	public int emailCheck(String user_email) {
		return dao.emailCheck(user_email);
	}
	public String findId(String user_email) {
		return dao.findId(user_email);
	}
	public int findPwd(String user_id) {
		return dao.findPwd(user_id);
	}
	// admin���� ���
	public MembersVo select(int user_num) {
		return dao.select(user_num);
	}

	public List<MembersVo> list(HashMap<String, Object> map) {
		return dao.list(map);
	}

	public int update(MembersVo vo) {
		return dao.update(vo);
	}

	public int delete(int user_num) {
		return dao.delete(user_num);
	}
	//����Ű
	@Transactional
	public void createkey(MembersVo vo) throws Exception {

		String key = new Key().getKey(50, false); // ����Ű ����

		dao.createKey(vo.getUser_email()); // ����Ű DB ����

		MailUtil sendMail = new MailUtil(mailSender);

		sendMail.setText(new StringBuffer().append("<h1>��������</h1>")
				.append("<a href='http://localhost:9090/kfi/mailcert?user_email=" + vo.getUser_email())
				.append("' target='_blenk'>�̸��� ���� Ȯ��</a>").toString());

		sendMail.setFrom("tester112492@gmail.com", "������");
		sendMail.setTo(vo.getUser_email());
		sendMail.send();
	}
////////////////////////////ȸ������ ����Ϸ� �� myskin���̺� ����Ʈ�� �ֱ�
	@Transactional
	public int insertMyskin(MySkinVo msvo) {
		try {
			int ms_num = msdao.getMaxNum();
			msvo.setMs_num(ms_num + 1);
			msdao.insert(msvo);
			int msc_num = mscdao.getMaxNum();
			mscdao.insert(new MySkinCoverVo(msc_num + 1, ms_num + 1, "logo2.png", "logo2.png"));
			int msp_num = mspdao.getMaxNum();
			mspdao.insert(new MySkinProfileVo(msp_num + 1, ms_num + 1, "default-profile.png", "default-profile.png"));
			return 1;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}
	
////////////////////////////���������� ȸ������ �ҷ�����
	public String passwordOk(int user_num, String password) {
		MembersVo vo=dao.select(user_num);
		if(vo.getUser_pwd().equals(password)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
}
