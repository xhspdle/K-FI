package com.kfi.ysy.admin.vo;

import java.sql.Date;

public class AdminVo {
	private int admin_num;
	private String admin_id;
	private String admin_pwd;
	private String admin_nick;
	private String admin_email;
	private Date admin_regdate;
	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminVo(int admin_num, String admin_id, String admin_pwd, String admin_nick, String admin_email,
			Date admin_regdate) {
		super();
		this.admin_num = admin_num;
		this.admin_id = admin_id;
		this.admin_pwd = admin_pwd;
		this.admin_nick = admin_nick;
		this.admin_email = admin_email;
		this.admin_regdate = admin_regdate;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public String getAdmin_nick() {
		return admin_nick;
	}
	public void setAdmin_nick(String admin_nick) {
		this.admin_nick = admin_nick;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public Date getAdmin_regdate() {
		return admin_regdate;
	}
	public void setAdmin_regdate(Date admin_regdate) {
		this.admin_regdate = admin_regdate;
	}
	
}
