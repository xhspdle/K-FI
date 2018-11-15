package com.kfi.jyi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;

import com.kfi.jyi.dao.CommBoardViewDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommUserListVo;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinCoverDao;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinCoverVo;
import com.kfi.ysy.vo.CommSkinProfileVo;

@Service
public class InsideCommunityServiceImpl implements CommonService {
	@Autowired
	private CommunityDao cdao;
	@Autowired
	private CommSkinCoverDao cscdao;
	@Autowired
	private CommSkinProfileDao cspdao;
	@Autowired
	private CommUserListDao culdao;
	@Autowired
	private CommBoardViewDao cbvdao;

	@Override
	public int getMaxNum() {
		return 0;
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int insert(Object data) {
		/* 해당 커뮤니티 가입하기 */
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
		/* 해당 커뮤니티 게시물 불러오기(전체, 상세보기 공용) */
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		return cbvdao.select(map);
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
