package com.kfi.ldk.vo;

public class StatCommViewSumVo {
	private int comm_num;
	private int sum;
	public StatCommViewSumVo() {}
	public StatCommViewSumVo(int comm_num, int sum) {
		super();
		this.comm_num = comm_num;
		this.sum = sum;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "StatCommViewCntVo [comm_num=" + comm_num + ", sum=" + sum + "]";
	}
}
