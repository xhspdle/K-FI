package com.kfi.dgl.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.vo.MembersVo;

@Service
public class MembersService {
	@Autowired private MembersDao dao;
	public void setDao(MembersDao dao) {
		this.dao = dao;
	}

	public int insert(MembersVo vo) {
		return dao.insert(vo);
	}
	//admin에서 사용
	public List<MembersVo> list(){
		return dao.list();
	}
	public int delete(int num) {
		return dao.delete(num);
	}
	/*public MembersVo select(vo) {
		return dao.select(vo);
	}*/
	public int update(MembersVo vo) {
		return dao.update(vo);
	}
	public MembersVo login(HashMap<String, Object> map) {
		return dao.login(map);
		
	}
	public int getMaxcnt() {
		return dao.getMaxnum();
	}
	public int getCnt() {
		return dao.getCtn();
	}
	public int getverify(MembersVo vo) {
		return dao.verify(vo);
	}
	public int createKey(String user_email) {
		return dao.createKey(user_email);
	}

	public int idcheck(String user_id) {
		return dao.idCheck();
	}
}
