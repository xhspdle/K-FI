package com.kfi.jyi.commcomment.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfi.jyi.util.PageUtil;
import com.kfi.jyi.vo.CommCommentVo;
import com.kfi.ldk.service.CommonService;

@Controller(value="commCommentListController")
public class ListController {
	@Autowired
	@Qualifier("commCommentServiceImpl") private CommonService service;
	
	@RequestMapping(value="/commcomment/list")
	public HashMap<String, Object> list(String cb_num, String pageNum){
		int cbNum=0;
		if(cb_num!=null) {
			cbNum=Integer.parseInt(cb_num);
		}
		int pageNUM=0;
		if(pageNum!=null && !pageNum.equals("")) {
			pageNUM=Integer.parseInt(pageNum);
		}
		HashMap<String, Object> map=new HashMap<>();
		map.put("cb_num", cbNum);
		map.put("pageNum",pageNUM);
		
		HashMap<String, Object> result=(HashMap<String, Object>)service.list(map);
		result.put("pageNum",pageNUM);
		return result;
	}

}
