<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="post" action="abinsert">
	<div>
		<div class="form-group">
			<label for="usr">Name:</label> <input type="text" class="form-control" name="admin_num">
		</div>
		<div class="form-group">
			<label for="usr">Title:</label> <input type="text" class="form-control" name="ab_title">
		</div>
		<div class="form-group">
			<label for="comment">Comment:</label>
			<textarea class="form-control" rows="8" id="comment" name="ab_content"></textarea>
		</div>
		<label class="checkbox-inline"> 
			<input type="checkbox" value="">Option 1
		</label> 
	</div>
	<input type="submit" value="등록">
</form>