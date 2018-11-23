package com.kfi.ldk.vo;

public class StatCommMemCntVo {
	private int comm_num;
	private int cnt;
	private String comm_name;
	public StatCommMemCntVo() {}
	public StatCommMemCntVo(int comm_num, int cnt, String comm_name) {
		super();
		this.comm_num = comm_num;
		this.cnt = cnt;
		this.comm_name = comm_name;
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
	public String getComm_name() {
		return comm_name;
	}
	public void setComm_name(String comm_name) {
		this.comm_name = comm_name;
	}
	@Override
	public String toString() {
		return "StatCommMemCntVo [comm_num=" + comm_num + ", cnt=" + cnt + ", comm_name=" + comm_name + "]";
	}
}
