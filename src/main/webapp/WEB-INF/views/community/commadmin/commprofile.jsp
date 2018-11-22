<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div id="userinsert">

	<div class="modal-dialog">
	<div class="btn-group">
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commprofile'">PROFILE</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commskin'">SKIN</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commuserlist'">MEMBERS</button>
	</div><!-- <br><br> -->
		<div class="modal-content">
			<form class="form-horizontal" action="mbinsert" method="get">		
			<div class="modal-header">
				<h4 class="modal-title" style="display: inline;">프로필 수정</h4>
				<div class="btn-group  pull-right">
					<button class="btn btn-primary">적용</button>
					<button type="button" class="btn btn-primary">초기화</button>
				</div>
			</div>
			
			<div class="modal-body">
				<div>
					<img src="<c:url value='/resources/images/ysy/aaa.gif'/>">
				</div>
					<button type="button" class="btn btn-primary">이미지찾기</button><br>
		
					<label>Admin ID:</label>
					<input type="text" class="form-control" name="user_id">		
					
					<label>Nickname:</label>
					<input type="text" class="form-control" name="user_nickname">
				
					<label>Community Name:</label>
					<input type="email" class="form-control" name="comm_name">

					<label>상태메세지:</label>
					<textarea class="form-control" rows="3" name="comm_content"></textarea>		
				</div>
			</form>			
		</div>
	</div>
</div>
