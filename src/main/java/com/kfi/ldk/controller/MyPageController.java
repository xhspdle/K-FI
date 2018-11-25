package com.kfi.ldk.controller;


import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller
public class MyPageController {
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService service;

	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		MySkinViewVo msv=new MySkinViewVo(0,user_num, "±âº»", "#00cee8","", 0, 0, "default-profile.png", "default-profile.png", 0,"logo2.png", "logo2.png","");
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", "ms_using");
		map.put("user_num", user_num);
		MySkinViewVo vo=(MySkinViewVo)service.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}
	
	@RequestMapping(value = "/mypage/main", method = RequestMethod.GET)
	public String myPage() {
		return ".mypage";
	}
}
