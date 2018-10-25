<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 프로필 -->
<div class="well well-lg">
	<h4>프로필사진</h4>
	<div>
		<img class="img-responsive" alt="프로필사진"
			src="<c:url value='/resources/images/logo0.png'/>">
	</div>
</div>
<ul>
	<li><a href="<c:url value='/mypage/myboard/insert'/>">글쓰기</a></li>
	<li><a href="<c:url value='/mypage/myboard/list'/>">글목록</a></li>
</ul>

<!-- 게시판 달력 -->
<div style="margin-left: 5%;">
	<table id="jyi_calendar" width="300">
		<tr id="jyi_main">
			<th colspan="7" style="color: #00cee8; text-align: center;">
			<a href="<c:url value='/mypage/main?year=${year }&month=${month-1 }' />"> < </a>
			${year } ${mon[month] } 
			<a href="<c:url value='/mypage/main?year=${year }&month=${month+1 }' />"> > </a>
		</tr>
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
					<td class="jyi_cal"></td>
				</c:when>
				<c:when test="${j%7==0}">
					<tr></tr>
					<td class="jyi_cal"><a class="jyi_a" style="color: red;"
						id="${i }"
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