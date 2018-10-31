package com.kfi.ysy.vo;

import java.sql.Date;

public class AccuseVo {
	private int ac_num;
	private int user1_num;
	private int user2_num;
	private String ac_reason;
	private int cb_num;
	private int board_num;
	private Date ac_date;
	private String user1_nickname;
	private String user2_nickname;
	public AccuseVo() {}
	public AccuseVo(int ac_num, int user1_num, int user2_num, String ac_reason, int cb_num, int board_num, Date ac_date,
			String user1_nickname, String user2_nickname) {
		super();
		this.ac_num = ac_num;
		this.user1_num = user1_num;
		this.user2_num = user2_num;
		this.ac_reason = ac_reason;
		this.cb_num = cb_num;
		this.board_num = board_num;
		this.ac_date = ac_date;
		this.user1_nickname = user1_nickname;
		this.user2_nickname = user2_nickname;
	}
	public int getAc_num() {
		return ac_num;
	}
	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
	}
	public int getUser1_num() {
		return user1_num;
	}
	public void setUser1_num(int user1_num) {
		this.user1_num = user1_num;
	}
	public int getUser2_num() {
		return user2_num;
	}
	public void setUser2_num(int user2_num) {
		this.user2_num = user2_num;
	}
	public String getAc_reason() {
		return ac_reason;
	}
	public void setAc_reason(String ac_reason) {
		this.ac_reason = ac_reason;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public Date getAc_date() {
		return ac_date;
	}
	public void setAc_date(Date ac_date) {
		this.ac_date = ac_date;
	}
	public String getUser1_nickname() {
		return user1_nickname;
	}
	public void setUser1_nickname(String user1_nickname) {
		this.user1_nickname = user1_nickname;
	}
	public String getUser2_nickname() {
		return user2_nickname;
	}
	public void setUser2_nickname(String user2_nickname) {
		this.user2_nickname = user2_nickname;
	}

}

