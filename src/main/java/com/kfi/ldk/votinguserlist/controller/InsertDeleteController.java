package com.kfi.ldk.votinguserlist.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="VotingUserListInsertDeleteController")
public class InsertDeleteController {
	@Autowired
	@Qualifier("votingUserListServiceImpl") private CommonService service;
	@RequestMapping("/community/votinguserlist/insert")
	@ResponseBody
	public HashMap<String, Object> insert(int vote_num,int vo_num,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		if(user_num==0) {
			map.put("code", "Login first");
			return map;
		}
		map.put("vote_num", vote_num);
		map.put("user_num", user_num);
		map.put("vo_num", vo_num);
		int n=service.insert(map);
		if(n>0) {
			//map.put("votedList", service.list(map));
			map.put("code", "success");
		}else if(n==-1) {
			map.put("code", "duplicated");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
