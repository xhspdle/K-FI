package com.kfi.ysy.admin.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.ysy.service.AccuseService;
import com.kfi.ysy.util.AdminPageUtil;
import com.kfi.ysy.vo.AccuseVo;

//신고게시판
@Controller
public class AccuseController {
	@Autowired 
	private AccuseService acservice;
	//신고게시판 리스트
	@RequestMapping("/accuse")
	public String aclist(@RequestParam(value="pagenum", defaultValue="1")int pagenum,String field, String keyword, Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("field", field);
		map.put("keyword",keyword);
		int totalrowcnt=acservice.acgetcnt(map);
		AdminPageUtil apu=new AdminPageUtil(totalrowcnt, pagenum, 5, 5);
		map.put("startrow",apu.getStartrow());	
		map.put("endrow",apu.getEndrow());
		List<AccuseVo> aclist = acservice.aclist(map);
		if(aclist!=null) {
			model.addAttribute("aclist", aclist);
			model.addAttribute("apu",apu);
			model.addAttribute("field",field);
			model.addAttribute("keyword",keyword);
			return ".admin.accuseboard";
		}else {
			return ".admin.error";
		}
	}
}
