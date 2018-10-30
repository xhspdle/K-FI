package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonViewService;
import com.kfi.ldk.util.PageUtil;

@Controller(value="MyBoardListController")
public class ListController {
	@Autowired 
	@Qualifier("myBoardListViewServiceImpl") private CommonViewService service;//Qualifier("앞문자소문자")
	@RequestMapping("/mypage/myboard/list")
	@ResponseBody
	public HashMap<String, Object> list(@RequestParam(value="pageNum",defaultValue="1")
		int pageNum,String keyword,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
//		map.put("user_num", session.getAttribute("user_num"));
		map.put("user_num", 1);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("list", service.list(map));
		map.put("pu", pu);
		return map;
	}
}
