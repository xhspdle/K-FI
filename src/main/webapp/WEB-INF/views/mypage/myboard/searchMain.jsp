<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="myBoardSearchListHere" value="${keyword }">
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
						<a href="<c:url value='/mypage/myboard/select?mb_num=${vo.mb_num }&keyword=${keyword }'/>" class="postA">
						${vo.mb_title }
						</a>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn dropdown-toggle" type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li <c:if test="${vo.user_num!=sessionScope.user_num}">class="disabled"</c:if>>
							<a href="#updateModal" data-toggle="modal" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
							</a>
						</li>
						<li <c:if test="${vo.user_num!=sessionScope.user_num}">class="disabled"</c:if>>
							<a href="#" onclick="return false;" data-toggle="popover" data-mb-num="${vo.mb_num }">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete
							</a>
						</li>
						<li><a href="#">Report bad contents</a></li>
					</ul>
				</div>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left media-top">
						<img src="<c:url value='/resources/images/kpop콘.gif'/>" class="media-object img-circle" style="width:50px;height:50px">
					</div>
					<div class="media-body" style="padding-left:5px;">
						<h4 class="media-heading" style="text-align:left;margin-bottom:-5px;"><strong>${vo.user_nickname }</strong></h4>
						<p style="text-align:left;"><small>${vo.mb_date }</small></p>
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
				<h4 class="postLikeComment">Likes: ${vo.like_cnt }</h4>
				<h4 class="postLikeComment">Comments: ${vo.comment_cnt }</h4>
			</div>	
		</div>
	</div>
</c:forEach>
</div>
