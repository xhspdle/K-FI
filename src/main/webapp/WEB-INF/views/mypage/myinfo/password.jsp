<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" style="margin: auto;">
	<div style="margin: 5% 0% 5% 30%;">
		<h2>
			<span class="glyphicon glyphicon-ok" style="color: red;'"></span>
			입력사항
		</h2>
		<p>회원님의 개인정보 보호를 위해 비밀번호를 입력해주세요</p>
		<div id="myinfo">
			<form class="navbar-form navbar-left" method="post"
				action="<c:url value='/mypage/myinfo/passwordCheck'/>"
				id="myinfo_pwdChk_frm">
				<label for="pwd">Password:</label>
				<div class="input-group">
					<input type="password" class="form-control" id="myinfo_pwd"
						name="password">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit" value="확인"
							id="myinfo_pwd_submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<div id="myinfo_pwd_result" style="color: red;margin: 8% 0%;">${code}</div>

	</div>

</div>


