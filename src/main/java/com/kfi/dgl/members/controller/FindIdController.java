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

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value = "FindIdController")
public class FindIdController {
	@Autowired
	MembersService service;
	@Autowired
	JavaMailSender Mailsender;

	@RequestMapping(value = "/login/findid", method = RequestMethod.GET)
	public String findId() {
		return "/login/findId";
	}

	@RequestMapping(value = "/login/findid", method = RequestMethod.POST)
	public String findId(String user_email, Model model) throws Exception {
		System.out.println("user_email:" + user_email);// aaaaaaaaaaaaaaaaaaaa
		MembersVo vo = service.emailCheck(user_email);
		model.addAttribute("user_email", user_email);
		if (vo != null) {
			System.out.println("성공");
			service.createkey(user_email);
			return "/login/findId";
		} else {
			System.out.println("실패");
			return "redirect:/login/login";
		}
	}

	@RequestMapping(value = "/login/findEmail")
	@ResponseBody
	public Map<String, String> findEmail(String user_email) {
		MembersVo vo = service.emailCheck(user_email);
		Map<String, String> map = new HashMap<>();
		if (vo != null) {
			System.out.println(user_email);
			map.put("msg", "true");
		} else {
			System.out.println(user_email);
			map.put("msg", "false");
		}
		return map;
	}

	@RequestMapping(value = "/login/emailConfirm", method = RequestMethod.GET)
	public String emailConfirm(String user_email, Model model) throws Exception { // 이메일인증 확인
		service.findId(user_email);
		model.addAttribute("user_email", user_email);

		return "/user/emailConfirm";
	}

	@RequestMapping(value = "/login/findpwd", method = RequestMethod.GET)
	public String findPwd(String user_email, Model model) throws Exception {
		System.out.println("user_email:" + user_email);
		MembersVo vo = service.emailCheck(user_email);
		model.addAttribute("user_email", user_email);
		if (vo != null) {
			System.out.println("보내자");
			service.createkey(user_email);
			return "/login/findId";
		} else {
			System.out.println("실패");
			return "redirect:/login/login";
		}
	}

	@RequestMapping(value = "/login/findpwdmail", method = RequestMethod.POST)
	public String findpwdsendmail(String user_id, String user_email, Model model) throws Exception {
		service.findpwsendmail(user_email, user_id);
		model.addAttribute("user_email", user_email);
		model.addAttribute("user_id", user_id);
		return "/login/findpwd";
	}

	@RequestMapping(value = "/login/selectcode", method = RequestMethod.POST)
	public String selectcode(MembersVo vo, String cm_key, Model model) {
		service.selectcode(cm_key);
		System.out.println("코드확인중");
		model.addAttribute("cm_key", cm_key);
		return "/login/resetpwd";
	}

	@RequestMapping(value = "/login/resetpwd", method = RequestMethod.GET)
	public String resetpwd() {
		System.out.println("리셋폼");
		return "/login/resetpwd";
	}

	@RequestMapping(value = "/login/resetpwd", method = RequestMethod.POST)
	public String resetpwd(MembersVo vo, Model model) throws Exception {
		service.resetPwd(vo);
		return "/login/login";
	}
}
