package com.kfi.jyi.mycomm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.jyi.mycomm.service.MyCommCalendarService;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;
import com.kfi.jyi.util.MyCalendar;

@Controller(value = "MyCommCalendarController")
public class MyCommCalendarController {
	Calendar cal = Calendar.getInstance();
	@Autowired private MyCommCalendarService service;
	
	@RequestMapping(value = "/mypage/mycommcalendar", method = RequestMethod.GET)
	public String mycommcalendar(Model model, 
			@RequestParam(value = "year", defaultValue = "-1") int year,
			@RequestParam(value = "month", defaultValue = "-2") int month,
			HttpSession session) {
		
		/* Calendar */
		if (year == -1) year = cal.get(Calendar.YEAR);
		if (month == -2) month = cal.get(Calendar.MONTH);
		if (month == 12) {
			year += 1;
			month = 0;
		} else if (month == -1) {
			year -= 1;
			month = 11;
		}

		MyCalendar mc = new MyCalendar();
		ArrayList<Integer> arr = mc.getCal(year, month, 1);

		String[] mon = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		model.addAttribute("arr", arr);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("mon", mon);

		/* Comm User List */
		//String user_id=(String)session.getAttribute("user_id");
		String user_id="user_id 1";
		List<CommCalendarVo> list=service.myCommCalendar(user_id);
		model.addAttribute("list",list);
		
		return ".mypage.mycommcalendar.calendar";
	}
}
