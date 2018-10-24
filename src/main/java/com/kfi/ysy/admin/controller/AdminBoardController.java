package com.kfi.ysy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ysy.admin.service.AdminBoardService;
import com.kfi.ysy.admin.vo.AdminBoardVo;



@Controller
public class AdminBoardController {
	@Autowired 
	private AdminBoardService abservice;
	//관리자 게시판 리스트조회
	@RequestMapping(value = "/ablist", method = RequestMethod.GET)
	public String ablist(Model model) {
		List<AdminBoardVo> ablist = abservice.ablist();
		if(ablist!=null) {
			model.addAttribute("ablist", ablist);
			return ".admin.adminboard";
		}else{
			System.out.println(ablist);
			return ".main.error";
		}
	}
	//관리자 게시판 양식
	@RequestMapping(value="/abinsert", method=RequestMethod.GET)
	public String abinsertForm() {
		return ".admin.abdetail";
	}
	//관리자 게시판 등록
	@RequestMapping(value="/abinsert", method=RequestMethod.POST)
	public String abinsert(AdminBoardVo vo) {
		int ab_num=abservice.abmaxcnt()+1;
		vo.setAb_num(ab_num);
		int result=abservice.abinsert(vo);
		if (result>0){
			return "redirect:/ablist";		
		}else {
			return ".admin.error";
		}
	}
}

