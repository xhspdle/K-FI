<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<div class="col-md-3">
			<table border="1">
				<tr>
					<th colspan="7">${year }년${month }월${day }일</th>
				</tr>
				<tr>
					<c:forEach var="i" items="${arr }">
						<c:choose>
							<c:when test="${j%7==0}">
								<tr></tr>
								<td class="sunday">${arr[i] }</td>
							</c:when>
							<c:when test="${j%7==6 }">
								<td class="saturday">${arr[i] }</td>
							</c:when>
							<c:otherwise>
								<td>${arr[i] }</td>
							</c:otherwise>
						</c:choose>
						<c:set var="j" value="${j+1 }" />
					</c:forEach>
				</tr>
			</table>
		</div>
		<div class="col-md-6">
			<h1>board</h1>
		</div>
		<div class="col-md-3">
			<h1>chat</h1>
		</div>
	</div>
</div>

