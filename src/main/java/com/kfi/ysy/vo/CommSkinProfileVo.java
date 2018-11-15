package com.kfi.ysy.vo;

public class CommSkinProfileVo {
	private int csp_num; //������ ��ȣ
	private int comm_num; //���ӹ�ȣ
	private String csp_orgimg; //��������
	private String csp_savimg; //�������
	private int csp_using; //������(1/0)
	
	public CommSkinProfileVo() {
		super();
	}
	public CommSkinProfileVo(int csp_num, int comm_num, String csp_orgimg, String csp_savimg, int csp_using) {
		super();
		this.csp_num = csp_num;
		this.comm_num = comm_num;
		this.csp_orgimg = csp_orgimg;
		this.csp_savimg = csp_savimg;
		this.csp_using = csp_using;
	}
	public int getCsp_num() {
		return csp_num;
	}
	public void setCsp_num(int csp_num) {
		this.csp_num = csp_num;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public String getCsp_orgimg() {
		return csp_orgimg;
	}
	public void setCsp_orgimg(String csp_orgimg) {
		this.csp_orgimg = csp_orgimg;
	}
	public String getCsp_savimg() {
		return csp_savimg;
	}
	public void setCsp_savimg(String csp_savimg) {
		this.csp_savimg = csp_savimg;
	}
	public int getCsp_using() {
		return csp_using;
	}
	public void setCsp_using(int csp_using) {
		this.csp_using = csp_using;
	}
	@Override
	public String toString() {
		return "CommSkinProfileVo [csp_num=" + csp_num + ", comm_num=" + comm_num + ", csp_orgimg=" + csp_orgimg
				+ ", csp_savimg=" + csp_savimg + ", csp_using=" + csp_using + "]";
	}
}
