package com.kfi.jyi.utils;

import java.util.ArrayList;
import java.util.Calendar;

public class MyCalendar {
	Calendar cal = Calendar.getInstance();

	public ArrayList<Integer> getCal(int year, int month, int day) {
		cal.set(year, month, day);
		int blankNum = cal.get(Calendar.DAY_OF_WEEK) - 1; // 현재 요일 (일요일은 1, 토요일은 7)
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 현재 월의 날짜 (DATE와 동일)
		// getActualMaximum 현재 객체의 특정 필드의 최대 값을 반환한다.

		if ((year % 4 == 0 || year % 400 == 0) && (year % 100 == 0) && (month == 1)) {
			maxDay += 1; // 윤년 2월 29일
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= blankNum; i++) {
			arr.add(0);// 공백
		}
		for (int i = 1; i <= maxDay; i++) {
			arr.add(i);// 해당 월의 날짜 넣기
		}
		return arr;
	}

}
