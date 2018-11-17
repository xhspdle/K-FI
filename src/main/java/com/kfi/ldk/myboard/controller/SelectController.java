package com.kfi.ldk.myboard.controller;

import java.util.HashMap;
import java.util.List;

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
	@SuppressWarnings("unchecked")
	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",1);
		List<MySkinViewVo> list=(List<MySkinViewVo>)mySkinService.list(map);
		MySkinViewVo msv=new MySkinViewVo(0, 0, "±âº»", "#00cee8"," ", 0, 0, "", "default-profile.png", 0, "", "logo2.png","");
		if(list!=null) {
			for(MySkinViewVo vo: list) {
				msv=vo;
			}
		}
		return msv;
	}
}
