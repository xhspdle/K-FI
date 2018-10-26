package com.kfi.jyi.mycomm.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.util.MyCalendar;


@Controller(value="MyCalendarScrollController")
public class MyCalendarModalController {
	Calendar cal = Calendar.getInstance();
	
	@RequestMapping(value="/mypage/mycalendarscroll",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getCalendar (@RequestParam(value = "year", defaultValue = "-1") int year,
			@RequestParam(value = "month", defaultValue = "-2") int month) {
		/* mypage Calendar Modal */
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
		String[] week= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		JSONObject json=new JSONObject();
		json.put("arr", arr);
		json.put("year", year);
		json.put("month", month);
		json.put("mon", mon[month]);
		json.put("week", week);
		
		return json.toString();
	}
	
}
