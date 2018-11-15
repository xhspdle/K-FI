package com.kfi.ysy.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="community_insertcontroller")
public class InsertController {
	@RequestMapping(value="/community/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".community.board.insert";
	}
	public String insert() {
		
		return null;
	}
}
