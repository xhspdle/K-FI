<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="post" action="abinsert">
	<div>
		<div class="form-group">
			<label>Name:</label> <input type="text" class="form-control" name="admin_num">
		</div>
		<div class="form-group">
			<label>Title:</label> <input type="text" class="form-control" name="ab_title">
		</div>
		<div class="form-group">
			<label>Comment:</label>
			<textarea class="form-control" rows="8" id="comment" name="ab_content"></textarea>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">상태정보:</label>
			<div class="col-sm-10">
				<label class="checkbox-inline">
					<input type="radio" name="ab_notice" value="1">게시
				</label>
				<label class="checkbox-inline">
					<input type="radio" name="ab_notice" value="2" checked>미게시
				</label>
				<button type="submit" class="btn btn-default pull-right">작성</button>
			</div>
		</div>	
	</div>
</form>