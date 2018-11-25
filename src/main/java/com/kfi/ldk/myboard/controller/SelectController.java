package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller(value="MyBoardSelectController")
public class SelectController {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService mySkinService;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/mypage/myboard/select",method=RequestMethod.GET)
	public String select(int mb_num,String keyword,
			@RequestParam(value="selectedUserNum",defaultValue="0")
			int selectedUserNum,Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("mb_num", mb_num);
		if(selectedUserNum!=0) {
			map.put("user_num", selectedUserNum);
		}else {
			map.put("keyword", keyword);
		}
		map=(HashMap<String, Object>)service.select(map);
		model.addAttribute("seledtedUserNum", selectedUserNum);
		model.addAttribute("keyword", keyword);
		model.addAttribute("boardVo", map.get("boardVo"));
		model.addAttribute("tagList", map.get("tagList"));
		model.addAttribute("imgList", map.get("imgList"));
		model.addAttribute("vidList", map.get("vidList"));
		model.addAttribute("prev", map.get("prev"));
		model.addAttribute("next", map.get("next"));
		return ".mypage.myboard.select";
	}
	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session,
			@RequestParam(value="selectedUserNum",defaultValue="0")int selectedUserNum){
		int user_num=0;
		if(selectedUserNum!=0) {
			user_num=selectedUserNum;
		}else {
			user_num=(Integer)session.getAttribute("user_num");
		}
		MySkinViewVo msv=new MySkinViewVo(0,user_num, "±âº»", "#00cee8","", 0, 0, "default-profile.png", "default-profile.png", 0,"logo2.png", "logo2.png","");
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", "ms_using");
		map.put("user_num", user_num);
		MySkinViewVo vo=(MySkinViewVo)mySkinService.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}
}
