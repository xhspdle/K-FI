package com.kfi.ldk.vo;

import java.sql.Date;

public class MyBoardListViewVo {
	private int mb_num;
	private String mb_title;
	private String mb_content;
	private Date mb_date;
	private int mb_views;
	private int comment_cnt;
	private int like_cnt;
	private int mp_num;
	private String mp_savimg;
	private int mv_num;
	private String mv_savvid;
	public MyBoardListViewVo() {}
	public MyBoardListViewVo(int mb_num, String mb_title, String mb_content, Date mb_date, int mb_views,
			int comment_cnt, int like_cnt, int mp_num, String mp_savimg, int mv_num, String mv_savvid) {
		super();
		this.mb_num = mb_num;
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
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
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
	@Override
	public String toString() {
		return "MyBoardListViewVo [mb_num=" + mb_num + ", mb_title=" + mb_title + ", mb_content=" + mb_content
				+ ", mb_date=" + mb_date + ", mb_views=" + mb_views + ", comment_cnt=" + comment_cnt + ", like_cnt="
				+ like_cnt + ", mp_num=" + mp_num + ", mp_savimg=" + mp_savimg + ", mv_num=" + mv_num + ", mv_savvid="
				+ mv_savvid + "]";
	}
}
