<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>K-Fi</title>
</head>
<body>
	<h2>비밀번호를 재설정 하세요.</h2>
	<form action="pw_change" method="post"></form>
	<div class="pw">
		<input type="password" name="pw1" placeholder="새 비밀번호">
	</div>
	<div> <!-- 암호 에러메시지 -->
		
	</div>
	<div class="pw">
		<input type="password" name="pw2" placeholder="새 비밀번호 확인">
	</div>
	<input type="submit" value="변경하기">

	<ul>
		<li>
		::before 영문+숫자를 조합하여 8~20자리로 변경하세요.<br>
		</li>
		<li>
		::before 비밀번호 변경 시 자동 로그인은 해제됩니다.<br>
		 변경된 비밀번호로 다시 로그인 하세요.
		</li>
	</ul>
</body>
</html>