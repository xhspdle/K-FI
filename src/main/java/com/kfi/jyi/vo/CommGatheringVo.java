package com.kfi.jyi.vo;

//CommGathering 모임참여목록
public class CommGatheringVo {
	private int cg_num; // 참여번호
	private int cc_num; // 모임일정번호
	private int user_num; // 참여유저번호

	public CommGatheringVo() {
		super();
	}

	public CommGatheringVo(int cg_num, int cc_num, int user_num) {
		super();
		this.cg_num = cg_num;
		this.cc_num = cc_num;
		this.user_num = user_num;
	}

	public int getCg_num() {
		return cg_num;
	}

	public void setCg_num(int cg_num) {
		this.cg_num = cg_num;
	}

	public int getCc_num() {
		return cc_num;
	}

	public void setCc_num(int cc_num) {
		this.cc_num = cc_num;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	@Override
	public String toString() {
		return "CommGatheringVo [cg_num=" + cg_num + ", cc_num=" + cc_num + ", user_num=" + user_num + "]";
	}

}
