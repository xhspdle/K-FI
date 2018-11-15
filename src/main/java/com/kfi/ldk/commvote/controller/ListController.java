package com.kfi.ldk.commvote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value="CommVoteListController")
public class ListController {
	@Autowired
	@Qualifier("commVoteServiceImpl") private CommonService service;
	@RequestMapping(value="/community/polls/list",method=RequestMethod.GET)
	public String list() {
		
		return ".community.polls.list";
	}
}
