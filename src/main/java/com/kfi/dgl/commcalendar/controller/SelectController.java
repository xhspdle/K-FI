package com.kfi.dgl.commcalendar.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.CommCalendarService;

@Controller(value="CommCalendarSelectController")
public class SelectController {
	@Autowired private CommCalendarService service;
	@RequestMapping("/community/commcalendar/select")
	@ResponseBody
	public HashMap<String, Object> select(@RequestParam(value="cc_num",defaultValue="0")int cc_num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("select", service.selectEvent(cc_num));
		return map;
	}
}
