<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>



</style>
<h1>리스트</h1>
<div id="boardcontentimg" class="modalimg">
	<span class="closeimg">&times;</span>
	<img class="board-content-img" id="contentimg">
	<div id="caption"></div>
</div>

<div class="flexrow">
	<div class="flexcolumn"></div>
	<div class="flexcolumn"></div>
	<div class="flexcolumn"></div>	
</div>


<script id="testboardlist" type="text/template">

<div class="board_content_ad">
	<div class="media">
		<div class="media-left media-top">
			<img src="img_avatar1.png" class="media-object" style="width:60px">
		</div>
		<div class="media-body">
		<h4 class="media-heading">Media Top</h4>
			<p>Lorem ipsum...</p>
		</div>
	</div>
	<img src="<c:url value='/resources/images/ysy/1 ({imgnum}).jpg'/>">
	내용<br>
	<a >답글</a><br>
	<input type="text">
	<input type="submit" value="작성">
</div>
<br>
</script>
<script>
$(function(){	
	$(".flexcolumn").empty();
	var length=($(".flexrow").children().length);
	console.log(length+"length")
	var j=0;
	
	for(var i=1;i<=20;i++){	//6 10 14
		var flaxcol=$(".flexrow").children().eq(j);
		var html=$("#testboardlist").html();
	 	var resulthtml=html.replace("{imgnum}",i);
		flaxcol.append(resulthtml);
		console.log("그냥 j"+j);
/*  		var last=flaxcol.children().last().offset();  나중에 사용*/
		console.log(flaxcol.children().length);
		console.log(flaxcol.children());
		if(j<length-1){ 		//다나옴
			j++;
		}else{		
			j=0;
			console.log("if문 j"+j);
		}
	};
	$($(".board_content_ad").children("img")).click(function(){
		console.log($(".board_content_ad").children("img"));
		alert("이미지 클릭");
		var src=$(this).prop("src");
		$("#contentimg").prop("src",src);
		$(".modalimg").css("display","block");
		$(".navbar").css("display","none");
		$('.modalimg').off();
	})
});

var closeimg = document.getElementsByClassName("closeimg")[0];

//When the user clicks on <span> (x), close the modalimg
closeimg.onclick = function() { 
	$(".modalimg").css("display","none");
	$(".navbar").css("display","block");
}

</script>