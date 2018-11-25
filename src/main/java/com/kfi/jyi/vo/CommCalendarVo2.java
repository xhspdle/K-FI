package com.kfi.jyi.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//CommCalendar 모임일정
public class CommCalendarVo2 {
	private int cc_num; // 모임일정번호
	private int comm_num; // 모임번호
	private String cc_name; // 일정이름
	private String cc_info; // 일정설명
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date cc_begin;// 모임시작일
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date cc_end;// 모임종료일

	public CommCalendarVo2() {
		super();
	}

	public CommCalendarVo2(int cc_num, int comm_num, String cc_name, String cc_info, Date cc_begin, Date cc_end) {
		super();
		this.cc_num = cc_num;
		this.comm_num = comm_num;
		this.cc_name = cc_name;
		this.cc_info = cc_info;
		this.cc_begin = cc_begin;
		this.cc_end = cc_end;
	}

	public int getCc_num() {
		return cc_num;
	}

	public void setCc_num(int cc_num) {
		this.cc_num = cc_num;
	}

	public int getComm_num() {
		return comm_num;
	}

	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}

	public String getCc_name() {
		return cc_name;
	}

	public void setCc_name(String cc_name) {
		this.cc_name = cc_name;
	}

	public String getCc_info() {
		return cc_info;
	}

	public void setCc_info(String cc_info) {
		this.cc_info = cc_info;
	}

	public Date getCc_begin() {
		return cc_begin;
	}

	public void setCc_begin(Date cc_begin) {
		this.cc_begin = cc_begin;
	}

	public Date getCc_end() {
		return cc_end;
	}

	public void setCc_end(Date cc_end) {
		this.cc_end = cc_end;
	}

	@Override
	public String toString() {
		return "CommCalendarVo [cc_num=" + cc_num + ", comm_num=" + comm_num + ", cc_name=" + cc_name + ", cc_info="
				+ cc_info + ", cc_begin=" + cc_begin + ", cc_end=" + cc_end + "]";
	}

}
