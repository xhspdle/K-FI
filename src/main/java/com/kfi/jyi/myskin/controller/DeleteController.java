package com.kfi.jyi.myskin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value = "myskinDeleteController")
public class DeleteController {
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService service;

	@RequestMapping(value = "/mypage/myskin/delete", method = RequestMethod.GET)
	public String delete(String ms_num) {
		int msNum=Integer.parseInt(ms_num);
		int result = service.delete(msNum);
		if (result > 0) {
			return "redirect: /mypage/myskin/list";
		} else {
			return "redirect: /mypage/myskin/list"; //에러페이지로 이동하기
		}
	}
}
