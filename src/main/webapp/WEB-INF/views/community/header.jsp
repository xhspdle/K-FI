<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron text-center" id="communityJumbo">
	<div> 
		<h3 class="communityHeader"><strong>K-Fi's Community World</strong></h3>
		<p class="communityHeader"><span class="">Meet likeminded people around the world.</span></p> 
	</div>
</div>  
<nav class="navbar navbar-default" data-spy="affix" data-offset-top="400" id="navAffix" style="background-color:${msv.ms_color};">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			</button>
			<a class="navbar-brand" style="padding:0 !important;" href="<c:url value='/'/>"><img class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/logo0-1.png'/>"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#best">BEST</a></li>
				<li><a href="#issue-img">ISSUE-IMG</a></li>
				<li><a href="#issue-vid">ISSUE-VID</a></li>
				<li><a href="#build">BUILD</a></li>
				<li class="dropdown">
					<a href="<c:url value='/communityMain'/>">COMMUNITY</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/community/newComm/insertForm'/>">CREATE</a></li>
						<li><a href="<c:url value='/communityMain/list'/>">K-FI's LIST</a></li>
						<li><a href="<c:url value='/mypage/mycomm/list'/>">MY COMMUNITY</a></li>
						<%-- <li><a href="<c:url value='/community/commcalendar'/>">일정보기</a></li> --%>
					</ul>
				</li>
				<c:if test="${!empty user_num }">
				<li class="dropdown">
					<a href="<c:url value='/mypage/main'/>">MYPAGE</a>
				<%-- 	<ul class="dropdown-menu">
						<li><a href="<c:url value='/mypage/myfriend/list'/>">FRIEND</a></li>
						<li><a href="<c:url value='/mypage/mycomm/calendar'/>">CALENDAR</a></li>
						<li><a href="<c:url value='/mypage/myskin/list'/>">SKIN</a></li>
						<li><a href="<c:url value='/mypage/myinfo/password'/>">INFO</a></li>
						<li><a href="<c:url value='/login/logout'/>" class="logout-btn">LOGOUT</a></li>
					</ul> --%>
				</li>
				</c:if>
				<li><button type="button" class="btn btn-default btn-lg" id="search" style="background-color:${msv.ms_color};">
				<span class="glyphicon glyphicon-search"></span></button></li>
			</ul>
		</div>
	</div>
</nav>
<div id="headerSearch">
	<div class="row">
		<div class="container search_con">
			<form id="searchForm" name="mySearchForm" method="post" action="<c:url value='/mypage/myboard/list'/>">
			<!-- 여기서 검색은 커뮤니티 검색 전용으로 : action 주소 변경 필요 -->
				<div class="input-group">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default btn-lg search_bar"><i class="glyphicon glyphicon-search"></i></button>
					</div>
					<input type="text" class="form-control search_bar" name="keyword" placeholder="search anything!">
					<div class="input-group-btn">
						<button class="btn btn-default btn-lg search_bar" id="search_close"><i class="glyphicon glyphicon-remove"></i></button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>