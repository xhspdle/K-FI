package com.kfi.ysy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunitySkinController {
	@RequestMapping(value="communityskin", method=RequestMethod.GET)
	public String comskinForm() {
		return ".admin.communityskin";
	}
}
