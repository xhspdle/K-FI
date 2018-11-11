/*package com.kfi.dgl.members.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.util.MailUtil;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.MySkinVo;

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
	public Map<String, String> findPwd(String user_id, String user_email ) throws MessagingException, UnsupportedEncodingException{
		int n = service.findPwd(user_id); 
		String returnURL = "";
		if (n > 0) {
			MailUtil sendMail = new MailUtil(MailSender);
			sendMail.setSubject("[이메일 인증]");
			sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
					.append("<a href='http://localhost:8082/kfi/mailcert?user_email="+vo.getUser_email())
					.append("' target='_blenk'>이메일 인증 확인</a>").toString());
			sendMail.setFrom("tester241192@gmail.com", "인증인증~!");
			sendMail.setTo(vo.getUser_email());
			sendMail.send();
			returnURL = "redirect:/login/login";
		}else if(n > 0) {
			returnURL = "redirect:/login/login";
			} else {
			returnURL="redirect:/login/join";
		}
		return returnURL;
	}
		
		
	
}
*/