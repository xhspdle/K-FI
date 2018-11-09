package com.kfi.ldk.mycommentlike.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyCommentLikeVo;

@Controller(value="MyCommentLikeInsertDeleteController")
public class InsertDeleteController {
	@Autowired
	@Qualifier("myCommentLikeServiceImpl") private CommonService service;
	@RequestMapping("/mypage/mycommentlike/insert")
	@ResponseBody
	public HashMap<String, Object> insert(int myc_num,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		int n=service.insert(new MyCommentLikeVo(0, myc_num, user_num));
		map.put("myc_num", myc_num);
		map.put("commentLikeCnt", service.getCount(map));
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
