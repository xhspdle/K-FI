<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<br>
	<h2>My Community</h2>
	<span style="margin-top: -5%;display: table-cell;float: right;">
	<a href="<c:url value='/mypage/mycomm/list'/>">
		<button class="w3-btn w3-black w3-round-xxlarge">전체</button></a>
	<a href="<c:url value='/mypage/mycomm/list?commAdmin=true'/>">
		<button class="w3-btn w3-black w3-round-xxlarge">관리 중인 커뮤니티</button></a>
	<a href="<c:url value='/mypage/mycomm/list?commAdmin=false'/>">
		<button class="w3-btn w3-black w3-round-xxlarge">가입한 커뮤니티</button></a>
	</span>
	<div class="w3-row-padding w3-margin-top">
		<c:forEach var="list" items="${list }">
			<div class="w3-third">
				<div class="w3-card">
					<c:forEach var="csplist" items="${csplist }">
						<c:if test="${list.comm_num == csplist.comm_num }">
							<!-- 해당 커뮤니티 페이지로 이동하기 -->
							<a href="#"> <img
								src="<c:url value='/resources/upload/img/${csplist.csp_savimg}'/>"
								style="width: 100%">
							</a>
						</c:if>
					</c:forEach>
					<div class="w3-container" style="background-color:${list.cs_color}">
						<h4>
							<b>${list.comm_name }</b>
						</h4>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>