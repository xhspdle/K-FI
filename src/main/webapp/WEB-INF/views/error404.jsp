<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error404</title>
</head>
<body>
<div id="wrapper">
	<div id="page-wrapper">
		<div align="center">
			<c:out value='${msg }' />
		</div>
	</div>
</div>
	요청한 페이지는 존재하지 않습니다.
	<br>
	<br> 주소를 올바르게 입력했는지 확인하시길 바랍니다.
</body>
</html>