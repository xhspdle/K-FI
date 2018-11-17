<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container w3-panel w3-border w3-round-xlarge">
	<div class="col-sm"
		style="background-color: white; width: 20%; height: 10%;">
		<h2 style="margin-left: 54%;margin-top: 8%; width: 80%;    font-size: 40px;
    text-transform: uppercase;
    color: #303030;
    font-weight: 600;">My Skin</h2>
	</div>
	
	<!-- 미리보기 -->	
	<div id="new_community">
		<div class="w3-row-padding w3-margin-top" style="height:370px;">
			<div class="w3-third" style="width: 100%;height:100%;">
				<div class="w3-card" id="preview_cover">
				<div>
					<img id="profile_preview" class="img-responsive img-circle" src="<c:url value='/resources/images/default-profile.png'/>">
					<h4><span id="myskin_list_nickname" >${user_nickname}</span></h4>
   					 <span id="preview_msg">상태메세지 미리보기</span>
     			</div>
						<div class="w3-container" style="padding: 0;">
						<div class="collapse navbar-collapse" id="preview_navbar" style="background-color:#00cee8">
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
									<a href="<c:url value='/community'/>">COMMUNITY</a>
								</li>
								<li class="dropdown">
									<a href="<c:url value='/mypage/main'/>">MYPAGE</a>
								</li>
								<li><button type="button" class="btn btn-default btn-lg" id="preview_cover">
								<span class="glyphicon glyphicon-search"></span></button></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	<br>

	<!-- 등록 -->
	<form class="form-horizontal col-sm" enctype="multipart/form-data"
		method="post" action="<c:url value='/mypage/myskin/insert'/>">
		<div class="form-group">
			<label class="control-label col-sm-2" for="skinname">스킨명:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="ms_name" name="ms_name">
			</div>
			<label class="control-label col-sm-1" for="color">배경색:</label>
			<div class="col-sm-2">
				<input type="color" id="ms_color" name="ms_color" value="#00cee8">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="msg">상태메세지:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="ms_msg" name="ms_msg">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="msg">프로필 사진:</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" id="ms_profile"
					name="ms_profile">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="msg">커버 사진:</label>
			<div class="col-sm-10">
				<input type="file" class="form-control" id="ms_cover"
					name="ms_cover">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default"
					style="margin-top: 2%; margin-left: 30%; padding: 8px 100px;">등록</button>
			</div>
		</div>
	</form>
</div></div>