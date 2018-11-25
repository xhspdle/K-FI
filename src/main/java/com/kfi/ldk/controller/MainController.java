package com.kfi.ldk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.MainCommunitySearchService;

@Controller
public class MainController {
	@Autowired private MainCommunitySearchService service;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpSession session) {
		session.setAttribute("comm_num", 1);
		return ".main";
	}
	@RequestMapping("/communitySearch")
	public String communitySearch(String keyword,Model model) {
		model.addAttribute("list", service.list(keyword));
		return ".community.list";
	}
}
