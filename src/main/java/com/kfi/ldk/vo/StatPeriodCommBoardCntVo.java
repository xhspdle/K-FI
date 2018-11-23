package com.kfi.ldk.vo;

import java.sql.Date;

public class StatPeriodCommBoardCntVo {
	private Date cb_date;
	private int cnt;
	public StatPeriodCommBoardCntVo() {}
	public StatPeriodCommBoardCntVo(Date cb_date, int cnt) {
		super();
		this.cb_date = cb_date;
		this.cnt = cnt;
	}
	public Date getCb_date() {
		return cb_date;
	}
	public void setCb_date(Date cb_date) {
		this.cb_date = cb_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "StatPeriodCommBoardCntVo [cb_date=" + cb_date + ", cnt=" + cnt + "]";
	}
}
