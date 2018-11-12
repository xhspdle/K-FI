package com.kfi.dgl.members.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value = "FindIdController")
public class FindIdController {
		@Autowired
		MembersService service;
		@Autowired
		JavaMailSender Mailsender;
		@Autowired
		MembersDao dao;
		@RequestMapping(value="/login/findid", method=RequestMethod.GET)
		public String findId() {
			return "/login/findId";
		}
		
		@RequestMapping(value="/login/findid", method=RequestMethod.POST)
		@ResponseBody
		public String findId(String user_email) throws Exception {
			System.out.println("user_email:" +user_email);//aaaaaaaaaaaaaaaaaaaa
			MembersVo vo=service.emailCheck(user_email);
			if (vo != null) {
				System.out.println("성공");
				service.createkey(user_email);
				return "redirect:/";
			}else {
				System.out.println("실패");
				return "redirect:/login/login";
			}
		}
		
		@RequestMapping(value="/login/findEmail")
		@ResponseBody
		public Map<String, String> findEmail(String user_email){
			MembersVo vo = service.emailCheck(user_email);
			Map<String, String> map = new HashMap<>();
			if(vo != null) {
				System.out.println(user_email);
				map.put("msg", "true");
			}else {
				System.out.println(user_email);
				map.put("msg", "false");
			}
			return map;
		}
		
		@RequestMapping(value="/login/emailConfirm", method=RequestMethod.GET)
		public String emailConfirm(String user_email, Model model) throws Exception { // 이메일인증 확인
			service.findId(user_email);
			model.addAttribute("user_email", user_email);

			return "/user/emailConfirm";
		}
}
