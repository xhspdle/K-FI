package com.kfi.jyi.myboard.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.utils.MyCalendar;

@Controller
public class HomeController {

	@RequestMapping(value="/mypage/mycal",method=RequestMethod.GET)
	public String mypage(Model model) {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH); 
		int day=cal.get(Calendar.DATE);
		
		MyCalendar mc=new MyCalendar();
		ArrayList<Integer> arr=mc.getCal(year,month,1);

		model.addAttribute("arr", arr);
		model.addAttribute("year", year);
		model.addAttribute("month", month+1);
		model.addAttribute("day", day);
		
		return ".mypage.mypage";
	}
}
