package com.kfi.ysy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinCoverDao;
import com.kfi.ysy.vo.CommSkinCoverVo;

@Service
public class InCommSkinServiceImpl implements CommonService{
	@Autowired private CommSkinCoverDao cscdao;
	@Autowired private CommunityDao cdao;
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
		int comm_num=(Integer)data;
		CommunityVo cvo = cdao.select_comm(comm_num);
		CommSkinCoverVo cscvo = cscdao.select(comm_num);
		
		return 1;
	}

	@Override
	public Object list(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
