package com.kfi.jyi.util;

import java.util.ArrayList;
import java.util.Calendar;

public class MyCalendar {
	Calendar cal = Calendar.getInstance();

	public ArrayList<Integer> getCal(int year, int month, int day) {
		cal.set(year, month, day);
		int blankNum = cal.get(Calendar.DAY_OF_WEEK) - 1; // ���� ���� (�Ͽ����� 1, ������� 7)
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // ���� ���� ��¥ (DATE�� ����)
		// getActualMaximum ���� ��ü�� Ư�� �ʵ��� �ִ� ���� ��ȯ�Ѵ�.

		int gong=0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= blankNum; i++) {
			gong+=1;
			arr.add(0);// �հ���
		}
		for (int i = 1; i <= maxDay; i++) {
			gong+=1;
			arr.add(i);// �ش� ���� ��¥ �ֱ�
		}
		if(gong>(7*5)) gong=(7*6)-gong;
		else if(gong>(7*4)) gong=(7*5)-gong;
		for(int i=1;i<=gong;i++) {
			arr.add(0); //�ڰ���
		}
		return arr;
	}
}
