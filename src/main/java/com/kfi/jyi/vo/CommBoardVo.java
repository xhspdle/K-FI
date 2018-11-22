package com.kfi.jyi.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommBoardVo {
	private int cb_num; // 모임글번호
	private int comm_num; // 모임번호
	private int user_num; //유저번호
	private String cb_title; // 모임글제목
	private String cb_content; // 모임글내용
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date cb_date; // 모임글작성일
	private int cb_notice; // 공지사항
	private int cb_views; // 조회수
	public CommBoardVo() {
		super();
	}
	public CommBoardVo(int cb_num, int comm_num, int user_num, String cb_title, String cb_content, Date cb_date,
			int cb_notice, int cb_views) {
		super();
		this.cb_num = cb_num;
		this.comm_num = comm_num;
		this.user_num = user_num;
		this.cb_title = cb_title;
		this.cb_content = cb_content;
		this.cb_date = cb_date;
		this.cb_notice = cb_notice;
		this.cb_views = cb_views;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getCb_title() {
		return cb_title;
	}
	public void setCb_title(String cb_title) {
		this.cb_title = cb_title;
	}
	public String getCb_content() {
		return cb_content;
	}
	public void setCb_content(String cb_content) {
		this.cb_content = cb_content;
	}
	public Date getCb_date() {
		return cb_date;
	}
	public void setCb_date(Date cb_date) {
		this.cb_date = cb_date;
	}
	public int getCb_notice() {
		return cb_notice;
	}
	public void setCb_notice(int cb_notice) {
		this.cb_notice = cb_notice;
	}
	public int getCb_views() {
		return cb_views;
	}
	public void setCb_views(int cb_views) {
		this.cb_views = cb_views;
	}
	@Override
	public String toString() {
		return "CommBoardVo [cb_num=" + cb_num + ", comm_num=" + comm_num + ", user_num=" + user_num + ", cb_title="
				+ cb_title + ", cb_content=" + cb_content + ", cb_date=" + cb_date + ", cb_notice=" + cb_notice
				+ ", cb_views=" + cb_views + "]";
	}
	

	
	
}
