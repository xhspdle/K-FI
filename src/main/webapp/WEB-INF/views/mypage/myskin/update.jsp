<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="myskin">
<div class="form-control"> 	
	<!-- 미리보기: 실시간 js 처리할 것 -->
	<div id="myskin_preview">
		<img src="" alt="new profile"><br>
		<input type="text" id="new msg"><br>
	</div>
	<div >
		<form enctype="multipart/form-data" method="post" action="<c:url value='/mypage/myskin/update'/>">
		<label for="label_skinname">스킨명</label>
		<input type="text" name="ms_name" class="myskin form-control" width="50"><br>
		<label for="label_color">배경색</label>
		<input type="color" name="ms_color"><br>
		<label for="label_new_msg">상태메세지</label>
		<input type="text" name="ms_msg" class="myskin form-control" width="50"><br>
		<label for="label_profile">프로필사진</label>
		<input type="file" name="ms_file"><br>
		<label for="label_cover">커버사진</label>
		<input type="file" name="ms_file"><br>
		<input type="submit" value="수정"><br>
		</form>
	</div>
</div></div>