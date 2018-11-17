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
			<a class="navbar-brand" href="#myPage"><img class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/logo0-1.png'/>"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#about">ABOUT</a></li>
				<li><a href="#explore">EXPLORE</a></li>
				<li><a href="#contact">CONTACT</a></li>
				<li><a href="<c:url value='/mypage/main'/>">MYPAGE</a></li>
				<li><a href="<c:url value='/login/login'/>">Login</a></li>
				<li><a href="<c:url value='/login/logout'/>" class="logout-btn">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>