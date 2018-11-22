package com.kfi.dgl.commcalendar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.CommCalendarService;
import com.kfi.jyi.vo.CommCalendarVo;

@Controller(value = "CommCalendarController")
public class CommCalendarController {
	@Autowired private CommCalendarService service;
	
	@RequestMapping(value="/community/commcalendar", method = RequestMethod.GET)
	public String commcalendar(HttpSession session, Model model) {
		/* 커뮤니티 일정 LIST */
		int comm_num1=(Integer)session.getAttribute("comm_num");
		System.out.println(comm_num1+"!!!!!!!!comm_num1");
		List<CommCalendarVo> list= service.listEvent(comm_num1);
		
		/* mycalendar 유틸  넣었다가 빼서 모델에 넣으세여 하고 이 문장은 지우세여*/
		
		model.addAttribute("list",list);
		return ".community.commcalendar.calendar";
	}
	
	@RequestMapping(value="/community/commcalendar", method = RequestMethod.POST)
	public String commcalendar(CommCalendarVo vo, HttpSession session) {
		int cc_num= service.getmaxnum()+1;
		System.out.println(vo.getCc_num());
		System.out.println(cc_num);
		vo.setCc_num(cc_num);
		int comm_num=(int) session.getAttribute("comm_num");
		vo.setComm_num(comm_num);
		System.out.println(comm_num);
		int n = service.addEvent(vo);
		if(n>0) {
			System.out.println("된다");
			return "redirect:/community/commcalendar";
		}else {
			System.out.println("안되");
			return "redirect:/";
		}
	}
	@RequestMapping(value="/community/detail", method = RequestMethod.POST)
	public String eventDetail(CommCalendarVo vo, HttpSession session) {
		int comm_num1=(int) session.getAttribute("comm_num");
		System.out.println(session.getAttribute("comm_num"));
		vo.setComm_num(comm_num1);
		System.out.println(vo.getComm_num());
		int n = service.selectEvent(comm_num1);
		if(n>0) {
			System.out.println("된다아아ㅏㅏ");
			return ".community.commcalendar.calendar";
		}else {
			System.out.println("안되으으");
			return "redirect:/";
		}
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/community/list", method = RequestMethod.POST)
	public String listEvent(HttpSession session, Model model, CommCalendarVo vo)throws Exception{
		int comm_num1=(int) session.getAttribute("comm_num");
		System.out.println(session.getAttribute("comm_num"));
		vo.setComm_num(comm_num1);
		List<CommCalendarVo> list= service.listEvent(comm_num1);
		model.addAttribute("list",list);
		return ".community.commcalendar.calendar";
		
	}
	
	@RequestMapping(value="/community/delete", method = RequestMethod.POST)
	public String deleteEvent(HttpSession session, int cc_num) {
		int comm_num2=(Integer) session.getAttribute("comm_num");
		System.out.println(session.getAttribute("comm_num"));
		int n= service.deleteEvent(comm_num2);
		if(n>0) {
			System.out.println("성공");
			return ".community.commcalendar.calendar";
		}else {
			System.out.println("실패");
			return ".community";
		}
	}
}

