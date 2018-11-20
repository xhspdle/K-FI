package com.kfi.ldk.vo;

public class VotingOptionListJoinVo {
	private int vo_num;
	private int vote_num;
	private int option_num;
	private String vo_content;
	private int cnt;
	public VotingOptionListJoinVo() {}
	public VotingOptionListJoinVo(int vo_num, int vote_num, int option_num, String vo_content, int cnt) {
		super();
		this.vo_num = vo_num;
		this.vote_num = vote_num;
		this.option_num = option_num;
		this.vo_content = vo_content;
		this.cnt = cnt;
	}
	public int getVo_num() {
		return vo_num;
	}
	public void setVo_num(int vo_num) {
		this.vo_num = vo_num;
	}
	public int getVote_num() {
		return vote_num;
	}
	public void setVote_num(int vote_num) {
		this.vote_num = vote_num;
	}
	public int getOption_num() {
		return option_num;
	}
	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}
	public String getVo_content() {
		return vo_content;
	}
	public void setVo_content(String vo_content) {
		this.vo_content = vo_content;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "VotingOptionListJoinVo [vo_num=" + vo_num + ", vote_num=" + vote_num + ", option_num=" + option_num
				+ ", vo_content=" + vo_content + ", cnt=" + cnt + "]";
	}
}
