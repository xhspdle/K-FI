<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title>K-FI Main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<style type="text/css">
#abpopup{
	margin: auto;
	display : none;
	position: fixed;
	width: 45%;
	max-height:100%;
	top: 50px;
    left: 50px;
    border-radius: 10px;
    padding: 10px;
	background-color: white;
	border: solid 3px orange; 
	z-index:3;
	font-weight: bold;
/*     background-image: url("../resources/images/1.png");  */
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script type="text/javascript">
	function template(ab_title,ab_content){
 		var html="<div class='well' >"
 				+"<h4 style='color:#08395e;font-weight: bold;'>"+ab_title+"</h4><hr>"
 				+"<div>"+ab_content+"</div>"
 				+"</div>"
		return html;
 	}
	$(function(){
		if(checkpopup("close")){
			$("#noticebtn").css("display","none");
		}else{
			$.getJSON("<c:url value='/admin/abpopup'/>",function(data){	
				if(data!=null && data!=""){
					$("#noticebtn").css("display","block");
				}else{
					return false;
				}
				$("#popupbtn").click(function(){
					$("#abpopupcontent").empty();
					for(var i=0;i<data.length;i++){
						var html=template(data[i].ab_title,data[i].ab_content);
						$("#abpopupcontent").append(html);					
					};
				});
			});
		};
	});
	 
 	function setCookie(name, value, expiredays){
 		var today=new Date();
 		today.setDate(today.getDate()+expiredays);
 		document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + today.toGMTString() + ";"
 	}
 	
 	function checkpopup(cookiename){
 		var cookie= document.cookie;
  		if(cookie.length>0){
 			startIndex=cookie.indexOf(cookiename);
 			if(startIndex != -1){
 				return true;
 			}else{
 				return false;
 			}
 		}else{
 			return false;
 		}	
 		return false;
 	}
 	function closepopup(){
 		setCookie("close","close",1);
 		$("#noticebtn").css("display","none");
 		$("#abpopup").css("display","none");
 	}
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>

<div id="abpopup">	
	<div class="modal-header">
		<div style="color:orange; font-size:20px; font-weight: bold">공지사항</div>	
	</div>
	<div id="abpopupcontent"></div>
	<div class="modal-footer">
		
		<input class="pull-right btn btn-default" style="width:45%" value="하루닫기" onclick="closepopup()">
		<input class="pull-right btn btn-default" style="width:45%" value="닫기"  onclick="$('#abpopup').css('display','none')"> 
		
	</div>
</div>
<div id="noticebtn" style="position: fixed;bottom: 20px;right: 20px; display: none;">
	<h1><span id="popupbtn"class="glyphicon glyphicon-exclamation-sign" style="color:gold; " onclick="$('#abpopup').css('display','block')"></span></h1> 
</div>