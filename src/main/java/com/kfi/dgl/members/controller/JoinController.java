package com.kfi.dgl.members.controller;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
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
	@RequestMapping(value = "/login/join", method = RequestMethod.GET)
	public String join() {
		return "/login/join";
	}

	@RequestMapping(value = "/login/join", method = RequestMethod.POST)
	public String join(MembersVo vo, HttpSession session) throws MessagingException, UnsupportedEncodingException {
		int user_num = service.getMaxnum()+1;
		vo.setUser_num(user_num);
		int n = service.join(vo);
		String returnURL = "";
		if (n > 0) {
			session.setAttribute("user_num", vo.getUser_num());
			session.setAttribute("user_id", vo.getUser_id());
			session.setAttribute("user_nickname", vo.getUser_nickname());
			
			
			// myskin 디폴트 테이블 추가
			int myskinOk = service.insertMyskin(new MySkinVo(0, user_num, "기본스킨", "#00cee8", "", 1));
			if (myskinOk < 0) {
				//returnURL="error"; 에러나면 오류페이지로 이동하기
			}
			System.out.println(session.getAttribute("user_id"));
			
			service.joinsendmail(vo.getUser_email());
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
	MembersVo vo = service.emailCheck(user_email);
	Map<String, String> map = new HashMap<>();
	if(vo == null) {
		System.out.println(user_email);
		map.put("msg", "true");
	}else {
		System.out.println(user_email);
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
		System.out.println(user_email);
		System.out.println(vo.getUser_certi());
		return "redirect:/login/login";
	}
}
