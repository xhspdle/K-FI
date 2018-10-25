package com.kfi.ldk.myboard.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyBoardVo;
import com.kfi.ldk.vo.MyPhotoVo;
import com.kfi.ldk.vo.MyVideoVo;

@Controller(value="MyBoardInsertController")
public class InsertController {
	@Autowired private CommonService service;
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".mypage.myboard.insert";
	}
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request,String[] tags,
				MultipartFile[] fileP,MultipartFile[] fileV,HttpSession session) {
		/*
		 * 
		 * 여기 할차례
		 */
		String uploadPathP=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathV=session.getServletContext().getRealPath("/resources/upload/vid");
		String mb_title=request.getParameter("mb_title");
		String mb_content=request.getParameter("mb_content");
		System.out.println("title:" +mb_title);
		System.out.println("content:" + mb_content);
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
			InputStream is=null;
			FileOutputStream fos=null;
			for(int i=0;i<fileP.length;i++) {
				String mp_orgimg=fileP[i].getOriginalFilename();
				String mp_savimg=UUID.randomUUID() + "_" + mp_orgimg;
				is=fileP[i].getInputStream();
				fos=new FileOutputStream(uploadPathP + "\\" + mp_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPathP + "경로에 사진 업로드 성공!");
				map.put("mpVo" + "[" + i + "]", new MyPhotoVo(0, 0, mp_orgimg, mp_savimg));
			}
			map.put("mpVoLength", fileP.length);
			for(int i=0;i<fileV.length;i++) {
				String mv_orgvid=fileV[i].getOriginalFilename();
				String mv_savvid=UUID.randomUUID() + "_" + mv_orgvid;
				is=fileV[i].getInputStream();
				fos=new FileOutputStream(uploadPathV + "\\" + mv_savvid);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPathV + "경로에 영상 업로드 성공!");
				map.put("mvVo" + "[" + i + "]", new MyVideoVo(0, 0, mv_orgvid, mv_savvid));
			}
			map.put("mvVoLength", fileV.length);
			
			map.put("mbVo", new MyBoardVo(0, 1, mb_title, mb_content, null, 0));	
			//유저 가입, 로그인 미구현인관계로 유저넘버1번으로 테스트
			int n=service.insert(map);
			if(n>0) {
				return "success";
			}else {
				return "error";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
}
