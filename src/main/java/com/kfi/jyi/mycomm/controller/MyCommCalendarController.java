package com.kfi.jyi.mycomm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
		MyCalendar mc = new MyCalendar();
		HashMap<String, Integer> calc=mc.getCalDay(year, month);
		year=calc.get("year");
		month=calc.get("month");
		ArrayList<Integer> arr = mc.getCal(year, month, 1);
		String mon=mc.getMonth(month);
		
		model.addAttribute("arr", arr);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("mon", mon);

		/* 유저가 속한 모든 커뮤니티의 월별 일정 불러오기 */
		//int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> hm=new HashMap<>();
		hm.put("user_num", 1);
		hm.put("begin",mc.begin(year, month));
		hm.put("end",mc.end(year, month));

		List<CommCalendarVo> list=service.myCommCalendar(hm);
		model.addAttribute("list",list);
		
		return ".mypage.mycommcalendar.calendar";
	}
}
