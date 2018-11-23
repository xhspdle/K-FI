package com.kfi.ldk.vo;

import java.sql.Date;

public class StatPeriodCommViewSumVo {
	private Date cb_date;
	private int sum;
	public StatPeriodCommViewSumVo() {}
	public StatPeriodCommViewSumVo(Date cb_date, int sum) {
		super();
		this.cb_date = cb_date;
		this.sum = sum;
	}
	public Date getCb_date() {
		return cb_date;
	}
	public void setCb_date(Date cb_date) {
		this.cb_date = cb_date;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "StatPeriodCommViewSumVo [cb_date=" + cb_date + ", sum=" + sum + "]";
	}
}
