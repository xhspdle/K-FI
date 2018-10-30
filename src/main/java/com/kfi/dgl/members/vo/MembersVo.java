package com.kfi.dgl.members.vo;

import java.util.Date;

//사용자 
public class MembersVo {
	private int user_num; // 유저번호 USER_NUM
	private String user_id; // 아이디 USER_ID
	private String user_pwd; // 비밀번호 USER_PWD
	private String user_nickname; // 닉네임 USER_NICKNAME
	private String user_email; // 이메일 USER_EMAIL
	private Date user_regdate; // 가입일 USER_REGDATE
	private int user_status; // 아이디상태 USER_STATUS
	private int user_certi; // 인증상태 USER_CERTI

	public MembersVo() {
		super();
	}

	public MembersVo(int user_num, String user_id, String user_pwd, String user_nickname, String user_email,
			Date user_regdate, int user_status, int user_certi) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.user_regdate = user_regdate;
		this.user_status = user_status;
		this.user_certi = user_certi;
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

	public int getUser_certi() {
		return user_certi;
	}

	public void setUser_certi(int user_certi) {
		this.user_certi = user_certi;
	}
}
