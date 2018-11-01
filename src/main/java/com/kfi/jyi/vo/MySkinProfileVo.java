package com.kfi.jyi.vo;

public class MySkinProfileVo {
	private int msp_num;
	private int ms_num;
	private String msp_orgimg;
	private String msp_savimg;
	public MySkinProfileVo() {
		super();
	}
	public MySkinProfileVo(int msp_num, int ms_num, String msp_orgimg, String msp_savimg) {
		super();
		this.msp_num = msp_num;
		this.ms_num = ms_num;
		this.msp_orgimg = msp_orgimg;
		this.msp_savimg = msp_savimg;
	}
	public int getMsp_num() {
		return msp_num;
	}
	public void setMsp_num(int msp_num) {
		this.msp_num = msp_num;
	}
	public int getMs_num() {
		return ms_num;
	}
	public void setMs_num(int ms_num) {
		this.ms_num = ms_num;
	}
	public String getMsp_orgimg() {
		return msp_orgimg;
	}
	public void setMsp_orgimg(String msp_orgimg) {
		this.msp_orgimg = msp_orgimg;
	}
	public String getMsp_savimg() {
		return msp_savimg;
	}
	public void setMsp_savimg(String msp_savimg) {
		this.msp_savimg = msp_savimg;
	}
	@Override
	public String toString() {
		return "MySkinProfileVo [msp_num=" + msp_num + ", ms_num=" + ms_num + ", msp_orgimg=" + msp_orgimg
				+ ", msp_savimg=" + msp_savimg + "]";
	}
	
	
	
	
	
}
