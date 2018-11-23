package com.kfi.jyi.vo;

public class CommCommentLikeVo {
	private int ccl_num;
	private int commc_num;
	private int user_num;
	public CommCommentLikeVo() {
		super();
	}
	public CommCommentLikeVo(int ccl_num, int commc_num, int user_num) {
		super();
		this.ccl_num = ccl_num;
		this.commc_num = commc_num;
		this.user_num = user_num;
	}
	public int getCcl_num() {
		return ccl_num;
	}
	public void setCcl_num(int ccl_num) {
		this.ccl_num = ccl_num;
	}
	public int getCommc_num() {
		return commc_num;
	}
	public void setCommc_num(int commc_num) {
		this.commc_num = commc_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "CommCommentLikeVo [ccl_num=" + ccl_num + ", commc_num=" + commc_num + ", user_num=" + user_num + "]";
	}
	
	
}
