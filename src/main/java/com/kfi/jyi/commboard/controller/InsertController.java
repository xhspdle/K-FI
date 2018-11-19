package com.kfi.jyi.commboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.ldk.service.CommonService;

@Controller(value="commBoardInsertController")
public class InsertController {
	
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
	
	@RequestMapping(value="/community/board/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".community.board.insert";
	}
	
	@RequestMapping(value="/community/board/insert",method=RequestMethod.POST)
	public String insert(HttpSession session,String cb_title, String cb_content, String cb_notice,
			String[] tag_name, MultipartFile[] fileP, MultipartFile[] fileV) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("cb_title", cb_title);
		map.put("cb_content", cb_content);
		map.put("cb_notice", cb_notice);
		map.put("tag_name", tag_name);
		map.put("fileP", fileP);
		map.put("fileV", fileV);
		int result=commBoardservice.insert(map);
		if(result>0) {
			return "redirect:/community";
		}else {
			return "redirect:/community"; //오류
		}
	}
}
