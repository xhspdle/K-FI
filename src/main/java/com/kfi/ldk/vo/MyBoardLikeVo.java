package com.kfi.ldk.vo;

public class MyBoardLikeVo {
	private int mbl_num;
	private int mb_num;
	private int user_num;
	public MyBoardLikeVo() {}
	public MyBoardLikeVo(int mbl_num, int mb_num, int user_num) {
		super();
		this.mbl_num = mbl_num;
		this.mb_num = mb_num;
		this.user_num = user_num;
	}
	public int getMbl_num() {
		return mbl_num;
	}
	public void setMbl_num(int mbl_num) {
		this.mbl_num = mbl_num;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "MyBoardLikeVo [mbl_num=" + mbl_num + ", mb_num=" + mb_num + ", user_num=" + user_num + "]";
	}
}
