<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="commInsideHere" value="CMH">
<input type="hidden" id="pageNum" value="${pageNum }">
<input type="hidden" id="user_num" value="${user_num }">
<input type="hidden" id="comm_adminNum" value="${comm_adminNum }">
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
	<c:forEach var="board" items="${list }" >
		<c:choose>
			<c:when test="${date ne board.cb_date }">
				<h1 class="text-center" id="${board.cb_date }" style="margin-bottom: 30px;">
					<span style="border-bottom: 4px solid tan">${board.cb_date }</span>
				</h1>
				<c:set var="date"  value="${board.cb_date } "/>
			</c:when>
			<c:when test="${date eq board.cb_date }">
			</c:when>
			<c:otherwise>
				<h1 class="text-center" id="${board.cb_date }" style="margin-bottom: 30px;">
					<span style="border-bottom: 4px solid tan">${board.cb_date }</span>
				</h1>
			</c:otherwise>
		</c:choose>		
		<c:set var="date" value="${board.cb_date }"/>
		
		<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading" id="${board.cb_num }">
				<blockquote class="postBlock">
					<h1 class="postTitle">
						<a href="<c:url value='/community/board/select?cb_num=${board.cb_num }'/>" class="postA">
						${board.cb_title }
						</a>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn dropdown-toggle 
					<c:if test="${board.user_num ne sessionScope.user_num}">disabled</c:if>" 
					type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<c:if test="${board.user_num eq sessionScope.user_num}">
							<li>
								<a href="#updateModal" data-toggle="modal" data-mb-num="${board.cb_num }">
									<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
								</a>
							</li>
						</c:if>
						<c:if test="${board.user_num eq sessionScope.user_num || sessionScope.user_num eq comm_adminNum }">
							<li>
								<a href="#" onclick="return false;" data-toggle="popover" data-mb-num="${board.cb_num}">
									<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete
								</a>
							</li>
						</c:if>
						<c:if test="${board.user_num ne sessionScope.user_num }">
							<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="panel-body">
			<c:forEach var="pro" items="${proflist }">
				<c:if test="${pro.cb_num eq board.cb_num }">
					<div class="media">
						<div class="media-left media-top">
							<img src="<c:url value='/resources/upload/img/${pro.msp_savimg }'/>" class="media-object img-circle" style="width:50px;height:50px">
						</div>
						<div class="media-body text-left" style="padding-left:5px;">
							<h4 class="media-heading">
								<a href="<c:url value='/mypage/myboard/selectList?selectedUserNum=${board.user_num }'/>" class="userSelect">
									<strong>${pro.user_nickname }</strong>
								</a>
							</h4>
							<p style="margin:0px;margin-top:-5px;"><small>${ pro.user_email}</small></p>
						</div>
					</div>
				</c:if>
			</c:forEach>
				<p>${board.cb_content }</p>
				<c:set var="j" value="0"/>
				<c:if test="${cvlist ne null }">
					<c:forEach var="video" items="${cvlist }">
							<c:if test="${video.cb_num eq board.cb_num }">
								<video class="img-responsive center-block" controls autoplay muted="muted" loop 
								src="<c:url value='/resources/upload/vid/${video.cv_savvid }'/>"></video>
								<c:set var="j" value="1"/>
							</c:if>
					</c:forEach>
				</c:if>		
				<c:if test="${j ne '1' and cplist ne null}">
					<c:forEach var="photo" items="${cplist }">
							<c:if test="${photo.cb_num eq board.cb_num }">
								<img class="img-responsive center-block" 
								src="<c:url value='/resources/upload/img/${photo.cp_savimg }'/>" alt="board image">
							</c:if>
					</c:forEach>
				</c:if>				
			</div>
			<div class="panel-footer">
			<c:forEach var="cnt" items="${cbclist }">
			<c:if test="${board.cb_num eq cnt.cb }">
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-heart-empty"></span>&nbsp;Likes <span class="badge">${cnt.cblcnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-comment"></span>&nbsp;Comments <span class="badge">${cnt.cmcnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-signal"></span>&nbsp;Views ${cnt.cvcnt }</h4>
			</c:if>
			</c:forEach>
			</div>
		</div>
	</div>
	</c:forEach>
	<div id="moreCommBoard"></div>
	<div class='container-fluid text-center'>
		<h2>
			<a class='btn btn-default' href='javascript:getCommBoard();'><span class='glyphicon glyphicon-plus'></span> More </a>
		</h2>
	</div>
	<!-- 여기까지 c:forEach -->
</div>
<!-- Calendar icon -->
	<input type="hidden" id="url" value="${pageContext.request.contextPath }">
	<input type="hidden" id="year" value="year">
	<input type="hidden" id="month" value="month">
	<div class="sidenav">
		<!--  
		<div id="icon_chat" data-toggle="tooltip" data-placement="top" title="chat">
		<i class="glyphicon glyphicon-comment"></i></div>
		<div id="wrap_icon_chat"></div>-->
		
		<div id="icon_calendar" data-toggle="tooltip" data-placement="top" title="calendar">
		<i class="glyphicon glyphicon-calendar"></i></div>
		<div id="wrap_icon_calendar" ></div>
	</div>
<script id="commBoardListTemplate" type="text/template">
		<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading" id="{board.cb_num }">
				<blockquote class="postBlock">
					<h1 class="postTitle">
						<a href="<c:url value='/community/board/select?cb_num={board.cb_num }'/>" class="postA">
						{board.cb_title }
						</a>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn dropdown-toggle {disabled}"  type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li>{liType}</li>
					</ul>
				</div>
			</div>
			<div class="panel-body">
				{mediaDiv}	
				<p>{board.cb_content }</p>
				{vid}
				{photo}				
			</div>
			<div class="panel-footer">
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-heart-empty"></span>&nbsp;Likes <span class="badge">{cblcnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-comment"></span>&nbsp;Comments <span class="badge">{cmcnt }</span></h4>
				<h4 class="postLikeComment slideanim"><span class="glyphicon glyphicon-signal"></span>&nbsp;Views {cvcnt }</h4>
			</div>
		</div>
	</div>
</script>	