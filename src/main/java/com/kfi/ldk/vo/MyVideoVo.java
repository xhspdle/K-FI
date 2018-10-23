package com.kfi.ldk.vo;

public class MyVideoVo {
	private int mv_num;
	private int mb_num;
	private String mv_orgvid;
	private String mv_savvid;
	public MyVideoVo() {}
	public MyVideoVo(int mv_num, int mb_num, String mv_orgvid, String mv_savvid) {
		super();
		this.mv_num = mv_num;
		this.mb_num = mb_num;
		this.mv_orgvid = mv_orgvid;
		this.mv_savvid = mv_savvid;
	}
	public int getMv_num() {
		return mv_num;
	}
	public void setMv_num(int mv_num) {
		this.mv_num = mv_num;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	public String getMv_orgvid() {
		return mv_orgvid;
	}
	public void setMv_orgvid(String mv_orgvid) {
		this.mv_orgvid = mv_orgvid;
	}
	public String getMv_savvid() {
		return mv_savvid;
	}
	public void setMv_savvid(String mv_savvid) {
		this.mv_savvid = mv_savvid;
	}
	@Override
	public String toString() {
		return "MyVideoVo [mv_num=" + mv_num + ", mb_num=" + mb_num + ", mv_orgvid=" + mv_orgvid + ", mv_savvid="
				+ mv_savvid + "]";
	}
}
