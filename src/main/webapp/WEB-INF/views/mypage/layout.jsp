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
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 sidenav">
					<tiles:insertAttribute name="leftside"/>
				</div>
				<div class="col-sm-offset-3 col-sm-6">
					<div class="container-fluid">
						<tiles:insertAttribute name="content"/>
					</div>		
				</div>
				<div class="col-sm-3">
					<tiles:insertAttribute name="rightside"/>
				</div>
			</div>
		</div>
		
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>