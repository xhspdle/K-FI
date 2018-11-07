package com.kfi.dgl.members.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value = "FindIdController")
public class FindIdController {
		@Autowired
		MembersService service;
		@Autowired
		JavaMailSender Mailsender;
		@RequestMapping(value="/login/findid", method=RequestMethod.GET)
		public String findId() {
			return "/login/findId";
		}
		
	/*	@RequestMapping(value="/login/findid", method=RequestMethod.POST)
		public String findId(MembersVo vo, HttpSession session, String user_email) throws MessagingException, UnsupportedEncodingException {
			service.findId(user_email);
				
			return "/login/findId";
		}*/
}
