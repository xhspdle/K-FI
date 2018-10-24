<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<form action="findpwok" method="post">
		<fieldset>
			<div id=f_pw>
				<input type="text" name="ipid" placeholder="아이디"><br>
				<input type="text" name="ipemail" placeholder="이메일"><br>
				<input type="radio" name="fnd_1" checked="true">이메일
				<input type="submit" value="다음">
			</div>
		</fieldset>
	</form>
</body>
</html>