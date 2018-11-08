<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="container" style="margin:auto;">
  <div style="margin:5% 0% 5% 15%;">
  <h2><span class="glyphicon glyphicon-ok" style="color:red;'"></span> 입력사항</h2>
  <p>회원님의 개인정보 보호를 위해 비밀번호를 입력해주세요</p>
  <form method="post" action="<c:url value='/mypage/myinfo/passwordCheck'/>" id="myinfo_pwdChk_frm">
  <label for="pwd">Password:</label><br>
    <div class="form-group" style="display: -webkit-box;" >
      <input type="password" class="form-control" id="myinfo_pwd" name="password" style="width:50%;'">
      <input type="submit" value="확인" class="btn" id="myinfo_pwd_submit">
    </div>
  </form>
  <span id="myinfo_pwd_result" style="color:red;">${code}</span>
  </div>
</div>