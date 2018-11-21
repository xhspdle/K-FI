package com.kfi.jyi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinProfileVo;


@Service
public class MyCommunityListServiceImpl implements CommonService{
	@Autowired
	private CommunityDao cdao;
	@Autowired
	private CommSkinProfileDao cspdao;

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
		HttpSession session = (HttpSession) map.get("session");
		int user_num = (Integer) session.getAttribute("user_num");

		/* mypage의 mycommunity 불러오기 */
		map.put("user_num", user_num);
		List<CommunityVo> list = cdao.select_mycommlist(map);

		/* 해당 커뮤니티의 스킨 프로필 불러오기 */
		List<CommSkinProfileVo> csplist = new ArrayList<>();
		for (CommunityVo cv : list) {
			int comm_num = cv.getComm_num();
			CommSkinProfileVo cspvo = cspdao.select_usingProfile(comm_num);
			csplist.add(cspvo);
		}
		HashMap<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("csplist", csplist);
		return result;
	}

	
	
}
