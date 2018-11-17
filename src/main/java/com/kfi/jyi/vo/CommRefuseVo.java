package com.kfi.jyi.vo;

public class CommRefuseVo {
	private int cr_num;
	private int cul_num;
	private String cr_refuse;
	public CommRefuseVo() {
		super();
	}
	public CommRefuseVo(int cr_num, int cul_num, String cr_refuse) {
		super();
		this.cr_num = cr_num;
		this.cul_num = cul_num;
		this.cr_refuse = cr_refuse;
	}
	public int getCr_num() {
		return cr_num;
	}
	public void setCr_num(int cr_num) {
		this.cr_num = cr_num;
	}
	public int getCul_num() {
		return cul_num;
	}
	public void setCul_num(int cul_num) {
		this.cul_num = cul_num;
	}
	public String getCr_refuse() {
		return cr_refuse;
	}
	public void setCr_refuse(String cr_refuse) {
		this.cr_refuse = cr_refuse;
	}
	@Override
	public String toString() {
		return "CommRefuseVo [cr_num=" + cr_num + ", cul_num=" + cul_num + ", cr_refuse=" + cr_refuse + "]";
	}
	
	
	
}
