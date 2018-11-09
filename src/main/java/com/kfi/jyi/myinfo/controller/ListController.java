package com.kfi.jyi.myinfo.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value="myInfoListController")
public class ListController {
	@Autowired private MembersService service;

	@RequestMapping(value="/mypage/myinfo/password",method=RequestMethod.GET)
	public String password() {
		return ".mypage.myinfo.password";
	}
	
	/* js 실행 안 됐을 경우 실행 */
	@RequestMapping(value="/mypage/myinfo/passwordCheck",method=RequestMethod.POST)
	public String passwordCheck(String password, HttpSession session, Model model) {
		int user_num=(Integer)session.getAttribute("user_num");
		String code=service.passwordOk(user_num, password);
		if(code.equals("true")) {
			return "redirect:/mypage/myinfo/list";
		}else {
			model.addAttribute("code", "비밀번호가 올바르지 않습니다");
			return ".mypage.myinfo.password";
		}
	}
	
	@RequestMapping(value="/mypage/myinfo/passwordChk",produces="application/json;charset=utf-8")
	@ResponseBody
	public String passwordChk(String password, HttpSession session, Model model) {
		int user_num=(Integer)session.getAttribute("user_num");
		String code=service.passwordOk(user_num, password);
		JSONObject json=new JSONObject();
		json.put("code", code);
		return json.toString();
	}
	
	@RequestMapping(value="/mypage/myinfo/list",method=RequestMethod.GET)
	public String list(HttpSession session, Model model) {
		int user_num=(Integer)session.getAttribute("user_num");
		MembersVo vo=service.select(user_num);
		model.addAttribute("vo", vo);
		return ".mypage.myinfo.list";
	}
	
	
}
