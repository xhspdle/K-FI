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
import com.kfi.jyi.dao.CommRefuseDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommRefuseVo;
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
	@Autowired
	private CommRefuseDao crfdao;

	@Override
	public int getMaxNum() {
		return 0;
	}

	@Override
	public int getCount(Object data) {
		return 0;
	}

	@Override
	@Transactional
	public int insert(Object data) {
		/* 해당 커뮤니티 가입하기 */
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) map.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		int comm_num = (Integer) map.get("comm_num");
		try {
			int cul_num = culdao.getMaxNum() + 1;
			CommUserListVo vo = new CommUserListVo(cul_num, comm_num, user_num, 1);
			culdao.insert(vo);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	@Override
	public int update(Object data) {	
		return 0;
	}
	
/*	@Override
	@Transactional
	public int update(Object data) {
		// 관리자 -> 강퇴 (-1), 취소사유에 강퇴사유 적기
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		int user_num = (Integer) map.get("user_num");
		String cr_refuse = (String) map.get("cr_refuse");
		try {
			culdao.update(map);
			int cr_num = crfdao.getMaxNum() + 1;
			CommRefuseVo vo = new CommRefuseVo(cr_num, user_num, cr_refuse);
			crfdao.insert(vo);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}*/

	@Override
	public int delete(Object data) {
		/* 해당 커뮤니티 탈퇴하기 */
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) map.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		map.put("user_num", user_num);
		return culdao.delete(map);
	}

	@Override
	public Object select(Object data) {
		/* 커뮤니티 가입유무, 강퇴유무 확인용 처리상태번호 불러오기 */
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		return culdao.getCul_status(map);
	}

	@Override
	public Object list(Object data) {
		
		
		
		return null;
	}

}
