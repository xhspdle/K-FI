/*package com.kfi.dgl.members.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value = "FindPwdController")
public class FindPwdController {
	@Autowired
	MembersService service;
	@Autowired
	JavaMailSender MailSender;
	@RequestMapping(value="/login/findpwd", method=RequestMethod.GET)
	public String findPwd() {
		System.out.println("Æû");
		return "/login/findpwd";
	}
	@RequestMapping(value="/login/findpwdmail", method=RequestMethod.POST)
	public String findpwdsendmail(String user_id, String user_email, Model model) throws Exception{
		service.findpwsendmail(user_email, user_id);
		model.addAttribute("user_email", user_email);
		model.addAttribute("user_id", user_id);
		return "/login/findpwd";
	}
	@RequestMapping(value="/login/selectcode", method=RequestMethod.POST)
	public String selectcode(MembersVo vo, String cm_key, Model model) {
		service.selectcode(cm_key);
		System.out.println("ÄÚµåºñ±³Áß");
		model.addAttribute("cm_key", cm_key);
		return "/login/resetpwd";
	}
	
	@RequestMapping(value="/login/resetpwd", method=RequestMethod.GET)
	public String resetpwd() {
		System.out.println("¸®¼ÂÆû");
		return "/login/resetpwd";
	}
	
	@RequestMapping(value="/login/resetpwd", method=RequestMethod.POST)
	public String resetpwd(MembersVo vo, Model model) throws Exception{
		service.resetPwd(vo);
		return "/login/login";
	}
}
*/