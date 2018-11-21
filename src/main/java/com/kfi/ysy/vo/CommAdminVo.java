package com.kfi.ysy.vo;

import java.sql.Date;

public class CommAdminVo {
	private int user_num;
	private String user_id;
	private String user_nickname;
	private String user_email;
	private int cul_num;
	private int comm_num;
	private int cul_status;
	public CommAdminVo() {}
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getCul_num() {
		return cul_num;
	}
	public void setCul_num(int cul_num) {
		this.cul_num = cul_num;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public int getCul_status() {
		return cul_status;
	}
	public void setCul_status(int cul_status) {
		this.cul_status = cul_status;
	}
	

	
}
