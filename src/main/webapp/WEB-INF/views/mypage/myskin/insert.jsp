<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container w3-panel w3-border w3-round-xlarge">
	<div class="col-sm"
		style="background-color: white; width: 20%; height: 10%;">
		<h2 style="margin-left: 50%; width: 80%;">My Skin</h2>
	</div>
	<!-- 미리보기 설정(js) -->
	<div class="jumbotron col-sm" id="preview_cover"
		style="margin: auto; width: 80%;">
		<div>
			<img src="<c:url value='/resources/images/default-profile.png'/>"
				alt="new profile" class="img-circle" id="profile_preview"
				style="margin-top: 60px; width: 150px; height: 150px; background-color: white; display: block; margin-left: auto; margin-right: auto;">
			<p>
				<span id="preview_msg"
					style="width: max-content; color: black; border-bottom: 2px solid white; display: block; margin-left: auto; margin-right: auto;">상태메세지
					미리보기</span>
			</p>
			<div class="collapse navbar-collapse" id="preview_navbar"
				style="border-radius: 10px;">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#contact">COMMUNITY</a></li>
					<li class="dropdown"><a href="#contact">MYPAGE</a></li>
					<li><button type="button" class="btn btn-default btn-lg"
							style="border-radius: 10px;">
							<span class="glyphicon glyphicon-search"></span>
						</button></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 등록 -->
	<form class="form-horizontal col-sm" enctype="multipart/form-data"
		method="post" action="<c:url value='/mypage/myskin/insert'/>"
		style="width: 85%; margin: 50px;">
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
</div>