<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="<c:url value='/admin/abdetail'/>">
	<div>
		작성자<input type="text" name="admin_num"><br>
		제목<input type="text" name="ab_title"><br>
		<textarea rows="20" cols="100" name="ab_content"></textarea><br>
		작성자<input type="checkbox" name="ab_notice">
	</div>
	<input type="submit" value="등록"> 	
</form>