package com.kfi.jyi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.FriendsDao;
import com.kfi.jyi.dao.MySkinViewDao;
import com.kfi.jyi.vo.FriendsVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Service
public class FriendsServiceImpl implements CommonService {
	@Autowired
	private FriendsDao fdao;
	@Autowired
	private MySkinViewDao msvdao;
	@Autowired private MembersDao mdao;
	
	
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
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		List<FriendsVo> flist = fdao.list(map);
		System.out.println(flist.toString());
		List<MySkinViewVo> msvlist = new ArrayList<>();
		HashMap<String, Object> hm = new HashMap<>();
		for (FriendsVo vo : flist) {
			if (map.get("user_number").equals("user1_num")) {
				hm.put("user_num", vo.getUser1_num());
			} else if (map.get("user_number").equals("user2_num")) {
				hm.put("user_num", vo.getUser2_num());
			}
			hm.put("ms_using", 1);
			List<MySkinViewVo> msvl = msvdao.list(hm);
			MySkinViewVo csv = null;
			for (MySkinViewVo csvv : msvl) {
				csv=csvv;
			}
			msvlist.add(csv);
		}
		List<MembersVo> mvolist=new ArrayList<>();
		for(MySkinViewVo vo : msvlist) {
			MembersVo memvo=mdao.select(vo.getUser_num());
			mvolist.add(memvo);
		}
		HashMap<String, Object> result = new HashMap<>();
		result.put("msvlist", msvlist);
		result.put("mvolist", mvolist);
		return result;
	}

}
