package com.kfi.jyi.commcomment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="commCommentUpdateController")
public class UpdateController {
	
	@Autowired
	@Qualifier("commCommentServiceImpl") private CommonService service;
	
	@RequestMapping(value="/communityBoard/comment/update",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> update(String commc_num, String commc_content){
		int commcNum=0;
		if(commc_num!=null && !commc_num.equals("")) {
			commcNum=Integer.parseInt(commc_num);
		}
		HashMap<String, Object> map=new HashMap<>();
		map.put("commc_num", commcNum);
		map.put("commc_content", commc_content);
		int result=service.update(map);
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		
		return resultMap;
	}

}
