package com.kfi.jyi.insidecommunity.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.ldk.service.CommonService;

@Controller("insideCommunityListController")
public class ListController {
	@Autowired 
	@Qualifier("commBoardServiceImpl") private CommonService service;

	@Autowired 
	@Qualifier("insideCommunityServiceImpl") private CommonService insideCommService;
	
	// model attribute annotation - 프로필, 커버 사진 넣기

	// 가입한 유저인지, 강퇴당한 유저인지 확인하기 (글쓰기 disabled)
	@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session, String comm_num) {
		
		//수정 예정 
		
		/*int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",1);  
		map.put("user_num", user_num);
		int cul_status=(Integer)insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);
		return cul_status;*/
		return 0; 
	}
	
	
	//해당 커뮤니티의 전체 게시물 불러오기
	@RequestMapping(value="/community/selectComm",method=RequestMethod.GET)
	public String selectComm(String comm_num, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",comm_num);//Integer.parseInt(comm_num)
		map.put("cb_num", "");
		List<CommBoardViewVo> list=(List<CommBoardViewVo>)service.list(map);
		model.addAttribute("list", list);
		return ".community.list";
	}
	
	//해당 커뮤니티의 선택한 게시물 불러오기
	@RequestMapping(value="/community/selectCommBoard",method=RequestMethod.GET)
	public String selectCommBoard(String comm_num, String cb_num, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",comm_num);
		map.put("cb_num", cb_num);
		CommBoardViewVo list=(CommBoardViewVo)service.select(map);
		model.addAttribute("list", list);
		return ".community.board.list";
	}
	
}
