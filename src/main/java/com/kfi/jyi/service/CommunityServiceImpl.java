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
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;

import com.kfi.jyi.dao.CommBoardViewDao;
import com.kfi.jyi.dao.CommPhotoDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommVideoDao;
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
public class CommunityServiceImpl implements CommonService {
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
	private CommPhotoDao cpdao;
	
	@Autowired
	private CommVideoDao cvdao;
	
	
	
	@Override
	public int getMaxNum() {
		/* 전체 커뮤니티 최대 갯수 구하기 */
		return cdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int insert(Object data) {
		/* 새 커뮤니티 등록하기 */
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) map.get("session");
		String comm_name = (String) map.get("comm_name");
		String comm_content = (String) map.get("comm_content");
		String cs_color = (String) map.get("cs_color");
		MultipartFile comm_skin_profile = (MultipartFile) map.get("comm_skin_profile");
		MultipartFile comm_skin_cover = (MultipartFile) map.get("comm_skin_cover");

		String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");

		int comm_num = getMaxNum() + 1;
		int user_num = (Integer) session.getAttribute("user_num");
		CommunityVo cvo = new CommunityVo(comm_num, user_num, comm_name, comm_content, cs_color, null);
		ArrayList<String> deleteFile = new ArrayList<>();
		try {
			int result = cdao.insert(cvo);
			if (result > 0) {
				int cul_num = culdao.getMaxNum() + 1;
				CommUserListVo culvo = new CommUserListVo(cul_num, comm_num, user_num, 1);
				culdao.insert(culvo);
				int csp_num = cspdao.getMaxNum() + 1;
				String csp_orgimg = "default-profile.png";
				String csp_savimg = "default-profile.png";
				photo:if (!comm_skin_profile.isEmpty()) {
					csp_orgimg = comm_skin_profile.getOriginalFilename();
					if(csp_orgimg.equals("")) break photo;
					csp_savimg = UUID.randomUUID() + "_" + csp_orgimg;
					InputStream is = comm_skin_profile.getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + csp_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					deleteFile.add(csp_savimg);
				}
				CommSkinProfileVo cspvo = new CommSkinProfileVo(csp_num, comm_num, csp_orgimg, csp_savimg, 1);
				cspdao.insert(cspvo);
				int csc_num = cscdao.getMaxNum() + 1;
				String csc_orgimg = "logo2.png";
				String csc_savimg = "logo2.png";
				cover: if (!comm_skin_cover.isEmpty()) {
					csc_orgimg = comm_skin_cover.getOriginalFilename();
					if(csc_orgimg.equals("")) break cover;
					csc_savimg = UUID.randomUUID() + "_" + csc_orgimg;
					InputStream is = comm_skin_cover.getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + csc_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					deleteFile.add(csc_savimg);
				}
				CommSkinCoverVo cscvo = new CommSkinCoverVo(csc_num, comm_num, csc_orgimg, csc_savimg, 1);
				cscdao.insert(cscvo);
				return 1;
			} else {
				throw new Exception("community insert error");
			}
		} catch (Exception e) {
			if (deleteFile != null) {
				for (int i = 0; i < deleteFile.size(); i++) {
					File file = new File(uploadPath + deleteFile.get(i));
					if (file.delete())
						System.out.println("커뮤니티 insert 트랜잭션 실패 -> 파일 삭제 성공");
				}
			}
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		CommunityVo vo=(CommunityVo)data;
		return cdao.update(vo);
	}

	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object data) {
		//관리자 번호 가져오기
		int comm_num=(Integer)data;
		return cdao.select_adminNum(comm_num);
	}

	@Override
	public Object list(Object data) {
		String list = (String) data;
		HashMap<String, Object> map = new HashMap<>();
		/* best6 커뮤니티 목록 불러오기 */
		if (list.equals("bestSix")) {
			List<CommunityVo> bestSix = cdao.bestSix();
			map.put("list", bestSix);
			
			/* 해당 커뮤니티의 스킨 프로필 불러오기 */
			List<CommSkinProfileVo> csplist = new ArrayList<>();
			for (CommunityVo cv : bestSix) {
				int comm_num = cv.getComm_num();
				CommSkinProfileVo cspvo = cspdao.select_usingProfile(comm_num);
				csplist.add(cspvo);
			}
			map.put("csplist", csplist);

			return map;
		}else if(list.equals("list")) {
			/* 전체 커뮤니티 목록 불러오기 */
			List<CommunityVo> clist = cdao.list();
			map.put("clist", clist);

			List<CommSkinProfileVo> csplist = new ArrayList<>();
			for (CommunityVo cv : clist) {
				int comm_num = cv.getComm_num();
				CommSkinProfileVo cspvo = cspdao.select_usingProfile(comm_num);
				csplist.add(cspvo);
			}
			map.put("csplist", csplist);
			return map;
		}else if(list.equals("hotPhoto3")) {
			return cpdao.hotPhoto3();
		}else if(list.equals("hotVideo")) {
			return cvdao.hotVideo();
		}
		return null;
	}
}
