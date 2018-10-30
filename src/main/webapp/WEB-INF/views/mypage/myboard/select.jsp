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
		</div>
	</div>
</div>
