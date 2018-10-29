package com.kfi.jyi.mycomm.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value="mycommCalendarListController")
public class ListController {
	
	@RequestMapping(value="/mycommCalendar/list",produces="application/json;charset=utf-8")
	@ResponseBody
	public String list(HttpSession session) {
		//String user_id=(String)session.getAttribute("user_id");
		//String user_num=(String)session.getAttribute("user_num");
		
		
		JSONObject json=new JSONObject();
		System.out.println("!!");
		
		return json.toString();
	}
}
