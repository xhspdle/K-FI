<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
/* flex */
.flexrow {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    -ms-flex-wrap: wrap; /* IE10 */
    flex-wrap: wrap;
    height: 100%;
    justify-content: center;
}

/* Create four equal columns that sits next to each other */
.flexcolumn {
    -ms-flex: 31%; /* IE10 */
    flex: 31%;
    max-width: 31%;
    margin: 0 10px;
    cursor: pointer;
}

.flexcolumn img {
    margin-top: 8px;
    vertical-align: middle;
    width: 100%;
}
.flexcolumn img:hover{
	opacity: 0.7;
}

/* Responsive layout - makes a two column-layout instead of four columns */
/* @media screen and (max-width: 1000px) {
    .flexcolumn {
        -ms-flex: 47%;
        flex: 47%;
        max-width: 47%;
        cursor: pointer;
    }
    #abpopup{
		display : none;
		width: 75%;
		max-height:100%;
	    border-radius: 10px;
	    padding: 10px;
		background-color: #efffd7;
		border: solid 3px orange; 
	}
	.logincontainer {
		position: absolute;
		max-width: 50%;
		max-height: 40%;
		top:25%;
		left:0;
		background: rgba(0, 0, 0, 0.3); 
		color: #f1f1f1;
		width: 100%;
		padding: 20px;
		border-radius: 10px;
	}
}
@media screen and (max-width: 600px) {
    .flexcolumn {
        -ms-flex: 100%;
        flex: 100%;
        max-width: 100%;
        cursor: pointer;
    }
	#abpopup{
		display : none;
		width: 80%;
		max-height:100%;
	    border-radius: 10px;
	    padding: 10px;
		background-color: #efffd7;
		border: solid 3px orange; 
	}
	.logincontainer {
		position: absolute;
		max-width: 80%;
		max-height: 40%;
		top:25%;
		left:0;
		background: rgba(0, 0, 0, 0.3); 
		color: #f1f1f1;
		width: 100%;
		padding: 20px;
		border-radius: 10px;
	}
} */
.board_content_ad{
	background-color:#f0f0f5;
	border-radius: 10px;
	padding:8px 0 8px 0;
}
.board-content-img {
    width: 100%;
    max-width: 600px;
    left: 0;
    top: 0;
}
.modalimg {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}
.closeimg {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}
.closeimg:hover,
.closeimg:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}

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
<div class=container>	
	<div class="media">
		<div class="media-left media-top">
			<img src="<c:url value='/resources/images/ysy/1 (19).jpg'/>" class="media-object" style="width:50px;height:50px;border-radius:50px">
		</div>
		<div class="media-body">
		<h4 class="media-heading">test1</h4>
			<p>집에가고싶다</p>
		</div>
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
	$
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
		$("#imgcomments").css("display","block");
	})
});

var closeimg = document.getElementsByClassName("closeimg")[0];
//When the user clicks on <span> (x), close the modalimg
closeimg.onclick = function() { 
	$(".modalimg").css("display","none");
	$(".navbar").css("display","block");
}

</script>