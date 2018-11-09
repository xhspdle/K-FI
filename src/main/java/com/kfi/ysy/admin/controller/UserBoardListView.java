package com.kfi.ysy.admin.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="Admin_UserBoardListView")
public class UserBoardListView {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@RequestMapping(value="userboardlistview",method=RequestMethod.GET)
	public String boardlistviewForm() {	
		return ".admin.ublistview";
	}
/*	@RequestMapping(value="userboardlistview",produces="application/json;charset=utf-8")
	@ResponseBody
	public HashMap<String, Object> boardlistview(){	
		
		return map;
	}*/
}
