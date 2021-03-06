<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="admin" value="${sessionScope.admininfo }" />
<div class="container" style="margin-top: 20px">
	<form method="post" action="<c:url value='/admin/abinsert'/>">
		<div class="media">
			<div class="media-left" >
				<img  style="border-radius: 50%; width: 50px;height: 50px;border: solid 1px gold; " src="<c:url value='/resources/images/ysy/1 (1).jpg'/>" class="media-object" style="width: 60px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">${admin.admin_nick }</h4>
				<p>${admin.admin_id }</p>
			</div>
		</div>
		<div class="form-group">
			<input type="hidden" class="form-control" name="admin_num" value=${admin.admin_num }> 
			<label>Title:</label> <input type="text" class="form-control"
				name="ab_title">
		</div>
		<div class="form-group">
			<label>Comment:</label>
			<textarea class="form-control" rows="8" id="comment"
				name="ab_content"></textarea>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">상태정보:</label>
			<div class="col-sm-10">
				<label class="checkbox-inline"> <input type="radio"
					name="ab_notice" value="1">게시
				</label> <label class="checkbox-inline"> <input type="radio"
					name="ab_notice" value="2" checked>미게시
				</label>
				<button type="submit" class="btn btn-default pull-right">작성</button>
			</div>
		</div>
	</form>
</div>