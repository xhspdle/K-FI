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
					<button class="btn dropdown-toggle"	type="button" data-toggle="dropdown">
						<span class="glyphicon glyphicon-option-vertical"></span>
					</button>
					<ul class="dropdown-menu rightOption">
						<li>
							<a href="#updateModal" class="btn btn-block 
							<c:if test="${sessionScope.user_num!=boardVo.user_num }">disabled</c:if>" 
							style="text-align: left;" data-toggle="modal" data-mb-num="${boardVo.mb_num }">
								<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
							</a>
						</li>
						<li>
							<a href="#" class="btn btn-block 
							<c:if test="${sessionScope.user_num!=boardVo.user_num }">disabled</c:if>" 
							style="text-align: left;" onclick="return false;" data-toggle="popover" data-mb-num="${boardVo.mb_num }">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete
							</a>
						</li>
						<c:if test="${sessionScope.user_num!=boardVo.user_num }">
						<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left media-top">
						<img src="<c:url value='/resources/upload/img/${boardVo.msp_savimg }'/>" class="media-object img-circle" style="width:50px;height:50px">
					</div>
					<div class="media-body" style="padding-left:5px;">
						<h4 class="media-heading" style="text-align:left;">
							<a href="<c:url value='/mypage/myboard/selectList?selectedUserNum=${boardVo.user_num }'/>" class="userSelect">
								<strong>${boardVo.user_nickname }</strong>
							</a>
						<span class="pull-right" style="color:#f4511e;"><span class="glyphicon glyphicon-signal"></span>&nbsp;Views ${boardVo.mb_views}</span></h4>
						<p style="text-align:left;margin:0px;margin-top:-5px;"><small>${boardVo.user_email }</small></p>
					</div>
				</div>
				
				<p>${boardVo.mb_content }</p>
				
				<c:if test="${!empty imgList }">
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
				</c:if>
				<c:forEach var="vo" items="${vidList }">
				<div>
					<video class="img-responsive center-block slideanim" controls autoplay muted="muted" loop 
					src="<c:url value='/resources/upload/vid/${vo.mv_savvid }'/>" style="margin-top:3%;"></video>
				</div>
				</c:forEach>				
			</div>
			<div class="panel-footer text-left">
				<h3 class="postListComment select">
				<c:forEach var="tags" items="${tagList }">
					<span style="font-size: 24px;">#${tags.tag_name }&nbsp;</span>
				</c:forEach>
				</h3>
				<h3 class="postLikeComment select" id="likeCnt" data-like-cnt="${like_cnt }">
				${like_cnt } Likes<span class="msgSpan"></span></h3>
				<div class="likes">
					<a class="btn btn-default" href="<c:url value='/mypage/myboardlike/insert?mb_num=${boardVo.mb_num }'/>" 
					data-board-num="${boardVo.mb_num }">
					<span class="glyphicon glyphicon-heart"></span> Like</a>
					<div class="likeUserList">
					
					</div>
				</div>
				<h3 class="postLikeComment select" id="commentCnt">${comment_cnt } Comments</h3>
				<div class="media">
				<c:choose>
					<c:when test="${!empty user_num }">
					<div class="media-left media-top">
						<img class="media-object img-circle" src="<c:url value='/resources/upload/img/${boardVo.msp_savimg }'/>" alt="userProfile">
					</div>
					<div class="media-body media-middle form-group row">
						<form id="commentForm" name="frmComment" class="form-inline" action="<c:url value='/mypage/mycomment/insert'/>">
							<input type="hidden" name="mb_num" value="${boardVo.mb_num }">
							<input type="text" name="myc_content" class="form-control" placeholder="Say something!">
							<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-comment"></span></button>
							<span class="help-block"></span>
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
				
				</div>
				
				<div class="text-center">
					<ul class="pagination"></ul>
					<a <c:if test="${!empty prev.mb_num }">href="<c:url value='/mypage/myboard/select?mb_num=${prev.mb_num }&keyword=${keyword }&selectedUserNum=${selectedUserNum }'/>"</c:if>>
						<span data-toggle="tooltip" 
						<c:choose>
							<c:when test="${!empty prev.mb_num }">
							title="Prev"
							</c:when>
							<c:otherwise>
							title="end of line"
							</c:otherwise>
						</c:choose> 
						class="pull-left glyphicon glyphicon-step-backward prev"></span>
					</a>
					
					<a <c:if test="${!empty next.mb_num }">href="<c:url value='/mypage/myboard/select?mb_num=${next.mb_num }&keyword=${keyword }&selectedUserNum=${selectedUserNum }'/>"</c:if>>
						<span data-toggle="tooltip" 
						<c:choose>
							<c:when test="${!empty next.mb_num }">
							title="Next"
							</c:when>
							<c:otherwise>
							title="end of line"
							</c:otherwise>
						</c:choose>
						class="pull-right glyphicon glyphicon-step-forward next"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- DeleteMsg Modal -->
<div class="modal fade" id="deleteMsg" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content deleteModal">
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
<div class="media slide" data-comm-pagenum="{pageNum}">
	<div class="media-left">
		<img class="media-object img-circle" src="<c:url value='/resources/upload/img/{msp_savimg}'/>" alt="commentProfile">
	</div>
	<div class="media-body">
		<h3><strong><a href="{userSelect}">{user_nickname}</a></strong><span class="msgSpan"></span></h3>
		<div class="dropdown commentOption">
			<button class="btn dropdown-toggle{optionBtn}" type="button" data-toggle="dropdown">
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