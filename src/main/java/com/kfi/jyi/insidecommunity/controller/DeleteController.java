package com.kfi.jyi.insidecommunity.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value="deleteInsideCommunityController")
public class DeleteController {
	@Autowired 
	@Qualifier("insideCommunityServiceImpl") private CommonService service;

	/* Å»Åð */
	@RequestMapping(value="/commuserlist/delete",method=RequestMethod.GET)
	public String insert(HttpSession session, String comm_num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("comm_num",Integer.parseInt(comm_num));
		int result=(Integer)service.delete(map);
		if(result>0) {
			return "redirect:/community"; 
		}else {
			return "redirect:/community";  //¿À·ù
		}
	}
	
	
}
