package com.kfi.jyi.friends.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value="friendsInsertController")
public class InsertController {
	@Autowired 
	@Qualifier("friendsServiceImpl") private CommonService service;
		
	@RequestMapping(value="/friends/follow",method=RequestMethod.GET)
	public String follow(HttpSession session, String user1_num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("user1_num",user1_num );
		int result=(Integer)service.insert(map);
		if(result>0) {
			return ".mypage.myfriend.list";
		}else {
			return ".mypage.myfriend.list"; //¿À·ù
		}
	}
}
