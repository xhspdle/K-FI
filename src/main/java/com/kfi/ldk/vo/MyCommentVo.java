package com.kfi.ldk.vo;

import java.sql.Date;

public class MyCommentVo {
	private int myc_num;
	private int mb_num;
	private int user_num;
	private String myc_content;
	private Date myc_date;
	public MyCommentVo() {}
	public MyCommentVo(int myc_num, int mb_num, int user_num, String myc_content, Date myc_date) {
		super();
		this.myc_num = myc_num;
		this.mb_num = mb_num;
		this.user_num = user_num;
		this.myc_content = myc_content;
		this.myc_date = myc_date;
	}
	public int getMyc_num() {
		return myc_num;
	}
	public void setMyc_num(int myc_num) {
		this.myc_num = myc_num;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getMyc_content() {
		return myc_content;
	}
	public void setMyc_content(String myc_content) {
		this.myc_content = myc_content;
	}
	public Date getMyc_date() {
		return myc_date;
	}
	public void setMyc_date(Date myc_date) {
		this.myc_date = myc_date;
	}
	@Override
	public String toString() {
		return "MyCommentVo [myc_num=" + myc_num + ", mb_num=" + mb_num + ", user_num=" + user_num + ", myc_content="
				+ myc_content + ", myc_date=" + myc_date + "]";
	}
}
