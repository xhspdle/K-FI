package com.kfi.dgl.members.vo;

import java.util.Date;

//����� 
public class MembersVo {

 // ������ȣ 
 private Integer userNum;

 // ���̵� 
 private String userId;

 // �г��� 
 private String userNickname;

 // ��й�ȣ 
 private String userPwd;

 // �̸��� 
 private String userEmail;

 // ������ 
 private Date userRegdate;

 // ���̵���� 
 private Integer userStatus;

 // �������� 
 private Integer userCerti;

 public MembersVo() {}
 public MembersVo(Integer userNum, String userId, String userNickname, String userPwd, String userEmail,
		Date userRegdate, Integer userStatus, Integer userCerti) {
	super();
	this.userNum = userNum;
	this.userId = userId;
	this.userNickname = userNickname;
	this.userPwd = userPwd;
	this.userEmail = userEmail;
	this.userRegdate = userRegdate;
	this.userStatus = userStatus;
	this.userCerti = userCerti;
}

public Integer getUserNum() {
     return userNum;
 }

 public void setUserNum(Integer userNum) {
     this.userNum = userNum;
 }

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public String getUserNickname() {
     return userNickname;
 }

 public void setUserNickname(String userNickname) {
     this.userNickname = userNickname;
 }

 public String getUserPwd() {
     return userPwd;
 }

 public void setUserPwd(String userPwd) {
     this.userPwd = userPwd;
 }

 public String getUserEmail() {
     return userEmail;
 }

 public void setUserEmail(String userEmail) {
     this.userEmail = userEmail;
 }

 public Date getUserRegdate() {
     return userRegdate;
 }

 public void setUserRegdate(Date userRegdate) {
     this.userRegdate = userRegdate;
 }

 public Integer getUserStatus() {
     return userStatus;
 }

 public void setUserStatus(Integer userStatus) {
     this.userStatus = userStatus;
 }

 public Integer getUserCerti() {
     return userCerti;
 }

 public void setUserCerti(Integer userCerti) {
     this.userCerti = userCerti;
 }
}