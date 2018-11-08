package com.kfi.jyi.vo;

public class MySkinVo {
	private int ms_num;
	private int user_num;
	private String ms_name;
	private String ms_color;
	private String ms_msg;
	private int ms_using;
	public MySkinVo() {
		super();
	}
	public MySkinVo(int ms_num, int user_num, String ms_name, String ms_color, String ms_msg, int ms_using) {
		super();
		this.ms_num = ms_num;
		this.user_num = user_num;
		this.ms_name = ms_name;
		this.ms_color = ms_color;
		this.ms_msg = ms_msg;
		this.ms_using = ms_using;
	}
	public int getMs_num() {
		return ms_num;
	}
	public void setMs_num(int ms_num) {
		this.ms_num = ms_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getMs_name() {
		return ms_name;
	}
	public void setMs_name(String ms_name) {
		this.ms_name = ms_name;
	}
	public String getMs_color() {
		return ms_color;
	}
	public void setMs_color(String ms_color) {
		this.ms_color = ms_color;
	}
	public String getMs_msg() {
		return ms_msg;
	}
	public void setMs_msg(String ms_msg) {
		this.ms_msg = ms_msg;
	}
	public int getMs_using() {
		return ms_using;
	}
	public void setMs_using(int ms_using) {
		this.ms_using = ms_using;
	}
	@Override
	public String toString() {
		return "MySkinVo [ms_num=" + ms_num + ", user_num=" + user_num + ", ms_name=" + ms_name + ", ms_color="
				+ ms_color + ", ms_msg=" + ms_msg + ", ms_using=" + ms_using + "]";
	}
	
	
	
	
}
