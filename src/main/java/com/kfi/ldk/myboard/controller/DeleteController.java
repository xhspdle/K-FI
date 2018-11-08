package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="MyBoardDeleteController")
public class DeleteController {
	@Autowired 
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/myboard/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(int mb_num,String user_pwd,
			HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("mb_num", mb_num);
		map.put("user_pwd", user_pwd);
		map.put("session", session);
		int n=service.delete(map);
		if(n>0) {
			map.put("code", "success");
		}else if(n==-1) {
			map.put("code", "wrong password");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
