package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.util.PageUtil;

@Controller
public class ListController {
	@Autowired private CommonService service;
	@RequestMapping("/mypage/myboard/list")
	public String list(@RequestParam(value="pageNum",defaultValue="1")
		int pageNum,String keyword,Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		model.addAttribute("list", service.list(map));
		model.addAttribute("pu", pu);
		model.addAttribute("keyword", keyword);
		return ".mypage.myboard.list";
	}
}
