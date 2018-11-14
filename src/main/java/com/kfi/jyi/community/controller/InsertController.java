package com.kfi.jyi.community.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.ldk.service.CommonService;

@Controller(value="communityInsertController")
public class InsertController {
	@Autowired 
	@Qualifier("communityServiceImpl") private CommonService service;

	@RequestMapping(value="/community/newComm/insertForm",method=RequestMethod.GET)
	public String insertForm() {
		return ".community.createCommunity.insert";
	}
	
	@RequestMapping(value="/community/newComm/insert",method=RequestMethod.POST)
	public String insert(String comm_name, String comm_content, String cs_color,
			MultipartFile comm_skin_profile, MultipartFile comm_skin_cover,HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session",session);
		map.put("comm_name", comm_name);
		map.put("cs_color", cs_color);
		map.put("comm_content", comm_content);
		map.put("comm_skin_profile", comm_skin_profile);
		map.put("comm_skin_cover", comm_skin_cover);
		int result=(Integer)service.insert(map);
		if(result>0) {
			return ".community";
		}else {
			return ".community"; //오류페이지로 이동
		}
	}
	
	
	
	
}
