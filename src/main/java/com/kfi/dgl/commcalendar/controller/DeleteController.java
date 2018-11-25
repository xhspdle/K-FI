package com.kfi.dgl.commcalendar.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.CommCalendarService;

@Controller(value="CommCalendarDeleteController")
public class DeleteController {
	@Autowired private CommCalendarService service;
	@RequestMapping("/community/commcalendar/delete")
	@ResponseBody
	public HashMap<String, Object> delete(@RequestParam(value="cc_num",defaultValue="0")int cc_num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int n=service.deleteEvent(cc_num);
		if(n>0) {
			map.put("code", "success");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
