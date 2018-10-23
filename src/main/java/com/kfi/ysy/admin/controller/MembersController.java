package com.kfi.ysy.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ysy.admin.service.MembersService;
import com.kfi.ysy.admin.vo.MembersVo;



@Controller
public class MembersController {
	@Autowired private MembersService mbservice;
	@RequestMapping(value = "/mblist", method = RequestMethod.GET)
	public String mblist(Model model) {
		List<MembersVo> mblist = mbservice.mblist();
		model.addAttribute("mblist", mblist);
		return ".admin.mblist";
	}
	@RequestMapping(value="/mbdelete", method=RequestMethod.GET)
	public String mbdelete(int user_num) {
		System.out.println(user_num);
		int result=mbservice.mbdelete(user_num);
		if(result>0) {
			System.out.println("사용불가능한 아이디입니다!!!!");
		}else{
			System.out.println("사용가능한 아이디입니다.");	
		}
		return "redirect:/mblist";
	}
	@RequestMapping(value="/mbgetinfo", method=RequestMethod.GET)
	public String mbgetinfo(int user_num, Model model) {
		MembersVo vo=mbservice.mbgetinfo(user_num);
		model.addAttribute("mbinfo", vo);
		return "redirect:/mblist";
	}
}
