package com.kfi.jyi.myskin.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "myskinDeleteController")
public class DeleteController {
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService service;

	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",1);
		List<MySkinViewVo> list=(List<MySkinViewVo>)service.list(map);
		MySkinViewVo msv=new MySkinViewVo(0, 0, "기본", "#00cee8"," ", 0, 0, "", "default-profile.png", 0, "", "logo2.png","");
		if(list!=null) {
			for(MySkinViewVo vo: list) {
				msv=vo;
			}
		}
		return msv;
	}
	
	@RequestMapping(value = "/mypage/myskin/delete", method = RequestMethod.GET)
	public String delete(String ms_num, HttpSession session) {
		HashMap<String, Object> hm=new HashMap<>();
		int msNum=Integer.parseInt(ms_num);
		hm.put("ms_num", msNum);
		hm.put("session", session);
		int result = service.delete(hm);
		if (result > 0) {
			return "redirect:/mypage/myskin/list";
		} else {
			return "redirect:/mypage/myskin/list"; //에러페이지로 이동하기
		}
	}
}
