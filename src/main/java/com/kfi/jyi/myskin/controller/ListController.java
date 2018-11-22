package com.kfi.jyi.myskin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller(value="myskinlistController")
public class ListController {
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService service;
	
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
		MySkinViewVo vo=(MySkinViewVo)service.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}

	@RequestMapping(value="/mypage/myskin/list")
	public String getMySkin(HttpSession session, Model model) { 
		int user_num=(Integer)session.getAttribute("user_num");
		List<MySkinViewVo> msvlist=(List<MySkinViewVo>)service.list(user_num);
		model.addAttribute("msvlist",msvlist);
		return ".mypage.myskin.list";
	}
	
	@RequestMapping(value="/mypage/myskin/select")
	@ResponseBody
	public HashMap<String, Object> selectMySkin(String ms_num) {
		int msNum=Integer.parseInt(ms_num);
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", "ms_num");
		map.put("ms_num",msNum);
		HashMap<String, Object> result=new HashMap<>();
		result.put("vo", (MySkinViewVo)service.select(map));
		return result;
	}

	
	
}
