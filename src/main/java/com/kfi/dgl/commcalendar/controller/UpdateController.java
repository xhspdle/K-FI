package com.kfi.dgl.commcalendar.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.CommCalendarService;
import com.kfi.jyi.vo.CommCalendarVo2;

@Controller(value="CommCalendarUpdateController")
public class UpdateController {
	@Autowired private CommCalendarService service;
	@RequestMapping("/community/commcalendar/update")
	@ResponseBody
	public HashMap<String, Object> update(CommCalendarVo2 vo){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int n=service.updateEvent(vo);
		if(n>0) {
			map.put("code", "success");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
