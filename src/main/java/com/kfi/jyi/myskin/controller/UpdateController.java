package com.kfi.jyi.myskin.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.jyi.vo.MySkinVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "myskinUpdateController")
public class UpdateController {
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService service;

	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",1);
		List<MySkinViewVo> list=(List<MySkinViewVo>)service.list(map);
		MySkinViewVo msv=new MySkinViewVo(0, 0, "기본", "#00cee8"," ", 0, 0, "", "default-profile.png", 0, "", "logo2.png","");
		if(list!=null) {
			for(MySkinViewVo vo: list) {
				msv=vo;
			}
		}
		return msv;
	}
	
	@RequestMapping(value = "/mypage/myskin/updateform", method = RequestMethod.GET)
	public String updateForm(Model model, String ms_num) {
		int msNum = Integer.parseInt(ms_num);
		MySkinViewVo vo=(MySkinViewVo)service.select(msNum);
		model.addAttribute("msvlist", vo);
		return ".mypage.myskin.update";
	}

	@RequestMapping(value = "/mypage/myskin/update", method = RequestMethod.POST)
	public String update(HttpSession session, MultipartFile ms_cover, MultipartFile ms_profile, 
			String ms_name, String ms_color, String ms_msg, String ms_num, String ms_using) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("session", session);
		hm.put("ms_num", Integer.parseInt(ms_num));
		hm.put("ms_profile", ms_profile);
		hm.put("ms_cover", ms_cover);
		hm.put("ms_name", ms_name);
		System.out.println("ms_name:"+ms_name);
		hm.put("ms_color", ms_color);
		System.out.println("ms_color:"+ms_color);
		hm.put("ms_msg", ms_msg);
		hm.put("ms_using",Integer.parseInt(ms_using));
		int result = service.update(hm);
		if (result > 0) {
			return "redirect:/mypage/myskin/list";
		} else {
			return "redirect:/mypage/myskin/list"; // 에러페이지 이동
		}
	}
}
