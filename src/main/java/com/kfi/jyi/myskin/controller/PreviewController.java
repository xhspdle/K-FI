package com.kfi.jyi.myskin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller(value="myskinPreviewController")
public class PreviewController {

	
	@RequestMapping(value="/mypage/myskin/preview",produces="application/json;charset=utf-8")
	@ResponseBody
	public String preview(HttpSession session,MultipartFile file) {
		
		
		
		return "";
	}
}
