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
<table class="table table-hover">
	<thead>
		<tr>
			<th>글번호</th>
			<th>유저번호</th>
			<th>글제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.mb_num }</td>
			<td>${vo.user_num }</td>
			<td>${vo.mb_title }</td>
			<td>${vo.mb_date }</td>
			<td>${vo.mb_views }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>