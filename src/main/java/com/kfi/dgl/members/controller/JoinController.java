package com.kfi.dgl.members.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.MembersService;
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
	public String join(MembersVo vo, HttpSession session) {
		int user_num = service.getMaxnum()+1;
		vo.setUser_num(user_num);
		int n = service.join(vo);
		String returnURL = "";
		if (n > 0) {
			session.setAttribute("user_num", vo.getUser_num());
			session.setAttribute("user_id", vo.getUser_id());
			
			// myskin ����Ʈ ���̺� �߰�
			int myskinOk = service.insertMyskin(new MySkinVo(0, user_num, "�⺻��Ų", "#00cee8", null, 1));
			if (myskinOk < 0) {
				//returnURL="error"; �������� ������������ �̵��ϱ�
			}
			
			returnURL = "redirect:/login/login";
			System.out.println(session.getAttribute("user_id"));

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
	Map<String, String> map = new HashMap<>();
	if(n == 0) {
		map.put("msg", "true");
	}else if(n == 1) {
		map.put("msg", "false");
	}
	return map;
	}
}
