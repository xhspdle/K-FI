package com.kfi.ysy.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value="community_listcontroller")
public class ListController {
	@RequestMapping(value="/community/list",method=RequestMethod.GET)
	public String listForm() {
		return ".community.board.list";
	}
	@RequestMapping(value="/community/list",produces="application/json;charset=utf-8")
	@ResponseBody
	public String list() {
		
		return null;
	}
}
