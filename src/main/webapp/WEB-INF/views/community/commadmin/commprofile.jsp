<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div id="userinsert">

	<div class="modal-dialog">
	<div class="btn-group">
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commprofile?comm_num=${comm_num}'">PROFILE</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commskin?comm_num=${comm_num}'">SKIN</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commuserlist?comm_num=${comm_num}'">MEMBERS</button>
	</div><!-- <br><br> -->
		<div class="modal-content">
			<form class="form-horizontal" action="mbinsert" method="post">		
			<div class="modal-header">
				<h4 class="modal-title" style="display: inline;">프로필 수정</h4>
				<div class="btn-group  pull-right">
					<button type="button" class="btn btn-primary" id="commskinmodifybtn">적용</button>
					<button type="button" class="btn btn-primary">초기화</button>
				</div>
			</div>
			
			<div class="modal-body">
				<div>
					<img id="commprofileimg" src="<c:url value='/resources/upload/img/${commprofile.csp_savimg}'/>" style="height: 300px">				
				</div>
					<label for="commprofileimgbtn" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-picture"> Upload Photo</span></label>
					<input type="file" id="commprofileimgbtn" style="display: none;"><br> 
					
					<div class="form-group">
						<label class="control-label col-sm-3">Admin ID:</label>
						<div class="col-sm-5">
							<p class="form-control-static">${commadmininfo.user_id }</p>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Nickname:</label>
						<div class="col-sm-5">
							<p class="form-control-static">${commadmininfo.user_nickname }</p>
						</div>
					</div>
	
					<label>Community Name:</label>
					<input type="email" class="form-control" name="comm_name" value=${comminfo.comm_name }>
				
					<label>상태메세지:</label>
					<textarea class="form-control" rows="3" name="comm_content">${comminfo.comm_content }</textarea>		
				</div>
			</form>			
		</div>
	</div>
</div>
<script>
	$("#commskinmodifybtn").on("click",function(){
		alert("와이제 시작인가?");
	});
</script>
