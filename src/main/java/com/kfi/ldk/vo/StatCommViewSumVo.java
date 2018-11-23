package com.kfi.ldk.vo;

public class StatCommViewSumVo {
	private int comm_num;
	private int sum;
	private String comm_name;
	public StatCommViewSumVo() {}
	public StatCommViewSumVo(int comm_num, int sum, String comm_name) {
		super();
		this.comm_num = comm_num;
		this.sum = sum;
		this.comm_name = comm_name;
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
	public String getComm_name() {
		return comm_name;
	}
	public void setComm_name(String comm_name) {
		this.comm_name = comm_name;
	}
	@Override
	public String toString() {
		return "StatCommViewSumVo [comm_num=" + comm_num + ", sum=" + sum + ", comm_name=" + comm_name + "]";
	}
}
