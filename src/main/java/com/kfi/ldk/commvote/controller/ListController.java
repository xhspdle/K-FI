package com.kfi.ldk.commvote.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.util.PageUtil;

@Controller(value="CommVoteListController")
public class ListController {
	@Autowired
	@Qualifier("commVoteServiceImpl") private CommonService service;
	@RequestMapping(value="/community/polls/list",method=RequestMethod.GET)
	public String list(@RequestParam(value="pageNum",defaultValue="1")
			int pageNum,HttpSession session,Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("comm_num", session.getAttribute("comm_num"));
		map.put("comm_num", 1);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 9, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		model.addAttribute("pu", pu);
		model.addAttribute("list", service.list(map));
		return ".community.polls.list";
	}
}
