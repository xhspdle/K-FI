<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.logout-btn{overflow:hidden;position:absolute;top:0;left:0;width:1px;height:1px;font-size:0;line-height:0}
</style>
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
<script type="text/javascript">
$(function(){
	$('.logout-btn').on('click',function(){
	event.preventDefault();
		alert("logout");
		location.href="<c:url value='/login/logout'/>";
	});
});
/* 로그인시 메인메뉴에서 로그인을 없애고 로그아웃으로 만들자 */
</script>