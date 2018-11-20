package com.kfi.jyi.vo;

public class CommBoardLikeVo {
	private int cbl_num;
	private int cb_num;
	private int user_num;
	public CommBoardLikeVo() {
		super();
	}
	public CommBoardLikeVo(int cbl_num, int cb_num, int user_num) {
		super();
		this.cbl_num = cbl_num;
		this.cb_num = cb_num;
		this.user_num = user_num;
	}
	public int getCbl_num() {
		return cbl_num;
	}
	public void setCbl_num(int cbl_num) {
		this.cbl_num = cbl_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "CommBoardLikeVo [cbl_num=" + cbl_num + ", cb_num=" + cb_num + ", user_num=" + user_num + "]";
	}
	
	
	
	
	
}
