package com.kfi.ldk.stat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.StatService;

@Controller(value="statListController")
public class ListController {
	@Autowired 
	private StatService service;
	@RequestMapping(value="/admin/stat/list",method=RequestMethod.GET)
	private String listForm(Model model) {
		model.addAttribute("totalMemCnt", service.totalMemCnt());
		model.addAttribute("totalCommCnt", service.totalCommCnt());
		return ".admin.stat.list";
	}
}
