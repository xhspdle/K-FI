/*package com.kfi.dgl.members.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
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
import com.kfi.ysy.admin.vo.AdminBoardVo;

@Controller
public class MailController{
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/mailpost", method= RequestMethod.POST)
	public String MailPost(MembersVo vo) throws MessagingException, UnsupportedEncodingException{
		System.out.println("메일 보내요!");
			int getmaxnum=service.maxcnt()+1;
			vo.setAb_num(num);
		
	}
}
*/