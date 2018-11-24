package com.kfi.jyi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
	@Transactional
	public int update(Object data) {
		String cbNum=(String)data;
		int cb_num=0;
		if(cbNum!=null && !cbNum.equals("")) {
			cb_num=Integer.parseInt(cbNum);
		}
		try {
			cbdao.updateViews(cb_num);
			int result=cbdao.getViews(cb_num);
			return result;
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object data) {
		return null;
	}

	@Override
	public Object list(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
