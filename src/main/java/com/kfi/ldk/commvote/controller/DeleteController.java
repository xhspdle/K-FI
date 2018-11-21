package com.kfi.ldk.commvote.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="CommVoteDeleteController")
public class DeleteController {
	@Autowired
	@Qualifier("commVoteServiceImpl") private CommonService service;
	@RequestMapping(value="/community/polls/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(int vote_num,String user_pwd) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("vote_num", vote_num);
		map.put("user_pwd", user_pwd);
		int n=service.delete(map);
		if(n>0) {
			map.put("code", "success");
		}else if(n==-1) {
			map.put("code", "wrong password");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
