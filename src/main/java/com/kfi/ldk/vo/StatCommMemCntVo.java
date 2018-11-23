package com.kfi.ldk.vo;

public class StatCommMemCntVo {
	private int comm_num;
	private int cnt;
	public StatCommMemCntVo() {}
	public StatCommMemCntVo(int comm_num, int cnt) {
		super();
		this.comm_num = comm_num;
		this.cnt = cnt;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "StatCommMemCntVo [comm_num=" + comm_num + ", cnt=" + cnt + "]";
	}
}
