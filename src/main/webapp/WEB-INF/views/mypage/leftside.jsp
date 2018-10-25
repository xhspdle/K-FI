<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 프로필 -->
<!-- <div id="leftside_wrap">
 -->	<div class="well well-lg">
		<h4>프로필사진</h4>
		<div>
			<img class="img-responsive" alt="프로필사진"
				src="<c:url value='/resources/images/logo0.png'/>">
		</div>
	</div>
	<ul>
	<li><button type="button" class="btn btn-default btn-lg" id="writeBtn">글쓰기</button></li>
	<li><a href="<c:url value='/mypage/myboard/list'/>">글목록</a></li>
	</ul>

	<!-- 게시판 달력 -->
	<%-- <div>
	<span>
	<a id="prevcal_left" class="btn btn-default" role="button" href="<c:url value='/mypage/mycommcalendar?year=${year }&month=${month-1 }' />"> < </a>
	<a id="aftcal_left" class="btn btn-default" role="button" href="<c:url value='/mypage/mycommcalendar?year=${year }&month=${month+1 }' />"> > </a>
	</span>
	<span style="color:#00cee8;font-weight: bold;">${year } ${mon[month] }</span>
	 --%>	<table class="table table-bordered" id="jyi_calendar" width="100">
			<tr>
				<th class="jyi_week">S</th>
				<th class="jyi_week">M</th>
				<th class="jyi_week">T</th>
				<th class="jyi_week">W</th>
				<th class="jyi_week">R</th>
				<th class="jyi_week">F</th>
				<th class="jyi_week">S</th>
			</tr>
			<c:forEach var="i" items="${arr }">
				<c:choose>
					<c:when test="${i==0}">
						<td class="jyi_cal_left"></td>
					</c:when>
					<c:when test="${j%7==0}">
						<tr></tr>
						<td class="jyi_cal_left"><a class="jyi_a" style="color: red;"
							id="${i }"
							href="<c:url value="/mypage/find?year=${year }&month=${month }&day=${i }" />">${i }</a></td>
					</c:when>
					<c:when test="${j%7==6 }">
						<td class="jyi_cal_left"><a class="jyi_a"
							style="color: blue;" id="${i }"
							href="<c:url value="/mypage/find?year=${year }&month=${month }&day=${i }" />">${i }</a></td>
					</c:when>
					<c:otherwise>
						<td class="jyi_cal_left"><a id="${i }" class="jyi_a"
							href="<c:url value="/mypage/find?year=${year }&month=${month }&day=${i }" />">${i }</a></td>
					</c:otherwise>
				</c:choose>
				<c:set var="j" value="${j+1 }" />
			</c:forEach>
		</table>
	</div>
