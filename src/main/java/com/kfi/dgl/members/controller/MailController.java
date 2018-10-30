/*package com.kfi.dgl.members.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;

import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.members.service.MembersService;
import com.kfi.dgl.members.vo.MembersVo;

@Controller
public class MailController{
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/mailpost", method= RequestMethod.POST)
	public String MailPost(MembersVo , HttpServletRequest request, HttpSession session ) throws Exception{
		Service.create()
		
	}
}
*/