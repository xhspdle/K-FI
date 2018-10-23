<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>	
<h1>회원정보</h1>
	<table class="table table-striped">
		<tr>
			<th>게시물번호</th>
			<th>회원ID</th>
			<th>게시상황</th>
			<th>제목</th>
			<th>게시일</th>
			<th>삭제</th>
		</tr>
<%-- 		<c:forEach var="abcontent" items="${ablist }">
			<tr>
				<td>${abcontent.ab_num}</td>
				<td>${abcontent.admin_num }</td>
				<td>${abcontent.ab_notice }</td>
				<td>${abcontent.ab_title }</td>
				<td>${abcontent.ab_date }</td>				
				<td><i class="glyphicon glyphicon-remove"></i></td>
			</tr>
		</c:forEach> --%>
	</table>
