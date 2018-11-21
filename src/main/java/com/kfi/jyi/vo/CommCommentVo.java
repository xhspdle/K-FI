package com.kfi.jyi.vo;

import java.sql.Date;

public class CommCommentVo {
	private int commc_num; //���Ӵ�۹�ȣ
	private int cb_num; //���ӱ۹�ȣ
	private int user_num; //������ȣ
	private String commc_content; //��۳���
	private Date commc_Date; //����ۼ���
	private int commc_like; //��õ��
	public CommCommentVo() {
		super();
	}
	public CommCommentVo(int commc_num, int cb_num, int user_num, String commc_content, Date commc_Date,
			int commc_like) {
		super();
		this.commc_num = commc_num;
		this.cb_num = cb_num;
		this.user_num = user_num;
		this.commc_content = commc_content;
		this.commc_Date = commc_Date;
		this.commc_like = commc_like;
	}
	public int getCommc_num() {
		return commc_num;
	}
	public void setCommc_num(int commc_num) {
		this.commc_num = commc_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getCommc_content() {
		return commc_content;
	}
	public void setCommc_content(String commc_content) {
		this.commc_content = commc_content;
	}
	public Date getCommc_Date() {
		return commc_Date;
	}
	public void setCommc_Date(Date commc_Date) {
		this.commc_Date = commc_Date;
	}
	public int getCommc_like() {
		return commc_like;
	}
	public void setCommc_like(int commc_like) {
		this.commc_like = commc_like;
	}
	@Override
	public String toString() {
		return "CommCommentVo [commc_num=" + commc_num + ", cb_num=" + cb_num + ", user_num=" + user_num
				+ ", commc_content=" + commc_content + ", commc_Date=" + commc_Date + ", commc_like=" + commc_like
				+ "]";
	}
	
	
	
	
}
