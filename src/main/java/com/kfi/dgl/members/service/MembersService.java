package com.kfi.dgl.members.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.members.dao.MembersDao;
import com.kfi.dgl.members.vo.MembersVo;

@Service
public class MembersService {
	@Autowired private MembersDao dao;
	public void setDao(MembersDao dao) {
		this.dao = dao;
	}
	public int insert(MembersVo vo	) {
		return dao.insert(vo);
	}
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
}
