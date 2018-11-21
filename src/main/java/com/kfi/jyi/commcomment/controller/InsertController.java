package com.kfi.jyi.commcomment.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="commCommentInsertController")
public class InsertController {

	@Autowired
	@Qualifier("commCommentServiceImpl") private CommonService service;
	
	@RequestMapping(value="/commcomment/insert")
	@ResponseBody
	public HashMap<String, Object> insert(String commc_content, String cb_num, HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		int cbNum=0;
		if(cb_num!=null && !cb_num.equals("")) {
			cbNum=Integer.parseInt(cb_num);
		}
		map.put("cb_num", cbNum);
		map.put("commc_content", commc_content);
		int result=service.insert(map);
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
}
