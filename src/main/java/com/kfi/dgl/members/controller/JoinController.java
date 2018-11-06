package com.kfi.dgl.members.controller;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.util.MailUtil;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.MySkinVo;

@Controller(value = "MembersInsertController")
public class JoinController {
	@Autowired
	private MembersService service;
	@Autowired
	private JavaMailSender MailSender;
	@RequestMapping(value = "/login/join", method = RequestMethod.GET)
	public String join() {
		return "/login/join";
	}

	@RequestMapping(value = "/login/join", method = RequestMethod.POST)
	public String join(MembersVo vo, HttpSession session,Model model) throws MessagingException, UnsupportedEncodingException {
		int user_num = service.getMaxnum()+1;
		vo.setUser_num(user_num);
		int n = service.join(vo);
		String returnURL = "";
		if (n > 0) {
			session.setAttribute("user_num", vo.getUser_num());
			session.setAttribute("user_id", vo.getUser_id());
			
			
			// myskin 디폴트 테이블 추가
			int myskinOk = service.insertMyskin(new MySkinVo(0, user_num, "기본스킨", "#00cee8", "", 1));
			if (myskinOk < 0) {
				//returnURL="error"; 에러나면 오류페이지로 이동하기
			}
			
			//service.createKey(vo);
			
			System.out.println(session.getAttribute("user_id"));
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
	@RequestMapping(value="/login/join/idcheck")
	@ResponseBody
		public Map<String, String> idcheck(String user_id){
		int n = service.idCheck(user_id);
		Map<String, String> map = new HashMap<>();
		if(n == 0) {
			map.put("msg", "true");
		}else if(n == 1) {
			map.put("msg", "false");
		}
		return map;
	}
	@RequestMapping(value="/login/join/nickcheck")
	@ResponseBody
	public Map<String, String> nickcheck(String user_nickname){
	int n = service.nickCheck(user_nickname);
	Map<String, String> map = new HashMap<>();
	if(n == 0) {
		map.put("msg", "true");
	}else if(n == 1) {
		map.put("msg", "false");
	}
	return map;
	}
	
	@RequestMapping(value="/login/join/emailcheck")
	@ResponseBody
	public Map<String, String> emailcheck(String user_email){
	int n = service.emailCheck(user_email);
	System.out.println(user_email);
	Map<String, String> map = new HashMap<>();
	if(n == 0) {
		map.put("msg", "true");
	}else if(n == 1) {
		map.put("msg", "false");
	}
	return map;
	}
	
	@RequestMapping(value="/mailcert", method = RequestMethod.GET)
	public String mailcert(@RequestParam String user_email) {
		System.out.println("이메일 인증처리");
		MembersVo vo = new MembersVo();
		vo.setUser_email(user_email);
		service.getverify(user_email);
		return "redirect:/login/login";
	}
}
