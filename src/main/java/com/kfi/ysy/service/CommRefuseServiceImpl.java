package com.kfi.ysy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.CommRefuseDao;
import com.kfi.jyi.vo.CommRefuseVo;
import com.kfi.ldk.service.CommonService;

@Service
public class CommRefuseServiceImpl implements CommonService {
	@Autowired
	private CommRefuseDao dao;
	@Override
	public int getMaxNum() {
		return dao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object data) {
		CommRefuseVo vo=(CommRefuseVo)data; 
		int cr_num=getMaxNum()+1;
		vo.setCr_num(cr_num);
		int result=dao.insert(vo);
		System.out.println(cr_num);
		System.out.println(result);
		
		return dao.insert(vo);
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
