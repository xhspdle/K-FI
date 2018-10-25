package com.kfi.ldk.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.jyi.util.MyCalendar;

@Controller
public class MyPageController {
	Calendar cal = Calendar.getInstance();

	@RequestMapping(value = "/mypage/main", method = RequestMethod.GET)
	public String myPage(Model model, @RequestParam(value = "year", defaultValue = "-1") int year,
			@RequestParam(value = "month", defaultValue = "-2") int month) {

		/* left-side bar Calendar */
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
		
		return ".mypage";
	}
}
