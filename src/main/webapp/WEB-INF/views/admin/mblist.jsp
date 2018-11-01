<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>

<div id="memberslist"> 
	<h1>
		회원정보
		<button class="btn btn-md" onclick="location.href='/kfi/adminlist'">관리자정보</button>
	</h1>
	<table class="table table-striped">
		<tr>
			<th>회원번호</th>
			<th>회원ID</th>
			<th>회원NICKNAME</th>
			<th>회원EMAIL</th>
			<th>가입일</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="user" items="${mblist }">
			<tr>
				<td class="usercontent" >${user.user_num}</td>
				<td class="usercontent">${user.user_id }</td>
				<td class="usercontent">${user.user_nickname }</td>
				<td class="usercontent">${user.user_email }</td>
				<td class="usercontent">${user.user_regdate }</td>
				<td><a href="mbdelete?user_num=${user.user_num }"><i class="glyphicon glyphicon-remove"></i></a></td>
			</tr>
		</c:forEach>
	</table>		
	<div class="btn-group">
		<button class="btn btn-lg" data-toggle="modal" data-target="#myModal">등록</button>
		<button class="btn btn-lg">체크박스</button>
	</div>
</div>



<div class="modal modal-dialog1" id="myModal">
	<div >
		<div>
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Question Editor</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="/action_page.php">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Enter ID">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="Enter password">
						</div>
					</div>
	<!-- 				<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="Enter password">
						</div>
					</div> -->
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Enter NickName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Enter Email">
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>		
		</div>
	</div>
</div>

<div class="container modal modal-dialog1 modal-content" id="admininfo-template" >
	<form class="form-horizontal " action="<c:url value='/admodify'/>" method="post">
	 	<input type="hidden" id="admininfo_num" name="admin_num">
		<div class="form-group">
			<label class="control-label col-sm-2" >ID:</label>
			<div class="col-sm-10">
				<p class="form-control-static" id="admininfo_id"></p>
			</div> 
		</div>
		<input type="hidden" id="admin_id" name="admin_id">
		<div class="form-group ">
			<label class="control-label col-sm-2" >NICKNAME:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="admininfo_nick" name="admin_nick">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Password:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="admininfo_pwd" name="admin_pwd">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Email:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="admininfo_email" name="admin_email">
			</div>
		</div>
		<div class="form-group ">
			<label class="control-label col-sm-2">가입일:</label>
			<div class="col-sm-10">
				<p class="form-control-static" id="admininfo_regdate"></p>
			</div>
		</div>
		<div class="form-group">        
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</form>
</div>



