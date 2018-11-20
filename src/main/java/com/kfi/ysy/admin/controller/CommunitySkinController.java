package com.kfi.ysy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunitySkinController {
	@RequestMapping(value="/community/commadmin/communityskin", method=RequestMethod.GET)
	public String commskinForm() {
		return ".community.commadmin.communityskin";
	}
	@RequestMapping(value="communityskin", method=RequestMethod.POST)
	public String insert() {
		
		return ".admin.communityskin";
	}
	@RequestMapping(value="commskinlist")
	public String list() {
		return ".admin.communityskin";
	}
}
