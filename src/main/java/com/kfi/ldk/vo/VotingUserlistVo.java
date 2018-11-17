package com.kfi.ldk.vo;

public class VotingUserlistVo {
	private int vu_num;
	private int vo_num;
	private int user_num;
	public VotingUserlistVo() {}
	public VotingUserlistVo(int vu_num, int vo_num, int user_num) {
		super();
		this.vu_num = vu_num;
		this.vo_num = vo_num;
		this.user_num = user_num;
	}
	public int getVu_num() {
		return vu_num;
	}
	public void setVu_num(int vu_num) {
		this.vu_num = vu_num;
	}
	public int getVo_num() {
		return vo_num;
	}
	public void setVo_num(int vo_num) {
		this.vo_num = vo_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	@Override
	public String toString() {
		return "VotingUserlistVo [vu_num=" + vu_num + ", vo_num=" + vo_num + ", user_num=" + user_num + "]";
	}
}
