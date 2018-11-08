package com.kfi.jyi.myinfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;

@Controller
public class UpdateController {
	@Autowired private MembersService service;
	
	@RequestMapping(value="/mypage/myinfo/updateJSON",produces="application/json;charset=utf-8")
	public String updateJSON(String user_pwd,String user_nickname,String user_email, HttpSession session) {
		int user_num=(Integer)session.getAttribute("user_num");
		String user_id=(String)session.getAttribute("user_id");
		MembersVo vo=service.select(user_num);
		MembersVo updatevo=new MembersVo(user_num, user_id, user_pwd, user_nickname, user_email, null,vo.getUser_status(),vo.getUser_certi());
		int result=service.update(updatevo);
		if(result>0) {
			return "";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="/mypage/myinfo/update",method=RequestMethod.POST)
	public String update(String user_pwd,String user_nickname,String user_email, HttpSession session) {
		
		
		
		return "";
	}
	
	
}
