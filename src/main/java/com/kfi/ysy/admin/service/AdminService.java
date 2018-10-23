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
	public AdminVo login(HashMap<String, String> map) {
		return dao.login(map);
	}
	public int checkid(String id) {
		return dao.checkid(id);
	}
	public int join(AdminVo vo) {
		return dao.join(vo);
	}
	
}
