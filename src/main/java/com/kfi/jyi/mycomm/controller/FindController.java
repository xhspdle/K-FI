package com.kfi.jyi.mycomm.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FindController {

	@RequestMapping(value="/mypage/find",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String find(Model model, int year, int month, int day) {
		JSONObject json=new JSONObject();
		json.put("one", 1);
		System.out.println(json.toString());
		return json.toString();
	}
}
