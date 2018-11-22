package com.kfi.ysy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinProfileVo;

public class CommSkinProfileServiceImpl implements CommonService {
	@Autowired private CommSkinProfileDao cspdao;
	@Override
	public int getMaxNum() {
		return cspdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object data) {
		CommSkinProfileVo vo=(CommSkinProfileVo)data;
		return cspdao.insert(vo);
	}

	@Override
	public int update(Object data) {
		CommSkinProfileVo vo=(CommSkinProfileVo)data;
		return 1;
	}

	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object data) {
		int comm_num=(Integer)data;
		/*return cspdao.select(comm_num);*/
		return null;
	}
	
	@Override
	public Object list(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
