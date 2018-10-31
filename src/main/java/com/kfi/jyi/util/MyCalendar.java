package com.kfi.jyi.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.kfi.jyi.vo.CommCalendarVo;

public class MyCalendar {
	Calendar cal = Calendar.getInstance();

	public String getBegin() {
		String year = String.valueOf(cal.get(Calendar.YEAR)).substring(2, 4);
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		if (Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		String begin = year + "/" + month + "/" + "01";
		return begin;
	}

	public String getEnd() {
		String year = String.valueOf(cal.get(Calendar.YEAR)).substring(2, 4);
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		String maxDay = String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		if (Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		String end = year + "/" + month + "/" + maxDay;
		return end;
	}

	public List<CommCalendarVo> changeEnd(List<CommCalendarVo> list) {
		for (CommCalendarVo vo : list) {
			Date end = vo.getCc_end();
			System.out.println(end);
			int year = Integer.parseInt(String.valueOf(end).substring(0, 4));
			int month = Integer.parseInt(String.valueOf(end).substring(5, 7));
			int date = Integer.parseInt(String.valueOf(end).substring(8, 10));
			date += 1;
			cal.set(year, month-1,1);
			int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (date >= maxDate) {
				date = 1;
				month += 1;
				if (month == 12) {
					year += 1;
					month = 1;
				}
			}
			String yyyy=String.valueOf(year);
			String mm=String.valueOf(month);
			String dd=String.valueOf(date);
			if (date < 10) dd="0"+dd;
			if (month < 10) mm="0"+mm;
			System.out.println(yyyy + "-" + mm + "-" + dd);
			end = Date.valueOf(yyyy + "-" + mm + "-" + dd);
			vo.setCc_end(end);
		}
		return list;
	}

}
