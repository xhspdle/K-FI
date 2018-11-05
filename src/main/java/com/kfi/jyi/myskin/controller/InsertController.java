package com.kfi.jyi.myskin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.ldk.service.CommonService;

@Controller(value = "myskininsertController")
public class InsertController {
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService service;

	@RequestMapping(value = "/mypage/myskin/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		return ".mypage.myskin.insert";
	}

	@RequestMapping(value = "/mypage/myskin/insert", method = RequestMethod.POST)
	public String insert(HttpSession session, MultipartFile[] ms_file, 
			String ms_name, String ms_color, String ms_msg) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("session", session);
		hm.put("ms_file", ms_file);
		hm.put("ms_name", ms_name);
		hm.put("ms_color", ms_color);
		hm.put("ms_msg", ms_msg);
		int result = service.insert(hm);
		if (result > 0) {
			return "redirect:/mypage/myskin/list";
		} else {
			return "redirect:/mypage/myskin/list"; //������������ ����
		}
	}

}