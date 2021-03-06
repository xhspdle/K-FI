<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="container_borderInset">
		<h2 style="margin-left: 26%;">회원 정보</h2>
		<form method="post" action="<c:url value='/mypage/myinfo/update'/>"
			class="form-horizontal" id="myinfo_list">
			<div class="form-group">
				<label class="control-label col-sm-3" for="id">ID:</label>
					<input type="text" class="form-control" name="user_id"
						value="${vo.user_id }" readonly="readonly" style="width: 40%">
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="pwd">Password:</label>
					<input type="password" class="form-control" name="user_pwd"
						value="${vo.user_pwd }" style="width: 40%">
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="nickname">Nickname:</label>
					<input type="text" class="form-control" name="user_nickname"
						value="${vo.user_nickname }" style="width: 40%">
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="email">Email:</label>
					<input type="email" class="form-control" name="user_email"
						value="${vo.user_email}" style="width: 40%">
			</div><br>
			<div class="form-group" style="margin: -3% 5% 0% 0%;">
				<div class="control-label col-sm-3"></div>
				<button type="submit" class="btn btn-default" style="padding: 7px 45px;" id="myinfo_update_submit">수정</button>&nbsp;
				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" style="padding: 7px 45px;">탈퇴</button>
			</div>
		</form>
</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">회원 탈퇴</h4>
				</div>
				<div class="modal-body">
					<!-- 회원 번호바꾸기 -->
					<p>비밀번호를 입력해주세요</p>
					<form method="post" action="<c:url value='/mypage/myinfo/delete'/>" id="myinfo_delete_frm">
					<div style="display: -webkit-box;">
						<input type="password" class="form-control" name="myinfo_delete_user_pwd" id="myinfo_delete_user_pwd">
						<button type="submit" class="btn btn-default" id="myinfo_delete">탈퇴하기</button>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
</div>

