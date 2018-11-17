package com.kfi.jyi.vo;

public class CommVideoVo {
	private int cv_num; //영상번호
	private int cb_num; //모임글번호
	private String cv_orgvid; //원본영상
	private String cv_savvid; //저장영상
	
	public CommVideoVo() {
		super();
	}
	public CommVideoVo(int cv_num, int cb_num, String cv_orgvid, String cv_savvid) {
		super();
		this.cv_num = cv_num;
		this.cb_num = cb_num;
		this.cv_orgvid = cv_orgvid;
		this.cv_savvid = cv_savvid;
	}
	public int getCv_num() {
		return cv_num;
	}
	public void setCv_num(int cv_num) {
		this.cv_num = cv_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public String getCv_orgvid() {
		return cv_orgvid;
	}
	public void setCv_orgvid(String cv_orgvid) {
		this.cv_orgvid = cv_orgvid;
	}
	public String getCv_savvid() {
		return cv_savvid;
	}
	public void setCv_savvid(String cv_savvid) {
		this.cv_savvid = cv_savvid;
	}
	@Override
	public String toString() {
		return "CommVideoVo [cv_num=" + cv_num + ", cb_num=" + cb_num + ", cv_orgvid=" + cv_orgvid + ", cv_savvid="
				+ cv_savvid + "]";
	}
	
	
	
	
}
