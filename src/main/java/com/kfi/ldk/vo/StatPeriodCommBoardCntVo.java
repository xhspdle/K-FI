package com.kfi.ldk.vo;

public class StatPeriodCommBoardCntVo {
	private String cb_date;
	private int cnt;
	public StatPeriodCommBoardCntVo() {}
	public StatPeriodCommBoardCntVo(String cb_date, int cnt) {
		super();
		this.cb_date = cb_date;
		this.cnt = cnt;
	}
	public String getCb_date() {
		return cb_date;
	}
	public void setCb_date(String cb_date) {
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
