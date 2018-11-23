package com.kfi.ldk.vo;

import java.sql.Date;

public class StatPeriodMemCntVo {
	private Date user_regdate;
	private int cnt;
	public StatPeriodMemCntVo() {}
	public StatPeriodMemCntVo(Date user_regdate, int cnt) {
		super();
		this.user_regdate = user_regdate;
		this.cnt = cnt;
	}
	public Date getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "StatPeriodMemCntVo [user_regdate=" + user_regdate + ", cnt=" + cnt + "]";
	}
}
