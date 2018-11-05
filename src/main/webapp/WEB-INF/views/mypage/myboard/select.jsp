<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="myCommentListHere" value="MCLH">
<input type="hidden" id="boardWriter" value="${boardVo.user_num }">
<input type="hidden" id="boardNum" value="${boardVo.mb_num }">
<div id="myBoardSelect" class="container">
	<h1 class="text-center" style="margin-bottom:30px;"><span style="border-bottom: 4px solid tan">${boardVo.mb_date }</span></h1>
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">
				<blockquote class="postBlock">
					<h1 class="postTitle">
						<span class="postA">${boardVo.mb_title }</span>
					</h1>
				</blockquote>
				<div class="dropdown boardOption">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li><a href="#">수정</a></li>
						<li><a href="#">삭제</a></li>
					</ul>
				</div>
				<!--  
				<div class="dropdown commentOption">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li><a href="#">수정</a></li>
						<li><a href="#">삭제</a></li>
					</ul>
				</div>
				-->
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
				<h3 class="postLikeComment select" id="likeCnt" data-like-cnt="${like_cnt }">
				${like_cnt } Likes<span class="msgSpan"></span></h3>
				<div class="likes">
					<a class="btn btn-default" href="<c:url value='/mypage/myboardlike/insert?mb_num=${boardVo.mb_num }'/>" 
					data-board-num="${boardVo.mb_num }">
					<span class="glyphicon glyphicon-heart"></span> Like</a>
					<div class="likeUserList">
						<img class="img-responsive img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="likerProfiles">
						<img class="img-responsive img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="likerProfiles">
						<img class="img-responsive img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="likerProfiles">
					</div>
				</div>
				<h3 class="postLikeComment select" id="commentCnt">${comment_cnt } Comments</h3>
				<div class="media">
				<c:choose>
					<c:when test="${!empty user_num }">
					<div class="media-left media-top">
						<img class="media-object img-circle" src="<c:url value='/resources/images/kpop콘.gif'/>" alt="userProfile">
					</div>
					<div class="media-body media-middle form-group row">
						<form id="commentForm" name="frmComment" class="form-inline" action="<c:url value='/mypage/mycomment/insert'/>">
							<input type="hidden" name="mb_num" value="${boardVo.mb_num }">
							<input type="text" name="myc_content" class="form-control" placeholder="Say something!">
							<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-comment"></span></button>
							<span class="help-block">asd</span>
						</form>
					</div>	
					</c:when>
					<c:otherwise>
					<div class="media-left media-top">
						<img class="media-object img-circle" src="<c:url value='/resources/images/default-profile.png'/>" alt="userProfile">
					</div>
					<div class="media-body media-middle form-group row">
						<p>Login first, if you wanna post comment!</p>
					</div>
					</c:otherwise>
				</c:choose>
				</div>
				<div id="commentList">
				<!--  
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
				-->	
				</div>
				<div class="text-center">
					<ul class="pagination"></ul>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteMsg" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-body">
				<p>Are you sure!?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="okBtn">Okay</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script id="commentTemplate" type="text/template">
<div class="media slide">
	<div class="media-left">
		<img class="media-object img-circle" src="<c:url value='/resources/images/{msp_savimg}'/>" alt="commentProfile">
	</div>
	<div class="media-body">
		<h3><strong><a href="">{user_id}</a></strong></h3>
		<div class="dropdown commentOption">
			<button class="btn btn-primary dropdown-toggle{optionBtn}" type="button" data-toggle="dropdown">
				<span class="glyphicon glyphicon-option-vertical"></span>
			</button>
			<ul class="dropdown-menu rightOption">{dropDowns}</ul>
		</div>
		<p>{myc_content}</p>
		<a class="thumbsUp" data-comm-num="{myc_num}" href="{path}/mypage/mycommentlike/insert?myc_num={myc_num}">
			<i class="glyphicon glyphicon-thumbs-up"></i>
		</a>
		<span data-comm-num="{myc_num}">{comment_likes}</span><small>{myc_date}</small><span class="msgSpan"></span>
	</div>
</div>
</script>