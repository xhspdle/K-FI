package com.kfi.ldk.vo;

import java.util.List;

public class CommVoteList {
	private int vote_num;
	private int comm_num;
	private String vote_title;
	private int remain;
	private String user_nickname;
	private String user_email;
	private String msp_savimg;
	private int cnt;
	private List<CommVoteOptionCollection> list;
	public CommVoteList() {}
	public CommVoteList(int vote_num, int comm_num, String vote_title, int remain, String user_nickname,
			String user_email, String msp_savimg, int cnt, List<CommVoteOptionCollection> list) {
		super();
		this.vote_num = vote_num;
		this.comm_num = comm_num;
		this.vote_title = vote_title;
		this.remain = remain;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.msp_savimg = msp_savimg;
		this.cnt = cnt;
		this.list = list;
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
	public List<CommVoteOptionCollection> getList() {
		return list;
	}
	public void setList(List<CommVoteOptionCollection> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CommVoteListCollection [vote_num=" + vote_num + ", comm_num=" + comm_num + ", vote_title=" + vote_title
				+ ", remain=" + remain + ", user_nickname=" + user_nickname + ", user_email=" + user_email
				+ ", msp_savimg=" + msp_savimg + ", cnt=" + cnt + ", list=" + list + "]";
	}
}
