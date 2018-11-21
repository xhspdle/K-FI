package com.kfi.jyi.commboard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ldk.service.CommonService;

@Controller(value="commBoardDeleteController")
public class DeleteController {

	@Autowired
	@Qualifier("commBoardServiceImpl")
	private CommonService commBoardservice;
	
	@RequestMapping(value="/community/board/delete",method=RequestMethod.POST)
	public String delete(String cb_num, String user_pwd, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("cb_num", cb_num);
		map.put("user_pwd", user_pwd);
	
		int result=(Integer)commBoardservice.delete(map);
		if(result>0) {
			return ".community";
		}else {
			return ".community"; //¿À·ù
		}
	
	}
	
}
