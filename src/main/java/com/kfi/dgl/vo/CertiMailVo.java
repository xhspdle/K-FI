package com.kfi.dgl.vo;

public class CertiMailVo { //인증 테이블
	private String cm_key; //인증 키 CM_KEY
	private int user_num; //유저번호 USER_NUM
	private int user_status; //유저상태 USER_STATUS
	private String user_email; //유저이메일 USER_EMAIL
	
	public CertiMailVo() {}

	public CertiMailVo(String cm_key, int user_num, int user_status, String user_email) {
		super();
		this.cm_key = cm_key;
		this.user_num = user_num;
		this.user_status = user_status;
		this.user_email = user_email;
	}

	public String getCm_key() {
		return cm_key;
	}

	public void setCm_key(String cm_key) {
		this.cm_key = cm_key;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
}
