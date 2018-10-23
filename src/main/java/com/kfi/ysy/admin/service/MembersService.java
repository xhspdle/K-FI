package com.kfi.ysy.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.admin.dao.MembersDao;
import com.kfi.ysy.admin.vo.MembersVo;



@Service
public class MembersService {
	@Autowired
	private MembersDao dao;
	public List<MembersVo> mblist(){
		return dao.mblist();
	}
	public MembersVo mbgetinfo(int user_num){
		return dao.mbgetinfo(user_num);
	}
	public int mbdelete(int user_num){
		return dao.mbdelete(user_num);
	}

}
