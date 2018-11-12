<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>저장된 스킨</h1>
<div class="container" style="background-color: yellow; padding: 20px" >
	<div class="communityskin" >
		<div style="background-color: red;max-height: 400px ;">
			
				
				
			<div class="text-center">
			<img id="cnskincover" alt="alt 텍스트" style="width :150px; max-height: 150px;  background-position: center;" > 
				<!-- <img id="cnskincover"  style="width: 200px; heigh : 150px; border: 3px solid gold; border-radius: 150px;background-position: center;"> -->		
			</div>
				
				
				
				
				
				<!-- <img id="cnskincover" alt="alt 텍스트" style="width :150px; max-height: 150px;  background-position: center;" > -->
			
			<img id="cnskincover" alt="alt 텍스트" style="width :100%; max-height: 400px;  width: auto;  background-position: center;   background-repeat: no-repeat;  background-size: cover; overflow: hidden;" >
		</div>	
		<div style="background-color: green;" id="navskin">
			<p>This is some text.</p>
			<p>This is another text.</p>
		</div>
	</div>
	<div class="communityskin" >
		<div style="background-color: blue;max-height: 400px ; width: auto;">
			<img alt="alt 텍스트" style="width :100%; max-height: 400px;  width: auto;  background-position: center;   background-repeat: no-repeat;  background-size: cover; overflow: hidden;" >
		</div>	
		<div style="background-color: white;" id="navskin">
			<p>This is some text.</p>
			<p>This is another text.</p>
		</div>
	</div>
</div>

<div id="modifycnskin" class="modal container" style="width: 90%;height: 90%; background-color: #f0f0f5; border-radius: 8px; margin-top: 3%">
	<form method="post" action="#" name="frm">
		<div id="currskin" style="padding: 20px;">
			
		</div>
		스킨커버파일<input type="file" accept="image/*" onchange="loadFile()">
		프로필파일<input type="file">
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
	var loadFile = function() {
	 	var skincover=$("#currskin").children().children().children("img");
		skincover.prop("src",URL.createObjectURL(event.target.files[0]));
	};
</script>