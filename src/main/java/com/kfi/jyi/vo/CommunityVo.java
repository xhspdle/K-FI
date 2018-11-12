package com.kfi.jyi.vo;

import java.sql.Date;

//Community ��������
public class CommunityVo {
	private int comm_num; // ���ӹ�ȣ
	private int user_num; // �����ڹ�ȣ
	private String comm_name; // ���Ӹ�
	private String comm_content; // ���ӼҰ�
	private String cs_color;//�÷��ڵ�
	private Date comm_reg; // ������
	public CommunityVo() {
		super();
	}
	public CommunityVo(int comm_num, int user_num, String comm_name, String comm_content, String cs_color,
			Date comm_reg) {
		super();
		this.comm_num = comm_num;
		this.user_num = user_num;
		this.comm_name = comm_name;
		this.comm_content = comm_content;
		this.cs_color = cs_color;
		this.comm_reg = comm_reg;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
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
	public Date getComm_reg() {
		return comm_reg;
	}
	public void setComm_reg(Date comm_reg) {
		this.comm_reg = comm_reg;
	}
	@Override
	public String toString() {
		return "CommunityVo [comm_num=" + comm_num + ", user_num=" + user_num + ", comm_name=" + comm_name
				+ ", comm_content=" + comm_content + ", cs_color=" + cs_color + ", comm_reg=" + comm_reg + "]";
	}


	
	
	
}
