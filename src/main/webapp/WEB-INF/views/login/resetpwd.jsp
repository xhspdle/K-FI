<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet"> -->
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.row {
	margin-top: 21rem;
}

body {
	padding-top: 15rem;
	padding-bottom: 15rem;
	margin: auto;
	width: 50%;
	padding: 10px;
	/* background: rgba(0, 0, 0, 0.76);
	background: url(../resources/images/backimg.png) no-repeat center center
		fixed; */
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

a {
	text-decoration: none !important;
}

h1, h2, h3, button {
	font-family: 'Montserrat', cursive;
}

.resetpassword-form {
	position: relative;
	display: -ms-flexbox;
	display: flex;
	padding: 2.5rem;
	-ms-flex-direction: column;
	flex-direction: column;
	width: 100%;
	pointer-events: auto;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid rgba(0, 0, 0, .2);
	border-radius: 1.1rem;
	outline: 0;
	max-width: 500px;
	margin-left: 20%;
	box-shadow: 5px 10px 40px rgba(0,0,0, .4);
}

.tx-tfm {
	text-transform: uppercase;
}

#submitbtn {
	border-radius: 50px;
}
.span-or {
	display: block;
	position: absolute;
	left: 50%;
	top: -2px;
	margin-left: -25px;
	background-color: #fff;
	width: 50px;
	text-align: center;
}
form .error {
	color: #ff0000;
}
</style>
</head>
<body>
<div class="row">
	<div class="resetpassword-form">
			<div class="col-md-12 text-center">
				<h1>Reset Password</h1>
			</div>
		<form action="<c:url value='/login/join'/>" name="resetpassword">
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					name="user_pwd" id="password" class="form-control"
					aria-describedby="passwordHelp" placeholder="Enter Password">
			</div>
			<div class="form-group">
				<label for="retypepassword">Retype Password</label> <input
					type="password" name="pwdCheck" id="retypepassword"
					class="form-control" aria-describedby="retypepasswordHelp"
					placeholder="Password to again">
			</div>
			<div class="col-md-12 text-center mb-3">
				<button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm" id="submitbtn">submit</button>
			</div>
		</form>
			<ul>
		<li>
		영문+숫자+특수문자를 조합하여 8~15자로 변경하세요.<br>
		</li>
		<li>
		비밀번호 변경 시 자동 로그인은 해제됩니다.<br>
		변경된 비밀번호로 다시 로그인 하세요.
		</li>
	</ul>
	</div>
	</div>
</body>
</html>