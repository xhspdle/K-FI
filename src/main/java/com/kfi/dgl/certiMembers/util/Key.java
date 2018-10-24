package com.kfi.dgl.certiMembers.util;

import java.util.Random;

public class Key {
	private boolean check;
	private int size;

	public String getKey(int size, boolean check) {
		this.size = size;
		this.check = check;
		return init();
	}

	public String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;
		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}
		} while (sb.length() < size);
		if (check) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}
}