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
public class UpdateController {
	@Autowired private MembersService service;
	
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService mySkinService;

	@SuppressWarnings("unchecked")
	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session){
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
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
	
	@RequestMapping(value="/mypage/myinfo/updateJSON",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateJSON(String user_pwd,String user_nickname,String user_email, HttpSession session) {
		int user_num=(Integer)session.getAttribute("user_num");
		String user_id=(String)session.getAttribute("user_id");
		int nickOk=service.nickCheck(user_nickname);
		JSONObject json=new JSONObject();
		if(nickOk>1) {
			json.put("nickOk", nickOk);
			return json.toString();
		}else {
			MembersVo vo=service.select(user_num);
			MembersVo updatevo=new MembersVo(user_num, user_id, user_pwd, user_nickname, user_email, null,vo.getUser_status(),vo.getUser_certi());
			int result=service.update(updatevo);
			json.put("result", result);
			return json.toString();
		}
	}
	
	@RequestMapping(value="/mypage/myinfo/update",method=RequestMethod.POST)
	public String update(String user_pwd,String user_nickname,String user_email, HttpSession session) {
		int user_num=(Integer)session.getAttribute("user_num");
		String user_id=(String)session.getAttribute("user_id");
		MembersVo vo=service.select(user_num);
		MembersVo updatevo=new MembersVo(user_num, user_id, user_pwd, user_nickname, user_email, null,vo.getUser_status(),vo.getUser_certi());
		service.update(updatevo);
		return "redirect:/mypage/myinfo/password";
	}
}