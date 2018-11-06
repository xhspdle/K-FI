package com.kfi.jyi.myskin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.service.MySkinServiceImpl;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller(value="myskinlistController")
public class ListController {
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService service;
	
	@RequestMapping(value="/mypage/myskin/list")
	public String getMySkin(HttpSession session, Model model) { 
		System.out.println("session: "+session.getAttribute("user_num"));
		session.setAttribute("user_num", 1);
		int user_num=(Integer)session.getAttribute("user_num");
		List<MySkinViewVo> msvlist=(List<MySkinViewVo>)service.list(1);
		model.addAttribute("msvlist",msvlist);
		System.out.println(msvlist.toString()); 
		
		return ".mypage.myskin.list";
	}
	
}
