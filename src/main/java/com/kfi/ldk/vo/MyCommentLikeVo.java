package com.kfi.ldk.vo;

public class MyCommentLikeVo {
	private int mcl_num;
	private int myc_num;
	private int user_num;
	public MyCommentLikeVo() {}
	public MyCommentLikeVo(int mcl_num, int myc_num, int user_num) {
		super();
		this.mcl_num = mcl_num;
		this.myc_num = myc_num;
		this.user_num = user_num;
	}
	public int getMcl_num() {
		return mcl_num;
	}
	public void setMcl_num(int mcl_num) {
		this.mcl_num = mcl_num;
	}
	public int getMyc_num() {
		return myc_num;
	}
	public void setMyc_num(int myc_num) {
		this.myc_num = myc_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "MyCommentLikeVo [mcl_num=" + mcl_num + ", myc_num=" + myc_num + ", user_num=" + user_num + "]";
	}
}
