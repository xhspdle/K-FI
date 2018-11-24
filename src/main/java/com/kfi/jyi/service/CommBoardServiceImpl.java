package com.kfi.jyi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.CommBoardDao;
import com.kfi.jyi.dao.CommBoardLikeDao;
import com.kfi.jyi.dao.CommBoardViewDao;
import com.kfi.jyi.dao.CommCommentDao;
import com.kfi.jyi.dao.CommPhotoDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommVideoDao;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.dao.MySkinViewDao;
import com.kfi.jyi.util.PageUtil;
import com.kfi.jyi.vo.CommBoardCntVo;
import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.CommBoardProfileVo;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommUserListVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.dao.CommTagDao;
import com.kfi.ldk.dao.TagDao;
import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.CommTagVo;
import com.kfi.ldk.vo.TagVo;
import com.kfi.ysy.dao.CommSkinCoverDao;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinCoverVo;
import com.kfi.ysy.vo.CommSkinProfileVo;
import com.sun.mail.handlers.multipart_mixed;

@Service
public class CommBoardServiceImpl implements CommonService {
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
	private CommBoardDao cbdao;
	@Autowired
	private CommPhotoDao cpdao;
	@Autowired
	private CommVideoDao cvdao;
	@Autowired
	private TagDao tdao;
	@Autowired
	private CommTagDao commtdao;
	@Autowired
	private CommBoardLikeDao cbldao;
	@Autowired
	private MySkinViewDao msvdao;
	@Autowired
	private MembersDao mdao;
	@Autowired
	private CommCommentDao ccdao;

	@Override
	public int getMaxNum() {
		return cbdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		return 0;
	}

	@Override
	@Transactional
	public int insert(Object data) {
		/* 새 게시글 등록 */
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) map.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		int comm_num = (Integer) session.getAttribute("comm_num");
		String cb_title = (String) map.get("cb_title");
		String cb_content = (String) map.get("cb_content");
		String cb_notice = (String) map.get("cb_notice");
		int cbNotice = 0;
		if (cb_notice != null) {
			cbNotice = 1;
		}
		String[] tag_name = (String[]) map.get("tag_name");
		MultipartFile[] fileP = (MultipartFile[]) map.get("fileP");
		MultipartFile[] fileV = (MultipartFile[]) map.get("fileV");

		ArrayList<String> fileP_list = new ArrayList<>();
		ArrayList<String> fileV_list = new ArrayList<>();
		String uploadPathPhoto = session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathVideo = session.getServletContext().getRealPath("/resources/upload/vid");
		System.out.println("uploadPathPhoto: " + uploadPathPhoto);
		System.out.println("uploadPathVideo: " + uploadPathVideo);
		try {
			int cb_num = getMaxNum() + 1;
			CommBoardVo cbvo = new CommBoardVo(cb_num, comm_num, user_num, cb_title, cb_content, null, cbNotice, 0);
			cbdao.insert(cbvo);
			if (!fileP[0].isEmpty()) {
				for (int i = 0; i < fileP.length; i++) {
					int cp_num = cpdao.getMaxNum() + 1;
					String cp_orgimg = fileP[i].getOriginalFilename();
					if (cp_orgimg.equals(""))
						continue;
					String cp_savimg = UUID.randomUUID() + "_" + cp_orgimg;
					fileP_list.add(cp_savimg);
					InputStream is = fileP[i].getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPathPhoto + "\\" + cp_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					CommPhotoVo cpvo = new CommPhotoVo(cp_num, cb_num, cp_orgimg, cp_savimg);
					cpdao.insert(cpvo);
				}
			}
			if (!fileV[0].isEmpty()) {
				for (int i = 0; i < fileV.length; i++) {
					int cv_num = cvdao.getMaxNum() + 1;
					String cv_orgvid = fileV[i].getOriginalFilename();
					if (cv_orgvid.equals(""))
						continue;
					String cv_savvid = UUID.randomUUID() + "_" + cv_orgvid;
					fileV_list.add(cv_savvid);
					InputStream is = fileV[i].getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPathVideo + "\\" + cv_savvid);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					CommVideoVo cvvo = new CommVideoVo(cv_num, cb_num, cv_orgvid, cv_savvid);
					cvdao.insert(cvvo);
				}
			}
			if (tag_name != null) {
				for (int i = 0; i < tag_name.length; i++) {
					System.out.println(tag_name[i]);
					int tagCount = tdao.getTagCountNum(tag_name[i]);
					int tag_num = 0;
					if (tagCount == 0) {
						tag_num = tdao.getMaxNum() + 1;
						TagVo newtvo = new TagVo(tag_num, tag_name[i]);
						tdao.insert(newtvo);
					} else {
						TagVo tvo = tdao.select(tag_name[i]);
						tag_num = tvo.getTag_num() + 1;
					}
					int ctag_num = commtdao.getMaxNum() + 1;
					CommTagVo ctvo = new CommTagVo(ctag_num, tag_num, cb_num);
					commtdao.insert(ctvo);
				}
			}

			return 1;
		} catch (Exception e) {
			for (String deleteImg : fileP_list) {
				File filePhoto = new File(uploadPathPhoto + "\\" + deleteImg);
				if (filePhoto.delete()) {
					System.out.println("파일 삭제");
				}
			}
			for (String deleteVid : fileV_list) {
				File fileVideo = new File(uploadPathVideo + "\\" + deleteVid);
				if (fileVideo.delete()) {
					System.out.println("파일 삭제");
				}
			}
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	@Transactional
	public int update(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) map.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		int cb_num = (Integer) map.get("cb_num");
		String cb_title = (String) map.get("cb_title");
		String cb_content = (String) map.get("cb_content");
		String cbNotice = (String) map.get("cb_notice");
		int cb_notice = -1;
		if (cbNotice != null && !cbNotice.equals("")) {
			cb_notice = Integer.parseInt(cbNotice);
		}
		String[] del_Tags = (String[]) map.get("del_Tags");
		String[] tag_name = (String[]) map.get("tag_name");

		ArrayList<MultipartFile> photoFile = new ArrayList<>();
		photoFile.add((MultipartFile) map.get("fileP1"));
		photoFile.add((MultipartFile) map.get("fileP2"));
		photoFile.add((MultipartFile) map.get("fileP3"));
		photoFile.add((MultipartFile) map.get("fileP4"));
		photoFile.add((MultipartFile) map.get("fileP5"));

		ArrayList<MultipartFile> videoFile = new ArrayList<>();
		videoFile.add((MultipartFile) map.get("fileV1"));
		videoFile.add((MultipartFile) map.get("fileV2"));

		String uploadPathPhoto = session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathVideo = session.getServletContext().getRealPath("/resources/upload/vid");

		ArrayList<String> deletePhoto = new ArrayList<>();
		ArrayList<String> deleteVideo = new ArrayList<>();
		try {
			CommBoardVo vo = new CommBoardVo(cb_num, 0, user_num, cb_title, cb_content, null, cb_notice, 0);
			cbdao.update(vo);

			List<CommPhotoVo> PhotoList = cpdao.select(cb_num);
			List<CommVideoVo> VideoList = cvdao.select(cb_num);

			// filePhotoList
			int psize=PhotoList.size();
			int vsize=VideoList.size();
			for (int i = 0; i < 5; i++) {
				if (photoFile.get(i)!=null) {
					String cp_orgimg = photoFile.get(i).getOriginalFilename();
					if (cp_orgimg.equals("")) {
						System.out.println("6");
						continue;
					}
					String cp_savimg = UUID.randomUUID() + "_" + cp_orgimg;
					deletePhoto.add(cp_savimg);
					InputStream is = photoFile.get(i).getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPathPhoto + "\\" + cp_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					if(psize>=(i+1)) {
						int cp_num = PhotoList.get(i).getCp_num();
						CommPhotoVo cpvo = new CommPhotoVo(cp_num, cb_num, cp_orgimg, cp_savimg);
						cpdao.update(cpvo);
						File f = new File(uploadPathPhoto + "\\" + PhotoList.get(i).getCp_savimg());
						if (f.delete()) {
							System.out.println("이전 파일 삭제 완료");
						} else {
							System.out.println("이전 파일 삭제 실패");
						}
					}else if(psize < (i+1)){
						int cp_num=cpdao.getMaxNum()+1;
						CommPhotoVo newPvo=new CommPhotoVo(cp_num, cb_num, cp_orgimg, cp_savimg);
						System.out.println("10");
						cpdao.insert(newPvo);
					}
				}
			}

			// fileVideoList
			for (int i = 0; i < 2; i++) { 
				if (videoFile.get(i)!=null) {
					String cv_orgvid = videoFile.get(i).getOriginalFilename();
					if (cv_orgvid.equals("")) {
						continue;
					}
					String cv_savvid = UUID.randomUUID() + "_" + cv_orgvid;
					deleteVideo.add(cv_savvid);
					InputStream is = videoFile.get(i).getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadPathVideo + "\\" + cv_savvid);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					if(vsize >= (i+1)) {
						int cv_num = VideoList.get(i).getCv_num();
						CommVideoVo cvvo = new CommVideoVo(cv_num, cb_num, cv_orgvid, cv_savvid);
						cvdao.update(cvvo);
						File ff = new File(uploadPathVideo + "\\" + VideoList.get(i).getCv_savvid());
						if (ff.delete()) {
							System.out.println("이전 영상 삭제 완료");
						} else {
							System.out.println("이전 영상 삭제 실패");
						}
					}else if(vsize < (i+1)) {
						int cv_num=cvdao.getMaxNum()+1;
						CommVideoVo newVvo=new CommVideoVo(cv_num, cb_num, cv_orgvid, cv_savvid);
						cvdao.insert(newVvo);
					}
				}
			}
			
			// DelTagList
			if (!del_Tags[0].isEmpty()) {
				for (String delTag : del_Tags) {
					int delNum = Integer.parseInt(delTag);
					HashMap<String, Object> delMap = new HashMap<>();
					delMap.put("cb_num", cb_num);
					delMap.put("tag_num", delNum);
					commtdao.delete_TagNum(delMap);
				}
			}

			// tagList
			if (!tag_name[0].isEmpty()) {
				for (int i = 0; i < tag_name.length; i++) {
					int tagCount = tdao.getTagCountNum(tag_name[i]);
					int tag_num = 0;
					if (tagCount == 0) {
						tag_num = tdao.getMaxNum() + 1;
						TagVo newtvo = new TagVo(tag_num, tag_name[i]);
						tdao.insert(newtvo);
						int ctag_num = commtdao.getMaxNum() + 1;
						CommTagVo ctvo = new CommTagVo(ctag_num, tag_num, cb_num);
						commtdao.insert(ctvo);
					} else {
						TagVo tvo = tdao.select(tag_name[i]);
						HashMap<String, Object> checkTagNum = new HashMap<>();
						checkTagNum.put("tag_num", tvo.getTag_num());
						checkTagNum.put("cb_num", cb_num);
						CommTagVo checkVo = commtdao.select_tagNum(checkTagNum);
						if (checkVo == null) {
							// 새로운 태그 추가
							int ctag_num = commtdao.getMaxNum() + 1;
							CommTagVo ctvo = new CommTagVo(ctag_num, tag_num, cb_num);
							commtdao.insert(ctvo);
						}
					}
				}
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());

			for (String delF : deletePhoto) {
				File ff = new File(uploadPathPhoto + "\\" + delF);
				if (ff.delete()) {
					System.out.println("커뮤니티 업데이트 실패, 업로드 파일-photo 삭제");
				}
			}
			for (String delV : deleteVideo) {
				File ff = new File(uploadPathVideo + "\\" + delV);
				if (ff.delete()) {
					System.out.println("커뮤니티 업데이트 실패, 업로드 파일-video 삭제");
				}
			}
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}

	}

	@Override
	public int delete(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		String cbNum = (String) map.get("cb_num");
		int cb_num = 0;
		if (cbNum != null && !cbNum.equals(""))
			cb_num = Integer.parseInt(cbNum);
		String userPwd = (String) map.get("user_pwd");
		int user_pwd = 0;
		if (userPwd != null && !userPwd.equals(""))
			user_pwd = Integer.parseInt(userPwd);
		int result = cbdao.commBoard_checkPwd(map);
		if (result > 0) {
			return cbdao.delete(cb_num);
		} else {
			return -1;
		}
	}

	@Override
	public Object select(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		String list = (String) map.get("list");
		HttpSession session = (HttpSession) map.get("session");
		int comm_num = (Integer) session.getAttribute("comm_num");
		map.put("comm_num", comm_num);
		if (list.equals("select")) {
			// 게시글 상세보기
			int cb_num = (Integer) map.get("cb_num");
			HashMap<String, Object> result = new HashMap<>();
			CommBoardVo cbvo = cbdao.select(cb_num);
			List<CommPhotoVo> imgList = cpdao.select(cb_num);
			List<CommVideoVo> vidList = cvdao.select(cb_num);
			List<CommBoardLikeVo> cblList = cbldao.select(cb_num);
			List<MySkinViewVo> msvList = new ArrayList<>();
			int writer = cbvo.getUser_num();
			MySkinViewVo writervo = msvdao.select_using(writer);
			for (CommBoardLikeVo vo : cblList) {
				MySkinViewVo msvo = msvdao.select_using(vo.getUser_num());
				msvList.add(msvo);
			}
			MembersVo vo = mdao.select(writer);
			int likeNum = 0;
			for (CommBoardLikeVo cblvo : cblList) {
				++likeNum;
			}
			List<TagVo> tagList = tdao.getCommTag(cb_num);
			int commentCnt = ccdao.select_CommentNum(cb_num);

			result.put("cbvo", cbvo); // 게시글
			result.put("imgList", imgList); // 게시글 사진
			result.put("vidList", vidList); // 게시글 비디오
			result.put("cblList", cblList); // 게시글 추천
			result.put("msvList", msvList); // 추천 유저 skin view
			result.put("vo", vo); // 작성자 회원 정보
			result.put("writervo", writervo); // 작성자 회원 skin view
			result.put("likeNum", likeNum); // 추천수
			result.put("tagList", tagList); // 태그리스트
			result.put("commentCnt", commentCnt); // 댓글수
			int prevCbNum = cbdao.prevCbNum(map);
			int nextCbNum = cbdao.nextCbNum(map);
			result.put("prevCbNum", prevCbNum); // 이전 게시글 번호
			result.put("nextCbNum", nextCbNum); // 다음 게시글 번호

			return result;
		} else if (list.equals("notice")) {
			// 공지사항 불러오기
			return cbdao.getNotice(comm_num);
		}
		return null;
	}

	@Override
	public Object list(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		String type = (String) map.get("type");
		HttpSession session = (HttpSession) map.get("session");
		int pageNum = (Integer) map.get("pageNum");
		int comm_num = (Integer) map.get("comm_num");
		int totalRowCount = cbdao.totalRowCount_commBoardList(comm_num);
		PageUtil page = new PageUtil(pageNum, totalRowCount, 5, 5);
		int startRow = page.getStartRow();
		int endRow = page.getEndRow();

		map.put("startRow", startRow); // maxRow
		map.put("endRow", endRow); // maxRow-5

		List<CommBoardVo> list = new ArrayList<>();

		if (type.equals("main")) {
			list = cbdao.list(map);
		} else if (type.equals("views")) {
			list = cbdao.list_Views(map);
		}

		List<CommBoardProfileVo> proflist = new ArrayList<>();
		List<CommBoardCntVo> cbclist = new ArrayList<>();
		List<CommPhotoVo> cplist = new ArrayList<>();
		List<CommVideoVo> cvlist = new ArrayList<>();

		for (CommBoardVo vo : list) {
			CommBoardCntVo cntvo = cbdao.getBoardCnt(vo.getCb_num());
			cbclist.add(cntvo);
			CommBoardProfileVo cbpvo = cbdao.getCommBoardProfile(vo.getCb_num());
			proflist.add(cbpvo);
			CommPhotoVo pvo = cpdao.getBoardPhoto1(vo.getCb_num());
			cplist.add(pvo);
			CommVideoVo cvo = cvdao.getCommVideo1(vo.getCb_num());
			cvlist.add(cvo);
		}

		HashMap<String, Object> result = new HashMap<>();
		result.put("list", list);// 게시글
		result.put("proflist", proflist); // 게시글 작성자 프로필
		result.put("cbclist", cbclist); // 게시글 좋아요, 댓글수, 조회수
		result.put("cplist", cplist); // 게시글 사진
		result.put("cvlist", cvlist); // 게시글 비디오

		return result;
	}

}
