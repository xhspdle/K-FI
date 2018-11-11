<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script type="text/javascript">
$('#btn1').click(function(){
	 var email = $("#fiemail").val();
	 var eMsg = $("#emailMsg");
	 var emailflag = false;
	 var isEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	if (email == "") {
		$(eMsg).text("이메일 주소를 입력해주세요.");
		return false;
	}
		$.ajax({
		async : true,
		type : "GET",
		url : getContext + '/login/join/emailcheck',
		data : {'user_email' : email},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "json",
		success : function(data) {
	 if(!isEmail.test(email)){
		$(eMsg).text("이메일 형식이 맞지않습니다.");
		return emailFlag = false;
		return false;
		
	} else if (data.msg == 'false') {
		$(eMsg).text("이미 사용중인 이메일 입니다.");
		eMsg.show();
		return emailFlag = false;
		return false;
		
	} else if (data.msg == 'true') {
		$(eMsg).text("사용할 수 있는 이메일 입니다.");
		return emailflag = true;
		return true;
	}
		}
		});
});
</script>
</head>
<body>
<div class="col-sm-4">
	<div class="container">
		<form class="navbar-form navbar-left" action="<c:url value='/login/join'/>" method="post">
			
			<div class="form-group">
				<label class="form-control-label" for="fpemail">Email</label><br>
				 <input type="email" class="form-control" id="fiemail" name="fiemail"
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
				<button type="submit" class="btn btn-default" id="btn2">Submit</button>
				<span id="idMsg" class="help-block" style="opacity: 1;"></span>
			</div>
		</form>
		</div>
</div>
</body>
</html>