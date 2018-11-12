package com.kfi.ldk.service;

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

import com.kfi.ldk.dao.MyBoardDao;
import com.kfi.ldk.dao.MyBoardListViewDao;
import com.kfi.ldk.dao.MyPhotoDao;
import com.kfi.ldk.dao.MyTagDao;
import com.kfi.ldk.dao.MyVideoDao;
import com.kfi.ldk.dao.TagDao;
import com.kfi.ldk.util.ImgUtil;
import com.kfi.ldk.util.VidUtil;
import com.kfi.ldk.vo.MyBoardConfirmDelVo;
import com.kfi.ldk.vo.MyBoardListViewVo;
import com.kfi.ldk.vo.MyBoardVo;
import com.kfi.ldk.vo.MyPhotoVo;
import com.kfi.ldk.vo.MyVideoVo;
import com.kfi.ldk.vo.TagVo;

@Service
public class MyBoardServiceImpl implements CommonService{
	@Autowired private MyBoardDao mbDao;
	@Autowired private MyPhotoDao mpDao;
	@Autowired private MyVideoDao mvDao;
	@Autowired private TagDao tagDao;
	@Autowired private MyTagDao myTagDao;
	@Autowired private MyBoardListViewDao mbViewDao;
	@Override
	public int getMaxNum() {
		return mbDao.getMaxNum();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCount(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mbViewDao.getCount(map);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public int insert(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		MyBoardVo mbVo=(MyBoardVo)map.get("mbVo");
		MultipartFile[] fileP=(MultipartFile[])map.get("fileP");
		MultipartFile[] fileV=(MultipartFile[])map.get("fileV");
		HttpSession session=(HttpSession)map.get("session");
		String[] tag_name=(String[])map.get("tag_name");
		String uploadPathP=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathV=session.getServletContext().getRealPath("/resources/upload/vid");
		int mb_num=getMaxNum();
		int mp_num=mpDao.getMaxNum();
		int mv_num=mvDao.getMaxNum();
		int tag_num=tagDao.getMaxNum();
		int mtag_num=myTagDao.getMaxNum();
		InputStream is=null;
		FileOutputStream fos=null;
		ArrayList<String> uploadedPhoto=new ArrayList<String>();
		ArrayList<String> uploadedVideo=new ArrayList<String>();
		try {	
			mbDao.insert(new MyBoardVo(mb_num + 1, mbVo.getUser_num(),
					mbVo.getMb_title(), mbVo.getMb_content(), null, 0));
			if(!fileP[0].getOriginalFilename().isEmpty()) {
				for(int i=0;i<fileP.length;i++) {
					String mp_orgimg=fileP[i].getOriginalFilename();
					String format=mp_orgimg.substring(mp_orgimg.lastIndexOf(".") + 1);
					String mType=ImgUtil.getImgType(format);
					/*
					 * 브라우저에서 여러개의 파일을 업로드시, 등록했던 파일중 하나를 취소했을 경우 ""값이 넘어온다
					 * 이때 해당하는 ""값이 들어있는 fileP 배열을 건너뛰는 코드 필요
					 * --> continue 사용
					 */
					if(mp_orgimg=="") continue;
					if(mType==null) {
						throw new Exception("*." + format + " is unsupported img file types");
					}
					String mp_savimg=UUID.randomUUID() + "_" + mp_orgimg;
					is=fileP[i].getInputStream();
					fos=new FileOutputStream(uploadPathP + "\\" + mp_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					System.out.println(uploadPathP + "경로에 사진 업로드 성공!");
					uploadedPhoto.add(mp_savimg);
					mpDao.insert(new MyPhotoVo(mp_num + i +1, mb_num + 1, mp_orgimg, mp_savimg));
				}
			}
			if(!fileV[0].getOriginalFilename().isEmpty()) {
				for(int i=0;i<fileV.length;i++) {
					String mv_orgvid=fileV[i].getOriginalFilename();
					String format=mv_orgvid.substring(mv_orgvid.lastIndexOf(".") + 1);
					String mType=VidUtil.getVidType(format);
					if(mv_orgvid=="") continue;
					if(mType==null) {
						throw new Exception("*." + format + " is unsupported vid file types");
					}
					String mv_savvid=UUID.randomUUID() + "_" + mv_orgvid;
					is=fileV[i].getInputStream();
					fos=new FileOutputStream(uploadPathV + "\\" + mv_savvid);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					System.out.println(uploadPathV + "경로에 영상 업로드 성공!");
					uploadedVideo.add(mv_savvid);
					mvDao.insert(new MyVideoVo(mv_num + i +1, mb_num + 1, mv_orgvid, mv_savvid));
				}				
			}
			for(int i=0;i<tag_name.length;i++) {
				if(tagDao.select(tag_name[i])==null) {
					tagDao.insert(new TagVo(tag_num + i + 1, tag_name[i]));
					/*
					 *  여기할차례
					 */
					
				}
			}
			return 1;
		}catch(Exception e) {
			File f=null;
			for(String delPhoto: uploadedPhoto) {
				f=new File(uploadPathP + "\\" + delPhoto);
				if(f.delete()) System.out.println(delPhoto + "파일 DB저장실패, 서버에서 삭제 완료!");
			}
			for(String delVideo: uploadedVideo) {
				f=new File(uploadPathV + "\\" + delVideo);
				if(f.delete()) System.out.println(delVideo + "파일 DB저장실패, 서버에서 삭제 완료!");
			}
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public int update(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		MyBoardVo mbVo=(MyBoardVo)map.get("mbVo");
		MultipartFile[] fileP=(MultipartFile[])map.get("fileP");
		MultipartFile[] fileV=(MultipartFile[])map.get("fileV");
		HttpSession session=(HttpSession)map.get("session");
		String uploadPathP=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathV=session.getServletContext().getRealPath("/resources/upload/vid");
		InputStream is=null;
		FileOutputStream fos=null;
		ArrayList<String> updatedPhoto=new ArrayList<String>();
		ArrayList<String> updatedVideo=new ArrayList<String>();
		List<Object> photoList=(List<Object>)mpDao.select(mbVo.getMb_num());
		List<Object> videoList=(List<Object>)mvDao.select(mbVo.getMb_num());
		try {
			mbDao.update(mbVo);
			for(int i=0;i<fileP.length;i++) {
				String mp_orgimg=fileP[i].getOriginalFilename();
				String format=mp_orgimg.substring(mp_orgimg.lastIndexOf(".") + 1);
				String mType=ImgUtil.getImgType(format);
				if(mp_orgimg=="") continue;
				if(mType==null) {
					throw new Exception("*." + format + " is unsupported img file types");
				}
				String mp_savimg=UUID.randomUUID() + "_" + mp_orgimg;
				is=fileP[i].getInputStream();
				fos=new FileOutputStream(uploadPathP + "\\" + mp_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPathP + "경로에 사진 업로드 성공!");
				updatedPhoto.add(mp_savimg);
				MyPhotoVo mpVo=(MyPhotoVo)photoList.get(i);
				mpDao.update(new MyPhotoVo(mpVo.getMp_num(), 0, mp_orgimg, mp_savimg));
				
				File f=new File(uploadPathP + "\\" + mpVo.getMp_savimg());
				if(!f.delete()) {
					throw new Exception("[사진삭제오류]" +photoList.size()+1 + "개 중 " + i+1 +"번째 파일에서 오류 발생");
				}
				System.out.println(uploadPathP + "경로에 사진 삭제 성공!");
			}
			for(int i=0;i<fileV.length;i++) {
				String mv_orgvid=fileV[i].getOriginalFilename();
				String format=mv_orgvid.substring(mv_orgvid.lastIndexOf(".") + 1);
				String mType=VidUtil.getVidType(format);
				if(mv_orgvid=="") continue;
				if(mType==null) {
					throw new Exception("*." + format + " is unsupported vid file types");
				}
				String mv_savvid=UUID.randomUUID() + "_" + mv_orgvid;
				is=fileV[i].getInputStream();
				fos=new FileOutputStream(uploadPathV + "\\" + mv_savvid);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPathV + "경로에 영상 업로드 성공!");
				updatedVideo.add(mv_savvid);
				MyVideoVo mvVo=(MyVideoVo)videoList.get(i);
				mvDao.update(new MyVideoVo(mvVo.getMv_num(), 0, mv_orgvid, mv_savvid));
				
				File f=new File(uploadPathV + "\\" + mvVo.getMv_savvid());
				if(!f.delete()) {
					throw new Exception("[영상삭제오류]" +videoList.size()+1 + "개 중 " + i+1 +"번째 파일에서 오류 발생");
				}
				System.out.println(uploadPathV + "경로에 영상 삭제 성공!");
			}
		}catch(Exception e) {
			File f=null;
			for(String delPhoto: updatedPhoto) {
				f=new File(uploadPathP + "\\" + delPhoto);
				if(f.delete()) System.out.println(delPhoto + "파일 DB업데이트 실패, 서버에서 삭제 완료!"); 
			}
			for(String delVideo: updatedVideo) {
				f=new File(uploadPathV + "\\" + delVideo);
				if(f.delete()) System.out.println(delVideo + "파일 DB업데이트 실패, 서버에서 삭제 완료!");
			}
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
		return 1;
	}
	@SuppressWarnings("unchecked")
	//@Transactional : on delete cascade
	@Override
	public int delete(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		String uploadPathP=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathV=session.getServletContext().getRealPath("/resources/upload/vid");
		map.remove("session");
		int mb_num=(Integer)map.get("mb_num");
		try {
			MyBoardConfirmDelVo vo=mbDao.confirmDel(map);
			if(vo!=null) {
				List<Object> photoList=mpDao.select(mb_num);
				List<Object> videoList=mvDao.select(mb_num);
				for(int i=0;i<photoList.size();i++) {
					MyPhotoVo mpVo=(MyPhotoVo)photoList.get(i);
					File f=new File(uploadPathP + "\\" + mpVo.getMp_savimg());
					if(!f.delete()) {
						throw new Exception("[사진삭제오류]" +photoList.size()+1 + "개 중 " + i+1 +"번째 파일에서 오류 발생");
					}
					System.out.println(uploadPathP + "경로에 사진 삭제 성공!");
				}
				for(int i=0;i<videoList.size();i++) {
					MyVideoVo mvVo=(MyVideoVo)videoList.get(i);
					File f=new File(uploadPathV + "\\" + mvVo.getMv_savvid());
					if(!f.delete()) {
						throw new Exception("[영상삭제오류]" +videoList.size()+1 + "개 중 " + i+1 +"번째 파일에서 오류 발생");
					}
					System.out.println(uploadPathV + "경로에 영상 삭제 성공!");
				}
				//mpDao.delete(mb_num); on delete cascade
				//mvDao.delete(mb_num); on delete cascade
				mbDao.delete(mb_num);
				return 1;
			}else {
				return -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -2;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object select(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		int mb_num=(Integer)map.get("mb_num");
		MyBoardListViewVo vo=mbViewDao.select(mb_num);
		String content=vo.getMb_content();
		if(content!=null && content!="") {
			vo.setMb_content(content.replaceAll("\n", "<br>"));
		}else {
			vo.setMb_content("");
		}
		mbDao.addHit(mb_num);
		map.put("user_num", vo.getUser_num());
		map.put("boardVo", vo);
		map.put("imgList", mpDao.select(mb_num));
		map.put("vidList", mvDao.select(mb_num));
		map.put("prev", mbViewDao.prev(map));
		map.put("next", mbViewDao.next(map));
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list(Object data) {	
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		List<Object> list=mbViewDao.list(map);
		for(int i=0;i<list.size();i++) {
			MyBoardListViewVo vo=(MyBoardListViewVo)list.get(i);
			String content=vo.getMb_content();
			if(content!=null && content!="") {
				vo.setMb_content(content.replaceAll("\n", "<br>"));
			}else {
				vo.setMb_content("");
			}
		}
		return list;
	}
}
