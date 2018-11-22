package com.kfi.jyi.commcomment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="commCommentDeleteController")
public class DeleteController {

	@Autowired
	@Qualifier("commCommentServiceImpl") private CommonService service;
	
	
	@RequestMapping(value="/communityBoard/comment/delete",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> delete(String commc_num){
		int commcNum=0;
		if(commc_num!=null && !commc_num.equals("")) {
			commcNum=Integer.parseInt(commc_num);
		}
		int result=service.delete(commcNum);
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		
		return resultMap;
	}
	
}
