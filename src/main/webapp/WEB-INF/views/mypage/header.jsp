<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<nav class="navbar navbar-default" data-spy="affix" data-offset-top="712">
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