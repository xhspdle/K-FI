package com.kfi.ldk.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyBoardListViewVo {
	private int mb_num;
	private int user_num;
	private String user_id;
	private String user_nickname;
	private String user_email;
	private String mb_title;
	private String mb_content;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date mb_date;
	private int mb_views;
	private int comment_cnt;
	private int like_cnt;
	private int mp_num;
	private String mp_savimg;
	private int mv_num;
	private String mv_savvid;
	private String msp_savimg;
	public MyBoardListViewVo() {}
	public MyBoardListViewVo(int mb_num, int user_num, String user_id, String user_nickname, String user_email,
			String mb_title, String mb_content, Date mb_date, int mb_views, int comment_cnt, int like_cnt, int mp_num,
			String mp_savimg, int mv_num, String mv_savvid, String msp_savimg) {
		super();
		this.mb_num = mb_num;
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.mb_title = mb_title;
		this.mb_content = mb_content;
		this.mb_date = mb_date;
		this.mb_views = mb_views;
		this.comment_cnt = comment_cnt;
		this.like_cnt = like_cnt;
		this.mp_num = mp_num;
		this.mp_savimg = mp_savimg;
		this.mv_num = mv_num;
		this.mv_savvid = mv_savvid;
		this.msp_savimg = msp_savimg;
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
	public String getMb_title() {
		return mb_title;
	}
	public void setMb_title(String mb_title) {
		this.mb_title = mb_title;
	}
	public String getMb_content() {
		return mb_content;
	}
	public void setMb_content(String mb_content) {
		this.mb_content = mb_content;
	}
	public Date getMb_date() {
		return mb_date;
	}
	public void setMb_date(Date mb_date) {
		this.mb_date = mb_date;
	}
	public int getMb_views() {
		return mb_views;
	}
	public void setMb_views(int mb_views) {
		this.mb_views = mb_views;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public int getMp_num() {
		return mp_num;
	}
	public void setMp_num(int mp_num) {
		this.mp_num = mp_num;
	}
	public String getMp_savimg() {
		return mp_savimg;
	}
	public void setMp_savimg(String mp_savimg) {
		this.mp_savimg = mp_savimg;
	}
	public int getMv_num() {
		return mv_num;
	}
	public void setMv_num(int mv_num) {
		this.mv_num = mv_num;
	}
	public String getMv_savvid() {
		return mv_savvid;
	}
	public void setMv_savvid(String mv_savvid) {
		this.mv_savvid = mv_savvid;
	}
	public String getMsp_savimg() {
		return msp_savimg;
	}
	public void setMsp_savimg(String msp_savimg) {
		this.msp_savimg = msp_savimg;
	}
	@Override
	public String toString() {
		return "MyBoardListViewVo [mb_num=" + mb_num + ", user_num=" + user_num + ", user_id=" + user_id
				+ ", user_nickname=" + user_nickname + ", user_email=" + user_email + ", mb_title=" + mb_title
				+ ", mb_content=" + mb_content + ", mb_date=" + mb_date + ", mb_views=" + mb_views + ", comment_cnt="
				+ comment_cnt + ", like_cnt=" + like_cnt + ", mp_num=" + mp_num + ", mp_savimg=" + mp_savimg
				+ ", mv_num=" + mv_num + ", mv_savvid=" + mv_savvid + ", msp_savimg=" + msp_savimg + "]";
	}
}
