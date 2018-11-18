package com.kfi.ldk.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value = "insideCommunityController")
public class InsideCommunityController {
	@Autowired
	@Qualifier("insideCommunityServiceImpl")
	private CommonService insideCommService;

	// 가입한 유저인지, 강퇴당한 유저인지 확인하기 (글쓰기 disabled)
/*	@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session, String comm_num) { //
		int user_num = (Integer) session.getAttribute("user_num");
		HashMap<String, Object> map = new HashMap<>();
		map.put("comm_num", 1); //Integer.parseInt(comm_num)
		map.put("user_num", user_num);
		int cul_status = (Integer) insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);
		return cul_status;
	}*/

	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String community(HttpSession session, String comm_num) {
/*		if(!comm_num.equals("") && comm_num!=null) {
			session.setAttribute("comm_num", comm_num);
		}*/
		return ".community";
	}

}
