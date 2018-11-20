package com.kfi.ldk.votinguserlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.kfi.ldk.service.CommonService;

@Controller(value="VotingUserListController")
public class ListController {
	@Autowired
	@Qualifier("votingUserListServiceImpl") private CommonService service;
	/*
	 * 
	 */
}
