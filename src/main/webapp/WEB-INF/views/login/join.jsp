<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	var idFlag = false;
	var nickFlag = false;
	var pwFlag = false;
	var authFlag = false;
	
	/* id 중복 체크 부분 */
$(function(){
	$('#idck').on('click',function(){
		
		var id = $("#id").val();
		var eMsg = $("#idMsg");
		
		

		var isID = /^[a-z0-9]{4,19}$/;
		if (!isID.test(id)) {
			alert(eMsg, "5~20자의 영문 소문자, 숫자만 사용가능 합니다!");
			return false;
		}
		idFlag = false;
		
		$.ajax({
			async: true,
			type : "POST",
			url : "<%=request.getContextPath()%>/join/join.jsp",
			data : id,
			dataType: "json",
			success : function(data) {
				if (data == "") {
					alert("반드시 입력해주세요!");
					$("#id").focus();
					return false;
				} else if(data.cnt > 0){
					 alert("이미 사용중인 아이디 입니다.");
					 return false;
				} else{
					 alert("cool ID~!!");
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
	<div id="header">
		<h1>
			<a href="<c:url value='../'/>" class="h_logo"> 
			<span class="blind">K-FI</span>
			</a>
		</h1>
	</div>
	<form action="" <c:url value='../'/> method="post">
		<div>
			아이디 <input type="text" name="id" id="id"> 
			<input type="button" value="ID중복체크" id="idck" onclick="checkId()">
			<label for="id"></label> <div id="idMsg"></div>
		</div>
		<label for="nickname"></label>
		<div>
			닉네임 <input type="text" name="nickname" id="nickname"> <input
				type="button" value="닉네임 중복체크" onclick="checkNick()">
		</div>
		<div>
			비밀번호 <input type="password" name="pw" id="pw" placeholder="비밀번호입력"><br>
			<label for="pw"></label>
		</div>
		<div>
			비밀번호 재확인<input type="password" name="pwCheck" id="pwCheck"
				placeholder="비밀번호 확인"><br> <label id="pwCheck2"
				for="pwCheck"> <span class="pwChk_blind">비밀번호가 맞는지
					확인을 위해 다시 입력 해주세요.</span>
			</label><br>
		</div>
		<div>
			이메일 <input type="text" name="email" id="email"> <input
				type="button" value="인증" onclick="checkMail()">
		</div>
		<!-- <div>인증번호 <input type="text" name="inputCode" id="inputCode" placeholder="인증번호를 입력하세요." disabled="disabled">
			<input type="button" value="확인" onclick="checkJoinCode()"><br>
		</div> -->
		<div>
			<input type="submit" value="가입"> <input type="reset"
				value="취소">
		</div>
	</form>
</body>
</html>