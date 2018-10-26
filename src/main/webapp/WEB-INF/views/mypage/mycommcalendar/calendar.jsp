<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- mycomm Calendar -->
<div id="mycomm_Calendar">
	<div id="jyi_mycomm_calendar_sub">
	<h1>
	<span>
	<a id="prevcal" class="btn btn-default" role="button" href="<c:url value='/mypage/mycommcalendar?year=${year }&month=${month-1 }' />"> < </a>
	</span>
	<span style="color:#00cee8;font-weight: bold;">${year } ${mon[month] }</span>
	<span>
	<a id="aftcal" class="btn btn-default" role="button" href="<c:url value='/mypage/mycommcalendar?year=${year }&month=${month+1 }' />"> > </a>
	<select id="mycommlist" class="btn btn-default" >
			<option>전체</option>
	</select>
	<a id="attendcal" class="btn btn-default" role="button" href="<c:url value='#' />"> 참석 </a>
	</span>
	</h1>
	</div>
	<input type="hidden" id="year" value="${year }">
	<input type="hidden" id="month" value="${month }">
	<input type="hidden" id="url" value="${pageContext.request.contextPath }">

	<!-- 날짜 테이블 -->
	<table class="table table-bordered" id="jyi_mycomm_calendar">
		<tr>
			<th class="jyi_week" >SUN</th>
			<th class="jyi_week" >MON</th>
			<th class="jyi_week" >TUE</th>
			<th class="jyi_week" >WED</th>
			<th class="jyi_week" >THU</th>
			<th class="jyi_week" >FRI</th>
			<th class="jyi_week" >SAT</th>
		</tr>
		<c:forEach var="i" items="${arr }">
			<c:choose>
				<c:when test="${i==0}">
					<td class="jyi_cal"></td>
				</c:when>
				<c:when test="${j%7==0}">
					<tr></tr>
					<td class="jyi_cal">
					<a class="jyi_a" style="color: red;" id="${i }"
						href="<c:url value="/mypage/find?year=${year }&month=${month }&day=${i }" />">${i }</a></td>
				</c:when>
				<c:when test="${j%7==6 }">
					<td class="jyi_cal"><a class="jyi_a" style="color: blue;"
						id="${i }"
						href="<c:url value="/mypage/find?year=${year }&month=${month }&day=${i }" />">${i }</a></td>
				</c:when>
				<c:otherwise>
					<td class="jyi_cal"><a id="${i }" class="jyi_a"
						href="<c:url value="/mypage/find?year=${year }&month=${month }&day=${i }" />">${i }</a></td>
				</c:otherwise>
			</c:choose>
			<c:set var="j" value="${j+1 }" />
		</c:forEach>
	</table>
</div>