package com.kfi.jyi.myinfo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller
public class DeleteController {
	@Autowired private MembersService service;
	
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService mySkinService;

	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("user_num", user_num);
		map.put("ms_using",1);
		List<MySkinViewVo> list=(List<MySkinViewVo>)mySkinService.list(map);
		MySkinViewVo msv=new MySkinViewVo(0, 0, "기본", "#00cee8"," ", 0, 0, "", "default-profile.png", 0, "", "logo2.png","");
		if(list!=null) {
			for(MySkinViewVo vo: list) {
				msv=vo;
			}
		}
		return msv;
	}
	
	//커뮤니티까지 끝내고 맨 마지막에 회원탈퇴하기
	
	@RequestMapping(value="/mypage/myinfo/delete",method=RequestMethod.POST)
	public String delete(String user_pwd, HttpSession session) {
		int user_num=(Integer)session.getAttribute("user_num");
		int result=service.delete(user_num);
		if(result>0) {
			session.removeAttribute("user_num");
			session.removeAttribute("user_id");
			return "redirect:/";
		}else {
			return "redirect:/mypage/myinfo/list";
		}
	}
	
	@RequestMapping(value="/mypage/myinfo/deleteJSON",produces="application/json;charset=utf-8")
	@ResponseBody
	public String deleteJSON(String user_pwd, HttpSession session) {
		int user_num=(Integer)session.getAttribute("user_num");
		MembersVo vo=service.select(user_num);
		int result=0;
		if(vo.getUser_pwd().equals(user_pwd)) {
			result=service.delete(user_num);
			if(result>0) {
				session.removeAttribute("user_num");
				session.removeAttribute("user_id");
			}
		}else {
			result=-1;
		}
		JSONObject json=new JSONObject();
		json.put("result", result);
		return json.toString();
	}
}
