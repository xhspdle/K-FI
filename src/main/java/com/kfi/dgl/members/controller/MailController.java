/*package com.kfi.dgl.members.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfi.dgl.certiMembers.util.MailUtil;
import com.kfi.dgl.members.service.MembersService;
import com.kfi.dgl.members.vo.MembersVo;

@Controller
public class MailController{
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/mailpost")
	public String insertmember(MembersVo vo) throws MessagingException, UnsupportedEncodingException{
		membersService.insert(vo);
		MailUtil sendMail = new MailController(MailSender);
	}
}
*/