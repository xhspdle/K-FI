package com.kfi.jyi.insidecommunity.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value="updateInsideCommunityController")
public class UpdateController {
	@Autowired 
	@Qualifier("insideCommunityServiceImpl") private CommonService service;

	/* °­Åð */ 
	@RequestMapping(value="/commuserlist/update",method=RequestMethod.GET)
	public String insert(String comm_num, String user_num, String cr_refuse) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num",Integer.parseInt(user_num));
		map.put("comm_num",Integer.parseInt(comm_num));
		map.put("cr_refuse",cr_refuse);
		int result=(Integer)service.update(map);
		if(result>0) {
			return "redirect:/community"; 
		}else {
			return "redirect:/community";  //¿À·ù
		}
	}
}
