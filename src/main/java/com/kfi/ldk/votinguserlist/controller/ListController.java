package com.kfi.ldk.votinguserlist.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="VotingUserListController")
public class ListController {
	@Autowired
	@Qualifier("votingUserListServiceImpl") private CommonService service;
	@SuppressWarnings("unchecked")
	@RequestMapping("/community/votinguserlist/list")
	@ResponseBody
	public HashMap<String, Object> list(int vote_num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("vote_num", vote_num);
		return (HashMap<String, Object>)service.list(map);
	}
}
