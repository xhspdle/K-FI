package com.kfi.ysy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.dao.AdminDao;
import com.kfi.ysy.vo.AdminVo;



@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	public int abmaxnum() {
		return dao.abmaxnum();
	}
	public AdminVo adlogin(HashMap<String, String> map) {	
		return dao.adlogin(map); 
	}
	public int adcheckid(String id) {
		return dao.adcheckid(id);
	}
	public int adjoin(AdminVo vo) {
		return dao.adjoin(vo);
	}
	public List<AdminVo> adminlist(){
		return dao.adminlist();
	}
	public AdminVo addetail(int admin_num) {
		return dao.addetail(admin_num);
	}
	public int admodify(AdminVo vo) {
		return dao.admodify(vo);
	}
}
