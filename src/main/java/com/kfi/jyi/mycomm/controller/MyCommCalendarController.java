package com.kfi.jyi.mycomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.mycomm.service.MyCommCalendarService;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;
import com.kfi.jyi.mycomm.vo.CommunityVo;
import com.kfi.jyi.util.MyCalendar;

@Controller(value = "MyCommCalendarController")
public class MyCommCalendarController {
	@Autowired private MyCommCalendarService service;
	
	@RequestMapping(value = "/mypage/mycommcalendar", method = RequestMethod.GET)
	public String mycommcalendar(Model model, HttpSession session) {

		/* ������ ���� ��� Ŀ�´�Ƽ�� ���� ���� �ҷ����� */
		//int user_num=(Integer)session.getAttribute("user_num");
		List<CommCalendarVo> monthlist=service.myCommCalendar(1); 
		MyCalendar mc=new MyCalendar();
		monthlist=mc.changeEnd(monthlist);
		model.addAttribute("monthlist",monthlist);
		
		/* ������ ���� ��� Ŀ�´�Ƽ ��� �ҷ����� */
		List<CommunityVo> communitylist =service.getMyCommunityList(1);
		model.addAttribute("communitylist", communitylist);
		
		return ".mypage.mycommcalendar.calendar";
	}
}
