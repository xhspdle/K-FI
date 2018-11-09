package com.kfi.ysy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="Admin_UserBoardListView")
public class AdBoardListView {
	@RequestMapping(value="boardlistview",method=RequestMethod.GET)
	public String boardlistview() {
		
		
		return ".admin.boardlistview";
	}
}
