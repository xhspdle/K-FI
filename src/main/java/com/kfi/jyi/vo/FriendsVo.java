package com.kfi.jyi.vo;

import java.sql.Date;

public class FriendsVo {
	private int frds_num;
	private int user1_num;
	private int user2_num;
	private Date frds_date;
	public FriendsVo() {
		super();
	}
	public FriendsVo(int frds_num, int user1_num, int user2_num, Date frds_date) {
		super();
		this.frds_num = frds_num;
		this.user1_num = user1_num;
		this.user2_num = user2_num;
		this.frds_date = frds_date;
	}
	public int getFrds_num() {
		return frds_num;
	}
	public void setFrds_num(int frds_num) {
		this.frds_num = frds_num;
	}
	public int getUser1_num() {
		return user1_num;
	}
	public void setUser1_num(int user1_num) {
		this.user1_num = user1_num;
	}
	public int getUser2_num() {
		return user2_num;
	}
	public void setUser2_num(int user2_num) {
		this.user2_num = user2_num;
	}
	public Date getFrds_date() {
		return frds_date;
	}
	public void setFrds_date(Date frds_date) {
		this.frds_date = frds_date;
	}
	@Override
	public String toString() {
		return "FriendsVo [frds_num=" + frds_num + ", user1_num=" + user1_num + ", user2_num=" + user2_num
				+ ", frds_date=" + frds_date + "]";
	} 
	
	
	
	
	
}
