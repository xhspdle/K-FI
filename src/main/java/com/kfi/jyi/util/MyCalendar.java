package com.kfi.jyi.util;

import java.util.ArrayList;
import java.util.Calendar;

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
}
