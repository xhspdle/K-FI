<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			</button>
			<a class="navbar-brand" href="<c:url value='/'/>"><img class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/logo0-1.png'/>"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#contact">COMMUNITY</a></li>
				<li class="dropdown">
					<a href="<c:url value='/mypage/main'/>">MyPage</a>
					<ul class="dropdown-menu">
						<li><a href="#">회원정보</a></li>
						<li><a href="#">마이커뮤니티</a></li>
						<li><a href="<c:url value='/mypage/mycommcalendar'/>">일정보기</a></li>
						<li><a href="#">로그아웃</a></li>
					</ul>
				</li>
				<li><button type="button" class="btn btn-default btn-lg" id="search">
				<span class="glyphicon glyphicon-search"></span></button></li>
			</ul>
		</div>
	</div>
</nav>
<div class="header_search">
	<div class="row">
		<div class="container">
			
		</div>
	</div>
</div>