package com.kfi.jyi.commboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.ldk.service.CommonService;

@Controller(value="commBoardInsertController")
public class InsertController {
	@Autowired 
	@Qualifier("commBoardServiceImpl")
	private CommonService service;
	
	
	@RequestMapping(value="/community/board/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".community.board.insert";
	}
	
	@RequestMapping(value="/community/board/insert",method=RequestMethod.POST)
	public String insert(HttpSession session,String cb_title, String cb_content, String cb_notice,
			String[] tag_name, MultipartFile[] fileP, MultipartFile[] fileV) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("cb_title", cb_title);
		map.put("cb_content", cb_content);
		map.put("cb_notice", cb_notice);
		map.put("tag_name", tag_name);
		map.put("fileP", fileP);
		map.put("fileV", fileV);
		int result=service.insert(map);
		if(result>0) {
			return "redirect:/community";
		}else {
			return "redirect:/community"; //¿À·ù
		}
	}
}
