package com.kfi.dgl.members.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value = "FindPwdController")
public class FindPwdController {
	@Autowired
	MembersService service;
	@Autowired
	JavaMailSender MailSender;
	@RequestMapping(value="/login/findpwd", method=RequestMethod.GET)
	public String findPwd() {
		return "/login/findPwd";
	}
	
	@RequestMapping(value="/login/findPwd", method=RequestMethod.POST)
	public void findPwd(String user_id, String user_email ) throws Exception{
		int n = service.idCheck(user_id);
		if (n > 0) {
		MembersVo vo=service.emailCheck(user_email);
		if (vo !=null)
			System.out.println("이메일보내자");
			 service.createkey(user_email);
			 return;
			} else {
				System.out.println("에러");
			return;
		}
		}
	}
