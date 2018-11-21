package com.kfi.ysy.community.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommAdminDao;
import com.kfi.ysy.service.CommAdminServiceImpl;

@Controller
public class CommAdminController {
	@Autowired 
	@Qualifier("commAdminServiceImpl") private CommonService service;
	@RequestMapping(value="/community/commadmin/commuserlist", method=RequestMethod.GET)
	public String commuserlist(int comm_num,Model model) {	
		List<CommAdminDao> list=(List<CommAdminDao>)service.list(comm_num);
		System.out.println(list);
		if(list!=null) {
			model.addAttribute("commuserlist", list);
			return ".community.commadmin.commuserlist";
		}else {
			return null;
		}
	}
	@RequestMapping(value="/community/commadmin/commskin", method=RequestMethod.GET)
	public String commskinForm() {
		return ".community.commadmin.commskin";
	}
	@RequestMapping(value="/community/commadmin/commprofile", method=RequestMethod.GET)
	public String commprofileForm() {
		return ".community.commadmin.commprofile";
	}
}
