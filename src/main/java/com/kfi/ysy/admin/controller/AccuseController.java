package com.kfi.ysy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ysy.admin.service.AccuseService;
import com.kfi.ysy.admin.vo.AccuseVo;


@Controller
public class AccuseController {
	@Autowired 
	private AccuseService acservice;
	@RequestMapping(value = "/accuse", method = RequestMethod.GET)
	public String aclist(Model model) {
		List<AccuseVo> aclist = acservice.aclist();
		System.out.println(aclist);
		model.addAttribute("aclist", aclist);
		return ".admin.accuseboard";
	}
}
