package com.kfi.jyi.vo;

public class MySkinCoverVo {
	private int msc_num;
	private int ms_num;
	private String msc_orgimg;
	private String msc_savimg;
	public MySkinCoverVo() {
		super();
	}
	public MySkinCoverVo(int msc_num, int ms_num, String msc_orgimg, String msc_savimg) {
		super();
		this.msc_num = msc_num;
		this.ms_num = ms_num;
		this.msc_orgimg = msc_orgimg;
		this.msc_savimg = msc_savimg;
	}
	public int getMsc_num() {
		return msc_num;
	}
	public void setMsc_num(int msc_num) {
		this.msc_num = msc_num;
	}
	public int getMs_num() {
		return ms_num;
	}
	public void setMs_num(int ms_num) {
		this.ms_num = ms_num;
	}
	public String getMsc_orgimg() {
		return msc_orgimg;
	}
	public void setMsc_orgimg(String msc_orgimg) {
		this.msc_orgimg = msc_orgimg;
	}
	public String getMsc_savimg() {
		return msc_savimg;
	}
	public void setMsc_savimg(String msc_savimg) {
		this.msc_savimg = msc_savimg;
	}
	@Override
	public String toString() {
		return "MySkinCoverVo [msc_num=" + msc_num + ", ms_num=" + ms_num + ", msc_orgimg=" + msc_orgimg
				+ ", msc_savimg=" + msc_savimg + "]";
	}
	
	
	
	
}
