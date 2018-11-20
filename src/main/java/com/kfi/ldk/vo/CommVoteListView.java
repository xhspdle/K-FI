package com.kfi.ldk.vo;
//resultMap 처리시 불필요
public class CommVoteListView {
	private int vote_num;
	private int comm_num;
	private String vote_title;
	private int remain;
	private int user_num;
	private String user_nickname;
	private String user_email;
	private String msp_savimg;
	private int cnt;
	public CommVoteListView() {}
	public CommVoteListView(int vote_num, int comm_num, String vote_title, int remain, int user_num,
			String user_nickname, String user_email, String msp_savimg, int cnt) {
		super();
		this.vote_num = vote_num;
		this.comm_num = comm_num;
		this.vote_title = vote_title;
		this.remain = remain;
		this.user_num = user_num;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.msp_savimg = msp_savimg;
		this.cnt = cnt;
	}
	public int getVote_num() {
		return vote_num;
	}
	public void setVote_num(int vote_num) {
		this.vote_num = vote_num;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public String getVote_title() {
		return vote_title;
	}
	public void setVote_title(String vote_title) {
		this.vote_title = vote_title;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
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
	public String getMsp_savimg() {
		return msp_savimg;
	}
	public void setMsp_savimg(String msp_savimg) {
		this.msp_savimg = msp_savimg;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CommVoteListView [vote_num=" + vote_num + ", comm_num=" + comm_num + ", vote_title=" + vote_title
				+ ", remain=" + remain + ", user_num=" + user_num + ", user_nickname=" + user_nickname + ", user_email="
				+ user_email + ", msp_savimg=" + msp_savimg + ", cnt=" + cnt + "]";
	}
}
