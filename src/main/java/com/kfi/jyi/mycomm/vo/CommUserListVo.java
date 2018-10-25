package com.kfi.jyi.mycomm.vo;

//COMM_USER_LIST �����������
public class CommUserListVo {
	private int cul_num; // ����������ȣ
	private int comm_numl; // ���ӹ�ȣ
	private int user_num; // ������ȣ
	private int cul_status; // ó������

	public CommUserListVo() {
		super();
	}

	public CommUserListVo(int cul_num, int comm_numl, int user_num, int cul_status) {
		super();
		this.cul_num = cul_num;
		this.comm_numl = comm_numl;
		this.user_num = user_num;
		this.cul_status = cul_status;
	}

	public int getCul_num() {
		return cul_num;
	}

	public void setCul_num(int cul_num) {
		this.cul_num = cul_num;
	}

	public int getComm_numl() {
		return comm_numl;
	}

	public void setComm_numl(int comm_numl) {
		this.comm_numl = comm_numl;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getCul_status() {
		return cul_status;
	}

	public void setCul_status(int cul_status) {
		this.cul_status = cul_status;
	}

	@Override
	public String toString() {
		return "CommUserListVo [cul_num=" + cul_num + ", comm_numl=" + comm_numl + ", user_num=" + user_num
				+ ", cul_status=" + cul_status + "]";
	}

}
