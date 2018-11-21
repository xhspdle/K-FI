package com.kfi.ldk.vo;

public class CommVoteConfirmDelVo {
	private int user_num;
	private String user_id;
	private String user_pwd;
	private int vote_num;
	public CommVoteConfirmDelVo() {}
	public CommVoteConfirmDelVo(int user_num, String user_id, String user_pwd, int vote_num) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.vote_num = vote_num;
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
	public int getVote_num() {
		return vote_num;
	}
	public void setVote_num(int vote_num) {
		this.vote_num = vote_num;
	}
	@Override
	public String toString() {
		return "CommVoteConfirmDelVo [user_num=" + user_num + ", user_id=" + user_id + ", user_pwd=" + user_pwd
				+ ", vote_num=" + vote_num + "]";
	}
}
