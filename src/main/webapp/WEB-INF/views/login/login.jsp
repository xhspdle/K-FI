<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
margin-top: 50px;
}
body {
	padding-top: 15rem;
	padding-bottom: 15rem;
	margin: auto;
	width: 50%;
	padding: 10px;
	background: rgba(0, 0, 0, 0.76);
	background: url(http://i.imgur.com/GHr12sH.jpg) no-repeat center center
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

#second {
	display: none;
}
</style>
<title>회원 로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/login/login'/>" method="post">
		아이디 <input type="text" name="userId" id="userId" value="${membersVo.id }"><br>
		비밀번호<input type="password" name="userPwd" id="userPwd">
		<input type="submit" value="로그인"><br>
		<a href="<c:url value='/login/join'/>">회원가입</a>
		<a href="<c:url value='/login/findid'/>">아이디 찾기</a>
		<a href="<c:url value='/login/findpwd'/>">비밀번호 찾기</a>
	</form>

<%-- <body>    
<div class="row">
    <div class="col-md-3"></div>
    <div class="container">
			<div id="first">
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Login</h1>
						 </div>
					</div>
                   <form action="<c:url value='/login/login'/>" method="post" name="login">
                           <div class="form-group">
                              <label for="exampleInputEmail1">Enter ID</label>
                              <input type="text" name="userId"  class="form-control" id="userId" aria-describedby="emailHelp" placeholder="Enter ID" value="${membersVo.id }">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Password</label>
                              <input type="password" name="userPwd" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                            <div class="input-group">
	                            <div class="checkbox">
	                              <label>
	                                <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
	                              </label>
	                            </div>
	                          </div>
                           <div class="form-group">
                          	<p class="text-center">Trouble signing in?<a href="<c:url value='/login/findid'/>"></a></p>
                            <div class="form-group-forgot">
                            <a href="<c:url value='/login/findid'/>">Forgot ID?</a>
                            <a href="<c:url value='/login/findpwd'/>"> Forgot Password?</a>
                            </div>
                          </div>
                           <div class="col-md-12 text-center ">
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
                           </div>
                           <div class="col-md-12 ">
                              <div class="login-or">
                                 <hr class="hr-or">
                                 <span class="span-or">or</span>
                              </div>
                           </div>
                           <div class="col-md-12 text-center ">
                              <button type="button" class=" btn btn-block mybtn btn-primary tx-tfm" id="signup">Sign up</button>
                           </div>
                        </form>
                 
				</div>
			</div>
			  <div id="second">
			      <div class="myform form ">
                        <div class="logo mb-3">
                           <div class="col-md-12 text-center">
                              <h1 >Signup</h1>
                           </div>
                        </div>
                        <form action="<c:url value='/login/join'/>" name="registration">
                           <div class="form-group">
                              <label for="exampleInputEmail1">ID</label>
                              <input type="text"  name="user_id" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Enter ID">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Nick Name</label>
                              <input type="text"  name="user_nickname" class="form-control" id="lastname" aria-describedby="emailHelp" placeholder="Enter Nick name">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Password</label>
                              <input type="password" name="user_pwd" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Password</label>
                              <input type="password" name="pwdCheck" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Email address</label>
                              <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
                           </div>
                           <div class="col-md-12 text-center mb-3">
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Sign Up</button>
                           </div>
                           <div class="col-md-12 ">
                              <div class="form-group">
                                 <p class="text-center"><a href="#" id="signin">Already have an account?</a></p>
                              </div>
                           </div>
                           </form>
                            </div>
                     </div>
			</div>
</div>
     	 <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
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
        	              rules: {
        	                
        	                id: {
        	                  required: true,
        	                  id: true
        	                },
        	                password: {
        	                  required: true,
        	                  
        	                }
        	              },
        	               messages: {
        	                id: "Please enter a valid id",
        	               
        	                password: {
        	                  required: "Please enter password",
        	                 
        	                }
        	                
        	              },
        	              submitHandler: function(form) {
        	                form.submit();
        	              }
        	            });
        	          });
        	          


        	 $(function() {
        	   
        	   $("form[name='registration']").validate({
        	     rules: {
        	       firstname: "required",
        	       lastname: "required",
        	       email: {
        	         required: true,
        	         email: true
        	       },
        	       password: {
        	         required: true,
        	         minlength: 5
        	       }
        	     },
        	     
        	     messages: {
        	       firstname: "Please enter your firstname",
        	       lastname: "Please enter your lastname",
        	       password: {
        	         required: "Please provide a password",
        	         minlength: "Your password must be at least 5 characters long"
        	       },
        	       email: "Please enter a valid email address"
        	     },
        	   
        	     submitHandler: function(form) {
        	       form.submit();
        	     }
        	   });
        	 });

         </script> --%>
</body>
</body>
</html>