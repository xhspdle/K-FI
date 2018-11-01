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

	public int join(MembersVo vo) {
		return dao.join(vo);
	}
	//admin에서 사용
	public List<MembersVo> list(HashMap<String, Object> map){
		return dao.list(map);
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
}
