package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.util.PageUtil;

@Controller(value="MyBoardListController")
public class ListController {
	@Autowired 
	@Qualifier("myBoardServiceImpl") private CommonService service;//Qualifier("앞문자소문자")
	@RequestMapping(value="/mypage/myboard/list",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> list(@RequestParam(value="pageNum",defaultValue="1")
			int pageNum,String keyword,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		map.put("user_num", user_num);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("pu", pu);
		map.put("list", service.list(map));
		return map;
	}
	@RequestMapping(value="/mypage/myboard/list",method=RequestMethod.POST)
	public String searchList(@RequestParam(value="pageNum",defaultValue="1")
			int pageNum,String keyword,Model model){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		model.addAttribute("pu", pu);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", service.list(map));
		return ".mypage.myboard.searchMain";
	}
}
