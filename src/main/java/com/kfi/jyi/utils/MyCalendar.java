package com.kfi.jyi.utils;

import java.util.ArrayList;
import java.util.Calendar;

public class MyCalendar {
	Calendar cal = Calendar.getInstance();

	public ArrayList<Integer> getCal(int year, int month, int day) {
		cal.set(year, month, day);
		int blankNum = cal.get(Calendar.DAY_OF_WEEK) - 1; // ���� ���� (�Ͽ����� 1, ������� 7)
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // ���� ���� ��¥ (DATE�� ����)
		// getActualMaximum ���� ��ü�� Ư�� �ʵ��� �ִ� ���� ��ȯ�Ѵ�.

		if ((year % 4 == 0 || year % 400 == 0) && (year % 100 == 0) && (month == 1)) {
			maxDay += 1; // ���� 2�� 29��
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= blankNum; i++) {
			arr.add(0);// ����
		}
		for (int i = 1; i <= maxDay; i++) {
			arr.add(i);// �ش� ���� ��¥ �ֱ�
		}
		return arr;
	}

}
