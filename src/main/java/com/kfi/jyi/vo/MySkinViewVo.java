package com.kfi.jyi.vo;

public class MySkinViewVo {
	private int ms_num; //스킨번호
	private int user_num; //유저번호 
	private String ms_name; //스킨이름
	private String ms_color; //컬러코드
	private String ms_msg; //상태메세지
	private int ms_using; //사용상태(1/0)
	private int msp_num; //프로필번호
	private String msp_orgimg; //프로필 원본사진
	private String msp_savimg; //프로필 저장사진
	private int msc_num; //커버번호
	private String msc_orgimg; //커버 원본사진
	private String msc_savimg; //커버 저장사진
	private String user_nickname; //유저 닉네임 추가
	public MySkinViewVo() {
		super();
	}
	public MySkinViewVo(int ms_num, int user_num, String ms_name, String ms_color, String ms_msg, int ms_using,
			int msp_num, String msp_orgimg, String msp_savimg, int msc_num, String msc_orgimg, String msc_savimg,
			String user_nickname) {
		super();
		this.ms_num = ms_num;
		this.user_num = user_num;
		this.ms_name = ms_name;
		this.ms_color = ms_color;
		this.ms_msg = ms_msg;
		this.ms_using = ms_using;
		this.msp_num = msp_num;
		this.msp_orgimg = msp_orgimg;
		this.msp_savimg = msp_savimg;
		this.msc_num = msc_num;
		this.msc_orgimg = msc_orgimg;
		this.msc_savimg = msc_savimg;
		this.user_nickname = user_nickname;
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
	public int getMsp_num() {
		return msp_num;
	}
	public void setMsp_num(int msp_num) {
		this.msp_num = msp_num;
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
	public int getMsc_num() {
		return msc_num;
	}
	public void setMsc_num(int msc_num) {
		this.msc_num = msc_num;
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
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	@Override
	public String toString() {
		return "MySkinViewVo [ms_num=" + ms_num + ", user_num=" + user_num + ", ms_name=" + ms_name + ", ms_color="
				+ ms_color + ", ms_msg=" + ms_msg + ", ms_using=" + ms_using + ", msp_num=" + msp_num + ", msp_orgimg="
				+ msp_orgimg + ", msp_savimg=" + msp_savimg + ", msc_num=" + msc_num + ", msc_orgimg=" + msc_orgimg
				+ ", msc_savimg=" + msc_savimg + ", user_nickname=" + user_nickname + "]";
	}
}
