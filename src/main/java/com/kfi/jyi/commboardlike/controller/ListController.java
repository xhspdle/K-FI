package com.kfi.jyi.commboardlike.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller(value="commBoardLikeListController")
public class ListController {
	
	@Autowired 
	@Qualifier("commBoardLikeServiceImpl") CommonService service;
	
	@RequestMapping(value="/commboardlike/list")
	@ResponseBody
	public HashMap<String, Object> likeList(String cb_num){
		int cbNum=0;
		if(cb_num!=null) {
			cbNum=Integer.parseInt(cb_num);
		}
		List<MySkinViewVo> list=(List<MySkinViewVo>)service.list(cbNum);
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list);
		return map;
	}

}
