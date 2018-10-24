package com.kfi.ldk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyPageController {
	@RequestMapping(value="/mypage/main",method=RequestMethod.GET)
	public String myPage() {
		return ".mypage";
	}
}
