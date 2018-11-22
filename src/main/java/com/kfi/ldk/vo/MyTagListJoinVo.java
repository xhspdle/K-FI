package com.kfi.ldk.vo;

public class MyTagListJoinVo {
	private int tag_num;
	private int mtag_num;
	private String tag_name;
	private int tag_cnt;
	public MyTagListJoinVo() {}
	public MyTagListJoinVo(int tag_num, int mtag_num, String tag_name, int tag_cnt) {
		super();
		this.tag_num = tag_num;
		this.mtag_num = mtag_num;
		this.tag_name = tag_name;
		this.tag_cnt = tag_cnt;
	}
	public int getTag_num() {
		return tag_num;
	}
	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}
	public int getMtag_num() {
		return mtag_num;
	}
	public void setMtag_num(int mtag_num) {
		this.mtag_num = mtag_num;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public int getTag_cnt() {
		return tag_cnt;
	}
	public void setTag_cnt(int tag_cnt) {
		this.tag_cnt = tag_cnt;
	}
	@Override
	public String toString() {
		return "MyTagListJoinVo [tag_num=" + tag_num + ", mtag_num=" + mtag_num + ", tag_name=" + tag_name
				+ ", tag_cnt=" + tag_cnt + "]";
	}
}
