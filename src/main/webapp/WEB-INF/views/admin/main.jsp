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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
* {margin-top:0px;padding:0px;}
body {
	font: 400 15px Lato, sans-serif;
	line-height: 1.8;
	color: #818181;
/*  	opacity: 0.5; */
}

h2 {
	font-size: 24px;
	text-transform: uppercase;
	color: #303030;
	font-weight: 600;
	margin-bottom: 30px;
}

h4 {
	font-size: 19px;
	line-height: 1.375em;
	color: #303030;
	font-weight: 400;
	margin-bottom: 30px;
}

.topheader {
	background-color: #333333;
	color: #fff;
	padding: 100px 25px;
	font-family: Montserrat, sans-serif;
}

.container-fluid {
	padding: 60px 50px;
}

.bg-grey {
	background-color: #f6f6f6;
}

.logo-small {
	color: #333333;
	font-size: 50px;
}

.logo {
	color: #333333;
	font-size: 200px;
}

.thumbnail {
	padding: 0 0 15px 0;
	border: none;
	border-radius: 0;
}

.thumbnail img {
	width: 100%;
	height: 100%;
	margin-bottom: 10px;
}

.carousel-control.right, .carousel-control.left {
	background-image: none;
	color: #333333;
}

.carousel-indicators li {
	border-color: #333333;
}

.carousel-indicators li.active {
	background-color: #333333;
}

.item h4 {
	font-size: 19px;
	line-height: 1.375em;
	font-weight: 400;
	font-style: italic;
	margin: 70px 0;
}

.item span {
	font-style: normal;
}

.panel {
	border: 1px solid #333333;
	border-radius: 0 !important;
	transition: box-shadow 0.5s;
}

.panel:hover {
	box-shadow: 5px 0px 40px rgba(0, 0, 0, .2);
}

.panel-footer .btn:hover {
	border: 1px solid #333333;
	background-color: #fff !important;
	color: #333333;
}

.panel-heading {
	color: #fff !important;
	background-color: #333333 !important;
	padding: 25px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

.panel-footer {
	background-color: white !important;
}

.panel-footer h3 {
	font-size: 32px;
}

.panel-footer h4 {
	color: #aaa;
	font-size: 14px;
}

.panel-footer .btn {
	margin: 15px 0;
	background-color: #333333;
	color: #fff;
}

.navbar {
	margin-bottom: 0;
	background-color: #333333;
	z-index: 9999;
	border: 0;
	line-height: 1.42857143 !important;
	border-radius: 0;
	font-family: Montserrat, sans-serif;
}

.navbar li a, .navbar .navbar-brand {
	color: #fff !important;
}

.navbar-nav li a:hover, .navbar-nav li.active a {
	color: #333333 !important;
	background-color: #fff !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
	color: #fff !important;
}
/* ///////////////////////////////////////////////////////////// */
.navbar-header a i {
	color: #fff !important;
	padding: 15px 15px;
}

.navbar-header a i:hover {
	color: #333333 !important;
	background-color: #fff !important;
}
/* //////////////////////////////////////////////////////////////////////// */
footer .glyphicon {
	font-size: 20px;
	margin-bottom: 20px;
	color: #333333;
}

.slideanim {
	visibility: hidden;
}

.slide {
	animation-name: slide;
	-webkit-animation-name: slide;
	animation-duration: 1s;
	-webkit-animation-duration: 1s;
	visibility: visible;
}

@keyframes slide { 0% {
		opacity: 0;
		transform: translateY(70%);
	}100%{
		opacity: 1;
		transform: translateY(0%);
	}
}
@-webkit-keyframes slide { 0% {
	opacity: 0;
	-webkit-transform: translateY(70%);
	}100%{
		opacity: 1;
		-webkit-transform: translateY(0%);
	}
}
@media screen and (max-width: 768px) {
	.col-sm-4 {
		text-align: center;
		margin: 25px 0;
	}
	.btn-lg {
		width: 100%;
		margin-bottom: 35px;
	}
}

@media screen and (max-width: 480px) {
	.logo {
		font-size: 150px;
	}
}
.modal {
	width: 50%;
	height: 50%;
	margin: auto;
}
#popup {
	width: 200px;
	height: 200px;
	background-color: white;
	border: 2px solid red;
	position: absolute;
	top: 100px;
	left: 10%;
	display: none;
}
#popup div{
word-break:break-all;
}

</style>
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
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
						<li><a href="">Q&#38;A</a></li>
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
	<script>
		function hidePopup() {
			var popup = document.getElementById("popup");
			popup.style.display = "none";//화면에서 숨기기
		}
		$(document).ready(function() {
			var popup = document.getElementById("popup");
			popup.style.display = "block";//화면에서 숨기기
		});
		

		$(document).ready(
				function() {
					// Add smooth scrolling to all links in navbar + footer link
					$(".navbar a, footer a[href='#myPage']").on('click',
							function(event) {
								// Make sure this.hash has a value before overriding default behavior
								if (this.hash !== "") {
									// Prevent default anchor click behavior
									event.preventDefault();

									// Store hash
									var hash = this.hash;

									// Using jQuery's animate() method to add smooth page scroll
									// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
									$('html, body').animate({
										scrollTop : $(hash).offset().top
									}, 900, function() {
										// Add hash (#) to URL when done scrolling (default click behavior)
										window.location.hash = hash;
									});
								} // End if
							});

					$(window).scroll(function() {
						$(".slideanim").each(function() {
							var pos = $(this).offset().top;
							var winTop = $(window).scrollTop();
							if (pos < winTop + 600) {
								$(this).addClass("slide");
							}
						});
					});
				})
	</script>
</body>
</html>