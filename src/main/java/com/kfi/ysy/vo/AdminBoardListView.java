package com.kfi.ysy.vo;

import java.sql.Date;

public class AdminBoardListView {
	private String admin_id;
	private String admin_nick;
	private int ab_num;
	private int admin_num;
	private int ab_notice;
	private String ab_content;
	private String ab_title;
	private Date ab_date;
	public AdminBoardListView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminBoardListView(String admin_id, String admin_nick, int ab_num, int admin_num, int ab_notice,
			String ab_content, String ab_title, Date ab_date) {
		super();
		this.admin_id = admin_id;
		this.admin_nick = admin_nick;
		this.ab_num = ab_num;
		this.admin_num = admin_num;
		this.ab_notice = ab_notice;
		this.ab_content = ab_content;
		this.ab_title = ab_title;
		this.ab_date = ab_date;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_nick() {
		return admin_nick;
	}
	public void setAdmin_nick(String admin_nick) {
		this.admin_nick = admin_nick;
	}
	public int getAb_num() {
		return ab_num;
	}
	public void setAb_num(int ab_num) {
		this.ab_num = ab_num;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	public int getAb_notice() {
		return ab_notice;
	}
	public void setAb_notice(int ab_notice) {
		this.ab_notice = ab_notice;
	}
	public String getAb_content() {
		return ab_content;
	}
	public void setAb_content(String ab_content) {
		this.ab_content = ab_content;
	}
	public String getAb_title() {
		return ab_title;
	}
	public void setAb_title(String ab_title) {
		this.ab_title = ab_title;
	}
	public Date getAb_date() {
		return ab_date;
	}
	public void setAb_date(Date ab_date) {
		this.ab_date = ab_date;
	}
	
}
