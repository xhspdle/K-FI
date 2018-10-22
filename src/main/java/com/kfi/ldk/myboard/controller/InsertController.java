package com.kfi.ldk.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.MyBoardService;
import com.kfi.ldk.vo.MyBoardVo;

@Controller
public class InsertController {
	@Autowired private MyBoardService service;
	@RequestMapping(value="/mypage/insert",method=RequestMethod.GET)
	public String insertForm() {
		return "mypage/insert";
	}
	@RequestMapping(value="/mypage/insert",method=RequestMethod.POST)
	public String insert(MyBoardVo vo) {
		try {
			service.insert(vo);
			return "success";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}
	}
}
