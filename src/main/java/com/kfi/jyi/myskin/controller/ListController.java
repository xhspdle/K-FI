package com.kfi.jyi.myskin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListController {

	@RequestMapping(value="/mypage/myskin",method=RequestMethod.GET)
	public String getMySkin() {
		
		return "";
	}
	
	
	
	
}
