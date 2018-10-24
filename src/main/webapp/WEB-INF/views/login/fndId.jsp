<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script type="text/javascript">
$("#submit").on("click", function(e){
    $("#submit").show();
});
</script>
</head>
<body>
<form action="fndIdOk" style="display:none">
이메일 <input type="text" name="user_email" placeholder="이메일로 인증코드 전송">
보내기 <input type="submit" id="submit">


</form>
</body>
</html>