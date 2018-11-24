<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
* {box-sizing: border-box}
body {font-family: Verdana, sans-serif; margin:0}
.mySlides {display: none}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .prev, .next,.text {font-size: 11px}
}


/*   스킨  관련   */
/* #modifycnskin{
	width: 85%;
	height: 80%;
	max-height: 80%;
	background-color: white;
	border-radius: 8px;
	margin-top: 5%;
} */
.communityskinimg{
	max-height: 400px;
}
.cnskincover{
	width :100%; 
	max-height: 400px; 
	background-position: center;   
	background-repeat: no-repeat;  
/* 	background-size: cover; */
}
#commskinlist{
	box-shadow: 0px 0px 7px #a6a6a6; 
	border-radius: 5px;
}
.navskincolor{
	margin-right: 20px;
	color:white;
}

</style>
<div class="container">
	<div class="btn-group">
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commprofile?comm_num=${comm_num}'">PROFILE</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commskin?comm_num=${comm_num}'">SKIN</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commuserlist?comm_num=${comm_num}'">MEMBERS</button>
	</div><!-- <br><br> -->
	<div id="commskinlist">
		<div class="modal-header"
		style="background-color: #0c558d;border-top-left-radius: 5px;border-top-right-radius: 5px;">
			<h4 style="display: inline;color: white;">저장된 스킨</h4>
			<div class="btn-group pull-right">
				<button type="button" class="btn btn-success" id="insertcnskinbtn">추가</button>
				<button type="button" class="btn btn-success">적용</button>
				<button type="button" class="btn btn-danger" id="deletecnskinbtn">삭제</button>
			</div>
		</div>
		<div class="slideshow-container">
			<c:forEach var="commskinlist" items="${commskinlist }">
			<div class="panel-body mySlides">
				<div class="communityskin" >
					<input type="text" value="${commskinlist.csc_num}">	
					<div class="communityskinimg">				
						<img class="cnskincover" alt="cover" src="<c:url value='/resources/upload/img/${commskinlist.csc_savimg}'/>">
					</div>		
					<div style="background-color: ${commvo.cs_color}; padding:5px;" id="navskincol">
						<span><img class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/logo0-1.png'/>"></span>
						<div class="pull-right " style="margin-top: 10px;">
							<span class="navskincolor">COMMUNITY</span>
							<span class="navskincolor">MYPAGE</span>
							<span class="glyphicon glyphicon-search navskincolor"></span>
						</div>	
					</div>
				</div> 
			</div>
			</c:forEach>	
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
			<a class="next" onclick="plusSlides(1)">&#10095;</a>
		</div>
		<div style="text-align:center">
			<span class="dot" onclick="currentSlide(1)"></span> 
			<span class="dot" onclick="currentSlide(2)"></span> 
			<span class="dot" onclick="currentSlide(3)"></span> 
			<span class="dot" onclick="currentSlide(4)"></span> 
			<span class="dot" onclick="currentSlide(5)"></span> 
			<span class="dot" onclick="currentSlide(6)"></span> 
			<span class="dot" onclick="currentSlide(7)"></span> 
		</div><br> 
	</div>	
</div>

<div id="modifycnskin" class="modal" style="margin-top: 5%;">
	<div class="modal-content container">
		<div class="modal-header">
			<h3>수정하기</h3>
		</div>
		<div class="modal-body">
			<form class="form-horizontal" method="post" action="#" name="cnskinfrm">
				<div id="currskin" class="form-group">
				
				</div>
				<div class="file_input_div form-group">
					<button class="btn btn-info">배경 사진</button>
					<input type="file" name="csc_orgimg" style="display: none;">
					<button class="btn btn-info">nav바 색상</button>
					<input type="color" name="cs_color" style="display: none;">
					<div class="btn-group pull-right form-group" style="margin-right: 10px">
						<input type="submit" class="btn btn-primary" value="저장">
						<input type="submit" class="btn btn-primary" data-dismiss="modal" value="닫기">
					</div>
				</div>	
			</form>
		</div>
	</div>
</div>

<div id="insertcnskin" class="modal" style="margin-top: 5%;">
	<div class="modal-content container">
		<div class="modal-header">
			<h3>스킨추가하기</h3>
		</div>
		<div class="modal-body">
			<form class="form-horizontal" method="post" action="<c:url value='/community/commadmin/commskininsert'/>" id="insertcnskinfrm" enctype="multipart/form-data">
				<div id="insertskin" class="form-group">
					<div class="panel-body">
						<div class="communityskin" >
							<div class="communityskinimg" style="height: 400px; background-color: #00cee8">				
								<img class="cnskincover">
							</div>		
							<div style="background-color: ${commvo.cs_color}; padding:5px;" id="navskincol">
								<span><img class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/logo0-1.png'/>"></span>
								<div class="pull-right " style="margin-top: 10px;">
									<span class="navskincolor">COMMUNITY</span>
									<span class="navskincolor">MYPAGE</span>
									<span class="glyphicon glyphicon-search navskincolor"></span>
								</div>	
							</div>
						</div> 
					</div>
				</div>
				<div class="file_input_div form-group">
				    <input type="hidden" name="comm_num" value=${comm_num }>
					<button class="btn btn-info">배경 사진</button>
					<input type="file" name="csc_orgimg" style="display: none;">
					<button class="btn btn-info">nav바 색상</button>
					<input type="color" name="cs_color" style="display: none;">
					<div class="btn-group pull-right form-group" style="margin-right: 10px">
						<input type="submit" class="btn btn-primary" value="추가">
						<input type="button" class="btn btn-primary" data-dismiss="modal" value="닫기" id="cloinsertcnskinbtn">
					</div>
				</div>	
			</form>
		</div>
	</div>
</div>

<script>
	$(function(){
		$(".navbar").css("display","block");
		$(".communityskin").attr({'data-toggle':'modal','data-target':'#modifycnskin'});
		$("#insertcnskinbtn").attr({'data-toggle':'modal','data-target':'#insertcnskin'});
		
		
		$(".communityskin").click(function(){
			$("#currskin").empty();
			$(this).clone().appendTo($("#currskin"));
		});
		$("#currskin").on("click",function(){
			return false;
		});
		$("#insertskin").on("click",function(){
			return false;
		});
		
	});
	$(".file_input_div button").on("click",function(event){
		event.preventDefault();
		$(this).next().click();
	});	
	$("input[name=csc_orgimg]").on("change",function(event){
		console.log($(this).closest("form").find(".cnskincover"));
		var cnskincover=$(this).closest("form").find(".cnskincover");
 	 	/* var cnskincover=$("#currskin").children().children().children("img").eq(0); */ 
 	 	cnskincover.prop("src",URL.createObjectURL(event.target.files[0]));
 		$("#cloinsertcnskinbtn").on("click",function(){
 			cnskincover.prop("src","");
 		});
	});
	$("input[name=cs_color]").on("change",function(event){
		var color=$(this).val();
		var navbar=$(this).closest("form").find("#navskincol");
	/* 	var navbar=$("#currskin").children().children().eq(1); */
		navbar.css("background-color",color);
	});
	$("#insertcnskinbtn").on("click",function(){
		alert("wow");	
	});
	
	$("#deletecnskinbtn").on("click",function(){
		alert("wow");	
	});
	

	var slideIndex = 1;
	showSlides(slideIndex);

	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}

	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}

	function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  if (n > slides.length) {slideIndex = 1}    
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";  
	  }
	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " active";
	}
	
</script>