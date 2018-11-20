package com.kfi.ysy.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller(value="community_listcontroller")
public class ListController {
	@RequestMapping(value="/community/list",method=RequestMethod.GET)
	public String list() {
		
		return ".community.board.list";
	}
}
