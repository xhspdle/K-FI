package com.kfi.jyi.mycomm.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.mycomm.service.MyCommCalendarService;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;

@Controller(value="mycommCalendarListController")
public class ListController {
	@Autowired MyCommCalendarService service;
	
	@RequestMapping(value="/mycommCalendar/list",produces="application/json;charset=utf-8")
	@ResponseBody
	public String list(HttpSession session, String year, String month, String day) {
		//String user_num=(String)session.getAttribute("user_num");
		
		HashMap<String, Object> hm=new HashMap<>();
		hm.put("user_num", 1);
		hm.put("begin",year+"/"+month+"/"+day);
		List<CommCalendarVo> list =service.findMyCommCal(hm);
		JSONObject json=new JSONObject();
		json.put("list",list);
		System.out.println(json.toString());
		return json.toString();
	}
}
