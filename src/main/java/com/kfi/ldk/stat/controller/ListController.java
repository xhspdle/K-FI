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
		model.addAttribute("commMemCnt", service.commMemCnt());
		model.addAttribute("commViewSum", service.commViewSum());
		model.addAttribute("periodMemCntWeek", service.periodMemCnt(7));
		model.addAttribute("periodMyBoardCntWeek", service.periodMyBoardCnt(7));
		model.addAttribute("periodCommBoardCntWeek", service.periodCommBoardCnt(7));
		model.addAttribute("periodMyViewSumWeek", service.periodMyViewSum(7));
		model.addAttribute("periodCommViewSumWeek", service.periodCommViewSum(7));
		return ".admin.stat.list";
	}
}
