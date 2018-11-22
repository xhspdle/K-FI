package com.kfi.jyi.friends.controller;

import java.util.ArrayList;
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

import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.FriendsVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller
public class ListController {
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
		MySkinViewVo msv=new MySkinViewVo(0,user_num, "±âº»", "#00cee8","", 0, 0, "default-profile.png", "default-profile.png", 0,"logo2.png", "logo2.png","");
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", "ms_using");
		map.put("user_num", user_num);
		MySkinViewVo vo=(MySkinViewVo)mySkinService.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}
	
	
	
	@RequestMapping(value="/mypage/myfriend/list",method=RequestMethod.GET)
	public String list(HttpSession session,String user_number,Model model) {
		HashMap<String, Object> map=new HashMap<>();
		int user_num=(Integer)session.getAttribute("user_num");
		map.put("user_num", user_num);
		if(user_number==null) {
			user_number="user2_num";
		}
		map.put("user_number", user_number);
		
		HashMap<String, Object> result=(HashMap<String, Object>)service.list(map);
		List<MySkinViewVo> msvlist=(List<MySkinViewVo>)result.get("msvlist");
		List<MembersVo> mvolist=(List<MembersVo>)result.get("mvolist");
		model.addAttribute("msvlist", msvlist);
		model.addAttribute("mvolist", mvolist);
		return ".mypage.myfriend.list";
	}
	
}
