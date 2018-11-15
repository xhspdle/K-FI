<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h2>신고</h2>
	<form action="acinsert" method="post">
		<div class="form-group"> 
			<label>신고인:</label> 
			<input type="text" class="form-control" name="user1_num">
		</div>
		<div class="form-group"> 
			<label>신고대상:</label> 
			<input type="text" class="form-control" name="user2_num">
		</div>	
		<div class="form-group"> 
			<label>사유:</label> 
			<input type="text" class="form-control" name="ac_reason">
		</div>
		<div class="form-group"> 
			<label>모임글번호:</label> 
			<input type="text" class="form-control" name="cb_num">
		</div>
		<div class="form-group"> 
			<label>게시글번호:</label> 
			<input type="text" class="form-control" name="board_num">
		</div>
		<div class="form-group"> 
			<label>상태:</label> 
			<input type="text" class="form-control" name="ac_status">
		</div>
		<button type="submit" class="btn btn-default pull-right">등록</button>
	</form>
</div>