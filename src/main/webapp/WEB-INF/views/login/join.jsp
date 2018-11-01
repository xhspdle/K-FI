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
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script type="text/javascript">
// id 중복 체크 부분 
$(function(){
		var idFlag = false;
		var nickFlag = false;
		var pwFlag = false;
		var authFlag = false;
		
		
	 $('#idck').click(function(){
		var id = $("#id").val();
		var eMsg = $("#idMsg");
		var isID = /^[a-z0-9]{4,19}$/;
		
		if (id == "") {
		    $(eMsg).text("반드시 입력해주세요!");
			$("#id").focus();
			return false;
		}
		$.ajax({
			async: true,
			type : "GET",
			url : "<c:url value='/login/join/idcheck'/>",
			data : {'user_id':id},
			dataType : "json",
			success : function(data) {
					console.log(data.msg);
					if(data.msg == 'true')
					if (!isID.test(id)) {
						alert("5~20자의 영문 소문자, 숫자만 사용가능 합니다!");
						$(eMsg).text("이미 사용중인 아이디 입니다.");
						$("#id").focus();
						return false;
					}if (id) {
						alert("이미 사용중인 아이디 입니다.");
						 $(eMsg).text("이미 사용중인 아이디 입니다.");
						$("#id").focus();
						return false;
					} else {
						alert("cool ID~!!");
						 $(eMsg).text("cool ID~!!");
						$("#pw").focus();
						return true;
					}
				}
			});
		});

	 
		 // 닉네임 중복 체크 부분 
	$('#nickck').click(function(){
		var nickname = $("#nickname").val();
		var eMsg = $("#nickMsg");
		if (nickname == "") {
		    $(eMsg).text("반드시 입력해주세요!");
			$("#nickname").focus();
			return false;
			
		$.ajax({
			async: true,
			type : "POST",
			url : "<c:url value='/login/join/idcheck'/>",
			data : {'user_id':id},
			dataType : "json",
			success : function(data) {
					console.log(data.msg);
				var isNick = /^[a-z0-9][가-힝]{4,19}$/;
				if (!isNick.test(nickname)) {
					showErrorMsg("영문(5~20자), 한글(2~10자) 로 이루어진 닉네임을 만들어 주세요.");
					return false;
				}
				}
			});
		}
	});
});
		<%--
		/* 비번 체크 부분 */
		function checkPwd1(){
			if(pwFlag) return true;
			var getContext=$("#getContext").val();
			var id = $("#id").val();
			var pw = $("#pw1").val();
			
			if (pw == "") {
				showErrorMsg(eMsg, "반드시 입력해주세요!");
				return false;
			}
				
			pwFlag =false;
			$.ajax({
				type:"GET",
				url:getContext+"/login/login&id=" +escape(encodeURIComponent(id)) + getContext+"/login/login&pw=" + escape(encodeURIComponent(pw)),
				success : function(data){
					var result = data.substr(5);
					if(result == 1){
						showErrorMsg(eMsg,"10~20자 대,소문자, 숫자, 특수문자를 사용하세요.");
						return false;
					}else if(result == 2){
						showErrorMsg(eMsg, "10~20자 대,소문자, 숫자, 특수문자를 사용하세요.");
					}else if(result == 3){
						eMsg.hide();
					}else if(result == 4){
						eMsg.hide();
					}
					pwFlag = true;
					createRsaKey();
				}
				});
			return true;
		};
		
		function checkPwd2() {
			var pw1 = $("#pw1");
			var pw2 = $("#pw2");
			
			if (pw2 == "") {
				showErrorMsg(eMsg, "반드시 입력해주세요!");
				return false;
			}
		 
	}
	function checkMail() {
		var email = document.getElementById("email").value;

		if (email == "") {
			alert("메일을 입력해 주세요.")
			return false;
		}
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				var data = JSON.parse(xhttp.responseText);
				if (data != null) {
					alert("이미 가입한 메일 입니다.");

				} else {
					sendMail(email);

				}
			}
		};
		xhttp.open("POST", 'checkMail/', true);
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xhttp.send('email=' + email);
		return false;
	}

	function sendMail(email) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				if (xhttp.status == 200)
					alert("메일을 정상적으로 보냈습니다.");
				else
					alert("올바른 메일 형식이 아닙니다.");
			}
		};
		xhttp.open("POST", 'sendMail/', true);
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xhttp.send('email=' + email);
		return false;
	}; --%>

</script>
<title>회원가입</title>
</head>
<body>
	<input type="hidden" id="getContext" name="getContext"
		value="<c:url value='/'/>">
	<!-- 헤더 로고부분  class blind -> 블라인드 처리 해줘야함-->
	<div id="header">
		<h1>
			<a href="<c:url value='/'/>" class="h_logo"> <span class="blind">K-FI</span>
			</a>
		</h1>
	</div>
	<form action="<c:url value='/login/join'/>" method="post">
		<div>
			<label for="id">아이디</label> <input type="text" name="user_id" id="id">
			<input type="button" value="ID중복체크" id="idck"> <br>
			<span id="idMsg"></span> <label for="id"></label>
		</div>

		<div>
			<label for="nickname">닉네임</label>
			<input type="text" name="user_nickname" id="nickname">
			<input type="button" value="닉네임 중복체크" id="nickck"> <br>
			<span id="nickMsg"></span>
		</div>
		<div>
			<label for="pwd">비밀번호</label> <input type="password" name="user_pwd"
				id="pwd" placeholder="비밀번호입력"><br> <br>
			<span id="pwdMsg"></span>
		</div>
		<div>
			<label for="pwdCheck">비밀번호 재확인</label>
			 <input type="password" name="pwdCheck" id="pwCheck" placeholder="비밀번호 확인"><br>
			<span class="pwdChk_blind">비밀번호가 맞는지 확인을 위해 다시 입력 해주세요.</span> <br>
			<span id="pwdMsg"></span>
		</div>
		<div>
			<label for="email">이메일</label> <input type="text" name="user_email"
				id="email"> <input type="button" value="이메일 중복 확인"
				id="emailck"> <br>
			<span id="idMsg"></span>
		</div>

		<div>
			<input type="submit" value="가입"> <input type="reset"
				value="취소">
		</div>
	</form>
</body>
</html>