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
import com.kfi.ysy.dao.CommunityAdminDao;
import com.kfi.ysy.service.CommunityAdminServiceImpl;

@Controller
public class CommAdmin {
	@Autowired 
	@Qualifier("communityAdminServiceImpl") private CommonService service;
	@RequestMapping(value="/community/commadmin/list", method=RequestMethod.GET)
	public String commadminForm(Model model) {	
		List<CommunityAdminDao> list=(List<CommunityAdminDao>)service.list(null);
		System.out.println(list);
		if(list!=null) {
			model.addAttribute("commuserlist", list);
			return ".community.commadmin.list";
		}else {
			return null;
		}
	}
}
