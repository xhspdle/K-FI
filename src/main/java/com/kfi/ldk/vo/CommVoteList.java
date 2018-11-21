package com.kfi.ldk.vo;

import java.util.List;

public class CommVoteList {
	private int vote_num;
	private int voteNum;
	private int comm_num;
	private String vote_title;
	private String vote_info;
	private int remain;
	private int user_num;
	private String user_nickname;
	private String user_email;
	private String msp_savimg;
	private int cnt;
	private List<CommVoteOptionCollection> list;
	public CommVoteList() {}
	public CommVoteList(int vote_num, int voteNum, int comm_num, String vote_title, String vote_info, int remain,
			int user_num, String user_nickname, String user_email, String msp_savimg, int cnt,
			List<CommVoteOptionCollection> list) {
		super();
		this.vote_num = vote_num;
		this.voteNum = voteNum;
		this.comm_num = comm_num;
		this.vote_title = vote_title;
		this.vote_info = vote_info;
		this.remain = remain;
		this.user_num = user_num;
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
	public int getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
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
	public String getVote_info() {
		return vote_info;
	}
	public void setVote_info(String vote_info) {
		this.vote_info = vote_info;
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
	public List<CommVoteOptionCollection> getList() {
		return list;
	}
	public void setList(List<CommVoteOptionCollection> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CommVoteList [vote_num=" + vote_num + ", voteNum=" + voteNum + ", comm_num=" + comm_num
				+ ", vote_title=" + vote_title + ", vote_info=" + vote_info + ", remain=" + remain + ", user_num="
				+ user_num + ", user_nickname=" + user_nickname + ", user_email=" + user_email + ", msp_savimg="
				+ msp_savimg + ", cnt=" + cnt + ", list=" + list + "]";
	}
}
