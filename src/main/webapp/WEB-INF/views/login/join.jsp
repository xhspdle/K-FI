<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.hlogo{position:relative; display:block; width:100px; height:100px;}
.blindlogo{
   display:block;
   position:absolute;
   width:100%;
   height:100%;
   background:#ffffff url("/kfi/resources/images/logo2.png") no-repeat left top;;
   z-index:100; }
.redText{display: block;color: red;margin-left:10px;}
.greenText{display: block;color: green;margin-left:10px;}
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
	// id 중복 체크 부분 
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
				$("#id").focus();
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
						$("#id").focus();
						return false;
					} else if (data.msg == 'false') {
						$(eMsg).text("이미 사용중인 아이디 입니다.");
						eMsg.show(); // span태그 보여준다.
						eMsg.removeClass('greenText'); // span태그에 greenText 클래스를 삭제한다.
						eMsg.addClass('redText'); // span태그에 redText 클래스를 추가한다.
						$("#id").focus();
						return false;
					} else if (data.msg == 'true') {
						$(eMsg).text("cool ID~!!");
						$("#nickname").focus();
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
				$("#nickname").focus();
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
						$("#nickname").focus();
						eMsg.show(); 
						eMsg.removeClass('greenText'); 
						eMsg.addClass('redText'); 
						return false;
					} else if (data.msg == 'false') {
						$(eMsg).text("이미 사용중인 닉네임 입니다.");
						$("#nickname").focus();
						return false;
					} else if (data.msg == 'true') {
						$(eMsg).text("좋은 닉네임이에요~^^");
						$("#pwd").focus();
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
					$("#pwd").focus();
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
			data : {'user_email' : email},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "json",
			success : function(data) {
			console.log(data)
		 if(!isEmail.test(email)){
			$(eMsg).text("이메일 형식이 맞지않습니다.");
			return false;
			
		} else if (data.msg == 'false') {
			$(eMsg).text("이미 사용중인 이메일 입니다.");
			eMsg.show();
			eMsg.removeClass('greenText'); 
			eMsg.addClass('redText'); 
			$("#email").focus();
			return false;
			
		} else if (data.msg == 'true') {
			$(eMsg).text("사용할 수 있는 이메일 입니다.");
			$("#email").focus();
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
	
</script>
<title>회원가입</title>
</head>
<body> 
	<input type="hidden" id="getContext" name="getContext" value="<c:url value='/'/>">
	<!-- 헤더 로고부분  class blind -> 블라인드 처리 해줘야함-->
	<div class="h_logo" id="header">
		<h1>
			<a href="<c:url value='/'/>" class="hlogo"> <span class="blindlogo">K-FI</span></a>
		</h1>
	</div>
	<form action="<c:url value='/login/join'/>" method="post">
		<div>
			<label for="id">아이디</label> 
			<input type="text" name="user_id" id="id">
			<input type="button" value="ID중복체크" id="idck"> <br>
			<span class="redText" id="idMsg"></span> 
		</div>

		<div>
			<label for="nickname">닉네임</label>
			<input type="text" name="user_nickname" id="nickname">
			<input type="button" value="닉네임 중복체크" id="nickck"> <br>
			<span  class="redText" id="nickMsg"></span>
		</div>
		<div>
			<label for="pwd">비밀번호</label> 
			<input type="password" name="user_pwd" id="pwd" placeholder="비밀번호 입력"><br>
			<span class="redText" id="pwdMsg"></span>
		</div>
		<div>
			<label for="pwdCheck">비밀번호 재확인</label>
			<input type="password" name="pwdCheck" id="pwdCheck" placeholder="비밀번호 확인"><br>
			<span class="redText" id="pwdCkMsg"></span>
		</div>
		<div>
			<label for="email">이메일</label> 
			<input type="text" name="user_email" id="email" placeholder="ex)xxx@kfi.com">
			<input type="button" value="이메일 중복 확인" name="user_email" id="emailck"> <br>
			<span class="redText" id="emailMsg"></span>
		</div>

		<div>
			<input type="submit" value="가입" id="joinbtn"> <input type="reset" value="취소">
		</div>
	</form>
</body>
</html>