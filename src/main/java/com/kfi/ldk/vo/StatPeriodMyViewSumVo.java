package com.kfi.ldk.vo;

import java.sql.Date;

public class StatPeriodMyViewSumVo {
	private Date mb_date;
	private int sum;
	public StatPeriodMyViewSumVo() {}
	public StatPeriodMyViewSumVo(Date mb_date, int sum) {
		super();
		this.mb_date = mb_date;
		this.sum = sum;
	}
	public Date getMb_date() {
		return mb_date;
	}
	public void setMb_date(Date mb_date) {
		this.mb_date = mb_date;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "StatPeriodMyViewSumVo [mb_date=" + mb_date + ", sum=" + sum + "]";
	}
}
