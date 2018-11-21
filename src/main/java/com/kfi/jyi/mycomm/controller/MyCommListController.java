package com.kfi.jyi.mycomm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfi.jyi.vo.CommunityVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.vo.CommSkinProfileVo;

@Controller(value="myCommListController")
public class MyCommListController {
	@Autowired 
	@Qualifier("myCommunityListServiceImpl") private CommonService service;
	
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
	

	
	@RequestMapping(value="/mypage/mycomm/list")
	public String list(HttpSession session, Model model,String commAdmin) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("commAdmin",commAdmin); 

		/* 조건에 따라 마이 커뮤니티 목록 불러오기 */
		HashMap<String, Object> result=(HashMap<String, Object>)service.list(map);
		List<CommunityVo> list=(List<CommunityVo>)result.get("list");
		model.addAttribute("list", list);
		
		/* 해당 커뮤니티가 사용 중인 스킨 불러오기 */
		List<CommSkinProfileVo> csplist=(List<CommSkinProfileVo>)result.get("csplist");
		model.addAttribute("csplist", csplist);

		return ".mypage.mycommlist.list";
	}
}
