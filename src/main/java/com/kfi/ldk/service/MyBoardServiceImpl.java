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
import com.kfi.ldk.dao.MyVideoDao;
import com.kfi.ldk.util.ImgUtil;
import com.kfi.ldk.util.VidUtil;
import com.kfi.ldk.vo.MyBoardVo;
import com.kfi.ldk.vo.MyPhotoVo;
import com.kfi.ldk.vo.MyVideoVo;

@Service
public class MyBoardServiceImpl implements CommonService{
	@Autowired private MyBoardDao mbDao;
	@Autowired private MyPhotoDao mpDao;
	@Autowired private MyVideoDao mvDao;
	@Autowired private MyBoardListViewDao mbViewDao;
	public int addHit(int mb_num) {
		return mbDao.addHit(mb_num);
	}
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
		String uploadPathP=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathV=session.getServletContext().getRealPath("/resources/upload/vid");
		int mb_num=getMaxNum();
		int mp_num=mpDao.getMaxNum();
		int mv_num=mvDao.getMaxNum();
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
					if(mType==null) {
						throw new Exception("*." + format + " is Unsupported img file types");
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
					if(mType==null) {
						throw new Exception("*." + format + " is Unsupported vid file types");
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
	@Transactional
	@Override
	public int update(Object data) {
		MyBoardVo vo=(MyBoardVo)data;
		return mbDao.update(vo);
	}
	@Transactional
	@Override
	public int delete(Object data) {
		int mb_num=(Integer)data;
		return mbDao.delete(mb_num);
	}
	@Override
	public Object select(Object data) {
		int mb_num=(Integer)data;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("boardVo", mbDao.select(mb_num));
		map.put("imgList", mpDao.select(mb_num));
		map.put("vidList", mvDao.select(mb_num));
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list(Object data) {	
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mbViewDao.list(map);
	}
}
