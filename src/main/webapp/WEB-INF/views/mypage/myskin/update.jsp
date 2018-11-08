<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container w3-panel w3-border w3-round-xlarge"  >
	<div class="col-sm" style="background-color: white;width:20%;height:10%;">
	<h2>My Skin Update</h2>
	</div>
	<!-- 미리보기 설정(js) -->'
	<c:if test="${msvlist.msc_orgimg eq null }">
		<c:set var="background" value="background-color:#00cee8;"/>
	</c:if>		
	<c:if test="${msvlist.msc_orgimg ne null}">
		<c:set var="background" value="background: url('${pageContext.request.contextPath }/resources/upload/img/${msvlist.msc_savimg }');"/>
	</c:if>
	<div class="jumbotron col-sm" id="preview_cover" 
	style="margin:auto;width:80%;${background}')">
		<div>
			<c:choose>
					<c:when test="${msvlist.msp_orgimg eq null }">
					<img id="profile_preview" src="<c:url value='/resources/images/default-profile.png'/>" class="img-circle"
						style="margin-top: 60px;width: 150px;height: 150px;background-color: white;display: block;
						margin-left: auto;margin-right: auto;">
					</c:when>
					<c:otherwise>
					<img id="profile_preview" src="<c:url value='/resources/upload/img/${msvlist.msp_savimg }'/>" class="img-circle"
						style="margin-top: 60px;width: 150px;height: 150px;background-color: white;display: block;
						margin-left: auto;margin-right: auto;">
					</c:otherwise>
				</c:choose>
			<p><span id="preview_msg" style="width: max-content;color:black;border-bottom: 2px solid white;display: block;margin-left: auto;margin-right: auto;">${msvlist.ms_msg }</span></p> 
			<div class="collapse navbar-collapse" id="preview_navbar"  style="background-color: ${msvlist.ms_color};border-radius:10px;" >
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#contact">COMMUNITY</a></li>
					<li class="dropdown">
						<a href="#contact">MYPAGE</a>
					</li>
					<li><button type="button" class="btn btn-default btn-lg" style="border:${msvlist.ms_color} ;background-color: ${msvlist.ms_color};border-radius:10px;">
					<span class="glyphicon glyphicon-search"></span></button></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 등록 -->
  	<form class="form-horizontal col-sm" enctype="multipart/form-data" method="post" action="<c:url value='/mypage/myskin/update'/>" style="width: 85%;margin:50px;">
    	<input type="hidden" name="ms_num" value="${msvlist.ms_num }">
    	<div class="form-group">
    		<label class="control-label col-sm-2" for="skinname">스킨명:</label>
    		<div class="col-sm-6"> 
    		  <input type="text" class="form-control" id="ms_name" name="ms_name" value="${msvlist.ms_name }">
      		</div>
      		<label class="control-label col-sm-1" for="color">배경색:</label>
      		<div class="col-sm-2"> 
      			<input type="color" id="ms_color" name="ms_color" value="${msvlist.ms_color }">
        	</div>
    	</div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="msg">상태메세지:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control" id="ms_msg" name="ms_msg" value="${msvlist.ms_msg }">
	      </div>
	    </div>
        <div class="form-group">
	      <label class="control-label col-sm-2" for="msg">프로필 사진:</label>
	      <div class="col-sm-10">   
	        <input type="file" class="form-control" id="ms_profile" name="ms_profile" value="${msvlist.msp_orgimg }">
	      </div>
   		</div>
        <div class="form-group">
	      <label class="control-label col-sm-2" for="msg">커버 사진:</label>
	      <div class="col-sm-10">          
	        <input type="file" class="form-control"  id="ms_cover" name="ms_cover" value="${msvlist.msc_orgimg }">
	      </div>
    	</div>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">수정</button>
	      </div>
	    </div>
  </form>
</div>