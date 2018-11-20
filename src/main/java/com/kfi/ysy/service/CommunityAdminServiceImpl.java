package com.kfi.ysy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommunityAdminDao;

@Service
public class CommunityAdminServiceImpl implements CommonService{
	@Autowired
	private CommunityAdminDao dao;
	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object select(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object list(Object data) {
		data=null;
		return (List<CommunityAdminDao>)dao.list(data);	
	}
}
