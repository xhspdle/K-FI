package com.kfi.ldk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="communityController")
public class CommunityController {

	@RequestMapping(value="/community",method=RequestMethod.GET)
	public String community() {
		return ".community";
	}
}
