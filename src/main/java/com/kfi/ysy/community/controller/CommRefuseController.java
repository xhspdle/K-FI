package com.kfi.ysy.community.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.vo.CommRefuseVo;
import com.kfi.ldk.service.CommonService;


@Controller(value="communityrefusecontroller")
public class CommRefuseController {
	@Autowired
	@Qualifier("commRefuseServiceImpl") private CommonService service;
	@RequestMapping(value="/community/commrefuse/insert", method=RequestMethod.POST)
	public String insert(CommRefuseVo vo,int comm_num) {
		int result=service.insert(vo);
		if(result>0) {
			return "redirect:/community/commadmin/commuserlist?comm_num="+comm_num;
		}else {
			return "fail";
		}
		
	}
}
