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
			<div class="modal-header">
				<h4 class="modal-title">프로필 수정</h4>
			</div>
			
			<div class="modal-body">
				<div>
					<img src="<c:url value='/resources/images/ysy/aaa.gif'/>">
				</div>
	
				<form class="form-horizontal" action="mbinsert" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_id">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="user_pwd">
						</div>
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
					</div>
					
	
				</form>
			</div>		
		</div>
	</div>
</div>
