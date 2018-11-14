package com.kfi.ldk.vo;

public class TagVo {
	private int tag_num;
	private String tag_name;
	public TagVo() {}
	public TagVo(int tag_num, String tag_name) {
		super();
		this.tag_num = tag_num;
		this.tag_name = tag_name;
	}
	public int getTag_num() {
		return tag_num;
	}
	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	@Override
	public String toString() {
		return "TagVo [tag_num=" + tag_num + ", tag_name=" + tag_name + "]";
	}
}
