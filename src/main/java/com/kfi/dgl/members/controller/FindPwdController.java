/*package com.kfi.dgl.members.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;

@Controller(value = "FindPwdController")
public class FindPwdController {
	@Autowired
	MembersService service;
	@Autowired
	JavaMailSender Mailsender;
	@RequestMapping(value="/findPwd", method=RequestMethod.GET)
	public String findPwd() {
		return "/findPwd";
	}
	
	@RequestMapping(value="/findPwd", method=RequestMethod.POST)
	public Map<String, String> findPwd(String user_id) {
		int n = service.idCheck(user_id);
		
		}
	
}
*/