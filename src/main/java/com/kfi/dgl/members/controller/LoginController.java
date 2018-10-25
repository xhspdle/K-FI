package com.kfi.dgl.members.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.members.service.MembersService;
import com.kfi.dgl.members.service.MembersServiceImpl;
import com.kfi.dgl.members.vo.MembersVo;

@Controller(value="LoginController")
public class LoginController {
	@Autowired //���� ����
	private MembersServiceImpl loginService;
	//�α��� ��
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	//�α��� ó��
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request,HttpSession session, MembersVo vo) {
		String user_id = request.getParameter("userId");
		String user_pwd = request.getParameter("userPwd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user_id);
		map.put("userPwd", user_pwd);
		String returnURL ="";
		
		if(session.getAttribute("user_num") != null) {
			//���ǿ� ���� �α��� ���ǰ��� ����� ����
			session.removeAttribute("user_num");
			session.removeAttribute("user_id");
		}
		//�α��� ������ vo��ü ��ȯ
		MembersVo vo2 =loginService.login(map);
		
		//�α��� ����
		if( vo2 != null) { 
			session.setAttribute("user_num", vo2.getUserNum() );
			session.setAttribute("user_id", vo2.getUserId() );
			returnURL = "redirect:/mypage/main";
		}else {
			returnURL = "redirect:/login/login";
		}
		return returnURL;
	}
	
	// �α׾ƿ�
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
