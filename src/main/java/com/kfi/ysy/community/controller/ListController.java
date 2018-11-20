package com.kfi.ysy.community.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ysy.service.CommunityAdminServiceImpl;


@Controller(value="community_listcontroller")
public class ListController {

	@RequestMapping(value="/community/list",method=RequestMethod.GET)
	public String list() {
	
		
		
		return ".community.board.list";
	}
}
