<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>저장된 스킨</h1>
<div class="container" style="background-color: yellow; padding: 20px" >
	<div class="communityskin" >
		<div style="background-color: red;max-height: 400px ;">				
			<img id="cnskinprofile" alt="텍스트"  style="position: relative; width :150px; max-height: 150px;  background-position: center; left: 45%; border-radius: 150px; border: solid 5px gold;">
			<img id="skincover" alt="alt 텍스트" style="width :100%; max-height: 400px;  width: auto;  background-position: center;   background-repeat: no-repeat;  background-size: cover; overflow: hidden;" >
		</div>	
		<div style="background-color: green;" id="navskin">
			<p>This is some text.</p>
			<p>This is another text.</p>
		</div>
	</div>
</div>

<div id="modifycnskin" class="modal container" style="width: 90%;height: 90%; background-color: #f0f0f5; border-radius: 8px; margin-top: 3%">
	<form method="post" action="#" name="cnskinfrm">
		<div id="currskin" style="padding: 20px;" >			
		</div>
		<div class=file_input_div>
			<button class="btn btn-info">프로필 사진</button>
			<input type="file" name="comm_skin_profile">
			<button class="btn btn-info">배경 사진</button>
			<input type="file" name="comm_skin_cover">
			<button class="btn btn-info">nav바 색상</button>
			<input type="color">
		</div>
		<input type="submit" value="적용">
	</form>
</div>


<script>
	$(function(){
		$(".navbar").css("display","block");
		$(".communityskin").attr({'data-toggle':'modal','data-target':'#modifycnskin'});
		$(".communityskin").click(function(){
			$(".navbar").css("display","none");
			$("#currskin").empty();
			alert("aaa");
			console.log($(this));
			$(this).clone().appendTo($("#currskin"));
		});
	});
	$("input[name=comm_skin_profile]").on("change",function(event){
		var cnskinprofile=$("#currskin").children().children().children("img").eq(0); 
		cnskinprofile.prop("src",URL.createObjectURL(event.target.files[0]));
	});
	$("input[name=comm_skin_cover]").on("change",function(event){
 	 	var cnskincover=$("#currskin").children().children().children("img").eq(1); 
 	 	cnskincover.prop("src",URL.createObjectURL(event.target.files[0]));
	});
	$(".file_input_div button").on("click",function(event){
		event.preventDefault();
		$(this).next().click();	
	});
	

</script>