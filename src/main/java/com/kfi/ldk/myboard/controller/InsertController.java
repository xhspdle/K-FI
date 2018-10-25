package com.kfi.ldk.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.ldk.service.MyBoardService;
import com.kfi.ldk.vo.MyBoardVo;

@Controller(value="MyBoardInsertController")
public class InsertController {
	@Autowired private MyBoardService service;
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".mypage.myboard.insert";
	}
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.POST)
	public String insert(String mb_title,String mb_content,String[] tags,
				MultipartFile[] fileP,MultipartFile[] fileV,HttpSession session) {
		try {
			String uploadPathP=session.getServletContext().getRealPath("/resources/upload/img");
			String uploadPathV=session.getServletContext().getRealPath("/resources/upload/vid");
			service.insert(new MyBoardVo(0, 1, mb_title, mb_content, null, 0));
			return "success";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
}
