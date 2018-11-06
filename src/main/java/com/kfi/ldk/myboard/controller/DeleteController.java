package com.kfi.ldk.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value="MyBoardDeleteController")
public class DeleteController {
	@Autowired 
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/myboard/delete",method=RequestMethod.GET)
	public String delete() {
		
		return null;
	}
}
