package com.kfi.dgl.members.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value="LoginController")
public class LoginController {
	@Autowired //서비스 주입
	private MembersService loginService;
	//로그인 폼
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	//로그인 처리
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpSession session) {
		String user_id = request.getParameter("userId");
		String user_pwd = request.getParameter("userPwd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("user_pwd", user_pwd);
		String returnURL ="";

		if ( session.getAttribute("user_id") != null ){
			//세션에 이전 로그인 세션값이 존재시 제거
			session.removeAttribute("user_num");
			session.removeAttribute("user_id");
	}	
		MembersVo vo =loginService.login(map);
		
		//로그인 성공
		if(vo!=null) { 
			if(vo.getUser_certi() ==1) {
				System.out.println(vo.getUser_id());
				System.out.println(vo.getUser_pwd());
			session.setAttribute("user_num", vo.getUser_num());
			session.setAttribute("user_id", vo.getUser_id());
			returnURL = "redirect:/mypage/main";
		}else {
			System.out.println(vo.getUser_email());
			returnURL = "redirect:/login/login";
		}
		}
		return returnURL;
		}
	
	// 로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
