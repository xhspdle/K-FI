 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(function(){
		console.log($("#mainimg").parent().prev());
		$("#mainimg").parent().prev().remove();
		$("#mainimg").parent().next().remove();
	});
/* 	$(function(){
		var i=1;
		setInterval(function(){ 			
			i++;
			console.log(i);
			changemainimg(i);
			if(i>40){
				i=0;
			}
		}, 5000);
	});
	function changemainimg(i){
		$("#mainimg").attr("src","<c:url value='/resources/images/ysy/1 ("+i+").jpg'/>");
	} */
</script>
<img src="<c:url value='/resources/images/ysy/loginmain.jpg'/>" id="mainimg">

<div class="logincontainer">
	<div class="logincontent">
		<h2>LOG IN</h2>
		<form method="post" action="<c:url value='/admin/adlogin'/>">
			<div class="form-group">
				<label for="usr">ID:</label>
				<input type="text" class="form-control" name="admin_id">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<input type="password" class="form-control" name="admin_pwd">
			</div>
			<button type="submit" class="btn btn-default">로그인</button>
		</form>
	</div>
</div>