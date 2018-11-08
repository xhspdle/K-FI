package com.kfi.ldk.mycomment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="MyCommentDeleteController")
public class DeleteController {
	@Autowired 
	@Qualifier("myCommentServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/mycomment/delete")
	@ResponseBody
	public HashMap<String, Object> delete(int myc_num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int n=service.delete(myc_num);
		if(n>0) {
			map.put("code","success");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
