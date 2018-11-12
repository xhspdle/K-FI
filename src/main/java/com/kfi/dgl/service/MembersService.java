package com.kfi.dgl.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kfi.dgl.dao.CertiMembersDao;
import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.util.Key;
import com.kfi.dgl.util.MailUtil;
import com.kfi.dgl.vo.CertiMembersVo;
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
	@Autowired
	private CertiMembersDao certiDao;
	
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

	public int idCheck(String user_id) {
		return dao.idCheck(user_id);
	}

	public int nickCheck(String user_nickname) {
		return dao.nickCheck(user_nickname);
	}

	public MembersVo emailCheck(String user_email) {
		return dao.emailCheck(user_email);
	}
	public void findId(String user_email) {
		dao.findId(user_email);
	}
	public void findPwd(MembersVo vo) {
		dao.findPwd(vo);
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
	
	public void joinsendmail(String user_email) throws MessagingException, UnsupportedEncodingException{
		MailUtil sendMail = new MailUtil(mailSender);
		sendMail.setSubject("[�̸��� ����]");
		sendMail.setText(new StringBuffer().append("<h1>��������</h1>")
				.append("<a href='http://localhost:8082/kfi/mailcert?user_email="+(user_email))
				.append("' target='_blenk'>ȸ������ �̸��� ���� Ȯ��</a>").toString());
		sendMail.setFrom("tester241192@gmail.com", "��������~!");
		sendMail.setTo(user_email);
		sendMail.send();
		System.out.println("ȸ������ �̸��� ����");
	}
	//����Ű
	public void createkey(String user_email) throws Exception {
		MembersVo vo=dao.emailCheck(user_email);
		String cm_key = new Key().getKey(25, false); // ����Ű ����
		certiDao.insert(new CertiMembersVo(certiDao.getMaxNum() + 1, vo.getUser_num(), cm_key)); // ����Ű DB ����
		System.out.println("���ϰ�ü�������");
		MailUtil sendMail = new MailUtil(mailSender);
		System.out.println("���ϰ�ü�ͱ�");
		sendMail.setText(new StringBuffer().append("<h1>��������</h1>")
				.append("<a href='http://localhost:8082/kfi/mailcert?user_email=")
				.append(user_email).append("&key=").append(cm_key)
				.append("' target='_blenk'>�̸��� ���� Ȯ��</a>").toString());
		sendMail.setFrom("tester112492@gmail.com", "������");
		sendMail.setTo(user_email);
		sendMail.send();
		System.out.println("���Ϻ���");
	}

/*	public void tempemail()*/
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