<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="getPageContext" value="<c:url value='/'/>">
<div id="myBoardSelect" class="container">
	<h1 class="text-center" style="margin-bottom:30px;"><span style="border-bottom: 4px solid tan">${boardVo.mb_date }</span></h1>
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">
				<blockquote class="postBlock"><h1 class="postTitle"><span class="postA">${boardVo.mb_title }</span></h1></blockquote>
			</div>
			<div class="panel-body">
				<p>${boardVo.mb_content }</p>
				
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<c:forEach var="vo" items="${imgList }" varStatus="vs">
					<c:choose>
						<c:when test="${vs.index==0 }">
						<li data-target="#myCarousel" data-slide-to="${vs.index }" class="active"></li>
						</c:when>
						<c:otherwise>
						<li data-target="#myCarousel" data-slide-to="${vs.index }"></li>
						</c:otherwise>
					</c:choose>
					</c:forEach>
				</ol>
				<div class="carousel-inner">
					<c:forEach var="vo" items="${imgList }" varStatus="vs">
					<c:choose>
						<c:when test="${vs.index==0 }">
						<div class="item active">
							<img class="img-responsive center-block" 
							src="<c:url value='/resources/upload/img/${vo.mp_savimg }'/>" 
							alt="MyBoard Photos"><!-- style="width:100%;" -->
						</div>
						</c:when>
						<c:otherwise>
						<div class="item">
							<img class="img-responsive center-block" 
							src="<c:url value='/resources/upload/img/${vo.mp_savimg }'/>" 
							alt="MyBoard Photos"><!-- style="width:100%;" -->
						</div>
						</c:otherwise>
					</c:choose>
					</c:forEach>
				</div>
				
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
					<span class="sr-only">Next</span>
				</a>
				</div>
				<c:forEach var="vo" items="${vidList }">
				<div>
					<video class="img-responsive center-block slideanim" controls autoplay muted="muted" loop 
					src="<c:url value='/resources/upload/vid/${vo.mv_savvid }'/>" style="margin-top:3%;"></video>
				</div>
				</c:forEach>				
			</div>
			<div class="panel-footer text-left">
				<h3 class="postLikeComment select">xx Likes</h3>
				<div class="likes">
					<a class="btn btn-default" href="#">
					<span class="glyphicon glyphicon-heart"></span> Like</a>
					<div class="likeUserList">
						<img class="img-responsive img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="likerProfiles">
						<img class="img-responsive img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="likerProfiles">
						<img class="img-responsive img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="likerProfiles">
					</div>
				</div>
				<h3 class="postLikeComment select">xx Comments</h3>
				<div class="media">
					<div class="media-left media-middle">
						<img class="media-object img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="userProfile">
					</div>
					<div class="media-body media-middle form-group row">
						<form id="commentForm" class="form-inline" action="">
							<input type="text" class="form-control" placeholder="Say something!">
							<button type="submit" class="btn btn-default pull-right"><span class="glyphicon glyphicon-comment"></span></button>
						</form>
					</div>
				</div>
				<div id="commentList">
					<div class="media">
						<div class="media-left">
							<img class="media-object img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="commentProfile">
						</div>
						<div class="media-body">
							<h3><strong><a href="">UserId</a></strong></h3>
							<p>댓글내용 블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라
							블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라
							ㅁㄴㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㄴㅇㄴㅁㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㄴㅁㅇㅁ
							ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
							ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ</p>
							<i class="glyphicon glyphicon-thumbs-up"></i><span>추천수</span><small>댓글작성일</small>
						</div>
					</div>
					<div class="media">
						<div class="media-left">
							<img class="media-object img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="commentProfile">
						</div>
						<div class="media-body">
							<h3><strong><a href="">UserId</a></strong></h3>
							<p>댓글내용 블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라
							블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라블라
							ㅁㄴㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㄴㅇㄴㅁㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㄴㅁㅇㅁ
							ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
							ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ</p>
							<i class="glyphicon glyphicon-thumbs-up"></i><span>추천수</span><small>댓글작성일</small>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>