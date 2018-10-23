package com.kfi.ldk.vo;

public class MyPhotoVo {
	private int mp_num;
	private int mb_num;
	private String mp_orgimg;
	private String mp_savimg;
	public MyPhotoVo() {}
	public MyPhotoVo(int mp_num, int mb_num, String mp_orgimg, String mp_savimg) {
		super();
		this.mp_num = mp_num;
		this.mb_num = mb_num;
		this.mp_orgimg = mp_orgimg;
		this.mp_savimg = mp_savimg;
	}
	public int getMp_num() {
		return mp_num;
	}
	public void setMp_num(int mp_num) {
		this.mp_num = mp_num;
	}
	public int getMb_num() {
		return mb_num;
	}
	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
	}
	public String getMp_orgimg() {
		return mp_orgimg;
	}
	public void setMp_orgimg(String mp_orgimg) {
		this.mp_orgimg = mp_orgimg;
	}
	public String getMp_savimg() {
		return mp_savimg;
	}
	public void setMp_savimg(String mp_savimg) {
		this.mp_savimg = mp_savimg;
	}
	@Override
	public String toString() {
		return "MyPhotoVo [mp_num=" + mp_num + ", mb_num=" + mb_num + ", mp_orgimg=" + mp_orgimg + ", mp_savimg="
				+ mp_savimg + "]";
	}
}
