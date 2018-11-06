<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>회원 로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/login/login'/>" method="post">
		아이디 <input type="text" name="userId" id="userId" value="${membersVo.id }"><br>
		비밀번호<input type="password" name="userPwd" id="userPwd">
		<input type="submit" value="로그인"><br>
		<a href="<c:url value='/login/join'/>">회원가입</a>
		<a href="<c:url value='/login/findId'/>">아이디 찾기</a>
		<a href="<c:url value='/login/findPwd'/>">비밀번호 찾기</a>
	</form>
</body>
</html>