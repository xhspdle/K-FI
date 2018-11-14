<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.logomb-3 .col-xs-6 a{float:left;display:block;width:50%;text-align:center;box-sizing:border-box;font-size:21px;cursor:pointer}

.row{
margin-top: 21rem;
}
}
body {
	padding-top: 15rem;
	padding-bottom: 15rem;
	margin: auto;
	width: 50%;
	padding: 10px;
	background: rgba(0, 0, 0, 0.76);
	background: url(${pagecontext.request.contextPath}/resources/images/login.png) no-repeat center center
		fixed;
		
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

a {
	text-decoration: none !important;
}

h1, h2, h3 {
	font-family: 'Kaushan Script', cursive;
}

.myform {
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

.findpwd-form {
	display: none;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
         <script type="text/javascript">
 		$(function() {
         var getPageContext=$("#getPageContext").val();
 			$('#findpwd-form-link1').click(function() {
 				$("#findpwd-form2").fadeIn(100);
 				$("#findid-form1").fadeOut(100);
 			});
 			$('#findid-form-link2').click(function() {
 				$("#findid-form1").fadeIn(100);
 				$("#findpwd-form2").fadeOut(100);
 			});
		
 			$("#findpwd-btn").on('submit',"form[name='findid']",function(e){
 				e.preventDefault();
 				
 				var formData=new formData($(this).get(0));
 				
 				$.ajax({
 					url: getPageContext + "/login/findid",
 					type:'post',
 					dataType: "json",
 					data: formData,
 					contentType: false,
 					processData: false,
 					success: funtion(json){
 						
 					}
 				});
 			});
 			$(function() {
 				var idFlag = false;
 				var nickFlag = false;
 				var pwdFlag = false;
 				var emailFlag = false;
 				
 				var getContext = $('#getContext').val();
 				/* var joinbtn = $("#joinbtn");
 				joinbtn.attr("disabled", "disabled");*/
 		 
 				$('#idck').click(function() {
 					var id = $("#id").val();
 					var eMsg = $("#idMsg");
 					var isID = /^[a-zA-Z0-9]{5,15}$/;
 					
 					if (id == "") {
 						$(eMsg).text("반드시 입력해주세요!");
 						$("#userid").focus();
 						return false;
 					}

 					$.ajax({
 						async : true,
 						type : "GET",
 						url : getContext + '/login/join/idcheck',
 						data : {'user_id' : id},
 						dataType : "json",
 						success : function(data) {
 							console.log(data)
 							if (!isID.test(id)) {
 								$(eMsg).text("5~15자의 영문 소문자, 숫자만 사용가능 합니다!");
 								$("#userid").focus();
 								return false;
 							} else if (data.msg == 'false') {
 								$(eMsg).text("이미 사용중인 아이디 입니다.");
 								eMsg.show(); // span태그 보여준다.
 								eMsg.removeClass('greenText'); // span태그에 greenText 클래스를 삭제한다.
 								eMsg.addClass('redText'); // span태그에 redText 클래스를 추가한다.
 								$("#userid").focus();
 								return false;
 							} else if (data.msg == 'true') {
 								$(eMsg).text("cool ID~!!");
 								$("#usernickname").focus();
 								eMsg.show();
 								eMsg.removeClass('redText');
 								eMsg.addClass('greenText');
 								return idFlag = 1;
 								return true;
 							}
 						}
 					});
 				});

 				// 닉네임 중복 체크 부분 
 				$('#nickck').click(function() {
 					var nickname = $("#nickname").val();
 					var eMsg = $("#nickMsg");
 					var isNick = /^[a-zA-Z0-9가-힣]{4,15}$/;
 					if (nickname == "") {
 						$(eMsg).text("반드시 입력해주세요!");
 						$("#usernickname").focus();
 						return false;
 					}
 					$.ajax({
 						async : true,
 						type : "GET",
 						url : getContext + '/login/join/nickcheck',
 						data : {'user_nickname' : nickname},
 						dataType : "json",
 						success : function(data) {
 							console.log(data)
 							if (!isNick.test(nickname)) {
 								$(eMsg).text("영문,한글,숫자를 이용한 4~15자의 닉네임을 만들어 주세요.");
 								$("#usernickname").focus();
 								eMsg.show(); 
 								eMsg.removeClass('greenText'); 
 								eMsg.addClass('redText'); 
 								return false;
 							} else if (data.msg == 'false') {
 								$(eMsg).text("이미 사용중인 닉네임 입니다.");
 								$("#usernickname").focus();
 								return false;
 							} else if (data.msg == 'true') {
 								$(eMsg).text("좋은 닉네임이에요~^^");
 								$("#userpwd").focus();
 								eMsg.show();
 								eMsg.removeClass('redText');
 								eMsg.addClass('greenText');
 								return nickFlag = 1;
 								return true;
 							}
 						}
 						
 					});
 				});

 				 //비밀번호 유효성 체크
 				$('#pwd').keyup(function() {
 						var pwd = $("#pwd").val();
 						var eMsg = $("#pwdMsg");
 						var pwdck =/^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
 						var nullck = " ";
 						if (pwd.valueOf(nullck) > -1){
 							$(eMsg).text("영문, 숫자, 특수문자 포함해야합니다. (8~15자)");
 							eMsg.removeClass('greenText');
 							eMsg.addClass('redText');
 							return false;
 						}else if(pwd.length < 1){
 							$(eMsg).text("영문, 숫자, 특수문자 포함해야합니다. (8~15자)");
 							eMsg.removeClass('greenText');
 							eMsg.addClass('redText');
 							return false;
 						}else if (!pwdck.test(pwd)) {
 							$(eMsg).text("영문, 숫자, 특수문자 포함해야합니다. (8~15자)");
 							$("#user_pwd").focus();
 							eMsg.removeClass('greenText');
 							eMsg.addClass('redText');
 							return false;
 						}else{
 							$(eMsg).text("좋아요~!");
 							eMsg.show();
 							eMsg.removeClass('redText');
 							eMsg.addClass('greenText');
 							return true;
 						}
 				
 					});
 				 
 				 //비밀번호 동일입력 체크
 				 $('#pwdCheck').keyup(function(){
 					var eMsg = $("#pwdCkMsg");
 					var pwd = $("#pwd").val();
 					var pwdck = $("#pwdCheck").val();
 					if(pwd == pwdck){
 					$(eMsg).text("비밀번호가 일치합니다.");
 					$("#email").focus();
 					eMsg.removeClass('redText');
 					eMsg.addClass('greenText');
 					}else{
 					$(eMsg).text("비밀번호가 일치하지않습니다.");
 					$("#pwdCheck").focus();
 					eMsg.removeClass('greenText');
 					eMsg.addClass('redText');
 					}
 					return pwdFlag;
 						
 				 });
 				
 			  // 이메일 중복체크
 			 $('#emailck').click(function(){
 				 var email = $("#email").val();
 				 var eMsg = $("#emailMsg");
 				 var isEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
 				if (email == "") {
 					$(eMsg).text("이메일 주소를 입력해주세요.");
 					return false;
 				}
 					$.ajax({
 					async : true,
 					type : "GET",
 					url : getContext + '/login/join/emailcheck',
 					data : {'useremail' : email},
 					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
 					dataType : "json",
 					success : function(data) {
 					console.log(data)
 				 if(!isEmail.test(email)){
 					$(eMsg).text("이메일 형식이 맞지않습니다.");
 					eMsg.show();
 					eMsg.removeClass('greenText'); 
 					eMsg.addClass('redText'); 
 					return false;
 					
 				} else if (data.msg == 'false') {
 					$(eMsg).text("이미 사용중인 이메일 입니다.");
 					eMsg.show();
 					eMsg.removeClass('greenText'); 
 					eMsg.addClass('redText'); 
 					$("#useremail").focus();
 					return false;
 					
 				} else if (data.msg == 'true') {
 					$(eMsg).text("사용할 수 있는 이메일 입니다.");
 					$("#useremail").focus();
 					eMsg.show();
 					eMsg.removeClass('redText');
 					eMsg.addClass('greenText');
 					return emailFlag = 1;
 					return true;
 				}
 					}
 					});
 			 });
 			});
 		});
         </script>

</head>
<body>




 <div class="col-sm-4">
	<div class="container">
		<form class="navbar-form navbar-left" action="<c:url value='/login/findid'/>" method="post">
			
			<div class="form-group">
				<input type="hidden" id="user_num" name="user_num">
				<label class="form-control-label" for="fpemail">Email</label><br>
				 <input type="email" class="form-control" id="fiemail" name="user_email"
					placeholder="Enter Email" value="${user_email }">
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

	<div class="row">
		<div class="col-md-3"></div>
		<div class="container">
			<div class="myform form">
				<div class="logomb-3">
					<div class="col-xs-6">
						<div class="tab-head1">
							<a href="http://localhost:8082/kfi/login/findid" class="tabhead1"
								id="findid-form-link1">Forgot ID</a>
						</div>
						<div class="tab-head2">
							<!-- <a href="http://localhost:8082/kfi/login/findpwd" class="tabhead2" id="findpwd-form-link2">Password?</a> -->
							<a href="http://localhost:8082/kfi/login/findpwd"
								class="tabhead2" id="findpwd-form-link2">Password?</a>
						</div>
					</div>

				</div>
				<form action="<c:url value='/login/findid'/>" name="findid"
					role="form" id="findid-form1">
					<div class="form-group">
						<label class="form-control-label" for="findpwd-email">Email</label><br>
						<input type="email" name="user_email" id="findpwd-email" class="form-control"
							 aria-describedby="emailHelp" placeholder="Enter Email">
					</div>
					</form>
					<form action="<c:url value='/login/selectcode'/>" name="findid"
					role="form" id="findid-form1">
					<div class="form-group">
						<label for="findpwd-code">Code</label> <input type="text"
							name="cm_key" id="findpwd-code" class="form-control"
							aria-describedby="codeHelp" placeholder="Enter Code">
					</div>
					<button type="submit" class="btn btn-default" id="findpwd-btn">인증번호보내기</button>
				</form>
			</div>
		</div>
<div class="container msgBox">
	<div class="alert alert-danger"></div>
</div>

		<form action="<c:url value='/login/findpwd'/>" method="post"
			name="findpwd" id="findpwd-form2" style="display: none">
			<div class="form-group">
				<label class="form-control-label" for="ficode">ID</label><br> <input
					type="text" name="user_id" class="form-control" id="id"
					aria-describedby="emailHelp" placeholder="Enter ID">
			</div>
			<div class="form-group">
				<label class="form-control-label" for="fpemail">Email</label><br>
				<input type="email" name="user_email" class="form-control"
					id="email" aria-describedby="emailHelp" placeholder="Enter Email">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Code</label> <input type="text"
					name="cm_key" id="code" class="form-control"
					aria-describedby="emailHelp" placeholder="Enter Code">
			</div>
			<button type="submit" class="btn btn-default" id="btn1">인증번호보내기</button>
		</form>
	</div>
	<!-- Alert Msg Box -->
<div class="container msgBox">
	<div class="alert alert-danger"></div>
</div>
</body>
</html>