package com.kfi.jyi.vo;

public class CommBoardProfileVo {
	private String msp_savimg;
	private String user_nickname;
	private int user_num;
	private String user_email;
	private int cb_num;
	public CommBoardProfileVo() {
		super();
	}
	public CommBoardProfileVo(String msp_savimg, String user_nickname, int user_num, String user_email, int cb_num) {
		super();
		this.msp_savimg = msp_savimg;
		this.user_nickname = user_nickname;
		this.user_num = user_num;
		this.user_email = user_email;
		this.cb_num = cb_num;
	}
	public String getMsp_savimg() {
		return msp_savimg;
	}
	public void setMsp_savimg(String msp_savimg) {
		this.msp_savimg = msp_savimg;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	@Override
	public String toString() {
		return "CommBoardProfileVo [msp_savimg=" + msp_savimg + ", user_nickname=" + user_nickname + ", user_num="
				+ user_num + ", user_email=" + user_email + ", cb_num=" + cb_num + "]";
	}

	
	
}
