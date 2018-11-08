package com.kfi.ldk.mycomment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyCommentVo;

@Controller(value="MyCommentUpdateController")
public class UpdateController {
	@Autowired 
	@Qualifier("myCommentServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/mycomment/update")
	@ResponseBody
	public HashMap<String, Object> update(int myc_num,
			String myc_content){
		HashMap<String, Object> map=new HashMap<String, Object>();
		int n=service.update(new MyCommentVo(myc_num, 0, 0, myc_content, null));
		if(n>0) {
			map.put("code", "success");
		}else {
			map.put("code", "fail");
		}
		return map;
	}
}
