package com.kfi.dgl.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class membersVo {
	// 사용자 
	public class Members {

	    // 유저번호 
	    private Integer userNum;

	    // 아이디 
	    @NotEmpty
	    @Length(min=4, max=10)
	    private String userId;

	    // 닉네임
	    @NotNull
	    private String userNickname;

	    // 비밀번호
	    @NotEmpty
	    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")
	    private String userPwd;

	    // 이메일
	    @NotEmpty
	    @Email
	    private String userEmail;

	    // 가입일
	    private Date userRegdate;

	    // 아이디상태 
	    private Integer userStatus;
	    
	    public Members() {}

		public Members(Integer userNum, String userId, String userNickname, String userPwd, String userEmail,
				Date userRegdate, Integer userStatus) {
			super();
			this.userNum = userNum;
			this.userId = userId;
			this.userNickname = userNickname;
			this.userPwd = userPwd;
			this.userEmail = userEmail;
			this.userRegdate = userRegdate;
			this.userStatus = userStatus;
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
	}
}
