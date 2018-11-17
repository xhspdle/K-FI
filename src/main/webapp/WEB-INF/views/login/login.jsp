<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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

.login-form {
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
	-webkit-box-shadow: 5px 10px 40px rgba(0,0,0, .4);
    box-shadow: 5px 10px 40px rgba(0,0,0, .4);
}

.tx-tfm {
	text-transform: uppercase;
}

.mybtn {
	border-radius: 50px;
}

.login-or {
	position: relative;
	color: #aaa;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 10px;
	padding-bottom: 10px;
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

.hr-or {
	height: 1px;
	margin-top: 0px !important;
	margin-bottom: 0px !important;
}

.form-group-forgot {
	text-align: center;
}

form .error {
	color: #ff0000;
}

.tab-head {
	font-size: 22px;
	text-align: center;
	font-family: 'Montserrat', cursive;
}

#second {
	display: none;
}
</style>
<body>

	<!-- /////////////////////////////모달/////////////////////////////////////// -->

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="bs-example bs-example-tabs">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#findid-form1" data-toggle="tab"
							id="findid" class="tab-head">Forgot ID</a></li>
						<li class=""><a href="#findpwd-form2" data-toggle="tab"
							id="findpwd" class="tab-head">Forgot Password</a></li>
					</ul>

				</div>
				<div class="modal-body">

					<form action="<c:url value='/login/findid'/>" name="findid"
						role="form" id="findid-form1" class="tab-pane fade in active" method="post">
						<div class="form-group">
							<label class="form-control-label" for="findpwd-email">Email</label><br>
							<input type="email" name="user_email" id="findpwd-email"
								class="form-control" aria-describedby="emailHelp"
								placeholder="Enter Email">
						</div>
						<div class="form-group">
							<label for="findpwd-code">Code</label> <input type="text"
								name="cm_key" id="findpwd-code" class="form-control"
								aria-describedby="codeHelp" placeholder="Enter Code">
						</div>
						<button type="submit" class="btn btn-default" id="findid-btn">Send
							Code</button>
					</form>

					<form action="<c:url value='/login/findpwd'/>" method="post"
						name="findpwd" id="findpwd-form2" class="tab-pane fade"
						style="display: none">
						<div class="form-group">
							<label class="form-control-label" for="ficode">ID</label><br>
							<input type="text" name="user_id" class="form-control" id="id"
								aria-describedby="emailHelp" placeholder="Enter ID">
						</div>
						<div class="form-group">
							<label class="form-control-label" for="fpemail">Email</label><br>
							<input type="email" name="user_email" class="form-control"
								id="email" aria-describedby="emailHelp"
								placeholder="Enter Email">
						</div>
						<button type="submit" class="btn btn-default" id="findpwd-btn">Send
							Code</button>
						<div class="form-group">
							<label for="exampleInputEmail1">Code</label> <input type="text"
								name="cm_key" id="code" class="form-control"
								aria-describedby="emailHelp" placeholder="Enter Code">
						</div>
						<button type="submit" class="btn btn-default" id="code">Code verification</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	</div>


	<!-- /////////////////////////////모달/////////////////////////////////////// -->


	<div class="row">
		<div class="col-md-3"></div>
		<div class="container">
			<div id="first">
				<div class="login-form">
					<div class="logo mb-3">
						<div class="col-md-12 text-center">
							<h1>Login</h1>
						</div>
					</div>
					<form action="<c:url value='/login/login'/>" method="post"
						name="login">
						<div class="form-group">
							<label for="exampleInputEmail1">Enter ID</label> <input
								type="text" name="user_id" class="form-control" id="userId"
								aria-describedby="emailHelp" placeholder="Enter ID"
								value="${membersVo.id }">
						</div>
						<div class="form-group">
							<label for="userpwd">Password</label> <input type="password"
								name="user_pwd" id="userpwd" class="form-control"
								aria-describedby="emailHelp" placeholder="Enter Password">
						</div>
						<div class="input-group">
							<div class="checkbox">

								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1"> Remember me
								</label>
							</div>
						</div>
						<div class="form-group">
							<p class="text-center">
								<a href="" data-toggle="modal" data-target="#myModal">Trouble
									signing in?</a>
							</p>
						</div>
						<div class="col-md-12 text-center ">
							<button type="submit"
								class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
						</div>
						<div class="col-md-12 ">
							<div class="login-or">
								<hr class="hr-or">
								<span class="span-or">or</span>
							</div>
						</div>
						<div class="col-md-12 text-center ">
							<button type="button"
								class=" btn btn-block mybtn btn-primary tx-tfm" id="signup">Sign
								up</button>
						</div>
					</form>
				</div>
			</div>


			<div id="second">
				<div class="login-form">
					<div class="logo mb-3">
						<div class="col-md-12 text-center">
							<h1>Signup</h1>
						</div>
					</div>
					<form action="<c:url value='/login/join'/>" name="registration">
						<div class="form-group">
							<label for="firstname">ID</label> <input type="text"
								name="user_id" class="form-control" id="userid"
								aria-describedby="idHelp" placeholder="Enter ID">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Nick Name</label> <input
								type="text" name="user_nickname" class="form-control"
								id="usernickname" aria-describedby="nicknameHelp"
								placeholder="Enter Nick name">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								type="password" name="user_pwd" id="password"
								class="form-control" aria-describedby="passwordHelp"
								placeholder="Enter Password">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								type="password" name="pwdCheck" id="passwordcheck"
								class="form-control" aria-describedby="passwordcheckHelp"
								placeholder="Enter Password">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> <input
								type="email" name="user_email" class="form-control" id="useremail"
								aria-describedby="emailHelp" placeholder="Enter email">
						</div>
						<div class="col-md-12 text-center mb-3">
							<button type="submit"
								class=" btn btn-block mybtn btn-primary tx-tfm">Sign Up</button>
						</div>
						<div class="col-md-12 ">
							<div class="form-group">
								<p class="text-center">
									<a href="" id="signin">Already have an account?</a>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script type="text/javascript">
		$("#signup").click(function() {
			$("#first").fadeOut("fast", function() {
				$("#second").fadeIn("fast");
			});
		});

		$("#signin").click(function() {
			$("#second").fadeOut("fast", function() {
				$("#first").fadeIn("fast");
			});
		});
		$(function() {
			$("form[name='login']").validate({
				rules : {

					id : {
						required : true,
						id : true
					},
					password : {
						required : true,

					}
				},
				messages : {
					id : "Please enter a valid id",

					password : {
						required : "Please enter password",

					}

				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});

		$(function() {

			$("form[name='registration']")
					.validate(
							{
								rules : {
									firstname : "required",
									lastname : "required",
									email : {
										required : true,
										email : true
									},
									password : {
										required : true,
										minlength : 5
									}
								},

								messages : {
									firstname : "Please enter your ID",
									lastname : "Please enter your NickName",
									password : {
										required : "Please provide a password",
										minlength : "Your password must be at least 5 characters long"
									},
									email : "Please enter a valid email address"
								},

								submitHandler : function(form) {
									form.submit();
								}
							});
		});
		$("#login-remember").click(
				function() {
					set_cookie_hs(name, value, expirehours, domain)
					var today = new Date();
					today.setTime(today.getTime()
							+ (60 * 60 * 1000 * expirehours));
					document.cookie = name + "=" + escape(value)
							+ "; path=/; expires=" + today.toGMTString() + ";";
					if (domain) {
						document.cookie += "domain=" + domain + ";";
					}
				});
		$("#findid").click(function() {
			$("#findpwd-form2").fadeOut("fast");
			$("#findid-form1").fadeIn("fast");
		});
		$("#findpwd").click(function() {
			$("#findid-form1").fadeOut("fast");
			$("#findpwd-form2").fadeIn("fast");
		});
	</script>
</body>
</html>