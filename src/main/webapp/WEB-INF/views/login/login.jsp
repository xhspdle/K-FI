<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="<c:url value='login'/>" method="post">
아이디 <input type="text" name="id" value="${membersVo.id }"><br>
<form:errors path="membersVo.id"/>
비밀번호<input type="password" name="pw" ><br>
<form:errors path="membersVo.pw"/>
<input type="submit" value="로그인">
<a href="join">회원가입</a>
<a href="fndId">아이디 찾기</a>
<a href="fndpwd">비밀번호 찾기</a>
</form>
</body>
</html>