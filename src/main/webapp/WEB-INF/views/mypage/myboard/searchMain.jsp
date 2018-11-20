<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${!empty keyword }">
	<input type="hidden" id="myBoardSearchListHere" value="${keyword }">
	</c:when>
	<c:otherwise>
	<input type="hidden" id="myBoardSelectListHere" value="${selectedUserNum }">
	</c:otherwise>	
</c:choose>
<div id="myBoardSearchList" class="container">
<c:forEach var="vo" items="${list }" varStatus="vs">
	<h1 class="text-center" id="${vo.mb_date }" style="margin-bottom: 30px;">
		<span style="border-bottom: 4px solid tan">${vo.mb_date }</span>
	</h1>
	<div class="panel-group <c:if test="${vs.index!=0}">slideanim</c:if>">
		<div class="panel panel-default">
			<div class="panel-heading" id="${vo.mb_num }">
				<blockquote class="postBlock">
					<h1 class="postTitle">
						<a href="<c:url value='/mypage/myboard/select?mb_num=${vo.mb_num }&keyword=${keyword }&selectedUserNum=${selectedUserNum }'/>" 
						class="postA">
						${vo.mb_title }
						</a>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn dropdown-toggle"	type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li>
							<a href="#updateModal" class="btn btn-block 
							<c:if test="${vo.user_num!=sessionScope.user_num}">disabled</c:if>" 
							style="text-align: left;" data-toggle="modal" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
							</a>
						</li>
						<li>
							<a href="#" class="btn btn-block 
							<c:if test="${vo.user_num!=sessionScope.user_num}">disabled</c:if>" 
							style="text-align: left;" onclick="return false;" data-toggle="popover" 
							data-mb-num="${vo.mb_num }" data-popover-type="myBoard">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete
							</a>
						</li>
						<c:if test="${vo.user_num!=sessionScope.user_num}">
						<li><a href="<c:url value='/acinsert?mb_num=${vo.mb_num }'/>"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left media-top">
						<img src="<c:url value='/resources/upload/img/${vo.msp_savimg }'/>" class="media-object img-circle" style="width:50px;height:50px">
					</div>
					<div class="media-body" style="padding-left:5px;">
						<h4 class="media-heading" style="text-align:left;">
							<a href="<c:url value='/mypage/myboard/selectList?selectedUserNum=${vo.user_num }'/>" class="userSelect">
								<strong>${vo.user_nickname }</strong>
							</a>
						</h4>
						<p style="text-align:left;margin:0px;margin-top:-5px;"><small>${vo.user_email }</small></p>
					</div>
				</div>
				<p>${vo.mb_content }</p>
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
</c:forEach>
</div>
