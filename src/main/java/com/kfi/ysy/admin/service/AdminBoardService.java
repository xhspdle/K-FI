package com.kfi.ysy.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.admin.dao.AdminBoardDao;
import com.kfi.ysy.admin.vo.AdminBoardVo;



@Service
public class AdminBoardService {
	@Autowired
	private AdminBoardDao dao;
	public List<AdminBoardVo> ablist(){
		return dao.ablist();
	}
}
