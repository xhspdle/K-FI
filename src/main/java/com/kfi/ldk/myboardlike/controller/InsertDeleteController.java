package com.kfi.ldk.myboardlike.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyBoardLikeVo;

@Controller(value="MyBoardLikeInsertDeleteController")
public class InsertDeleteController {
	@Autowired
	@Qualifier("myBoardLikeServiceImpl") private CommonService service;
	@RequestMapping("/mypage/myboardlike/insert")
	@ResponseBody
	public HashMap<String, Object> insert(int mb_num,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		int n=service.insert(new MyBoardLikeVo(0, mb_num, user_num));
		map.put("mb_num", mb_num);
		map.put("boardLikeCnt", service.getCount(map));
		if(n>0) {
			map.put("code", "success");
		}else if(n==-1) {
			map.put("code", "duplicated");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
