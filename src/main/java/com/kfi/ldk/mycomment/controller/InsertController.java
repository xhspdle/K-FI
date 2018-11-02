package com.kfi.ldk.mycomment.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyCommentVo;

@Controller(value="MyCommentInsertController")
public class InsertController {
	@Autowired
	@Qualifier("myCommentServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/mycomment/insert")
	@ResponseBody
	public HashMap<String, Object> insert(int mb_num,
			String myc_content,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		int n=service.insert(new MyCommentVo(0, mb_num, user_num, myc_content, null));
		if(n>0) {
			map.put("code", "success");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
