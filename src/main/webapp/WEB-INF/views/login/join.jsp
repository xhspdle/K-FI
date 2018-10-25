<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="join" method="post">
	아이디 <input type="text" name="id">
	<input type="button" value="중복체크"><br>
	닉네임 <input type="text" name="nickname"><br>
	비밀번호 <input type="password" name="pw"><br>
	이메일 <input type="text" name="email"><br>
	<input type="submit" value="가입">
	<input type="reset" value="취소">
</form>
</body>
</html>