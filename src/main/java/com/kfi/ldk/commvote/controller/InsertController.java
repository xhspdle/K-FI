package com.kfi.ldk.commvote.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.CommVoteVo;

@Controller(value="CommVoteInsertController")
public class InsertController {
	@Autowired
	@Qualifier("commVoteServiceImpl") private CommonService service;
	@RequestMapping("/community/polls/insert")
	public String insert(CommVoteVo cvVo,HttpServletRequest request,
			HttpSession session,Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		String[] vo_content=request.getParameterValues("vo_content");
		int user_num=0;
		Object session_num=session.getAttribute("user_num");
		if(session_num!=null && session_num!="") {
			user_num=(Integer)session_num;
		}
		if(user_num==0) {
			model.addAttribute("msg", "Login first");
			return ".community.polls.list";
		}
		//int comm_num=(Integer)session.getAttribute("comm_num");
		int comm_num=1;
		cvVo.setComm_num(comm_num);
		cvVo.setUser_num(user_num);
		map.put("CommVoteVo", cvVo);
		map.put("vo_content", vo_content);
		int n=service.insert(map);
		if(n>0) {
			return "redirect:/community/polls/list";
		}else {
			model.addAttribute("msg", "fail");
			return ".community.polls.list";
		}
	}
}
