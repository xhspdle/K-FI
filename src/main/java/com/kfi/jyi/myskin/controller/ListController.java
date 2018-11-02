package com.kfi.jyi.myskin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.service.MySkinImpl;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller
public class ListController {
	@Autowired private CommonService service;
	
	@RequestMapping(value="/mypage/myskin/list",method=RequestMethod.GET)
	public String getMySkin(HttpSession session, Model model) {
		Object user_num=session.getAttribute("user_num");
		List<MySkinViewVo> msvlist=(List<MySkinViewVo>)service.list(user_num);
		model.addAttribute("msvlist",msvlist);
		return ".mypage.myskin.list";
	}
	
	
	
	
}
