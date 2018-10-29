<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="getPageContext" value="<c:url value='/'/>">
<div id="myBoardList" class="container">

	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">
				<blockquote class="postBlock"><h1 class="postTitle"><a href="#" class="postA">Post Title</a></h1></blockquote>
			</div>
			<div class="panel-body">
				<p>글 내용이 여기 딱 호롤로로로로로로로</p>
				<img class="img-responsive center-block" src="<c:url value='/resources/images/logo2.png'/>">
			</div>
			<div class="panel-footer">
				<div>
					<h4 class="postLikeComment">xx Likes</h4>
					<h4 class="postLikeComment">xx Comments</h4>
				</div>
			</div>
		</div>	
	</div>

</div>

