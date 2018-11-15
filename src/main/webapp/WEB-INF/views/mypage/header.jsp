<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div class="jumbotron text-center" id="mypageJumbo">
	<div style="background:url(${pageContext.request.contextPath}/resources/upload/img/${msv.msc_savimg })"> 
		<img id="profileImg" class="img-circle" alt="profile" src="<c:url value='/resources/upload/img/${msv.msp_savimg }'/>">
		<h3><strong>${user_nickname }</strong></h3>
		<p><span style="border-bottom: 2px solid white;">${msv.ms_msg }</span></p>
		<form class="form-follow">
			<div class="input-group col-sm-offset-5 col-sm-2">
				<button type="submit" class="btn btn-join-follow">Follow</button>
			</div>
		</form>  
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
				<li><a href="<c:url value='/communityMain/'/>">COMMUNITY</a></li>
				<li class="dropdown">
					<a href="<c:url value='/mypage/main'/>">MYPAGE</a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#writeModal">글쓰기</a></li>
						<li><a href="<c:url value='/mypage/mycomm/list'/>">마이커뮤니티</a></li>
						<li><a href="<c:url value='/mypage/mycomm/calendar'/>">일정보기</a></li>
						<li><a href="<c:url value='/mypage/myskin/list'/>">MYSKIN</a></li>
						<li><a href="<c:url value='/mypage/myinfo/password'/>">회원정보</a></li>
						<li><a href="#">로그아웃</a></li>
					</ul>
				</li>
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