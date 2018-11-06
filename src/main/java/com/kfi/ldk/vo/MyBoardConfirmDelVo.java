package com.kfi.ldk.vo;

public class MyBoardConfirmDelVo {
	private int user_num;
	private String user_id;
	private String user_pwd;
	private int mb_num;
	public MyBoardConfirmDelVo() {}
	public MyBoardConfirmDelVo(int user_num, String user_id, String user_pwd, int mb_num) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.mb_num = mb_num;
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
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	@Override
	public String toString() {
		return "MyBoardConfirmDelVo [user_num=" + user_num + ", user_id=" + user_id + ", user_pwd=" + user_pwd
				+ ", mb_num=" + mb_num + "]";
	}
}
