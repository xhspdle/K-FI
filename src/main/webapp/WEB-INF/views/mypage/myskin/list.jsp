<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="<c:url value='#' />">스킨 추가하기</a>
<a href="<c:url value='#' />">기본 이미지로 변경하기</a>

<div>
<c:forEach var="msvlist" items=${msvlist }>
	<c:choose>
		<c:when test="${i%3==0 }">
			<br>
		</c:when>
		<c:otherwise>
			<div class="myskin_msclist">
				<!-- 수정 -->
				<a href="#"><span class="muskinlist glyphicon glyphicon-cog"></span></a>
				<!-- 삭제 -->
				<a href="#"><span class="myskinlist glyphicon glyphicon-trash"></span></a>
				<img alt="${msclist.ms_name }" src="<c:url value=''/>">				
				<h6>${msclist.ms_name }}</h6>
				<a href="#"><span class="glyphicon glyphicon-log-in">적용하기</span></a>
			</div>
		</c:otherwise>
	</c:choose>
	<c:set var="i" value="i++"/>
</c:forEach>
</div>