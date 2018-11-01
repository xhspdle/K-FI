package com.kfi.ysy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.dao.AccuseDao;
import com.kfi.ysy.vo.AccuseVo;


@Service
public class AccuseService {
	@Autowired
	private AccuseDao dao;
	public List<AccuseVo> aclist(HashMap<String, Object> map){
		return dao.aclist(map);
	}
	public int acgetcnt(HashMap<String, Object> map) {
		return dao.acgetcnt(map);
	}
	public int acdelete(int ac_num) {
		return dao.acdelete(ac_num);
	}
	public AccuseVo acdetail(int ac_num) {
		return dao.acdetail(ac_num);
	}
}
