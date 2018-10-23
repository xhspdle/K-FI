package com.kfi.ysy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ysy.admin.service.AdminBoardService;
import com.kfi.ysy.admin.vo.AdminBoardVo;



@Controller
public class AdminBoardController {
	@Autowired 
	private AdminBoardService abservice;
	@RequestMapping(value = "/ablist", method = RequestMethod.GET)
	public String ablist(Model model) {
		List<AdminBoardVo> ablist = abservice.ablist();
		if(ablist!=null) {
			System.out.println(ablist);	
			model.addAttribute("ablist", ablist);
			AdminBoardVo vo=(AdminBoardVo)ablist.get(0);
			System.out.println("title1111///////////////"+vo.getAb_title());
			return ".admin.adminboard";
		}else{
			System.out.println(ablist);
			return ".main.error";
		}
	}
}

