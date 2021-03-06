package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyBoardVo;

@Controller(value="MyBoardInsertController")
public class InsertController {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".mypage.myboard.insert";
	}
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.POST)
	@ResponseBody
	public String insert(MultipartHttpServletRequest request,
				MultipartFile[] fileP,MultipartFile[] fileV,HttpSession session) {
		String mb_title=request.getParameter("mb_title");
		String mb_content=request.getParameter("mb_content");
		String[] tag_name=request.getParameterValues("tag_name");
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("session", session);
			map.put("fileP", fileP);
			map.put("fileV", fileV);
			map.put("tag_name", tag_name);
			int user_num=0;
			Object session_num=session.getAttribute("user_num");
			if(session_num!=null && session_num!="") {
				user_num=(Integer)session_num;
			}
			map.put("mbVo", new MyBoardVo(0, user_num, mb_title, mb_content, null, 0));	
			int n=service.insert(map);
			if(n>0) {
				return "Post Success";
			}else {
				return "Post Failed";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
}
