package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="MyBoardSelectController")
public class SelectController {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/mypage/myboard/select",method=RequestMethod.GET)
	public String select(int mb_num,Model model) {
		HashMap<String, Object> map=(HashMap<String, Object>)service.select(mb_num);
		model.addAttribute("boardVo", map.get("boardVo"));
		model.addAttribute("imgList", map.get("imgList"));
		model.addAttribute("vidList", map.get("vidList"));
		return ".mypage.myboard.select";
	}
}
