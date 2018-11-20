package com.kfi.ldk.myboardlike.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.util.PageUtil;

@Controller(value="MyBoardLikeListController")
public class ListController {
	@Autowired
	@Qualifier("myBoardLikeServiceImpl") private CommonService service;
	@RequestMapping("/mypage/myboardlike/list")
	@ResponseBody
	public HashMap<String, Object> list(@RequestParam(value="pageNum",defaultValue="1") 
		int pageNum,int mb_num){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("mb_num", mb_num);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 15, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("list", service.list(map));
		map.put("pu", pu);
		return map;
	}
}
