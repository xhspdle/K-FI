<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.redText{display: block;color: red;margin-left:10px;}
.greenText{display: block;color: green;margin-left:10px;}
#divbox{background-color: green;}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script type="text/javascript">
$(function(){
	var idflag = false;
	var emailflag = false;
	var getContext = $('#getContext').val();
	
	$('#fnid').keyup(function() {
		var id = $("#fnid").val();
		var eMsg = $("#idMsg");
		var nullck = " ";
		
		if (id.valueOf(nullck) > -1 || id.length < 1 || id==""){
			$(eMsg).text("아이디에 공백이 있습니다.");
			eMsg.removeClass('greenText');
			eMsg.addClass('redText');
			return false;
			$.ajax({
				async : true,
				type : "GET",
				url : getContext + '/login/join/idcheck',
				data : {'user_id' : id},
				dataType : "json",
				success : function(data) {
					else if (data.msg == 'false') {
						eMsg.show();
						eMsg.removeClass('redText'); 
						eMsg.addClass('greenText'); 
						$("#fnemail").focus();
						return false;
					} else if (data.msg == 'true') {
						$(eMsg).text("아이디가 존재하지 않습니다.");
						$("#fnid").focus();
						eMsg.show();
						eMsg.removeClass('greenText'); 
						eMsg.addClass('redText'); 
						return idFlag = 1;
						return true;
					}
				}
			
		}
	});
});
</script>
</head>
<body>
<input type="hidden" id="getContext" name="getContext" value="<c:url value='/'/>">
	
	<form action="<c:url value='/findpwd'/>" method="post">
			<div id="divbox">
			<label for="fnid">아이디</label><br>
				<input type="text" name="user_id" id="fnid" placeholder="아이디"><br>
				<span class=""  id="idMsg"></span>
			</div>
			<div>
			<label for="fnemail">이메일</label><br>
				<input type="text" name="user_email" id="fnemail"placeholder="이메일"><br>
			</div>

			<div>
				<input type="submit" value="다음" id="pwdbtn">
			</div>
	</form>
</body>
</html> --%>