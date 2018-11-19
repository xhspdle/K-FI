package com.kfi.ldk.vo;

public class CommVoteOptionCollection {
	private int option_num;
	private String vo_content;
	public CommVoteOptionCollection() {}
	public CommVoteOptionCollection(int option_num, String vo_content) {
		super();
		this.option_num = option_num;
		this.vo_content = vo_content;
	}
	@Override
	public String toString() {
		return "CommVoteOptionCollection [option_num=" + option_num + ", vo_content=" + vo_content + "]";
	}
}
