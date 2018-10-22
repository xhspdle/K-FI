package com.kfi.ldk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyBoardDao;
import com.kfi.ldk.vo.MyBoardVo;

@Service
public class MyBoardService {
	@Autowired private MyBoardDao dao;
	public int getMaxnum() {
		return dao.getMaxnum();
	}
	public int insert(MyBoardVo vo) {
		return dao.insert(new MyBoardVo(getMaxnum(), vo.getUser_num(),
				vo.getMb_title(), vo.getMb_content(), null, 0));
	}
}
