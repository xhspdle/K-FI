<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<br>
	<h2>새 커뮤니티 등록하기</h2>
	<!-- 미리보기 -->	
	<div id="new_community">
		<div class="w3-row-padding w3-margin-top">
			<div class="w3-third">
				<div class="w3-card">
					<img id="new_community_profile"
						src="<c:url value='/resources/images/default-profile.png'/>"
						style="width: 100%">
					<div class="w3-container">
						<h4 id="pre_newComm_name">
							<b>커뮤니티명</b>
						</h4>
						<p id="pre_newComm_content">커뮤니티 소개</p>
					</div>
				</div>
			</div>

			<div class="w3-third" style="width: 75%">
				<div class="w3-card">
					<img id="new_community_cover"
						src="<c:url value='/resources/images/logo2.png'/>"
						style="width: 100%; height: 369px;">
				</div>
			</div>
		</div>
	<br>
	
	<!-- 등록 -->	
	<form class="form-horizontal" method="post" action="<c:url value='/community/newComm/insert'/>" enctype="multipart/form-data">

	 <div class="form-group">
      <label class="control-label col-sm-2" for="comm_name">커뮤니티명:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="comm_name">
      </div>
      <label class="control-label col-sm-2" for="cs_color">배경색:</label>
       <div class="col-sm-2">
        <input type="color" class="form-control" name="cs_color" value="#00cee8">
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="comm_content">커뮤니티소개:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" name="comm_content">
      </div>
    </div>

	<div class="form-group">
      <label class="control-label col-sm-2" for="comm_skin_profile">프로필사진:</label>
      <div class="col-sm-10">          
        <input type="file" class="form-control" name="comm_skin_profile">
      </div>
    </div>

	<div class="form-group">
      <label class="control-label col-sm-2" for="comm_skin_cover">커버사진:</label>
      <div class="col-sm-10">          
        <input type="file" class="form-control" name="comm_skin_cover">
      </div>
    </div>

	<div class="form-group">        
      <div>
        <button type="submit" class="btn btn-default" id="new_community_submit">등록</button>
      </div>
    </div>
	</form>		
	</div>
</div>

