package com.kfi.ldk.vo;

public class StatPeriodMemCntVo {
	private String user_regdate;
	private int sum;
	public StatPeriodMemCntVo() {}
	public StatPeriodMemCntVo(String user_regdate, int sum) {
		super();
		this.user_regdate = user_regdate;
		this.sum = sum;
	}
	public String getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "StatPeriodMemCntVo [user_regdate=" + user_regdate + ", sum=" + sum + "]";
	}
}
