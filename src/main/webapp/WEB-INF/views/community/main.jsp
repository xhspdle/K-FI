<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="commMainHere" value="CMH">
<div id="communityMainList" class="container text-center">
	<div class="panel-group communitySlide" style="opacity:0;">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo2.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<!-- 
	총 8개 중에 1번째, 마지막번째는 안보임 
	실제 데이터는 2번째꺼부터 7번째꺼까지 총 6개
	foreach로 꽂으면 될듯
	-->
	<div class="panel-group communitySlide">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo1.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<div class="panel-group communitySlide">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo2.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<div class="panel-group communitySlide">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo1.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<div class="panel-group communitySlide">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo2.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
		<div class="panel-group communitySlide">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo1.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<div class="panel-group communitySlide">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo2.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<div class="panel-group communitySlide" style="opacity:0;">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
				src="<c:url value='/resources/images/logo1.png'/>" alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
</div>

<hr>
<div>
	<img class="img-responsive center-block"
				src="<c:url value='/resources/images/logo1.png'/>" alt="community list">
</div>
