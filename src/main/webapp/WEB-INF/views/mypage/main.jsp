<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="myBoardListHere" value="MBL">
<div id="myBoardList" class="container">
</div>
<!-- Calendar icon -->
	<input type="hidden" id="url" value="${pageContext.request.contextPath }">
	<input type="hidden" id="year" value="year">
	<input type="hidden" id="month" value="month">
	<div class="sidenav">
		<div id="icon_calendar" class="glyphicon glyphicon-calendar"></div>
		<div id="wrap_icon_calendar" ></div>
	</div>