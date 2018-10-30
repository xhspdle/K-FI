<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#
</style>
<script type="text/javascript">
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
					$("#joincode").csss("display", "none");
				} else {
					sendMail(email);
					$("#joincode").css("display", "");
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
	}
	var idFlag = false;
	var nickFlag = false;
	var pwFlag = false;
	var authFlag = false;
	/* id 중복 체크 부분 */
	function checkId(event) {
		if (idFlag)
			return true;

		var id = $("#id").val();
		var eMsg = $("#idMsg");

		if (id == "") {
			showErrorMsg(eMsg, "반드시 입력해주세요!");
			return false;
		}

		var isID = /^[a-z0-9]{4,19}$/;
		if (!isID.test(id)) {
			showErrorMsg(eMsg, "5~20자의 영문 소문자, 숫자만 사용가능 합니다!");
			return false;
		}
		idFlag = false;
		$.ajax({
			type : "GET",
			url : "<%=request.getContextPath()%>/login/join" + id, /*  / 주소 입력 해야함 */
			success : function(data) {
				var result = data.substr(4);
				if (result == "Y") {
					if (event == "first") {
						showSuccessMsg(eMsg, "cool ID~!!");
					} else {
						hideMsg(eMsg);
					}
					idFlag = true;
				} else {
					showErrorMsg(eMsg, "이미사용중인 닉네임 이에요!!");
				} else {
					
				}
			}
		});
		return true;
	}
	/* 닉네임 중복 체크 부분 */
	function checkNickname(){
		if(nickFlag) return true;
		
		var nickname = $("#nickname").val();
		
		if(nickname == ""){
			showErrorMsg(eMsg, "반드시 입력해주세요.");
			return false;
		}
		var isNick = /^[a-z0-9][가-힝]{4,19}$/;
		if (!isNick.test(id)) {
			showErrorMsg(eMsg, "영문(5~20자), 한글(2~10자) 로 이루어진 닉네임을 만들어 주세요.");
			return false;
		}
		
	}
	
	/* 비번 체크 부분 */
	function checkPwd1(){
		if(pwFlag) return true;
		
		var id = $("#id").val();
		var pw = $("#pw1").val();
		
		if (pw == "") {
			showErrorMsg(eMsg, "반드시 입력해주세요!");
			return false;
		}
	}
		
		
		pwFlag =false;
		$.ajax({
			type:"GET",
			url:"&id=" +escape(encodeURIComponent(id)) + "&pw=" + escape(encodeURIComponent(pw)), success :
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
				createRsaKey();s
			});
		});
		return true;
	}
	
	function checkPwd2() {
		var pw1 = $("#pw1");
		var pw2 = $("#pw2");
		
		if (pw2 == "") {
			showErrorMsg(eMsg, "반드시 입력해주세요!");
			return false;
		}
	
</script>
<title>회원가입</title>
</head>
<body>
	<input type="hidden" id="getContext" name="getContext" value="<c:url value=''/>">
	<!-- 헤더 로고부분  class blind -> 블라인드 처리 해줘야함-->
	<div id="header">
	<h1><a href="<c:url value='../'/>" class="h_logo"> 
	<span class="blind">K-FI</span>
	</a>
	</h1>
	</div>
	<form action=""<c:url value='../'/> method="post">
		<div>아이디 <input type="text" name="id" id="id">
			<input type="button" value="ID중복체크" onclick="checkId()"><br>
			<label id="id2" for="id"></label>
		</div>
		<div>닉네임 <input type="text" name="nickname">
			<input type="button" value="닉네임 중복체크" onclick="checkNick()"><br>
			<label id="nickname2" for="nickname"></label>
		</div>
		<div>비밀번호 <input type="password" name="pw" id="pw" placeholder="비밀번호입력"><br>
			<label id="pw2" for="pw"></label>
		</div>
		<div>비밀번호 재확인<input type="password" name="pwCheck" id="pwCheck" placeholder="비밀번호 확인"><br>
			<label id="pwCheck2" for="pwCheck">
			<span class="pwChk_blind">비밀번호가 맞는지 확인을 위해 다시 입력 해주세요.</span>
			</label><br>
		</div>
		<div>이메일 <input type="text" name="email">
			<input type="button" value="인증" onclick="checkMail()"><br>
		</div>
		<div>인증번호 <input type="text" name="inputCode" id="inputCode" placeholder="인증번호를 입력하세요." disabled="disabled">
			<input type="button" value="확인" onclick="checkJoinCode()"><br>
		</div>
		<div>
			<input	type="submit" value="가입"> <input type="reset" value="취소">
		</div>
	</form>
</body>
</html>