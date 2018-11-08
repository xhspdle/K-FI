<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	
	<h2>회원 가입</h2>
	<form action="faqinsert" method="post">
		제목<input type="text" name="qa_title"><br>
		내용<textarea rows="5" cols="100" name="qa_content"></textarea><br>
		사용자ID<input type="text" name="user_num"><br>
		<input type="submit" value="등록">
	</form>
</div>