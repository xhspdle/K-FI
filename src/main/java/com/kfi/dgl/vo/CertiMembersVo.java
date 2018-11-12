package com.kfi.dgl.vo;

public class CertiMembersVo {
	private int cm_num;
	private int user_num;
	private String cm_key;
	public CertiMembersVo() {}
	public CertiMembersVo(int cm_num, int user_num, String cm_key) {
		super();
		this.cm_num = cm_num;
		this.user_num = user_num;
		this.cm_key = cm_key;
	}
	public int getCm_num() {
		return cm_num;
	}
	public void setCm_num(int cm_num) {
		this.cm_num = cm_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getCm_key() {
		return cm_key;
	}
	public void setCm_key(String cm_key) {
		this.cm_key = cm_key;
	}
	@Override
	public String toString() {
		return "CertiMembersVo [cm_num=" + cm_num + ", user_num=" + user_num + ", cm_key=" + cm_key + "]";
	}
}
