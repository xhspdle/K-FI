package com.kfi.jyi.vo;

import java.sql.Date;

public class CommBoardViewVo {
    private int cb_num; //���ӱ۹�ȣ
    private int comm_num; //���ӹ�ȣ
    private int user_num; //������ȣ
    private String cb_title; //���ӱ�����
    private String cb_content; //���ӱ۳���
    private Date cb_date; //���ӱ��ۼ���
    private int cb_notice; //��������
    private int cb_views; //��ȸ��
    
    private int cp_num; //������ȣ
    private String cp_orgimg; //��������
    private String cp_savimg; //�������

    private int cv_num; //�����ȣ
    private String cv_orgvid; //��������
    private String cv_savvid; //���念��
    
    private int commc_num; //���Ӵ�۹�ȣ
    private int commc_user_num; //��۴� ������ȣ
    private String commc_content; //��۳���
    private Date commc_date; //����ۼ���
    private int commc_like; //�����õ��
    
    private int cbl_num; //���ӰԽñ���õ��ȣ
    private int cbl_user_num;  //��õ�� ������ȣ
	public CommBoardViewVo() {
		super();
	}
	public CommBoardViewVo(int cb_num, int comm_num, int user_num, String cb_title, String cb_content, Date cb_date,
			int cb_notice, int cb_views, int cp_num, String cp_orgimg, String cp_savimg, int cv_num, String cv_orgvid,
			String cv_savvid, int commc_num, int commc_user_num, String commc_content, Date commc_date, int commc_like,
			int cbl_num, int cbl_user_num) {
		super();
		this.cb_num = cb_num;
		this.comm_num = comm_num;
		this.user_num = user_num;
		this.cb_title = cb_title;
		this.cb_content = cb_content;
		this.cb_date = cb_date;
		this.cb_notice = cb_notice;
		this.cb_views = cb_views;
		this.cp_num = cp_num;
		this.cp_orgimg = cp_orgimg;
		this.cp_savimg = cp_savimg;
		this.cv_num = cv_num;
		this.cv_orgvid = cv_orgvid;
		this.cv_savvid = cv_savvid;
		this.commc_num = commc_num;
		this.commc_user_num = commc_user_num;
		this.commc_content = commc_content;
		this.commc_date = commc_date;
		this.commc_like = commc_like;
		this.cbl_num = cbl_num;
		this.cbl_user_num = cbl_user_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
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
	public String getCb_title() {
		return cb_title;
	}
	public void setCb_title(String cb_title) {
		this.cb_title = cb_title;
	}
	public String getCb_content() {
		return cb_content;
	}
	public void setCb_content(String cb_content) {
		this.cb_content = cb_content;
	}
	public Date getCb_date() {
		return cb_date;
	}
	public void setCb_date(Date cb_date) {
		this.cb_date = cb_date;
	}
	public int getCb_notice() {
		return cb_notice;
	}
	public void setCb_notice(int cb_notice) {
		this.cb_notice = cb_notice;
	}
	public int getCb_views() {
		return cb_views;
	}
	public void setCb_views(int cb_views) {
		this.cb_views = cb_views;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}
	public String getCp_orgimg() {
		return cp_orgimg;
	}
	public void setCp_orgimg(String cp_orgimg) {
		this.cp_orgimg = cp_orgimg;
	}
	public String getCp_savimg() {
		return cp_savimg;
	}
	public void setCp_savimg(String cp_savimg) {
		this.cp_savimg = cp_savimg;
	}
	public int getCv_num() {
		return cv_num;
	}
	public void setCv_num(int cv_num) {
		this.cv_num = cv_num;
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
	public int getCommc_num() {
		return commc_num;
	}
	public void setCommc_num(int commc_num) {
		this.commc_num = commc_num;
	}
	public int getCommc_user_num() {
		return commc_user_num;
	}
	public void setCommc_user_num(int commc_user_num) {
		this.commc_user_num = commc_user_num;
	}
	public String getCommc_content() {
		return commc_content;
	}
	public void setCommc_content(String commc_content) {
		this.commc_content = commc_content;
	}
	public Date getCommc_date() {
		return commc_date;
	}
	public void setCommc_date(Date commc_date) {
		this.commc_date = commc_date;
	}
	public int getCommc_like() {
		return commc_like;
	}
	public void setCommc_like(int commc_like) {
		this.commc_like = commc_like;
	}
	public int getCbl_num() {
		return cbl_num;
	}
	public void setCbl_num(int cbl_num) {
		this.cbl_num = cbl_num;
	}
	public int getCbl_user_num() {
		return cbl_user_num;
	}
	public void setCbl_user_num(int cbl_user_num) {
		this.cbl_user_num = cbl_user_num;
	}
	@Override
	public String toString() {
		return "CommBoardViewVo [cb_num=" + cb_num + ", comm_num=" + comm_num + ", user_num=" + user_num + ", cb_title="
				+ cb_title + ", cb_content=" + cb_content + ", cb_date=" + cb_date + ", cb_notice=" + cb_notice
				+ ", cb_views=" + cb_views + ", cp_num=" + cp_num + ", cp_orgimg=" + cp_orgimg + ", cp_savimg="
				+ cp_savimg + ", cv_num=" + cv_num + ", cv_orgvid=" + cv_orgvid + ", cv_savvid=" + cv_savvid
				+ ", commc_num=" + commc_num + ", commc_user_num=" + commc_user_num + ", commc_content=" + commc_content
				+ ", commc_date=" + commc_date + ", commc_like=" + commc_like + ", cbl_num=" + cbl_num
				+ ", cbl_user_num=" + cbl_user_num + "]";
	}
	
    
    
    
}
