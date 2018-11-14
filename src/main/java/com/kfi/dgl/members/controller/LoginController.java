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
	@Autowired //���� ����
	private MembersService loginService;
	//�α��� ��
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	//�α��� ó��
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpSession session, String user_num) {
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("user_pwd", user_pwd);
		String returnURL ="";

		if ( session.getAttribute("user_id") != null ){
			//���ǿ� ���� �α��� ���ǰ��� ����� ����
			session.removeAttribute("user_num");
			session.removeAttribute("user_id");
			System.out.println(session.getAttribute("user_num")+"11");
	}	
		MembersVo vo =loginService.login(map);
		
		//�α��� ����
		if(vo!=null) { 
			if(vo.getUser_certi() == 1) {
			session.setAttribute("user_num", vo.getUser_num());
			session.setAttribute("user_id", vo.getUser_id());
			System.out.println("id:" +vo.getUser_id());
			System.out.println(vo.getUser_pwd());
			System.out.println((String)session.getAttribute("user_id"));
			returnURL = "redirect:/mypage/main";
			}else if(vo.getUser_certi() == 0){
				returnURL = "redirect:/login/login";
			}else {
				returnURL = "redirect:/login/login";
		}
		}
		return returnURL;
		}
	
	// �α׾ƿ�
	@RequestMapping(value="/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
