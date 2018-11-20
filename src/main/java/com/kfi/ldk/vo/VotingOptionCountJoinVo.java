package com.kfi.ldk.vo;

public class VotingOptionCountJoinVo {
	private int vote_num;
	private int votecnt;
	public VotingOptionCountJoinVo() {}
	public VotingOptionCountJoinVo(int vote_num, int votecnt) {
		super();
		this.vote_num = vote_num;
		this.votecnt = votecnt;
	}
	public int getVote_num() {
		return vote_num;
	}
	public void setVote_num(int vote_num) {
		this.vote_num = vote_num;
	}
	public int getVotecnt() {
		return votecnt;
	}
	public void setVotecnt(int votecnt) {
		this.votecnt = votecnt;
	}
	@Override
	public String toString() {
		return "VotingOptionCountJoinVo [vote_num=" + vote_num + ", votecnt=" + votecnt + "]";
	}
}
