package com.kfi.ysy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BoardListView {
	@RequestMapping(value="/boardlistview",method=RequestMethod.GET)
	public String boardlistForm() {
		return ".admin.boardlistview";
	}
}
