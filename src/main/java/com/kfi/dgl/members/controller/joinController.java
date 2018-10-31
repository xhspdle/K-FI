package com.kfi.dgl.members.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView join(MembersVo vo) {
		int n = service.insert(vo);
		ModelAndView mv = new ModelAndView("result");
		if (n > 0) {
			mv.addObject("code", "success");
		} else {
			mv.addObject("code", "fail");
		}
		return mv;
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
