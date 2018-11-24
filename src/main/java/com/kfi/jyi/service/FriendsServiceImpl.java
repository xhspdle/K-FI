package com.kfi.jyi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
		return 0;
	}

	@Override
	public int getCount(Object data) {
		/* 친구인지 확인 */
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return fdao.getFrdNum(map);
	}

	@Override
	@Transactional
	public int insert(Object data) {
		//팔로우
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user2_num=(Integer)session.getAttribute("user_num");
		int user1_num=(Integer)map.get("user1_num");
		try {
			int frds_num=fdao.getMaxNum()+1;
			FriendsVo vo=new FriendsVo(frds_num, user1_num, user2_num, null);
			fdao.insert(vo);
			return 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		return 0;
	}

	@Override
	public int delete(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user2_num=(Integer)session.getAttribute("user_num");
		map.put("user2_num", user2_num);
		return fdao.delete(map);
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
		List<MySkinViewVo> msvlist = new ArrayList<>();
		for (FriendsVo vo : flist) {
			MySkinViewVo csv = null;
			if (map.get("user_number").equals("user1_num")) {
				csv=msvdao.select_using(vo.getUser2_num());
			} else if (map.get("user_number").equals("user2_num")) {
				csv=msvdao.select_using(vo.getUser1_num());
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
