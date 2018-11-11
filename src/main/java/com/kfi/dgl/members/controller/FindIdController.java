package com.kfi.dgl.members.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		@RequestMapping(value="/login/findid", method=RequestMethod.POST)
		public String findId(MembersVo vo,Model model, RedirectAttributes rttr, HttpServletRequest request, HttpSession session, String user_email) throws Exception {
			service.createkey(vo, user_email);
			rttr.addFlashAttribute("msg", "가입시 사용한 이메일로 인증");
			return "redirect:/";
		}
		
		@RequestMapping(value="/login/emailConfirm", method=RequestMethod.GET)
		public String emailConfirm(String user_email, Model model) throws Exception { // 이메일인증 확인
			service.findId(user_email);
			model.addAttribute("user_email", user_email);

			return "/user/emailConfirm";
		}
}
