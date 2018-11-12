 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">

.form-group input{width: 25%;}

</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script type="text/javascript">
 $(function(){
	var btn = $("#submit");
	btn.disabled = true;
	var idflag = false;
	var emailflag = false;
	var getContext = $('#getContext').val();
	
	$('#submit').click(function() {
		var form = $("#form-control");
		var id = $("#fpid").val();
		var email = $("#fpemail").val();
		var iMsg = $("#idMsg");
		var eMsg = $("#emailMsg");
		var nullck = " ";
		
		if (id.valueOf(nullck) > -1 || id.length < 1 || id== ""){
			$(iMsg).text("아이디에 공백이 있습니다.");
		/* 	iMsg.show(); 
			iMsg.removeClass('greenText'); 
			iMsg.addClass('redText'); */
			return idflag = false ;
			//return false;
		}
		if (email.valueOf(nullck) > -1 || email.length < 1 || id== ""){
			$(eMsg).text("이메일 형식에 맞지않습니다.");
			return emailflag = false ;
			//return false;
		}
			$.ajax({
				async : true,
				type : "GET",
				url : getContext + '/login/join/idcheck',
				data : {'user_id' : id},
				dataType : "json",
				success : function(data){
					console.log(data)
					if(data.msg == 'false') {
						$(iMsg).text("통과");
						$("#fpemail").focus();
					/* 	iMsg.show(); 
						iMsg.removeClass('redText'); 
						iMsg.addClass('greenText'); */
						return idflag = true;
					//	return true;
					}else if (data.msg == 'true') {
						$(iMsg).text("아이디가 존재하지 않습니다.");
						$("#fpid").focus();
					/* 	iMsg.show(); 
						iMsg.removeClass('greenText'); 
						iMsg.addClass('redText'); */
						return idflag = false;
					//	return false;
					}else{
					$(iMsg).text("에러에러에러");
					$("#fpid").focus();
				/* 	iMsg.show(); 
					iMsg.removeClass('greenText'); 
					iMsg.addClass('redText'); */
					return idflag = false;
					//return false;
					}
				}
			});
			
			$.ajax({
				async : true,
				type : "GET",
				url : getContext + '/login/join/emailcheck',
				data : {'user_email' : email},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType : "json",
				success : function(data){
					if (data.msg == 'true') {
					$(eMsg).text("이메일 형식을 확인해주세요.");
					/* eMsg.show();
					eMsg.removeClass('greenText'); 
					eMsg.addClass('redText');  */
					$("#id").focus();
					return emailflag = false;
					//return false;
					
				} else if (data.msg == 'false') {
					$(eMsg).text("이메일을 확인했습니다.");
					$("#email").focus();
					/* eMsg.show();
					eMsg.removeClass('redText');
					eMsg.addClass('greenText'); */
					return emailflag = true;
					//return true;
				}else{
					$(eMsg).text("오류");
					return emailflag = false;
					//return false;
				}
			}
		});
			$('#submit').click(function(){
				if(idflag == true && emailflag == true){
					btn.disabled =false;
					console.log("ididididi");
					
				}else{
					btn.disabled ='disabled';
					console.log("asdfsdafasd");
				}
			});
	});
 });
</script>
</head>
<body>
<input type="hidden" id="getContext" name="getContext" value="<c:url value='/'/>">
<div class="container">
  <label>비밀번호찾기</label>
  <form class="" action="<c:url value='/findpwd'/>" method="post">
  <div class="form-group">
    <label class="form-control-label" for="fpid">ID</label>
    <input type="text" class="form-control" id="fpid" name="fpid" placeholder="Enter ID">
  <span id="idMsg" class="help-block" style="opacity:1;"></span>
  </div>
  <div class="form-group">
    <label class="form-control-label" for="fpemail">Email</label>
    <input type="email" class="form-control" id="fpemail" name="fpemail" placeholder="Enter Email">
  </div>
  <span id="emailMsg" class="help-block" style="opacity:1;"></span>
    <button type="submit" class="btn btn-default" id="btn1">인증번호보내기</button>
				 <span id="emailMsg"class="help-block" style="opacity: 1;"></span>
    <div class="form-group">        
      <div class="submitbox" >
        <button type="submit" class="btn btn-default" id="submit" name="submit">Submit</button>
      </div>
    </div>
  </form>
  
</div>
</body>
</html>