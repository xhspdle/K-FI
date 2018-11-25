<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

.modal-header{
	background-color: #08395e;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}
#commskinprosty{
	box-shadow: 0px 0px 7px #a6a6a6;
	border-radius: 5px;
}
</style>


<div>
	<div class="modal-dialog">
	<div class="btn-group">
		<a class="btn btn-primary" href="<c:url value='/community/commadmin/commprofile?comm_num=${comm_num}'/>">PROFILE</a>
		<a class="btn btn-primary" href="<c:url value='/community/commadmin/commskin?comm_num=${comm_num}'/>">SKIN</a>
		<a class="btn btn-primary" href="<c:url value='/community/commadmin/commuserlist?comm_num=${comm_num}'/>">MEMBERS</a>
	</div><!-- <br><br> -->
		<div id="commskinprosty"><!-- style="background-color: #f6f6ff" -->
			<form class="form-horizontal" action="commprofileupdate" method="post" id="commprofilemodify" enctype="multipart/form-data">		
			<div class="modal-header" ><!-- style="background-color: #e6e6ff" -->
				<h4 class="modal-title" style="display: inline;color: white;">프로필 수정</h4>
				<!-- <div class="btn-group  pull-right"> -->
				<button type="button" class="btn btn-success pull-right" id="commprofilemodifybtn">적용</button>
				<%-- 	<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commprofile?comm_num=${comm_num}'">초기화</button> --%>
				<!-- </div> -->
			</div>		
			<div class="modal-body">
				<div style="text-align: center;">
					<img id="commprofileimg" src="<c:url value='/resources/upload/img/${commprofile.csp_savimg}'/>" style="height: 300px;">				
				</div>
					<label for="commprofileimgbtn" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-picture"> Upload Photo</span></label>
					<input type="file" id="commprofileimgbtn" name="csp_orgimg" style="display: none;"><br> 
					
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
					<input type="hidden" name="csp_num" value=${commprofile.csp_num }>
					<input type="hidden" name="comm_num" value=${comminfo.comm_num }>
					<label>Community Name:</label>
					<input type="text" class="form-control" name="comm_name" value=${comminfo.comm_name }>		
					<label>상태메세지:</label>
					<textarea class="form-control" rows="3" name="comm_content">${comminfo.comm_content }</textarea>		
				</div>

			</form>			
		</div>
	</div>
</div>
<script>
$(function(){
	$("#commprofilemodifybtn").on("click",function(){
		var result=confirm("저장할까요???");
		if(result){
			var form=$("#commprofilemodify")[0];
			console.log(form)
			var formData=new FormData(form);
			console.log(form);
			$.ajax({
				url: "<c:url value='/community/commadmin/commprofileupdate'/>",
				type: "post",
				dataType:"json",
				data: formData,
				cache: false,
				contentType: false,
				processData: false,
				success:function(data){
					console.log(data);
				}
			});
		}else{
			return false;
		}
	});
	$("#commprofileimgbtn").on("change",function(event){ 
		$("#commprofileimg").prop("src",URL.createObjectURL(event.target.files[0]));
	});
})
	
</script>
