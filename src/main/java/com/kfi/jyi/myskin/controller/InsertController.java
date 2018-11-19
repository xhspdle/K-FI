package com.kfi.jyi.myskin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.jyi.service.MySkinServiceImpl;
import com.kfi.jyi.vo.MySkinProfileVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "myskininsertController")
public class InsertController {
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService service;

	@SuppressWarnings("unchecked")
	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		MySkinViewVo msv=new MySkinViewVo(0,user_num, "기본", "#00cee8","", 0, 0, "default-profile.png", "default-profile.png", 0,"logo2.png", "logo2.png","");
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", "ms_using");
		map.put("user_num", user_num);
		MySkinViewVo vo=(MySkinViewVo)service.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}
	
	@RequestMapping(value = "/mypage/myskin/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpSession session) {
		return ".mypage.myskin.insert";
	}

	@RequestMapping(value = "/mypage/myskin/insert", method = RequestMethod.POST)
	public String insert(HttpSession session, MultipartFile ms_cover, MultipartFile ms_profile, 
			String ms_name, String ms_color, String ms_msg) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("session", session);
		hm.put("ms_profile", ms_profile);
		hm.put("ms_cover", ms_cover);
		hm.put("ms_name", ms_name);
		hm.put("ms_color", ms_color);
		hm.put("ms_msg", ms_msg);
		int result = service.insert(hm);
		if (result > 0) {
			return "redirect:/mypage/myskin/list";
		} else {
			return "redirect:/mypage/myskin/list"; //에러페이지로 가기
		}
	}
}
