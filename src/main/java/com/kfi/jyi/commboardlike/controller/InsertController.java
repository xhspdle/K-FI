package com.kfi.jyi.commboardlike.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="commBoardLikeController")
public class InsertController {

	@Autowired 
	@Qualifier("commBoardLikeServiceImpl") private CommonService service;
	
	@RequestMapping(value="/commboardlike/insert")
	@ResponseBody
	public HashMap<String, Object> insertCommBoardLike(String cb_num, HttpSession session) {
		int cbNum=0;
		if(cb_num!=null) {
			cbNum=Integer.parseInt(cb_num);
		}

		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("cb_num",cbNum);
		int result=service.insert(map);
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	
}
