<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>">	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/admin.js'/>"></script>

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar1"
	data-offset="60">
	<c:set var="admin" value="${sessionScope.admininfo }" />
	<%-- <c:set var="user" value="${mblist }"/> --%>
	<div id="wrap">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div>
						<c:choose>
							<c:when test="${empty admin}">
								<!--  	<a class="navbar-brand" href="#myPage">관리자</a> -->
								<a href="adlogin"><i class="glyphicon glyphicon-log-in"></i></a>
								<a href="adjoin"><i class="glyphicon glyphicon-user"></i></a>
							</c:when>
							<c:otherwise>
								<a class="navbar-brand" href="#myPage">${admin.admin_nick }님
									반갑습니다</a>
								<a href="adlogout"><i class="glyphicon glyphicon-log-out"></i></a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>		
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="mblist">회원관리</a></li>
						<li><a href="accuse">신고관리</a></li>
						<li><a href="">통계관리</a></li>
						<li><a href="ablist">공지사항</a></li>
						<li><a href="faqlist">Q&#38;A</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<c:choose>
			<c:when test="${empty admin}">
				<div class="topheader text-center">
					<h1>Company</h1>
				</div>
			</c:when>
			<c:otherwise>
				<div class="topheader text-center">
					<img src="<c:url value='/resources/images/1 (1).jpg'/>"
						style="width: 200px; heigh =150px; border: 3px solid gold; border-radius: 150px;">
					${admin.admin_id } ${admin.admin_nick }
				</div>
			</c:otherwise>
		</c:choose>

		<div id="content" class="container-fluid bg-grey">
			<tiles:insertAttribute name="content" />
		</div>

		<footer class="container-fluid text-center">
			<a href="#myPage" title="To Top"> <span
				class="glyphicon glyphicon-chevron-up"></span>
			</a>
			<p>
				Bootstrap Theme Made By <a href="https://www.w3schools.com"
					title="Visit w3schools">www.w3schools.com</a>
			</p>
		</footer>
<!-- 		<div id="popup">
			<a href="javascript:hidePopup()">닫기</a>
			<h1>공지사항</h1>
			<div>ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</div>
		</div> -->
	</div>

</body>
</html>