package com.kfi.ysy.admin.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.admin.dao.AdminDao;
import com.kfi.ysy.admin.vo.AdminVo;



@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	public int admaxcnt() {
		return dao.admaxcnt();
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
	
}
