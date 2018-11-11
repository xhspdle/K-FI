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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller(value="myskinlistController")
@SessionAttributes("msv")
public class ListController {
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService service;
	
	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		/*session.setAttribute("user_num", 1);
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",1);
		List<MySkinViewVo> list=(List<MySkinViewVo>)service.list(map);*/
		MySkinViewVo msv=null;
		
/*		if(list!=null) {
			for(MySkinViewVo vo: list) {
				msv=vo;
			}
		}else {*/
			msv=new MySkinViewVo(0, 0, "기본", "#00cee8"," ", 0, 0, "", "default-profile.png", 0, "", "logo2.png");
	/*	}*/
		return msv;
	}

	@RequestMapping(value="/mypage/myskin/list")
	public String getMySkin(HttpSession session, Model model) { 
		session.setAttribute("user_num", 1);
		session.setAttribute("user_nickname", "nicknameTEST");
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",null);
		List<MySkinViewVo> msvlist=(List<MySkinViewVo>)service.list(map);
		model.addAttribute("msvlist",msvlist);
		return ".mypage.myskin.list";
	}
	
	@RequestMapping(value="/mypage/myskin/select")
	@ResponseBody
	public HashMap<String, Object> selectMySkin(String ms_num) {
		int msNum=Integer.parseInt(ms_num);
		HashMap<String, Object> map=new HashMap<>();
		map.put("vo", (MySkinViewVo)service.select(msNum));
		return map;
	}

	@RequestMapping(value="/mypage/myskin/applySkin",method=RequestMethod.GET)
	public String applySkin(HttpSession session, String ms_num) {
		int msNum=Integer.parseInt(ms_num);
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("ms_num", msNum);
		map.put("ms_using",1);
		int result=service.update(map);
		if(result>0) {
			return "redirect:/mypage/myskin/list";
		}else {
			return "redirect:/mypage/myskin/list"; //오류
		}
	}
	
	@RequestMapping(value="/mypage/myskin/default",method=RequestMethod.GET)
	public String defaultSkin(HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("ms_num", -1);
		int result=service.update(map);
		if(result>0) {
			return "redirect:/mypage/myskin/list";
		}else {
			return "redirect:/mypage/myskin/list"; //오류
		}
	}
	
}
