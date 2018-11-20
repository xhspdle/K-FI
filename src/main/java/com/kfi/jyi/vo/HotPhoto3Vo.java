package com.kfi.jyi.vo;

import java.sql.Date;

public class HotPhoto3Vo {
	private int cp_num;
	private int cb_num;
	private String cp_orgimg;
	private String cp_savimg;
	private int comm_num;
	private int user_num;
	private String cb_title;
	private String cb_content;
	private Date cb_date;
	private int cb_notice;
	private int cb_views;
	public HotPhoto3Vo() {
		super();
	}
	public HotPhoto3Vo(int cp_num, int cb_num, String cp_orgimg, String cp_savimg, int comm_num, int user_num,
			String cb_title, String cb_content, Date cb_date, int cb_notice, int cb_views) {
		super();
		this.cp_num = cp_num;
		this.cb_num = cb_num;
		this.cp_orgimg = cp_orgimg;
		this.cp_savimg = cp_savimg;
		this.comm_num = comm_num;
		this.user_num = user_num;
		this.cb_title = cb_title;
		this.cb_content = cb_content;
		this.cb_date = cb_date;
		this.cb_notice = cb_notice;
		this.cb_views = cb_views;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public String getCp_orgimg() {
		return cp_orgimg;
	}
	public void setCp_orgimg(String cp_orgimg) {
		this.cp_orgimg = cp_orgimg;
	}
	public String getCp_savimg() {
		return cp_savimg;
	}
	public void setCp_savimg(String cp_savimg) {
		this.cp_savimg = cp_savimg;
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
		return "HotPhoto3Vo [cp_num=" + cp_num + ", cb_num=" + cb_num + ", cp_orgimg=" + cp_orgimg + ", cp_savimg="
				+ cp_savimg + ", comm_num=" + comm_num + ", user_num=" + user_num + ", cb_title=" + cb_title
				+ ", cb_content=" + cb_content + ", cb_date=" + cb_date + ", cb_notice=" + cb_notice + ", cb_views="
				+ cb_views + "]";
	}
	
	
}
