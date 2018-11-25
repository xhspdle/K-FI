package com.kfi.dgl.commcalendar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.CommCalendarService;
import com.kfi.jyi.vo.CommCalendarVo2;

@Controller(value="CommCalendarInsertController")
public class InserController {
	@Autowired private CommCalendarService service;
	@RequestMapping(value = "/community/commcalendar/insert", method = RequestMethod.POST)
	public String insert(CommCalendarVo2 vo, HttpSession session) {
		int cc_num = service.getMaxnum() + 1;
		System.out.println(vo.getCc_num());
		System.out.println(cc_num);
		vo.setCc_num(cc_num);
		int comm_num = (int) session.getAttribute("comm_num");
		vo.setComm_num(comm_num);
		System.out.println(comm_num);
		int n = service.addEvent(vo);
		if (n > 0) {
			session.setAttribute("cc_num", cc_num);
			System.out.println("µÈ´Ù");
			return "redirect:/community/commcalendar/list";
		} else {
			System.out.println("¾ÈµÅ");
			return "redirect:/";
		}
	}
}
