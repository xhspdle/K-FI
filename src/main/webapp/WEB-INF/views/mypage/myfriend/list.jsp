<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<br>
	<h2>My Friend List</h2>
	<span style="margin-top: -5%; display: table-cell; float: right;">
		<a href="<c:url value='/mypage/myfriend/list?user_number=user2_num'/>">
			<button class="w3-btn w3-black w3-round-xxlarge"
				style="background-color:${msv.ms_color} !important;">팔로워</button>
	</a> <a href="<c:url value='/mypage/myfriend/list?user_number=user1_num'/>">
			<button class="w3-btn w3-black w3-round-xxlarge"
				style="background-color:${msv.ms_color} !important;">팔로잉</button>
	</a>
	</span>
	<div style="width: 100%;">
		<c:forEach var="msvVo" items="${msvlist }">
			<c:forEach var="mVo" items="${mvolist }">
				<c:if test="${msvVo.user_num eq mVo.user_num }">
				<div class="w3-third" style="width: 33%; padding: 0.8%;">
					<div class="w3-card"
						style="height: 100px; border-radius: 25px; background-color:${msvVo.ms_color};overflow: hidden;">
						<div class="myFriendContainer">
						<a href="#" style="text-decoration: none;">
						  <img src="<c:url value='/resources/upload/img/${msvVo.msp_savimg}'/>">
						  <p><span><b> ${mVo.user_nickname }</b></span>
						  <br><span>${msvVo.ms_msg }</span></p>
						  <p></p>
						</a>
						</div>
					</div>
				</div>
				</c:if>
			</c:forEach>
		</c:forEach>
	</div>
</div>