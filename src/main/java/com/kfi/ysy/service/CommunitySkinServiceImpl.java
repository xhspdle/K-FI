package com.kfi.ysy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinCoverDao;
import com.kfi.ysy.dao.CommSkinProfileDao;

public class CommunitySkinServiceImpl implements CommonService {
	@Autowired private CommSkinCoverDao cdao;
	@Autowired private CommSkinProfileDao pdao;
	
	
	@Override
	public int getMaxNum() {
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
