package com.kfi.dgl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.kfi.dgl.dao.MembersDao;
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

	// admin에서 사용
	public List<MembersVo> list(HashMap<String, Object> map) {
		return dao.list(map);
	}

	public int delete(int num) {
		return dao.delete(num);
	}

	/*
	 * public MembersVo select(vo) { return dao.select(vo); }
	 */
	public int update(MembersVo vo) {
		return dao.update(vo);
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

	public int getverify(MembersVo vo) {
		return dao.verify(vo);
	}

	public int createKey(String user_email) {
		return dao.createKey(user_email);
	}

	public int idcheck(String user_id) {
		return dao.idCheck(user_id);
	}

	public int nickcheck(String user_nickname) {
		return dao.nickCheck(user_nickname);
	}

	public MembersVo select(int user_num) {
		return dao.select(user_num);
	}
	public int update(int user_num) {
		return dao.update(user_num);
	}

////////////////////////////회원가입 정상완료 후 myskin테이블에 디폴트값 넣기
	@Transactional
	public int insertMyskin(MySkinVo msvo) {
		try {
			int ms_num = msdao.getMaxNum();
			if (ms_num < 0)
				throw new Exception("error: myskin's getMaxNum");
			msvo.setMs_num(ms_num + 1);
			int myskinOk = msdao.insert(msvo);
			if (myskinOk < 0)
				throw new Exception("error: myskin's insert");
			int msc_num = mscdao.getMaxNum();
			if (msc_num < 0)
				throw new Exception("error: myskinCover's getMaxNum");
			int myskincoverOk = mscdao.insert(new MySkinCoverVo(msc_num + 1, ms_num + 1, "", ""));
			if (myskincoverOk < 0)
				throw new Exception("error: myskinCover's insert");
			int msp_num = mspdao.getMaxNum();
			if (msp_num < 0)
				throw new Exception("error: myskinProfile's getMaxNum");
			int myskinprofileOk = mspdao.insert(new MySkinProfileVo(msp_num + 1, ms_num + 1, "", ""));
			if (myskinprofileOk < 0)
				throw new Exception("error: myskinProfile's insert");
			return 1;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}
}
