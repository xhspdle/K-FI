<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>저장된 스킨</h1>

<div id="commskinlist" class="panel panel-default">
	<div class="panel-heading" >	
		<a href="#myPage"><img style="width:50px; height:50px;border-radius:50px;" class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/1 (1).jpg'/>"></a>
		${faqlist.user_num }
		${faqlist.qa_title }		
	</div>
	<div class="panel-body">
		<div class="communityskin" >
			<div class="communityskinimg">				
				<img id="cnskinprofile" alt="profile">
				<img id="cnskincover" alt="cover">
			</div>	
			<div style="background-color: green;" id="navskin">
				<p>This is some text.</p>
				<p>This is another text.</p>
			</div>
		</div> 
	</div>
</div>

<div id="modifycnskin" class="modal container">
		<div class="modal-header">
	<h3>수정하기</h3>
	</div>
	<form method="post" action="#" name="cnskinfrm">
		<div id="currskin" style="padding: 20px;" >			
		
		</div>
		<div class="file_input_div">
			<button class="btn btn-info">프로필 사진</button>
			<input type="file" name="comm_skin_profile">
			<button class="btn btn-info">배경 사진</button>
			<input type="file" name="comm_skin_cover">
			<button class="btn btn-info">nav바 색상</button>
			<input type="color" name="comm_skin_color">	
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
			/* $(".navbar").css("display","none"); */
			$("#currskin").empty();
			$(this).clone().appendTo($("#currskin"));
		});
	});
	$(".file_input_div button").on("click",function(event){
		event.preventDefault();
		$(this).next().click();
	});	
	$("input[name=comm_skin_profile]").on("change",function(event){
		var cnskinprofile=$("#currskin").children().children().children("img").eq(0); 
		cnskinprofile.prop("src",URL.createObjectURL(event.target.files[0]));
	});
	$("input[name=comm_skin_cover]").on("change",function(event){
 	 	var cnskincover=$("#currskin").children().children().children("img").eq(1); 
 	 	cnskincover.prop("src",URL.createObjectURL(event.target.files[0]));
	});
	$("input[name=comm_skin_color]").on("change",function(event){
		var color=$(this).val();
		var navbar=$("#currskin").children().children().eq(1);
		navbar.css("background-color",color);
	});
	
</script>