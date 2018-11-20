<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="padding: 0px;">
	<div class="modal-header" style="padding:35px 50px;">
		<h2><span class="glyphicon glyphicon-check"></span> Write</h2>
	</div>
	<div class="modal-body" style="padding:40px 50px;">
		<form method="post" action="<c:url value='/community/board/insert'/>" name="frm1" enctype="multipart/form-data">
			<div class="form-group">
				<label for="comm_title"><span class="glyphicon glyphicon-pencil"></span> Title</label>
				<input type="text" class="form-control" id="cb_title" name="cb_title" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="comm_content"><span class="glyphicon glyphicon-menu-hamburger"></span> Content</label>
				<textarea class="form-control" rows="5" id="cb_content" name="cb_content" placeholder="Write something!"></textarea>
			</div>
			<!-- 공지유무 -->
			<c:if test="${user_num eq comm_adminNum && cul_status eq 1 }">
				<div class="form-group">
					<label for="cb_notice"><span class="glyphicon glyphicon-menu-hamburger"></span>Notice</label>
					<div class="checkbox">
				      <label><input type="checkbox" name="cb_notice" value="1">is Notice</label>
					</div>
				</div>
			</c:if>
			<div class="form-group" style="margin-bottom:-11.4px;">
				<label for="tags"><span class="glyphicon glyphicon-tags"></span> Tags</label>
				<div class="editableDiv" id="tags"></div><span class="tagsPlaceholder">#tags and hit the SPACEBAR!</span>							
			</div>
			<div class="form-group imgUpload">
				<label for="fileP1" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> Upload Photo</label>
				<input type="file" class="form-control myboardFile" id="fileP1" name="fileP" accept=".jpg, .jpeg, .png, .gif">
				<img id="fimg1" src="" style="display:none;width:100%;">
			</div>
			<div class="form-group vidUpload">
				<label for="fileV1" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> Upload Video</label>
				<input type="file" class="form-control myboardFile" id="fileV1" name="fileV" style="display:none;" accept=".avi, .wmv, .mp4">
				<video id="fvid1" controls autoplay muted="muted" loop src="" style="display:none;width:100%"></video>
			</div>
			<!-- id="sendServer" -->
			<button type="submit" class="btn btn-success btn-block" ><span class="glyphicon glyphicon-ok"></span> Write</button>
		</form>
	</div>
</div>
