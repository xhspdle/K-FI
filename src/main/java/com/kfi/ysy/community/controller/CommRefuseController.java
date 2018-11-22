package com.kfi.ysy.community.controller;

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
	public String insert(CommRefuseVo vo) {
		int result=service.insert(vo);
		System.out.println(result);
		return null;
	}
}
