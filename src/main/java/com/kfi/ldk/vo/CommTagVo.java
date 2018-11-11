package com.kfi.ldk.vo;

public class CommTagVo {
	private int ctag_num;
	private int tag_num;
	private int cb_num;
	public CommTagVo(int ctag_num, int tag_num, int cb_num) {
		super();
		this.ctag_num = ctag_num;
		this.tag_num = tag_num;
		this.cb_num = cb_num;
	}
	public int getCtag_num() {
		return ctag_num;
	}
	public void setCtag_num(int ctag_num) {
		this.ctag_num = ctag_num;
	}
	public int getTag_num() {
		return tag_num;
	}
	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	@Override
	public String toString() {
		return "CommTagVo [ctag_num=" + ctag_num + ", tag_num=" + tag_num + ", cb_num=" + cb_num + "]";
	}
}
