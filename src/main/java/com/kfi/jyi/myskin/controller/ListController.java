package com.kfi.jyi.myskin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.service.MySkinServiceImpl;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;


@Controller(value="myskinlistController")
public class ListController {
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService service;
	
	@RequestMapping(value="/mypage/myskin/list")
	public String getMySkin(HttpSession session, Model model) { 
		session.setAttribute("user_num", 1);
		int user_num=(Integer)session.getAttribute("user_num");
		List<MySkinViewVo> msvlist=(List<MySkinViewVo>)service.list(user_num);
		model.addAttribute("msvlist",msvlist);
		return ".mypage.myskin.list";
	}
	
	@RequestMapping(value="/mypage/myskin/select")
	@ResponseBody
	public HashMap<String, Object> selectMySkin(String ms_num) {
		int msNum=Integer.parseInt(ms_num);
		HashMap<String, Object> map=new HashMap<>();
		map.put("vo", service.select(msNum));
		return map;
	}
}
