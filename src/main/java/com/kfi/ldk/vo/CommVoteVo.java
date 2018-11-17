package com.kfi.ldk.vo;

import java.sql.Date;

public class CommVoteVo {
	private int vote_num;
	private int comm_num;
	private String vote_title;
	private String vote_info;
	private Date vote_begin;
	private Date vote_end;
	public CommVoteVo() {}
	public CommVoteVo(int vote_num, int comm_num, String vote_title, String vote_info, Date vote_begin, Date vote_end) {
		super();
		this.vote_num = vote_num;
		this.comm_num = comm_num;
		this.vote_title = vote_title;
		this.vote_info = vote_info;
		this.vote_begin = vote_begin;
		this.vote_end = vote_end;
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
	public String getVote_info() {
		return vote_info;
	}
	public void setVote_info(String vote_info) {
		this.vote_info = vote_info;
	}
	public Date getVote_begin() {
		return vote_begin;
	}
	public void setVote_begin(Date vote_begin) {
		this.vote_begin = vote_begin;
	}
	public Date getVote_end() {
		return vote_end;
	}
	public void setVote_end(Date vote_end) {
		this.vote_end = vote_end;
	}
	@Override
	public String toString() {
		return "CommVoteVo [vote_num=" + vote_num + ", comm_num=" + comm_num + ", vote_title=" + vote_title
				+ ", vote_info=" + vote_info + ", vote_begin=" + vote_begin + ", vote_end=" + vote_end + "]";
	}
}
