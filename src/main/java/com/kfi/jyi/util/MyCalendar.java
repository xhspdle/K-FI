package com.kfi.jyi.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCalendar {
	Calendar cal = Calendar.getInstance();

	public ArrayList<Integer> getCal(int year, int month, int day) {
		cal.set(year, month, day);
		int blankNum = cal.get(Calendar.DAY_OF_WEEK) - 1; // 현재 요일 (일요일은 1, 토요일은 7)
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 현재 월의 날짜 (DATE와 동일)
		// getActualMaximum 현재 객체의 특정 필드의 최대 값을 반환한다.

		int gong=0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= blankNum; i++) {
			gong+=1;
			arr.add(0);// 앞공백
		}
		for (int i = 1; i <= maxDay; i++) {
			gong+=1;
			arr.add(i);// 해당 월의 날짜 넣기
		}
		if(gong>(7*5)) gong=(7*6)-gong;
		else if(gong>(7*4)) gong=(7*5)-gong;
		for(int i=1;i<=gong;i++) {
			arr.add(0); //뒤공백
		}
		return arr;
	}
	
	
	public String maxDay(int year, int month) {
		cal.set(year, month, 1);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 현재 월의 날짜 (DATE와 동일)
		String end=String.valueOf(maxDay);
		return end;
	}
	
	
	public String begin(int year, int month) {
		String begin=String.valueOf(year).substring(2, 4)+"/"+String.valueOf(month+1)+"/01";
		return begin;
	}
	
	public String end(int year, int month) {
		String e=maxDay(year, month);
		String end=String.valueOf(year).substring(2, 4)+"/"+String.valueOf(month+1)+"/"+e;
		return end;
	}
	
	public HashMap<String, Integer> getCalDay(int year, int month) {
		if (year == -1) year = cal.get(Calendar.YEAR);
		if (month == -2) month = cal.get(Calendar.MONTH);
		if (month == 12) {
			year += 1;
			month = 0;
		} else if (month == -1) {
			year -= 1;
			month = 11;
		}
		HashMap<String, Integer> hm=new HashMap<>();
		hm.put("year", year);
		hm.put("month",month);
		return hm;
	}
	
	public String getMonth(int month) {
		String[] mon = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return mon[month];
	}
	
	
}
