<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h2>Q&#38;A</h2>
	<form action="faqinsert" method="post">
		<div class="form-group"> 
			<label>Title:</label> 
			<input type="text" class="form-control" name="qa_title">
		</div>
		<div class="form-group">
			<label>Content:</label>
			<textarea class="form-control" rows="8" id="comment" name="qa_content"></textarea>
		</div>
		<div class="media">
			<div class="media-left">
				<img src="img_avatar1.png" class="media-object" style="width: 60px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">아이디</h4>
				사용자ID<input type="text" name="user_num">
			</div>
		</div>
		<button type="submit" class="btn btn-default pull-right">등록</button>
	</form>
</div>
