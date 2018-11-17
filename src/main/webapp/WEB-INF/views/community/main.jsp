<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" id="commMainHere" value="CMH">
<div id="best" class="container text-center">
	<h1 class="bigTitle" style="margin-bottom: 50px; margin-top: 60px;">BEST
		COMMUNITY</h1>
	<div class="panel-group communitySlide" style="opacity: 0;">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
					src="<c:url value='/resources/images/logo2.png'/>"
					alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
	<!-- 총 8개 중에 1번째, 마지막번째는 안보임  실제 데이터는 2번째꺼부터 7번째꺼까지 총 6개 -->
	<c:forEach var="list" items="${list }">
		<c:forEach var="csplist" items="${csplist }">
			<div class="panel-group communitySlide">
				<div class="panel panel-default">
					<div class="panel-body">
					<c:if test="${list.comm_num == csplist.comm_num }">
						<a href="<c:url value='/community/selectComm?comm_num=${list.comm_num }'/>">
							<img class="img-responsive center-block communitySlideImg"
								src="<c:url value='/resources/upload/img/${ csplist.savimg}'/>"
								alt="community list">
						</a>
					</c:if>
					</div>
					<div class="panel-footer">
						<h4>${list.comm_name }</h4>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:forEach>
	<div class="panel-group communitySlide" style="opacity: 0;">
		<div class="panel panel-default">
			<div class="panel-body">
				<img class="img-responsive center-block communitySlideImg"
					src="<c:url value='/resources/images/logo1.png'/>"
					alt="community list">
			</div>
			<div class="panel-footer">
				<h4>Community name</h4>
			</div>
		</div>
	</div>
</div>

<div id="issue-img" class="container-fluid bg-grey text-center">
	<h1 class="bigTitle">HOT ISSUE - PHOTO</h1>
	<br>
	<div class="row">
		<div class="col-sm-4">
			<p>
				<small>2018-11-13</small>
			</p>
			<p>게시글 제목만 보여주면 되지않을까</p>
			<img class="img-responsive margin"
				src="<c:url value='/resources/images/logo2.png'/>"
				alt="community issue list" style="width: 100%">
		</div>
		<div class="col-sm-4">
			<p>
				<small>2018-11-13</small>
			</p>
			<p>blablabla blablabla</p>
			<img class="img-responsive margin"
				src="<c:url value='/resources/images/라이언움짤.gif'/>"
				alt="community issue list" style="width: 100%">
		</div>
		<div class="col-sm-4">
			<p>
				<small>2018-11-13</small>
			</p>
			<p>블라블라블라블라</p>
			<img class="img-responsive margin"
				src="<c:url value='/resources/images/Kpoplogo.png'/>"
				alt="community issue list" style="width: 100%">
		</div>
	</div>
</div>
<div id="issue-vid" class="container-fluid text-center">
	<h1 class="bigTitle">HOT ISSUE - VIDEO</h1>
	<br>
	<div class="row">
		<div class="col-sm-12">
			<p>
				<small>2018-11-13</small>
			</p>
			<p>영상은 딱 하나만 뙇</p>
			<video class="img-responsive center-block" controls autoplay
				muted="muted" loop
				src="<c:url value='/resources/images/Aerial - 18390.mp4'/>">
			</video>
		</div>
	</div>
</div>
<div id="build" class="container-fluid bg-grey">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-5">
			<h1 class="bigTitle">BUILD YOUR OWN COMMUNITY</h1>
			<br>
			<h3>Anyone can create K-Fi Community!</h3>
			<p>Custom design features including logo, theme color, background
				image!</p>
			<p>Provides community statistics</p>
			<br>
			<button class="btn btn-default btn-lg"><a href="<c:url value='/community/newComm/insertForm'/>">Create Community!</a></button>
		</div>
		<div class="col-sm-5">
			<span class="glyphicon glyphicon-globe logo"></span>
		</div>
	</div>
</div>