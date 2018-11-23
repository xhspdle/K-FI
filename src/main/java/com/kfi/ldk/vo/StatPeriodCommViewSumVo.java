package com.kfi.ldk.vo;

import java.sql.Date;

public class StatPeriodCommViewSumVo {
	private Date mb_date;
	private int cnt;
	public StatPeriodCommViewSumVo() {}
	public StatPeriodCommViewSumVo(Date mb_date, int cnt) {
		super();
		this.mb_date = mb_date;
		this.cnt = cnt;
	}
	public Date getMb_date() {
		return mb_date;
	}
	public void setMb_date(Date mb_date) {
		this.mb_date = mb_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "StatPeriodMyViewCntVo [mb_date=" + mb_date + ", cnt=" + cnt + "]";
	}
}
