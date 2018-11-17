package com.kfi.ldk.vo;

public class VotingOptionVo {
	private int vo_num;
	private int vote_num;
	private int option_num;
	private String vo_content;
	public VotingOptionVo() {}
	public VotingOptionVo(int vo_num, int vote_num, int option_num, String vo_content) {
		super();
		this.vo_num = vo_num;
		this.vote_num = vote_num;
		this.option_num = option_num;
		this.vo_content = vo_content;
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
	@Override
	public String toString() {
		return "VotingOptionVo [vo_num=" + vo_num + ", vote_num=" + vote_num + ", option_num=" + option_num
				+ ", vo_content=" + vo_content + "]";
	}
}
