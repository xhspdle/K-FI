package com.kfi.jyi.vo;

public class CommPhotoVo {
	private int cp_num; // ������ȣ
	private int cb_num; // ���ӱ۹�ȣ
	private String cp_orgimg; // ��������
	private String cp_savimg; // �������
	public CommPhotoVo() {
		super();
	}
	public CommPhotoVo(int cp_num, int cb_num, String cp_orgimg, String cp_savimg) {
		super();
		this.cp_num = cp_num;
		this.cb_num = cb_num;
		this.cp_orgimg = cp_orgimg;
		this.cp_savimg = cp_savimg;
	}
	public int getCp_num() {
		return cp_num;
	}
	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}
	public int getCb_num() {
		return cb_num;
	}
	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
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
	@Override
	public String toString() {
		return "CommPhotoVo [cp_num=" + cp_num + ", cb_num=" + cb_num + ", cp_orgimg=" + cp_orgimg + ", cp_savimg="
				+ cp_savimg + "]";
	}


	
	
}
