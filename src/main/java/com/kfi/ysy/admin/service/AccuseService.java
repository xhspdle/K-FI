package com.kfi.ysy.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.admin.dao.AccuseDao;
import com.kfi.ysy.admin.vo.AccuseVo;


@Service
public class AccuseService {
	@Autowired
	private AccuseDao dao;
	public List<AccuseVo> aclist(){
		return dao.aclist();
	}
}
