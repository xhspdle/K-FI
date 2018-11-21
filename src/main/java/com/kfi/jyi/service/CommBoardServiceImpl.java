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
	@Autowired private CommPhotoDao cpdao;
	@Autowired private CommVideoDao cvdao;
	@Autowired private TagDao tdao;
	@Autowired private CommTagDao commtdao;
	@Autowired private CommBoardLikeDao cbldao;
	@Autowired private MySkinViewDao msvdao;
	@Autowired private MembersDao mdao;
	@Autowired private CommCommentDao ccdao;
	
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
		/* 새 게시글 등록*/
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user_num=(Integer)session.getAttribute("user_num");
		int comm_num=(Integer)session.getAttribute("comm_num");
		String cb_title=(String)map.get("cb_title");
		String cb_content=(String)map.get("cb_content");
		String cb_notice=(String)map.get("cb_notice");
		int cbNotice=0;
		if(cb_notice!=null) {
			cbNotice=1;
		}
		String[] tag_name=(String[])map.get("tag_name");
		MultipartFile[] fileP=(MultipartFile[])map.get("fileP");
		MultipartFile[] fileV=(MultipartFile[])map.get("fileV");
		
		ArrayList<String> fileP_list=new ArrayList<>();
		ArrayList<String> fileV_list=new ArrayList<>();
		String uploadPathPhoto=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathVideo=session.getServletContext().getRealPath("/resources/upload/vid");
		System.out.println("uploadPathPhoto: "+uploadPathPhoto);
		System.out.println("uploadPathVideo: "+uploadPathVideo);
		try {
			int cb_num=getMaxNum()+1;
			CommBoardVo cbvo=new CommBoardVo(cb_num, comm_num, user_num, cb_title, cb_content, null, cbNotice, 0);
			cbdao.insert(cbvo);
			if(!fileP[0].isEmpty()) {
				for(int i=0;i<fileP.length;i++) {
					int cp_num=cpdao.getMaxNum()+1;
					String cp_orgimg=fileP[i].getOriginalFilename();
					String cp_savimg=UUID.randomUUID()+"_"+cp_orgimg;
					fileP_list.add(cp_savimg);
					InputStream is=fileP[i].getInputStream();
					FileOutputStream fos=new FileOutputStream(uploadPathPhoto+"\\"+cp_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					CommPhotoVo cpvo=new CommPhotoVo(cp_num, cb_num, cp_orgimg, cp_savimg);
					cpdao.insert(cpvo);
				}
			}
			if(!fileV[0].isEmpty()) {
				for(int i=0; i<fileV.length;i++) {
					int cv_num=cvdao.getMaxNum()+1;
					String cv_orgvid=fileV[i].getOriginalFilename();
					String cv_savvid=UUID.randomUUID()+"_"+cv_orgvid;
					fileV_list.add(cv_savvid);
					InputStream is=fileV[i].getInputStream();
					FileOutputStream fos=new FileOutputStream(uploadPathVideo+"\\"+cv_savvid);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					CommVideoVo cvvo=new CommVideoVo(cv_num, cb_num, cv_orgvid, cv_savvid);
					cvdao.insert(cvvo);
				}
			}
			if(tag_name!=null) {
				for(int i=0;i<tag_name.length;i++) {
					System.out.println(tag_name[i]);
					int tagCount=tdao.getTagCountNum(tag_name[i]);
					int tag_num=0;
					if(tagCount==0) {
						tag_num=tdao.getMaxNum()+1;
						TagVo newtvo=new TagVo(tag_num, tag_name[i]);
						tdao.insert(newtvo);
					}else{
						TagVo tvo=tdao.select(tag_name[i]);
						tag_num=tvo.getTag_num()+1;
					}
					int ctag_num=commtdao.getMaxNum()+1;
					CommTagVo ctvo=new CommTagVo(ctag_num, tag_num, cb_num);
					commtdao.insert(ctvo);
				}
			}
			
			return 1;
		}catch(Exception e) {
			for(String deleteImg:fileP_list) {
				File filePhoto=new File(uploadPathPhoto+"\\"+deleteImg);
				if(filePhoto.delete()) {
					System.out.println("파일 삭제");
				}
			}
			for(String deleteVid:fileV_list) {
				File fileVideo=new File(uploadPathVideo+"\\"+deleteVid);
				if(fileVideo.delete()) {
					System.out.println("파일 삭제");
				}
			}
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		String cbNum=(String)map.get("cb_num");
		int cb_num=0;
		if(cbNum!=null && !cbNum.equals("")) cb_num=Integer.parseInt(cbNum);
		String userPwd=(String)map.get("user_pwd");
		int user_pwd=0;
		if(userPwd!=null && !userPwd.equals("")) user_pwd=Integer.parseInt(userPwd);
		int result=cbdao.commBoard_checkPwd(map);
		if(result>0) {
			return cbdao.delete(cb_num);
		}else {
			return -1;
		}
	}

	@Override
	public Object select(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		String list=(String)map.get("list");
		HttpSession session=(HttpSession)map.get("session");
		int comm_num=(Integer)session.getAttribute("comm_num");
		if(list.equals("select")) {
			//게시글 상세보기
			int cb_num=(Integer)map.get("cb_num");
			HashMap<String, Object> result=new HashMap<>();
			CommBoardVo cbvo=cbdao.select(cb_num);
			List<CommPhotoVo> imgList=cpdao.select(cb_num);
			List<CommVideoVo> vidList=cvdao.select(cb_num);
			List<CommBoardLikeVo> cblList=cbldao.select(cb_num);
			List<MySkinViewVo> msvList=new ArrayList<>();
			int writer=cbvo.getUser_num();
			MySkinViewVo writervo=msvdao.select_using(writer);
			for(CommBoardLikeVo vo : cblList) {
				MySkinViewVo msvo=msvdao.select_using(vo.getUser_num());
				msvList.add(msvo);
			}
			MembersVo vo=mdao.select(writer);
			int likeNum=0;
			for(CommBoardLikeVo cblvo: cblList) {
				++likeNum;
			}
			List<TagVo> tagList=tdao.getCommTag(cb_num);
			int commentCnt=ccdao.select_CommentNum(cb_num);

			result.put("cbvo", cbvo); //게시글
			result.put("imgList", imgList); //게시글 사진
			result.put("vidList", vidList); //게시글 비디오
			result.put("cblList", cblList); //게시글 추천
			result.put("msvList", msvList); //추천 유저 skin view
			result.put("vo", vo); //작성자 회원 정보
			result.put("writervo", writervo); //작성자 회원 skin view  
			result.put("likeNum", likeNum); //추천수
			result.put("tagList", tagList); //태그리스트
			result.put("commentCnt", commentCnt); //댓글수
			
			return result;
		}else if(list.equals("notice")) {
			//공지사항 불러오기
			return cbdao.getNotice(comm_num);
		}
		return null;
	}

	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int pageNum=(Integer)map.get("pageNum");
		int comm_num=(Integer)map.get("comm_num");
		
		PageUtil page=new PageUtil(pageNum, 5, 5, 5);
		int startRow=page.getStartRow();
		int endRow=page.getEndRow();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List<CommBoardVo> list=cbdao.list(map);
		List<MySkinViewVo> msvlist=new ArrayList<>();
		List<CommBoardCntVo> cbclist=new ArrayList<>();
		
		for(CommBoardVo vo: list) {
			MySkinViewVo msvv=msvdao.select_using(vo.getUser_num());
			msvlist.add(msvv);
			CommBoardCntVo cntvo=cbdao.getBoardCnt(vo.getCb_num());
			cbclist.add(cntvo);
		}
		
		
		HashMap<String, Object> result=new HashMap<>();
		result.put("list", list);//게시글
		result.put("msvlist", msvlist); //게시글 작성자 프로필
		result.put("cbclist", cbclist); //게시글 좋아요, 댓글수, 조회수 
		
		return result;
	}

}
