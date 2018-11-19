<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="commInsideHere" value="CMH">
<div id="commBoardList" class="container text-center">
	<div id="commNotice">
		<ul class="commNoticeList center-block text-left">
		<c:forEach var="notice" items="${noticeList }">
			<li>
				<a href="<c:url value='/community/board/select?cb_num=${notice.cb_num }'/>"><i class="glyphicon glyphicon-bullhorn"></i>
				${notice.cb_title }<i class="glyphicon glyphicon-menu-right pull-right"></i></a>
			</li>		
		</c:forEach>
		</ul>
	</div>
	
	<!-- 여기서부터 c:forEach -->
	<h1 class="text-center" id="브이오.mb_date" style="margin-bottom: 30px;">
		<span style="border-bottom: 4px solid tan">2018-날짜-날짜</span>
	</h1>
	<!-- 								0번째꺼는 슬라이드 안주기 
	<div class="panel-group <c:if test="${vs.index!=0 }">slideanim</c:if>">
	-->
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading" id="브이오.mb_num">
				<blockquote class="postBlock">
					<h1 class="postTitle">
						<a href="#" class="postA">
						브이오.mb_title
						</a>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn dropdown-toggle 
					<c:if test="${vo.user_num!=sessionScope.user_num}">disabled</c:if>" 
					type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li>
							<a href="#updateModal" data-toggle="modal" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
							</a>
						</li>
						<li>
							<a href="#" onclick="return false;" data-toggle="popover" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete
							</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>
					</ul>
				</div>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left media-top">
											<!-- /resources/upload/img/브이오.msp_savimg -->
						<img src="<c:url value='/resources/images/라이언움짤.gif'/>" class="media-object img-circle" style="width:50px;height:50px">
					</div>
					<div class="media-body text-left" style="padding-left:5px;">
						<h4 class="media-heading"><strong>브이오.user_nickname</strong></h4>
						<p style="margin:0px;margin-top:-5px;"><small>브이오.user_email</small></p>
					</div>
				</div>
				<p>브이오.mb_content</p>
				<!-- 스샷용 이미지 -->
				<img class="img-responsive center-block" 
					src="<c:url value='/resources/images/logo2.png'/>" alt="board image">
				<!-- --------- -->
				<c:choose>
					<c:when test="${!empty vo.mv_savvid}">
					<video class="img-responsive center-block" controls autoplay muted="muted" loop 
					src="<c:url value='/resources/upload/vid/${vo.mv_savvid }'/>"></video>
					</c:when>
					<c:when test="${!empty vo.mp_savimg }">
					<img class="img-responsive center-block" 
					src="<c:url value='/resources/upload/img/${vo.mp_savimg }'/>" alt="board image">
					</c:when>
				</c:choose>
			</div>
			<div class="panel-footer">
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-heart-empty"></span>&nbsp;Likes <span class="badge">${vo.like_cnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-comment"></span>&nbsp;Comments <span class="badge">${vo.comment_cnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-signal"></span>&nbsp;Views ${vo.mb_views }</h4>
			</div>
		</div>
	</div>
	<!-- 여기까지 c:forEach -->
	
	
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel=heading" id="브이오.mb_num">
				<blockquote class="postBlock">
					<h1 class="postTitle">
						<a href="#" class="postA">
						브이오.mb_title
						</a>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn dropdown-toggle 
					<c:if test="${vo.user_num!=sessionScope.user_num}">disabled</c:if>" 
					type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li>
							<a href="#updateModal" data-toggle="modal" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
							</a>
						</li>
						<li>
							<a href="#" onclick="return false;" data-toggle="popover" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete
							</a>
						</li>
						<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>
					</ul>
				</div>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left media-top">
											<!-- /resources/upload/img/브이오.msp_savimg -->
						<img src="<c:url value='/resources/images/라이언움짤.gif'/>" class="media-object img-circle" style="width:50px;height:50px">
					</div>
					<div class="media-body" style="padding-left:5px;">
						<h4 class="media-heading" style="text-align:left;"><strong>브이오.user_nickname</strong></h4>
						<p style="text-align:left;margin:0px;margin-top:-5px;"><small>브이오.user_email</small></p>
					</div>
				</div>
				<p>브이오.mb_content</p>
				<!-- 스샷용 이미지 -->
				<img class="img-responsive center-block" 
					src="<c:url value='/resources/images/logo2.png'/>" alt="board image">
				<!-- --------- -->
				<c:choose>
					<c:when test="${!empty vo.mv_savvid}">
					<video class="img-responsive center-block" controls autoplay muted="muted" loop 
					src="<c:url value='/resources/upload/vid/${vo.mv_savvid }'/>"></video>
					</c:when>
					<c:when test="${!empty vo.mp_savimg }">
					<img class="img-responsive center-block" 
					src="<c:url value='/resources/upload/img/${vo.mp_savimg }'/>" alt="board image">
					</c:when>
				</c:choose>
			</div>
			<div class="panel-footer">
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-heart-empty"></span>&nbsp;Likes <span class="badge">${vo.like_cnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-comment"></span>&nbsp;Comments <span class="badge">${vo.comment_cnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-signal"></span>&nbsp;Views ${vo.mb_views }</h4>
			</div>
		</div>
	</div>
	
	
	
</div>
<!-- Calendar icon -->
	<input type="hidden" id="url" value="${pageContext.request.contextPath }">
	<input type="hidden" id="year" value="year">
	<input type="hidden" id="month" value="month">
	<div class="sidenav">
		<div id="icon_chat" data-toggle="tooltip" data-placement="top" title="chat">
		<i class="glyphicon glyphicon-comment"></i></div>
		<div id="wrap_icon_chat"></div>
		
		<div id="icon_calendar" data-toggle="tooltip" data-placement="top" title="calendar">
		<i class="glyphicon glyphicon-calendar"></i></div>
		<div id="wrap_icon_calendar" ></div>
	</div>