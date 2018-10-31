/*package com.kfi.dgl.members.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.dgl.service.MailService;
import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.util.MailUtil;
import com.kfi.dgl.vo.MembersVo;

@Controller
public class MailController{
	
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private MembersService membersService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/mailpost", method= RequestMethod.POST)
	public String MailPost(MembersVo vo) throws MessagingException, UnsupportedEncodingException{
		System.out.println("메일 보내요!");
		int num = membersService.getMaxnum()+1;
		vo.setUser_num(num);
		int result= membersService.insert(vo);
		if(result>0) {
		MailUtil sendMail = new MailUtil(mailSender);
		sendMail.setSubject("[이메일 인증]");
		sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
				.append("<a href='http://localhost:9090/kfi/mailcert?user_email="+vo.getUser_email())
				.append("' target='_blenk'>이메일 인증 확인</a>").toString());
		
		sendMail.setFrom("donkr24@gmail.com", "인증인증~!");
		sendMail.setTo(vo.getUser_email());
		sendMail.send();
		return "/mypage/main";
		}
		return null;
		
	}
	@RequestMapping(value="/verify", method= RequestMethod.GET)
	public String joinSuccess(@RequestParam String user_email) {
		System.out.println("이메일 인증처리!");
		MembersVo vo = new MembersVo();
		vo.setUser_email(user_email);
		membersService.getverify(vo);
		return "/mypage/main";
		
	}
}*/
