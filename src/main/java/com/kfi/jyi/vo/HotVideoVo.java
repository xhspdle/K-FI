package com.kfi.jyi.vo;

import java.sql.Date;

public class HotVideoVo {
	private int cv_num;
	private int cb_num;
	private String cv_orgvid;
	private String cv_savvid;
	private int comm_num;
	private int user_num;
	private String cb_title;
	private String cb_content;
	private Date cb_date;
	private int cb_notice;
	private int cb_views;

	public HotVideoVo() {
		super();
	}

	public HotVideoVo(int cv_num, int cb_num, String cv_orgvid, String cv_savvid, int comm_num, int user_num,
			String cb_title, String cb_content, Date cb_date, int cb_notice, int cb_views) {
		super();
		this.cv_num = cv_num;
		this.cb_num = cb_num;
		this.cv_orgvid = cv_orgvid;
		this.cv_savvid = cv_savvid;
		this.comm_num = comm_num;
		this.user_num = user_num;
		this.cb_title = cb_title;
		this.cb_content = cb_content;
		this.cb_date = cb_date;
		this.cb_notice = cb_notice;
		this.cb_views = cb_views;
	}

	public int getCv_num() {
		return cv_num;
	}

	public void setCv_num(int cv_num) {
		this.cv_num = cv_num;
	}

	public int getCb_num() {
		return cb_num;
	}

	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}

	public String getCv_orgvid() {
		return cv_orgvid;
	}

	public void setCv_orgvid(String cv_orgvid) {
		this.cv_orgvid = cv_orgvid;
	}

	public String getCv_savvid() {
		return cv_savvid;
	}

	public void setCv_savvid(String cv_savvid) {
		this.cv_savvid = cv_savvid;
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
		return "HotVideoVo [cv_num=" + cv_num + ", cb_num=" + cb_num + ", cv_orgvid=" + cv_orgvid + ", cv_savvid="
				+ cv_savvid + ", comm_num=" + comm_num + ", user_num=" + user_num + ", cb_title=" + cb_title
				+ ", cb_content=" + cb_content + ", cb_date=" + cb_date + ", cb_notice=" + cb_notice + ", cb_views="
				+ cb_views + "]";
	}

}
