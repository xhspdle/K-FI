package com.kfi.ldk.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyCommentListViewVo {
	private int myc_num;
	private int mb_num;
	private int user_num;
	private String myc_content;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date myc_date;
	private int cnt;
	private String user_id;
	public MyCommentListViewVo() {}
	public MyCommentListViewVo(int myc_num, int mb_num, int user_num, String myc_content, Date myc_date, int cnt,
			String user_id) {
		super();
		this.myc_num = myc_num;
		this.mb_num = mb_num;
		this.user_num = user_num;
		this.myc_content = myc_content;
		this.myc_date = myc_date;
		this.cnt = cnt;
		this.user_id = user_id;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "MyCommentListViewVo [myc_num=" + myc_num + ", mb_num=" + mb_num + ", user_num=" + user_num
				+ ", myc_content=" + myc_content + ", myc_date=" + myc_date + ", cnt=" + cnt + ", user_id=" + user_id
				+ "]";
	}
}
