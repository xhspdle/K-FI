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
	<c:forEach var="list" items="${list }">
			<div class="panel-group communitySlide">
				<div class="panel panel-default">
					<div class="panel-body">
					<c:forEach var="csplist" items="${csplist }">
					<c:if test="${list.comm_num == csplist.comm_num }">
						<a href="<c:url value='/community?comm_num=${list.comm_num }'/>">
							<img class="img-responsive center-block communitySlideImg"
								src="<c:url value='/resources/upload/img/${ csplist.csp_savimg}'/>"
								alt="community list">
						</a>
					</c:if>
					</c:forEach>
					</div>
					<div class="panel-footer">
						<h4>${list.comm_name }</h4>
					</div>
				</div>
			</div>
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
		<c:forEach var="hotP" items="${hotPhoto3 }"> 
			<div class="col-sm-4">
				<p>
					<small>${hotP.cb_date }</small>
				</p>
				<p>${hotP.cb_title }</p>
				<img class="img-responsive margin"
					src="<c:url value='/resources/upload/img/${hotP.cp_savimg }'/>"
					alt="community issue list" style="width: 100%">
			</div>
		</c:forEach>
	</div>
</div>
<div id="issue-vid" class="container-fluid text-center">
	<h1 class="bigTitle">HOT ISSUE - VIDEO</h1>
	<br>
	<div class="row">
		<div class="col-sm-12">
			<p>
				<small>${hotvideo.cb_date }</small>
			</p>
			<p>${hotvideo.cb_title }</p>
			<video class="img-responsive center-block" controls autoplay
				muted="muted" loop
				src="<c:url value='/resources/upload/vid/${hotvideo.cv_savvid }'/>">
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