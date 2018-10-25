package com.kfi.ysy.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.admin.dao.AdminBoardDao;
import com.kfi.ysy.admin.vo.AdminBoardVo;



@Service
public class AdminBoardService {
	@Autowired
	private AdminBoardDao dao;
	public List<AdminBoardVo> ablist(HashMap<String, Object> map){
		return dao.ablist(map);
	}
	public int abmaxcnt() {
		return dao.abmaxcnt();
	}
	public int abinsert(AdminBoardVo vo) {
		return dao.abinsert(vo);
	}
	public int abdelete(int ab_num) {
		return dao.abdelete(ab_num);
	}
	public AdminBoardVo abdetail(int ab_num) {
		return dao.abdetail(ab_num);
	}
	public int abgetcnt(HashMap<String, Object> map) {
		return dao.abgetcnt(map);
	}

}
