package com.kfi.dgl.members.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller(value = "MembersInsertController")
public class joinController {
	@Autowired
	private MembersService service;

	@RequestMapping(value = "/login/join", method = RequestMethod.GET)
	public String join() {
		return "login/join";
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
			returnURL = "redirect:/login/login";
			System.out.println(session.getAttribute("user_id"));

		} else {
			returnURL="redirect:/login/join";
		}
		return returnURL;
	}
	@RequestMapping("/idcheck")
		public Map<Object, Object> idcheck(@RequestBody String user_id){
		
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		count = service.idcheck(user_id);
		map.put("cnt", count);
		return map;
	}
}
