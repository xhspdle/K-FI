 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
<script type="text/javascript">
/* 	$(function() {
		$("#checkid").click(function() {
			var admin_id = $("#id").val();
			var reg=/^[A-Za-z0-9]{4,12}$/;
			var rst=reg.test(admin_id);
			if(!rst){
				alert('영문대,소문자, 숫자 4~12 자리로 입력해 주세요.');
				return false;
			}		
			if(admin_id==''){
				$("#checkedid").html("");
				return false;
			}
			alert(admin_id);
			$.getJSON("<c:url value='/adcheckid'/>", {
				admin_id : admin_id
			}, function(data) {
				if(data.msg=="success"){
					$("#checkedid").html("사용가능한 아이디입니다.");
					$("#checkedid").css("color","green");
				}else{
					$("#checkedid").html("사용불가능한 아이디입니다!!!");
					$("#checkedid").css("color","red");
				}
			});
		});
	}); */
	$(function() {
		$(".check_info").click(function(event) {
			alert("aa");
			console.log(event.target);
			if(event.target.id=="checknick"){
				alert("wow");
				var admin_nick = $("#nick").val();
				$.getJSON("<c:url value='/adcheckid'/>", {
					admin_id : admin_id
				}, function(data) {
					if(data.msg=="success"){
						$("#checkedid").html("사용가능한 아이디입니다.");
						$("#checkedid").css("color","green");
					}else{
						$("#checkedid").html("사용불가능한 아이디입니다!!!");
						$("#checkedid").css("color","red");
					}
				});
			}
		});
	}); 
	$(function(){
		$("#checkpwd").keyup(function(){		
			if($("#pwd").val()!=''){
				$("#checkpwd").focusout(function(){
					if($("#pwd").val()==$("#checkpwd").val()){
						$("#checkedpwd").html("비밀번호가 같습니다.");
						$("#checkedpwd").css("color","green");
						
					}else{
						$("#checkedpwd").html("비밀번호가 다릅니다.");
						$("#checkedpwd").css("color","red");
					}
				});
			}else{		
				alert("위에 패스워드를 적어주세요");
			/* 	$("#pwd").focus(); */
				alert($("#checkpwd").val());
				$("#checkpwd").val('');
				return false;
			}
		});
	});
	$(function(){
 		$("#pwd").focusout(function(){
			var admin_pwd=$("#pwd").val();
			var reg=/^[A-Za-z0-9]{4,12}$/;
			var rst=reg.test(admin_pwd);
			if(!rst){
				alert('영문대,소문자, 숫자 4~12 자리로 입력해 주세요.');
			/* 	$(this).focus(); */
				$(this).val('');
				return false;	
			}
 		});
	}); 
</script>
<div class="container">
	<h2>회원 가입</h2>
	<form method="post" action="adjoin">
		<label>ID:</label>	
		<div class="input-group form-group">
			<input type="text" class="form-control" name="admin_id" id="id">
			<div class="input-group-btn">
				<input type="button" class="btn btn-default check_info" id="checkid" value="중복확인" >
			</div>
		</div>
		<div id="checkedid"></div>
		<div class="form-group">
			<label>Password:</label>
			<input type="password" class="form-control" name="admin_pwd" id="pwd">
		</div>
		<div class="form-group">
			<label>Password:</label> 
			<input type="password" class="form-control" id="checkpwd">
		</div>
		<div id="checkedpwd"></div>
		<label>NickName:</label> 
		<div class="input-group form-group">
			<input type="text" class="form-control" name="admin_nick" id="nick">
			<div class="input-group-btn">
				<input type="button" class="btn btn-default  check_info" id="checknick" value="중복확인" >
			</div>
		</div>
		<div class="form-group">
			<label>E-mail:</label> 
			<input type="text" class="form-control" name="admin_email">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>
