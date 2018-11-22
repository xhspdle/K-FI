package com.kfi.jyi.friends.controller;

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

@Controller(value="friendsInsertController")
public class InsertController {
	@Autowired 
	@Qualifier("friendsServiceImpl") private CommonService service;
		
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService mySkinService;
	
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
		MySkinViewVo vo=(MySkinViewVo)mySkinService.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}
	
	@RequestMapping(value="/friends/follow",method=RequestMethod.POST)
	public String follow(HttpSession session, String selectedUserNum) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		int user1_num=0;
		if(selectedUserNum!=null && !selectedUserNum.equals("")) {
			user1_num=Integer.parseInt(selectedUserNum);
		}
		map.put("user1_num",user1_num );
		int result=(Integer)service.insert(map);
		if(result>0) {
			return "redirect:/mypage/myfriend/list";
		}else {
			return "redirect:/mypage/myfriend/list"; //오류
		}
	}
}
