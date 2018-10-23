<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br>
<h1>게시글작성</h1>
<form method="post" action="<c:url value='/mypage/myboard/insert'/>">
	유저번호 <input type="text" name="user_num"><br>
	글제목 <input type="text" name="mb_title"><br>
	글내용 <input type="text" name="mb_content"><br>
	<input type="submit" value="등록">
</form>
<a href="<c:url value='/mypage/main'/>">마이페이지로</a>
</body>
</html>