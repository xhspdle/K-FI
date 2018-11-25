package com.kfi.ldk.vo;

public class StatPeriodMyBoardCntVo {
	private String mb_date;
	private int cnt;
	public StatPeriodMyBoardCntVo() {}
	public StatPeriodMyBoardCntVo(String mb_date, int cnt) {
		super();
		this.mb_date = mb_date;
		this.cnt = cnt;
	}
	public String getMb_date() {
		return mb_date;
	}
	public void setMb_date(String mb_date) {
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
		return "StatPeriodMyBoardCntVo [mb_date=" + mb_date + ", cnt=" + cnt + "]";
	}
}
