package com.kfi.ldk.vo;

public class MyTagVo {
	private int mtag_num;
	private int tag_num;
	private int mb_num;
	public MyTagVo() {}
	public MyTagVo(int mtag_num, int tag_num, int mb_num) {
		super();
		this.mtag_num = mtag_num;
		this.tag_num = tag_num;
		this.mb_num = mb_num;
	}
	public int getMtag_num() {
		return mtag_num;
	}
	public void setMtag_num(int mtag_num) {
		this.mtag_num = mtag_num;
	}
	public int getTag_num() {
		return tag_num;
	}
	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	@Override
	public String toString() {
		return "My_Tag [mtag_num=" + mtag_num + ", tag_num=" + tag_num + ", mb_num=" + mb_num + "]";
	}
}
