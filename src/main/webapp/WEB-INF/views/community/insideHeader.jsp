<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron text-center" id="communityJumbo">
	<input type="hidden" id="comm_num" value="${comm_num }">
	<input type="hidden" id="cul_status" value="${cul_status }">
	<div> 
		<h3 class="communityHeader"><strong>Community Name</strong></h3>
		<p class="communityHeader"><span class="">Welcome to community~!</span></p>
		<c:choose>
			<c:when test="${user_num eq comm_adminNum && cul_status eq 1}">
				<!-- admin일 경우 -->
				<div class="form-join">
					<div class="col-sm-offset-5 col-sm-2">			
						<a href="<c:url value='/community/commadmin/commuserlist?comm_num=${comm_num }'/>" class="btn btn-comm-admin">Admin</a>
					</div>
				</div>
			</c:when>
			<c:when test="${user_num ne comm_adminNum && cul_status eq 1 }">
				<!-- 이미 가입한 회원일 경우 -->
				<form class="form-join">
					<div class="input-group col-sm-offset-5 col-sm-2">
						<a class="btn btn-join-follow" href="<c:url value='/commuserlist/delete?comm_num=${comm_num }'/>">Leave</a><br>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<!-- 가입 안한 회원일 경우 -->
				<form class="form-join">
					<div class="input-group col-sm-offset-5 col-sm-2">
						<a class="btn btn-join-follow" href="<c:url value='/commuserlist/insert?comm_num=${comm_num }'/>">Join</a>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
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
				<li class="dropdown">
					<a href="<c:url value='/community'/>">COMMUNITY</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/community/newComm/insertForm'/>">커뮤니티 등록(가제)</a></li>
						<li><a href="#">마이커뮤니티</a></li>
						<li><a href="#">일정보기</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="<c:url value='/mypage/main'/>">MYPAGE</a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#writeModal">글쓰기</a></li>
						<li><a href="#">마이커뮤니티</a></li>
						<li><a href="<c:url value='/mypage/mycommcalendar'/>">일정보기</a></li>
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
<div class="navbar navbar-comm-menu" data-spy="affix" data-offset-top="450">
	<ul class="nav navbar-nav navbar-center"> 
		<li><a id='commWrite' href="<c:url value='/community/board/insert'/>"><i class="glyphicon glyphicon-check"></i>WRITE</a></li>
		<li><a href="#"><i class="glyphicon glyphicon-star"></i>POPULAR</a></li>
		<li><a href="#"><i class="glyphicon glyphicon-time"></i>LATEST</a></li>
		<li><a href="<c:url value='/community/polls/list'/>"><i class="glyphicon glyphicon-stats"></i>POLLS</a></li>
	</ul>
</div>