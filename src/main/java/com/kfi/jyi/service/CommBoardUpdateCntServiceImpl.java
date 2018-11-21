package com.kfi.jyi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.CommBoardDao;
import com.kfi.ldk.service.CommonService;

@Service
public class CommBoardUpdateCntServiceImpl implements CommonService{
	@Autowired 
	private CommBoardDao cbdao;
	
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
		String cbNum=(String)data;
		int cb_num=0;
		if(cbNum!=null && !cbNum.equals("")) {
			cb_num=Integer.parseInt(cbNum);
		}
		return cbdao.updateViews(cb_num);
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
