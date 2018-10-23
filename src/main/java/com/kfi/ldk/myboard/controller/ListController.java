package com.kfi.ldk.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfi.ldk.service.MyBoardService;

@Controller
public class ListController {
	@Autowired private MyBoardService service;
	@RequestMapping("/mypage/myboard/list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return ".mypage.myboard.list";
	}
}
