<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="myskin">
	<a class="myskin_ud" href="<c:url value='/mypage/myskin/insertForm' />">스킨 추가하기</a>
	<a class="myskin_ud" href="<c:url value='#' />">기본 이미지로 변경하기</a><br>
	<c:forEach var="list" items="${msvlist }">
		<br><br>
		<div class="col-sm-2">
			<h1>${list.ms_name }</h1>
			<span> 
				<a class="myskin_ud" href="javascript:mySkinApply(1)">적용하기</a> 
				<a class="myskin_ud" href="<c:url value='/mypage/myskin/updateform?ms_num=${list.ms_num }' />">수정</a> 
				<a class="myskin_ud" href="<c:url value='/mypage/myskin/delete?ms_num=${list.ms_num }' />">삭제</a>
			</span>
		</div>
		<c:if test="${list.msc_orgimg eq null }">
			<c:set var="background" value="background-color:#00cee8;"/>
		</c:if>		
		<c:if test="${list.msc_orgimg ne null}">
			<c:set var="background" value="background: url('${pageContext.request.contextPath }/resources/upload/img/${list.msc_savimg }');"/>
		</c:if>
		<div class="pre_cover" style="${background}">
			<c:choose>
				<c:when test="${list.msp_orgimg eq null }">
					<img src="<c:url value='/resources/images/default-profile.png'/>" class="img-circle"
						style="margin-top: 60px;width: 150px;height: 150px;background-color: white;display: block;
						margin-left: auto;margin-right: auto;">
				</c:when>
				<c:otherwise>
					<img src="<c:url value='/resources/upload/img/${list.msp_savimg }'/>" class="img-circle"
						style="margin-top: 60px;width: 150px;height: 150px;background-color: white;display: block;
						margin-left: auto;margin-right: auto;">
				</c:otherwise>
			</c:choose>
			<br>
			<p><span style="width: max-content;color:black;border-bottom: 2px solid white;display: block;margin-left: auto;margin-right: auto;">${ list.ms_msg}</span></p> 
			<div class="collapse navbar-collapse" style="background-color: ${list.ms_color};border-radius:10px;">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#contact">COMMUNITY</a></li>
					<li class="dropdown"><a href="#contact">MYPAGE</a></li>
					<li><button type="button" class="btn btn-default btn-lg"style="border:${list.ms_color} ;background-color: ${list.ms_color};border-radius:10px;" ><span class="glyphicon glyphicon-search"></span></button></li>
				</ul>
			</div>
		</div>
	</c:forEach>
</div>