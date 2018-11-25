package com.kfi.dgl.commcalendar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.CommCalendarService;
import com.kfi.jyi.util.MyCalendar;
import com.kfi.jyi.vo.CommCalendarVo;

@Controller(value = "CommCalendarController")
public class CommCalendarController {
	@Autowired
	private CommCalendarService service;

/*	@RequestMapping(value = "/community/detail", method = RequestMethod.POST)
	public String eventDetail(CommCalendarVo vo, HttpSession session, HttpServletRequest request) {
		String cc_name = request.getParameter("cc_name");
		String cc_info = request.getParameter("cc_name");
		int comm_num1 = (int) session.getAttribute("comm_num");
		System.out.println(session.getAttribute("comm_num"));
		vo.setComm_num(comm_num1);
		System.out.println(vo.getComm_num());
		int n = service.selectEvent(comm_num1);

		if (n > 0) {
			System.out.println("된다아아ㅏㅏ");
			return "redirect:/community/update";
		} else {
			System.out.println("안되으으");
			return "redirect:/";
		}
	}*/

/*	@RequestMapping(value = "/community/delete", method = RequestMethod.GET)
	public String deleteEvent(HttpSession session, String cc_name, HttpServletRequest request, CommCalendarVo vo) {
		int comm_num = (Integer) session.getAttribute("comm_num");
		vo.setComm_num(comm_num);
		int cc_num1= (Integer)session.getAttribute("cc_num");
		System.out.println(session.getAttribute("comm_num"));
		System.out.println(vo.getComm_num()+"####");
		System.out.println(cc_name+"제목제목");
		System.out.println(cc_num1);
		int n = service.deleteEvent(cc_name);
		if (n > 0) {
			System.out.println("성공");
			return "redirect:/community/commcalendar";
		} else {
			System.out.println("실패");
			return "redirect:/";
		}
	}*/

/*	@RequestMapping(value = "/community/update", method = RequestMethod.POST)
	public String updateEvent(HttpSession session, int cc_num, CommCalendarVo vo, HttpServletRequest request) {
		int comm_num = (Integer) session.getAttribute("comm_num");
		String cc_name = request.getParameter("cc_name");
		String cc_info = request.getParameter("cc_info");
		 Date cc_begin = request.getParameter("cc_begin"); 
		System.out.println("어느쪽이게?" + session.getAttribute("comm_num"));
		vo.setComm_num(comm_num);

		int n = service.updateEvent(new CommCalendarVo(cc_num, comm_num, cc_name, cc_info, null, null));
		if (n > 0) {
			System.out.println("성공");
			return "redirect:/community/commcalendar";
		} else {
			System.out.println("실패");
			return "redirect:/";
		}
	}*/
}
