package com.kfi.dgl.commcalendar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.CommCalendarService;
import com.kfi.jyi.util.MyCalendar;
import com.kfi.jyi.vo.CommCalendarVo;

@Controller(value="CommCalendarListController")
public class ListController {
	@Autowired private CommCalendarService service;
	@RequestMapping(value = "/community/commcalendar/list", method = RequestMethod.GET)
	public String commcalendar(HttpSession session, Model model) {
		/* 커뮤니티 일정 LIST */
		int comm_num = 0;
		Object comm_num1= session.getAttribute("comm_num");
		if(comm_num1!=null && comm_num1!="") {
			comm_num=(Integer)comm_num1;
		}
		List<CommCalendarVo> list = service.listEvent(comm_num);
		MyCalendar mc = new MyCalendar();
		mc.changeEnd(list);
		mc.getEnd();
		model.addAttribute("list", list);
		return ".community.commcalendar.calendar";
	}
}
