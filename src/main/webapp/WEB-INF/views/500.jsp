<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>404 Not found</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<style type="text/css">
	<!--
	*{margin:0px;padding:0px;}
	body {font-family:Montserrat, sans-serif;color:black;font-size:18px;}
	h1 {font-family:Montserrat, sans-serif;font-size:32px;}
	img.img-responsive {
		position: relative;
		left: 50%;
		transform: translateX(-50%);
		max-height: 400px;
	}
	div.container {margin-top: 5%;}
	-->
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrap" class="container-fluid text-center">
		<p>
			<img class="img-responsive" 
			alt="Page not found error" src="<c:url value='/resources/images/404Logo.png'/>">
		</p>
		<h1>OOPS!</h1>
		<p>Our developer's wrong.</p>
		<p>please wait for update.</p>
	</div>
	<div class="container text-center">
		<a class="btn btn-success btn-lg" href="<c:url value='/'/>">GO TO HOMEPAGE</a>
	</div>
</body>
</html>
