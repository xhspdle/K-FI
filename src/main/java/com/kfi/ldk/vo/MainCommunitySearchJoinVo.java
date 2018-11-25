package com.kfi.ldk.vo;

public class MainCommunitySearchJoinVo {
	private int comm_num;
	private String comm_name;
	private String comm_content;
	private String cs_color;
	private String csp_savimg;
	public MainCommunitySearchJoinVo() {}
	public MainCommunitySearchJoinVo(int comm_num, String comm_name, String comm_content, String cs_color,
			String csp_savimg) {
		super();
		this.comm_num = comm_num;
		this.comm_name = comm_name;
		this.comm_content = comm_content;
		this.cs_color = cs_color;
		this.csp_savimg = csp_savimg;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public String getComm_name() {
		return comm_name;
	}
	public void setComm_name(String comm_name) {
		this.comm_name = comm_name;
	}
	public String getComm_content() {
		return comm_content;
	}
	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}
	public String getCs_color() {
		return cs_color;
	}
	public void setCs_color(String cs_color) {
		this.cs_color = cs_color;
	}
	public String getCsp_savimg() {
		return csp_savimg;
	}
	public void setCsp_savimg(String csp_savimg) {
		this.csp_savimg = csp_savimg;
	}
	@Override
	public String toString() {
		return "MainCommunitySearchJoinVo [comm_num=" + comm_num + ", comm_name=" + comm_name + ", comm_content="
				+ comm_content + ", cs_color=" + cs_color + ", csp_savimg=" + csp_savimg + "]";
	}
}
