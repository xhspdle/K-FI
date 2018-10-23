package com.kfi.ysy.admin.vo;

import java.sql.Date;

public class MembersVo {
	private int user_num;
	private String user_id;
	private String user_nickname;
	private String user_pwd;
	private String user_email;
	private Date user_regdate;
	private int user_status;
	public MembersVo() {}
	public MembersVo(int user_num, String user_id, String user_nickname, String user_pwd, String user_email,
			Date user_regdate, int user_status) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_pwd = user_pwd;
		this.user_email = user_email;
		this.user_regdate = user_regdate;
		this.user_status = user_status;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	
	
}
