package com.kfi.ldk.controller;


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
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "insideCommunityController")
public class InsideCommunityController {

	@Autowired
	@Qualifier("communityServiceImpl")
	private CommonService commService;

	@Autowired
	@Qualifier("insideCommunityServiceImpl")
	private CommonService insideCommService;

	@Autowired
	@Qualifier("commBoardServiceImpl")
	private CommonService commBoardservice;

	@ModelAttribute("getCommNum")
	public void getCommNum(HttpSession session, String comm_num) {
		int commNum = 1;
		if (comm_num!=null) {
			commNum = Integer.parseInt(comm_num);
			session.setAttribute("comm_num", commNum);
			//System.out.println(comm_num+"!!!!!!!comm_num");
		}
	}

	// 가입한 유저인지, 강퇴당한 유저인지 확인하기
	@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session,String comm_num) {
		int commNum=1;
		if(comm_num!=null) {
			commNum=Integer.parseInt(comm_num);
		}else {
			commNum=(Integer)session.getAttribute("comm_num");
		}
		int user_num = (Integer) session.getAttribute("user_num");
		HashMap<String, Object> map = new HashMap<>();
		map.put("comm_num", commNum); 
		map.put("user_num", user_num);
		//회원인지 확인
		int cul_status = (Integer) insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);
		
		//관리자 번호
		int comm_adminNum=(Integer)commService.select(commNum);
		model.addAttribute("comm_adminNum", comm_adminNum);
		return cul_status;
	}

	// 해당 커뮤니티의 전체 게시물 불러오기
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String community(Model model, HttpSession session,String comm_num) {
		int commNum=1;
		if(comm_num!=null) {
			commNum=Integer.parseInt(comm_num);
		}else {
			commNum=(Integer)session.getAttribute("comm_num");
		}
		
		//공지사항 번호 --> 날짜 없으면 관리자가 공지사항 아님으로 수정해줘야함
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "notice");
		map.put("session", session);
		List<CommBoardVo> noticeList=(List<CommBoardVo>)commBoardservice.select(map);
		model.addAttribute("noticeList", noticeList);
		
		return ".community";
	}
	
	
	
}
