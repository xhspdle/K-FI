package com.kfi.ldk.vo;

import java.sql.Date;

public class MyBoardVo {
	private int mb_num;
	private int user_num;
	private String mb_title;
	private String mb_content;
	private Date mb_date;
	private int mb_views;
	public MyBoardVo() {}
	public MyBoardVo(int mb_num, int user_num, String mb_title, String mb_content, Date mb_date, int mb_views) {
		super();
		this.mb_num = mb_num;
		this.user_num = user_num;
		this.mb_title = mb_title;
		this.mb_content = mb_content;
		this.mb_date = mb_date;
		this.mb_views = mb_views;
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
	public String getMb_title() {
		return mb_title;
	}
	public void setMb_title(String mb_title) {
		this.mb_title = mb_title;
	}
	public String getMb_content() {
		return mb_content;
	}
	public void setMb_content(String mb_content) {
		this.mb_content = mb_content;
	}
	public Date getMb_date() {
		return mb_date;
	}
	public void setMb_date(Date mb_date) {
		this.mb_date = mb_date;
	}
	public int getMb_views() {
		return mb_views;
	}
	public void setMb_views(int mb_views) {
		this.mb_views = mb_views;
	}
	@Override
	public String toString() {
		return "MyBoardVo [mb_num=" + mb_num + ", user_num=" + user_num + ", mb_title=" + mb_title + ", mb_content="
				+ mb_content + ", mb_date=" + mb_date + ", mb_views=" + mb_views + "]";
	}
}
