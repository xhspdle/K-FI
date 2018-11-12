package com.kfi.ysy.vo;

public class CommSkinCoverVo {
	private int csc_num; //Ŀ����ȣ
	private int comm_num; //���ӹ�ȣ 
	private String csc_orgimg; //��������
	private String csc_savimg; //�������
	private int csc_using; //������(1/0)
	public CommSkinCoverVo() {
		super();
	}
	public CommSkinCoverVo(int csc_num, int comm_num, String csc_orgimg, String csc_savimg, int csc_using) {
		super();
		this.csc_num = csc_num;
		this.comm_num = comm_num;
		this.csc_orgimg = csc_orgimg;
		this.csc_savimg = csc_savimg;
		this.csc_using = csc_using;
	}
	public int getCsc_num() {
		return csc_num;
	}
	public void setCsc_num(int csc_num) {
		this.csc_num = csc_num;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	public String getCsc_orgimg() {
		return csc_orgimg;
	}
	public void setCsc_orgimg(String csc_orgimg) {
		this.csc_orgimg = csc_orgimg;
	}
	public String getCsc_savimg() {
		return csc_savimg;
	}
	public void setCsc_savimg(String csc_savimg) {
		this.csc_savimg = csc_savimg;
	}
	public int getCsc_using() {
		return csc_using;
	}
	public void setCsc_using(int csc_using) {
		this.csc_using = csc_using;
	}
	@Override
	public String toString() {
		return "CommSkinCoverVo [csc_num=" + csc_num + ", comm_num=" + comm_num + ", csc_orgimg=" + csc_orgimg
				+ ", csc_savimg=" + csc_savimg + ", csc_using=" + csc_using + "]";
	}

	

}
