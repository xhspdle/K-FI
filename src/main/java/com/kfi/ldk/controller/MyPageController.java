package com.kfi.ldk.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller
@SessionAttributes("msv")
public class MyPageController {
	/*@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService service;

	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		session.setAttribute("user_num", 1);
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",1);
		List<MySkinViewVo> list=(List<MySkinViewVo>)service.list(map);
		MySkinViewVo msv=null;
		if(list!=null) {
			for(MySkinViewVo vo: list) {
				msv=vo;
				System.out.println(vo.toString()+"??????????");
			}
		}
		if(list==null){
			msv=new MySkinViewVo(0,user_num, "±âº»", "#00cee8","", 0, 0, "default-profile.png", "default-profile.png", 0,"logo2.png", "logo2.png");
		}
		return msv;
	}*/
	
	@RequestMapping(value = "/mypage/main", method = RequestMethod.GET)
	public String myPage() {
		return ".mypage";
	}
}
