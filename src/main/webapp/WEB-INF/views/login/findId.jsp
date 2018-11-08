<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.redText{display: block;color: red;margin-left:10px;}
.greenText{display: block;color: green;margin-left:10px;}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
</head>

<body>
<input type="hidden" id="getContext" name="getContext" value="<c:url value='/'/>">
	<form action="<c:url value='/findid'/>" method="post">
<input type="text" id="user_email" name="user_email" placeholder="이메일주소">
<input type="submit" id="submit" value="인증코드 받기"><br>
<input type="text" name="idCode" placeholder="인증코드 입력"><br>
<input type="submit" value="확인">
</form>
</body>
</html>