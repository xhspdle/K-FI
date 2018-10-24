package com.kfi.dgl.members.vo;

import java.util.Date;

//사용자 
public class MembersVo {

 // 유저번호 
 private Integer userNum;

 // 아이디 
 private String userId;

 // 닉네임 
 private String userNickname;

 // 비밀번호 
 private String userPwd;

 // 이메일 
 private String userEmail;

 // 가입일 
 private Date userRegdate;

 // 아이디상태 
 private Integer userStatus;

 // 인증상태 
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