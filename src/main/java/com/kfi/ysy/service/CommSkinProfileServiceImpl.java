package com.kfi.ysy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinProfileVo;
@Service
public class CommSkinProfileServiceImpl implements CommonService {
	@Autowired private CommSkinProfileDao cspdao;
	@Autowired private CommunityDao cdao;
	@Autowired private MembersDao mdao;
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
		CommSkinProfileVo cspvo=cspdao.select(comm_num);
		CommunityVo cvo=cdao.select_comm(comm_num);
		int admin_num=cvo.getUser_num();
		MembersVo mvo=mdao.select(admin_num);
		HashMap<String, Object> map=new HashMap<>();
		map.put("cvo", cvo);
		map.put("cspvo", cspvo);
		map.put("mvo",mvo);
		return map; 
	}
	
	@Override
	public Object list(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
