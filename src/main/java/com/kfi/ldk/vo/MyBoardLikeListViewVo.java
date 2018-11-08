package com.kfi.ldk.vo;

public class MyBoardLikeListViewVo {
	private int mbl_num;
	private int mb_num;
	private int user_num;
	private String user_id;
	private String user_nickname;
	private String user_email;
	private String msp_savimg;
	public MyBoardLikeListViewVo() {}
	public MyBoardLikeListViewVo(int mbl_num, int mb_num, int user_num, String user_id, String user_nickname,
			String user_email, String msp_savimg) {
		super();
		this.mbl_num = mbl_num;
		this.mb_num = mb_num;
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.msp_savimg = msp_savimg;
	}
	public int getMbl_num() {
		return mbl_num;
	}
	public void setMbl_num(int mbl_num) {
		this.mbl_num = mbl_num;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getMsp_savimg() {
		return msp_savimg;
	}
	public void setMsp_savimg(String msp_savimg) {
		this.msp_savimg = msp_savimg;
	}
	@Override
	public String toString() {
		return "MyCommentLikeListViewVo [mbl_num=" + mbl_num + ", mb_num=" + mb_num + ", user_num=" + user_num
				+ ", user_id=" + user_id + ", user_nickname=" + user_nickname + ", user_email=" + user_email
				+ ", msp_savimg=" + msp_savimg + "]";
	}
}
