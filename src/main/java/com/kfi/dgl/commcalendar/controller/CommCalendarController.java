package com.kfi.dgl.commcalendar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.CommCalendar;
import com.kfi.jyi.vo.CommCalendarVo;

@Controller(value = "CommCalendarController")
public class CommCalendarController {
	@Autowired private CommCalendar service;
	@RequestMapping(value="/community/commcalendar", method = RequestMethod.GET)
	public String commcalendar() {
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
			return ".community.commcalendar.calendar";
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
			System.out.println("ㄷㄷㄷ");
			return ".community.commcalendar.calendar";
		}else {
			System.out.println("안되으으");
			return "redirect:/";
		}
	}
/*	@RequestMapping(value="/community/list", method = RequestMethod.POST)
	public String listEvent() {
		
	}
	
	@RequestMapping(value="/community/delete", method = RequestMethod.POST)
	public String deleteEvent() {
	}*/
}

