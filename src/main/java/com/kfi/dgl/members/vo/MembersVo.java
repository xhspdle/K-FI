package com.kfi.dgl.members.vo;

import java.util.Date;

//����� 
public class MembersVo {

 // ������ȣ 
 private Integer user_Num;

 // ���̵� 
 private String user_Id;

 // �г��� 
 private String user_Nickname;

 // ��й�ȣ 
 private String user_Pwd;

 // �̸��� 
 private String user_Email;

 // ������ 
 private Date user_Regdate;

 // ���̵���� 
 private Integer user_Status;

 // �������� 
 private Integer user_Certi;
 public MembersVo() {}
public MembersVo(Integer user_Num, String user_Id, String user_Nickname, String user_Pwd, String user_Email,
		Date user_Regdate, Integer user_Status, Integer user_Certi) {
	super();
	this.user_Num = user_Num;
	this.user_Id = user_Id;
	this.user_Nickname = user_Nickname;
	this.user_Pwd = user_Pwd;
	this.user_Email = user_Email;
	this.user_Regdate = user_Regdate;
	this.user_Status = user_Status;
	this.user_Certi = user_Certi;
}


public Integer getUser_Num() {
	return user_Num;
}
public void setUser_Num(Integer user_Num) {
	this.user_Num = user_Num;
}
public String getUser_Id() {
	return user_Id;
}
public void setUser_Id(String user_Id) {
	this.user_Id = user_Id;
}
public String getUser_Nickname() {
	return user_Nickname;
}
public void setUser_Nickname(String user_Nickname) {
	this.user_Nickname = user_Nickname;
}
public String getUser_Pwd() {
	return user_Pwd;
}
public void setUser_Pwd(String user_Pwd) {
	this.user_Pwd = user_Pwd;
}
public String getUser_Email() {
	return user_Email;
}
public void setUser_Email(String user_Email) {
	this.user_Email = user_Email;
}
public Date getUser_Regdate() {
	return user_Regdate;
}
public void setUser_Regdate(Date user_Regdate) {
	this.user_Regdate = user_Regdate;
}
public Integer getUser_Status() {
	return user_Status;
}
public void setUser_Status(Integer user_Status) {
	this.user_Status = user_Status;
}
public Integer getUser_Certi() {
	return user_Certi;
}
public void setUser_Certi(Integer user_Certi) {
	this.user_Certi = user_Certi;
}

@Override
public String toString() {
	return "MembersVo [user_Num=" + user_Num + ", user_Id=" + user_Id + ", user_Nickname=" + user_Nickname
			+ ", user_Pwd=" + user_Pwd + ", user_Email=" + user_Email + ", user_Regdate=" + user_Regdate
			+ ", user_Status=" + user_Status + ", user_Certi=" + user_Certi + "]";
}


}