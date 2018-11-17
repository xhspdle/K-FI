package com.kfi.jyi.community.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.service.CommunityServiceImpl;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.vo.CommSkinProfileVo;

@Controller(value="communityListController")
public class ListController {
	@Autowired 
	@Qualifier("communityServiceImpl") private CommonService service;
	
	@RequestMapping(value="/communityMain/list",method=RequestMethod.GET)
	public String list(Model model) {
		HashMap<String, Object> map =(HashMap<String, Object>)service.list("list");
		List<CommunityVo> clist =(List<CommunityVo>)map.get("clist");
		List<CommSkinProfileVo> csplist=(List<CommSkinProfileVo>)map.get("csplist");
		model.addAttribute("clist", clist);
		model.addAttribute("csplist", csplist);
		return ".community.list";
	}
}
