package com.kfi.dgl.members.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kfi.dgl.members.service.MembersService;
import com.kfi.dgl.members.vo.MembersVo;

@Controller
public class LoginController {
	@Autowired
	private MembersService service;
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public ModelAndView login(MembersVo vo) {
		int n=service.insert(vo);
		ModelAndView mv=new ModelAndView("result");
		if(n>0) {
			mv.addObject("code","success");
		}else {
			mv.addObject("code","fail");
		}
		return mv;
	}
}
