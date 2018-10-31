<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="adminlist">
	<h1>
		관리자정보<button class="btn btn-md" id="memberslist_btn">회원정보</button>
	</h1>
	<table class="table table-striped">
		<tr>
			<th>관리자번호</th>
			<th>관리자ID</th>
			<th>관리자NICKNAME</th>
			<th>관리자EMAIL</th>
			<th>가입일</th>
			<th>관리자정보</th>
		</tr>
		<c:forEach var="admin" items="${adminlist }"> 
 			<tr>
				<td >${adminlist.admin_num}</td>
				<td>${adminlist.admin_id }</td>
				<td >${adminlist.admin_nick }</td>
				<td >${adminlist.admin_email }</td>
				<td >${adminlist.admin_regdate }</td>
				<td></td>
			</tr>
		</c:forEach> 
	</table>		
	<div class="btn-group">
		<button class="btn btn-lg" data-toggle="modal" data-target="#myModal">등록</button>
		<button class="btn btn-lg">체크박스</button>
	</div>
</div>