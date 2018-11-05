<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title>K-FI Main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/jyi.css'/>">
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script src="<c:url value='/resources/js/jyi.js'/>"></script>
<!-- full calendar 추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<link href="<c:url value='/resources/css/fullcalendar.min.css'/>" rel="stylesheet">
<script src="<c:url value='/resources/js/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
<!-- 추가끝 -->
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60"><!-- style="padding-top:60px;" -->
<input type="hidden" id="getPageContext" value="<c:url value='/'/>">
<input type="hidden" id="getSession" value="${user_num }">
<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content">
		<div class="row">
			<tiles:insertAttribute name="content"/>
		</div>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
	
	<!-- Calendar icon -->
	<input type="hidden" id="url" value="${pageContext.request.contextPath }">
	<input type="hidden" id="year" value="year">
	<input type="hidden" id="month" value="month">
	<div id="icon_calendar" class="glyphicon glyphicon-calendar" style="font-size:40px;"></div>
	<div id="wrap_icon_calendar"><!--   class="well" style="width:320px;" -->
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="writeModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding:35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-edit"></span> Write</h4>
				</div>
				<div class="modal-body" style="padding:40px 50px;">
					<form method="post" action="<c:url value='/mypage/myboard/insert'/>" name="frm" enctype="multipart/form-data">
						<div class="form-group">
							<label for="mb_title"><span class="glyphicon glyphicon-pencil"></span> Title</label>
							<input type="text" class="form-control" id="mb_title" name="mb_title" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="mb_content"><span class="glyphicon glyphicon-menu-hamburger"></span> Content</label>
							<textarea class="form-control" rows="5" id="mb_content" name="mb_content"></textarea>
						</div>
						<div class="form-group">
							<label for="tags"><span class="glyphicon glyphicon-tags"></span> Tags</label>
							<input type="text" class="form-control" id="tags" name="tags" placeholder="#blabla #blabla">
						</div>
						<div class="form-group" id="imgUpload">
							<label for="fileP1" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> Upload Photo</label>
							<input type="file" class="form-control myboardFile" id="fileP1" name="fileP" accept=".jpg, .jpeg, .png, .gif">
							<img id="fimg1" src="" style="display:none;width:100%;">
						</div>
						<div class="form-group" id="vidUpload">
							<label for="fileV1" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> Upload Video</label>
							<input type="file" class="form-control myboardFile" id="fileV1" name="fileV" style="display:none;" accept=".avi, .wmv, .mp4">
							<video id="fvid1" controls autoplay muted="muted" loop src="" style="display:none;width:100%"></video>
						</div>
						<button type="submit" class="btn btn-success btn-block" id="sendServer"><span class="glyphicon glyphicon-ok"></span> Write</button>
					</form>
					<div class="progress">
						<div class="progress-bar progress-bar-striped active" role="progressbar" 
						aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%;"></div>
					</div>
				</div>
				<div class="modal-footer">
				  <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				  <p id="uploadMsg">upload photo and video!</p>
				</div>
			</div> 
		</div>
	</div> 
</div>
<script id="modalForm" type="text/template">
<form method="post" action="<c:url value='/mypage/myboard/insert'/>" name="frm" enctype="multipart/form-data">
	<div class="form-group">
		<label for="mb_title"><span class="glyphicon glyphicon-pencil"></span> Title</label>
		<input type="text" class="form-control" id="mb_title" name="mb_title" placeholder="Enter Title">
	</div>
	<div class="form-group">
		<label for="mb_content"><span class="glyphicon glyphicon-menu-hamburger"></span> Content</label>
		<textarea class="form-control" rows="5" id="mb_content" name="mb_content"></textarea>
	</div>
	<div class="form-group">
		<label for="tags"><span class="glyphicon glyphicon-tags"></span> Tags</label>
		<input type="text" class="form-control" id="tags" name="tags" placeholder="#blabla #blabla">
	</div>
	<div class="form-group" id="imgUpload">
		<label for="fileP1" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> Upload Photo</label>
		<input type="file" class="form-control myboardFile" id="fileP1" name="fileP" accept=".jpg, .jpeg, .png, .gif">
		<img id="fimg1" src="" style="display:none;width:100%;">
	</div>
	<div class="form-group" id="vidUpload">
		<label for="fileV1" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> Upload Video</label>
		<input type="file" class="form-control myboardFile" id="fileV1" name="fileV" style="display:none;" accept=".avi, .wmv, .mp4">
		<video id="fvid1" controls autoplay muted="muted" loop src="" style="display:none;width:100%"></video>
	</div>
	<button type="submit" class="btn btn-success btn-block" id="sendServer"><span class="glyphicon glyphicon-ok"></span> Write</button>
</form>
<div class="progress">
	<div class="progress-bar progress-bar-striped active" role="progressbar" 
	aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%;"></div>
</div>
</script>