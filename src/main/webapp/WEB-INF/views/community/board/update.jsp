<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="updateCommBoard">
<div class="container" style="padding: 0px;">
	<div class="modal-header" style="padding:35px 50px;">
		<h2><span class="glyphicon glyphicon-check"></span> Update</h2>
	</div>
	<div class="modal-body" style="padding:40px 50px;">
		<form method="post" action="<c:url value='/communityBoard/update'/>" name="frm1" enctype="multipart/form-data">
			<input type="hidden" name="cb_num" value="${cbvo.cb_num }">
			<div class="form-group">
				<label for="comm_title"><span class="glyphicon glyphicon-pencil"></span> Title</label>
				<input type="text" class="form-control" id="cb_title" name="cb_title" value="${cbvo.cb_title }">
			</div>
			<div class="form-group">
				<label for="comm_content"><span class="glyphicon glyphicon-menu-hamburger"></span> Content</label>
				<textarea class="form-control" rows="5" id="cb_content" name="cb_content" >${cbvo.cb_content }</textarea>
			</div>
			<!-- 공지유무 -->
			<c:if test="${user_num eq comm_adminNum && cul_status eq 1 }">
				<div class="form-group">
					<label for="cb_notice"><span class="glyphicon glyphicon-menu-hamburger"></span>Notice</label>
					<div class="checkbox">
					<c:if test="${cbvo.cb_notice eq 1 }"><label><input type="checkbox" name="cb_notice" value="1" checked="checked">is Notice</label></c:if>
					<c:if test="${cbvo.cb_notice ne 1 }"><label><input type="checkbox" name="cb_notice" value="1">is Notice</label></c:if>
					</div>
				</div>
			</c:if>
			<!-- tag -->
			<div class="form-group" style="margin-bottom:-11.4px;">
				<label for="tags"><span class="glyphicon glyphicon-tags"></span> Tags
				<c:if test="${tagNull ne 'tagNull' }">
					<c:forEach var="tag" items="${tagList }" varStatus="status">
						<span data-tag-num="${tag.tag_num }" class="tagSpan" style="opacity: 1;">${tag.tag_name }<span class="glyphicon glyphicon-remove-circle" data-tag-num="${tag.tag_num }"></span>
						</span>
					</c:forEach>
				</c:if>
				</label>
				<c:if test="${tagNull ne 'tagNull' }">
				<c:forEach var="tag" items="${tagList }" varStatus="status">
					<input type="hidden" name="tag_name" id="tag${tag.tag_num }" value="${tag.tag_name }">		
				</c:forEach>
				<div style="display:none;" id="del_TagList"></div>
				</c:if>
				<div class="editableDiv" id="tags" contenteditable="true"></div><span class="tagsPlaceholder">#tags and hit the SPACEBAR!</span>							
			</div>
			
			<!-- imgList -->
			<div class="form-group imgUpload">
			<c:if test="${imgNull eq 'imgNull' }">
				<label for="fileP1" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> Upload Photo</label>
				<input type="file" class="form-control myboardFile" id="fileP1" name="fileP">
				<img id="fimg1" src="" style="display:none;width:100%;">
			</c:if>	
			<c:if test="${imgList != null }">
			<input type="hidden" id="imgListSize" value="${imgListSize }">
			<c:forEach var="img" items="${imgList }" varStatus="status">
				<label for="fileP${status.count }_up" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> Upload Photo</label>
				<input type="file" class="form-control myboardFile" id="fileP${status.count }_up" name="fileP${status.count }" >
				<img id="fimg${status.count }" src="<c:url value='/resources/upload/img/${img.cp_savimg }'/>" style="width:100%;">
			</c:forEach>
			</c:if>
			</div>
			<!-- vidList -->
			<div class="form-group vidUpload">
			<c:if test="${vidNull eq 'vidNull'}">
				<label for="fileV1" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> Upload Video</label>
				<input type="file" class="form-control myboardFile" id="fileV1" name="fileV" style="display:none;">
				<video id="fvid1" controls autoplay muted="muted" loop src="" style="display:none;width:100%"></video>
			</c:if>
			<c:if test="${vidList != null }">
			<input type="hidden" id="vidListSize" value="${vidListSize }">
			<c:forEach var="vid" items="${vidList }" varStatus="status">
				<label for="fileV${status.count }_up" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> Upload Video</label>
				<input type="file" class="form-control myboardFile" id="fileV${status.count }_up" name="fileV${status.count }" >
				<video id="fvid${status.count }" controls autoplay muted="muted" loop src="<c:url value='/resources/upload/vid/${vid.cv_savvid }'/>" style="width:100%"></video>
			</c:forEach>
			</c:if>
			</div>
			<button type="submit" id="updateCommBoardSub" class="btn btn-success btn-block" ><span class="glyphicon glyphicon-ok"></span> Modify</button>
		</form>
	</div>
</div>
</div>
<script id="fileImgTemplate" type="text/template">
<label for="fileP{i}_up" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> {label}</label>
<input type="file" class="form-control myboardFile" id="fileP{i}_up" name="fileP{i}" accept=".jpg, .jpeg, .png, .gif">
<img id="fimg{i}" src="{mp_savimg}" style="display:none;width:100%;">
</script>
<script id="fileVidTemplate" type="text/template">
<label for="fileV{i}_up" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> {label}</label>
<input type="file" class="form-control myboardFile" id="fileV{i}_up" name="fileV" accept=".avi, .wmv, .mp4">
<video id="fvid{i}" controls autoplay muted="muted" loop src="{mv_savvid}" style="display:none;width:100%"></video>
</script>