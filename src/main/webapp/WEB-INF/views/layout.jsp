<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title>K-FI Main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	body {
		font: 400 15px Lato, sans-serif;
		font-size: 15px;
		line-height: 1.8;
		color: #818181;
	}
	h2 {
    	font-size: 24px;
        text-transform: uppercase;
        color: #303030;
        font-weight: 600;
        margin-bottom: 30px;
 	}
 	h4{
		font-size: 19px;
        line-height: 1.375em;
        color: #303030;
        font-weight: 400;
        margin-bottom: 30px;
 	}
 	.jumbotron{
 		font-family: Montserrat, sans-serif;
 		background-color: #00cee8;
 		color: #fff;
     	padding: 100px 25px;
 	}
	.container-fluid {
		padding: 60px 50px;
	}
	.bg-grey {
		background-color: #f6f6f6;
	}
	.logo-small {
		color: #337ab7;
		font-size: 50px;
	}
	.logo {
	    color: #337ab7;
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
	    color: #f4511e;
	}
	.carousel-indicators li {
	    border-color: #f4511e;
	}
	.carousel-indicators li.active {
	    background-color: #f4511e;
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
	    border: 1px solid #f4511e; 
	    border-radius:0 !important;
	    transition: box-shadow 0.5s;
	}
	.panel:hover {
	    box-shadow: 5px 0px 40px rgba(0,0,0, .2);
	}
	.panel-footer .btn:hover {
	    border: 1px solid #f4511e;
	    background-color: #fff !important;
	    color: #f4511e;
	}
	.panel-heading {
	    color: #fff !important;
	    background-color: #f4511e !important;
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
	    background-color: #f4511e;
	    color: #fff;
	}
	.navbar {
	    margin-bottom: 0;
	    background-color: #00cee8;
	    z-index: 9999;
	    border: 0;
	    font-size: 12px !important;
	    line-height: 1.42857143 !important;
	    letter-spacing: 4px;
	    border-radius: 0;
	    font-family: Montserrat, sans-serif;
	}
	.navbar li a, .navbar .navbar-brand {
	    color: #fff !important;
	}
	.miniLogo {
		width: 74px;
		height: 50px;
	}
	.navbar-nav li a:hover, .navbar-nav li.active a {
	    color: #f4511e !important;
	    background-color: #fff !important;
	}
	.navbar-brand {
		padding: 0px;
	}
	.navbar-default .navbar-toggle {
	    border-color: transparent;
	    color: #fff !important;
	}
	footer .glyphicon {
	    font-size: 20px;
	    margin-bottom: 20px;
	    color: #f4511e;
	}
	.slideanim {visibility:hidden;}
	.slide {
	    animation-name: slide;
	    -webkit-animation-name: slide;
	    animation-duration: 1s;
	    -webkit-animation-duration: 1s;
	    visibility: visible;
	}
	@keyframes slide {
		0% {
			opacity: 0;
			transform: translateY(70%);
		} 
		100% {
			opacity: 1;
			transform: translateY(0%);
		}
	}
	@-webkit-keyframes slide {
		0% {
			opacity: 0;
			-webkit-transform: translateY(70%);
		} 
		100% {
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
		.logoImg{
			width: 371.7px;
			height: 277.2px;
		}
	}
	@media screen and (max-width: 480px) {
		.logo {
		    font-size: 150px;
		}
		.logoImg{
			width: 212.4px;
			height: 158.4px;
		}
	}
</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

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
				<li><a href="#signin">SIGNIN</a></li>
				<li><a href="#contact">CONTACT</a></li>
			</ul>
		</div>
	</div>
</nav>

<div class="jumbotron text-center">
	<h1><img class="logoImg" alt="logo" src="<c:url value='/resources/images/logo2.png'/>"></h1>
	<p>We love Korea!</p> 
	<form>
		<div class="input-group col-sm-offset-4 col-sm-4">
			<input type="email" class="form-control" placeholder="what is you're favorite k-culture?" required>
			<div class="input-group-btn">
				<button type="button" class="btn btn-primary">Search</button>
			</div>
		</div>
	</form>
</div>

<div id="about" class="container-fluid">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-6">
			<h2>About K-FI</h2><br>
			<h4>Korea, K-POP, K-Drama, Red Velvet, Twice, BTS</h4><br>
			<p>K-POP 좋아하는 사람 모여라! 덕질하기 가장 좋은 싸이트는 바로 여기! 수다, 사진, 영상 모두 모두 나누자!
			너도 나도 K-POP! 드라마도 한국 드라마가 최고!! 미스터 선샤인 짱짱맨 오예!! 트와이스 사나 모모 짱짱 레드벨벳도 짱짱 방탄소년단도 호올
			신나게 모이자 후룰룰루룰루루루루루루루루루ㅜㄹ루ㅜ루루루ㅜ루루루
			</p>
			<br><button class="btn btn-default btn-lg">Join Us</button>
		</div>
		<div class="col-sm-4">
			<span class="glyphicon glyphicon-signal logo"></span>
		</div>
	</div>
</div>

<div id="explore" class="container-fluid bg-grey">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-6">
			<!-- img class="img-responsive slideanim" -->
			<img class="img-responsive slideanim" alt="kpop로고" src="<c:url value='/resources/images/Kpoplogo.png'/>">
		</div>
		<div class="col-sm-4">
			<h2>Best Community</h2><br>
			<h4><strong>Share:</strong> K-POP과 함께 즐거운 순간을 공유하자! </h4><br>
			<p><strong>MeetUp:</strong> K-POP팬들과 함께 만나서 놀자!</p>
		</div>
	</div>
</div>

<div id="contact" class="container-fluid">
	<h2 class="text-center">CONTACT</h2>
	<div class="row">
		<div class="col-sm-offset-2 col-sm-5">
			<p>Contact us and we'll get back to you within 24 hours.</p>
			<p><span class="glyphicon glyphicon-map-marker"></span> Jongno, KR</p>
			<p><span class="glyphicon glyphicon-phone"></span> +81 01000000000</p>
			<p><span class="glyphicon glyphicon-envelope"></span> k-fi@k-fi.com</p>
		</div>
		<div class="col-sm-5 slideanim">
			<div class="row">
				<div class="col-sm-6 form-group">
					<input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
				</div>
				<div class="col-sm-6 form-group">
					<input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
				</div>
			</div>
			<textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
			<div class="row">
				<div class="col-sm-12 form-group">
					<button class="btn btn-default pull-right" type="submit">Send</button>
				</div>
			</div>
		</div>
	</div>
</div>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Bootstrap Theme Made By <a href="https://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a></p>
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
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