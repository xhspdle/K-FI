package com.kfi.ldk.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyBoardListViewDao;
import com.kfi.ldk.vo.MyBoardListViewVo;

@Service
public class MyBoardListViewServiceImpl implements CommonViewService{
	@Autowired private MyBoardListViewDao dao;
	@Override
	public int getMaxNum() {
		return dao.getMaxNum();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCount(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return dao.getCount(map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return dao.list(map);
	}
	@Override
	public MyBoardListViewVo select(Object data) {
		int mb_num=(Integer)data;
		return dao.select(mb_num);
	}
}
