package com.kfi.jyi.commboard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="commBoardUpdateController")
public class UpdateController {
	
	@Autowired
	@Qualifier("commBoardServiceImpl")
	private CommonService commBoardservice;
	
	@Autowired
	@Qualifier("commBoardUpdateCntServiceImpl")
	private CommonService commBoardUpdateCntService;
	
	@RequestMapping(value="/community/board/updateViews")
	@ResponseBody
	public HashMap<String, Object> updateViewsCnt(String cb_num){
		int result=commBoardUpdateCntService.update(cb_num);
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		
		return resultMap;
	}
	
}
