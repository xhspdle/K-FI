package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="MyBoardUpdateController")
public class UpdateController {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/mypage/myboard/updateModal",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> updateModal(int mb_num){
		HashMap<String, Object> map=(HashMap<String, Object>)service.select(mb_num);
		return map;
	}
}
