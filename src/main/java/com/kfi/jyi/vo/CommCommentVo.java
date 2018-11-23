package com.kfi.jyi.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommCommentVo {
	private int commc_num; //모임댓글번호
	private int cb_num; //모임글번호
	private int user_num; //유저번호
	private String commc_content; //댓글내용
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date commc_date; //댓글작성일
	private int commc_like; //추천수
	public CommCommentVo() {
		super();
	}
	public CommCommentVo(int commc_num, int cb_num, int user_num, String commc_content, Date commc_date,
			int commc_like) {
		super();
		this.commc_num = commc_num;
		this.cb_num = cb_num;
		this.user_num = user_num;
		this.commc_content = commc_content;
		this.commc_date = commc_date;
		this.commc_like = commc_like;
	}
	public int getCommc_num() {
		return commc_num;
	}
	public void setCommc_num(int commc_num) {
		this.commc_num = commc_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getCommc_content() {
		return commc_content;
	}
	public void setCommc_content(String commc_content) {
		this.commc_content = commc_content;
	}
	public Date getCommc_date() {
		return commc_date;
	}
	public void setCommc_date(Date commc_date) {
		this.commc_date = commc_date;
	}
	public int getCommc_like() {
		return commc_like;
	}
	public void setCommc_like(int commc_like) {
		this.commc_like = commc_like;
	}
	@Override
	public String toString() {
		return "CommCommentVo [commc_num=" + commc_num + ", cb_num=" + cb_num + ", user_num=" + user_num
				+ ", commc_content=" + commc_content + ", commc_date=" + commc_date + ", commc_like=" + commc_like
				+ "]";
	}
	
}
