<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.redText{display: block;color: red;margin-left:10px;}
.greenText{display: block;color: green;margin-left:10px;}
.fiform-group input {
	width: 400px;
}
.fiform-group-code input {
	width: 200px;
}
.form-group{display: block;}
.col-sm-4 {margin-top: 4.2rem; margin-left: 30rem; padding-top:4.2rem; padding-bottom:4.2rem;
	position: relative;
		display: -ms-flexbox;
		display: flex;
		padding: 1rem;
		-ms-flex-direction: column;
		flex-direction: column;
		width: 100%;
		pointer-events: auto;
		background-color: #fff;
		background-clip: padding-box;
		border: 2px solid rgba(0,0,0,.2);
		border-radius: 1.1rem;
		outline: 0;
		max-width: 500px;}

</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	var emailflag = false;
/* 	$('#btn1').click(function(){
		 var email = $("#fiemail").val();
		 var eMsg = $("#emailMsg");
		 var isEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		if (email == "") {
			$(eMsg).text("이메일 주소를 입력해주세요.");
			$("#fiemail").focus();
			return false;
		}
			$.ajax({
			type : "GET",
			url : '/login/findid',
			data : {'user_email' : email},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "json",
			success : function(data) {
				console.log(data)
		 if(!isEmail.test(email)){
			$(eMsg).text("이메일 형식이 맞지않습니다.");
			return emailFlag = false;
			return false;
			
		} else if (data.msg == 'false') {
			$(eMsg).text("이메일을 확인했습니다..");
			return emailFlag = true;
			return true;
			
		} else if (data.msg == 'true') {
			$(eMsg).text("존재하지 않는 이메일 입니다.");
			$("#fiemail").focus();
			return emailflag = false;
			return false;
		}
			}
			});
	}); */
	$('#btn2')
});
</script>
</head>
<body>
<div class="col-sm-4">
	<div class="container">
		<form class="navbar-form navbar-left" action="<c:url value='/login/findid'/>" method="post">
			
			<div class="form-group">
				<label class="form-control-label" for="fpemail">Email</label><br>
				 <input type="email" class="form-control" id="fiemail" name="user_email"
					placeholder="Enter Email">
					<button type="submit" class="btn btn-default" id="btn1">인증번호보내기</button>
				 <span id="emailMsg"class="help-block" style="opacity: 1;"></span>
			</div>
		</form>
	</div>
	<div class="container">
	<form class="navbar-form navbar-left" action="<c:url value='/login/findpidok'/>" method="post">
			<div class="form-group">
				<label class="form-control-label" for="ficode">Code</label><br>
				<input type="text" class="form-control" id="ficode" name="ficode"placeholder="Enter Code">
				<button type="submit" class="btn btn-default" id="btn2">확인</button>
				<span id="idMsg" class="help-block" style="opacity: 1;"></span>
				<button type="submit" class="btn btn-default" id="btn3">다음</button>
			</div>
		</form>
		</div>
</div>
</body>
</html>