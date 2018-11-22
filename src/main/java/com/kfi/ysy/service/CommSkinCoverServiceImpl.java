package com.kfi.ysy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinCoverDao;


public class CommSkinCoverServiceImpl implements CommonService {
	@Autowired private CommSkinCoverDao cdao;
	@Override
	public int getMaxNum() {
		return cdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object data) {
		

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
