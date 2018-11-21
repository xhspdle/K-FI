<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

/*   스킨  관련   */
#modifycnskin{
	width: 85%;
	height: 80%;
	max-height: 80%;
	background-color: #f0f0f5;
	border-radius: 8px;
	margin-top: 5%;
}
.communityskinimg{
	background-color: red;
	max-height: 400px;
}
#cnskincover{
	width :100%; 
	max-height: 400px; 
	background-position: center;   
	background-repeat: no-repeat;  
	background-size: cover;
}
#commskinlist{
	box-shadow: 0px 0px 7px #a6a6a6;
	border-radius: 5px;
}
</style>
<div class="container">
	<div class="btn-group">
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commprofile'">PROFILE</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commskin'">SKIN</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commuserlist'">MEMBERS</button>
	</div><!-- <br><br> -->
	<div id="commskinlist">
		<div class="panel-heading" >
			저장된 스킨	
		</div>
		<div class="panel-body">
			<div class="communityskin" >
				<div class="communityskinimg">				
					<img id="cnskincover" alt="cover">
				</div>	
				<div style="background-color: green;" id="navskin">
					<p>This is some text.</p>
					<p>This is another text.</p>
				</div>
			</div> 
		</div>
	</div>
</div>
<div id="modifycnskin" class="modal container">
		<div class="modal-header">
	<h3>수정하기</h3>
	</div>
	<form method="post" action="#" name="cnskinfrm">

		<div class="file_input_div">
			<button class="btn btn-info">배경 사진</button>
			<input type="file" name="comm_skin_cover" style="display: none;">
			<button class="btn btn-info">nav바 색상</button>
			<input type="color" name="comm_skin_color" style="display: none;">	
		</div>
		<div class="btn-group pull-right">
			<input type="submit" class="btn btn-default " value="적용">
			<input type="submit" class="btn btn-default " value="수정">
			<input type="submit" class="btn btn-default " value="삭제">
			<input type="submit" class="btn btn-default " value="초기화">
		</div>
		
	</form>
</div>


<script>
	$(function(){
		$(".navbar").css("display","block");
		$(".communityskin").attr({'data-toggle':'modal','data-target':'#modifycnskin'});
		$(".communityskin").click(function(){
			$("#currskin").empty();
			$(this).clone().appendTo($("#currskin"));
		});
	});
	$(".file_input_div button").on("click",function(event){
		event.preventDefault();
		$(this).next().click();
	});	
	$("input[name=comm_skin_cover]").on("change",function(event){
 	 	var cnskincover=$("#currskin").children().children().children("img").eq(0); 
 	 	cnskincover.prop("src",URL.createObjectURL(event.target.files[0]));
	});
	$("input[name=comm_skin_color]").on("change",function(event){
		var color=$(this).val();
		var navbar=$("#currskin").children().children().eq(1);
		navbar.css("background-color",color);
	});
	
</script>