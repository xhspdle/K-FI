<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container w3-panel w3-border w3-round-xlarge"  >
	<div class="col-sm-offset-2" style="background-color: white;width:20%;height:10%;">
	<h2>My Skin</h2>
	</div>
	<!-- 미리보기 설정(js) -->
	<div class="jumbotron col-sm-offset-2" id="preview_cover">
		<div>
			<img src="<c:url value='/resources/images/default-profile.png'/>" alt="new profile" 
			class="img-circle" id="profile_preview" style="margin-top: 60px;width: 150px;height: 150px;background-color: white;
			display: block;margin-left: auto;margin-right: auto;"><br>
			<p><span id="preview_msg" style="width: max-content;color:black;border-bottom: 2px solid white;display: block;margin-left: auto;margin-right: auto;">상태메세지 미리보기</span></p> 
			<div class="collapse navbar-collapse" id="preview_navbar" >
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#contact">COMMUNITY</a></li>
					<li class="dropdown">
						<a href="#contact">MYPAGE</a>
						<ul class="dropdown-menu">
							<li><a href="#contact">글쓰기</a></li>
							<li><a href="#contact">마이커뮤니티</a></li>
							<li><a href="#contact">일정보기</a></li>
							<li><a href="#contact">MYSKIN</a></li>
							<li><a href="#contact">회원정보</a></li>
							<li><a href="#contact">로그아웃</a></li>
						</ul>
					</li>
					<li><button type="button" class="btn btn-default btn-lg">
					<span class="glyphicon glyphicon-search"></span></button></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 등록 -->
  	<form class="form-horizontal" enctype="multipart/form-data" method="post" action="<c:url value='/mypage/myskin/insert'/>">
    	<div class="form-group">
    		<label class="control-label col-sm-2" for="skinname">스킨명:</label>
    		<div class="col-sm-5"> 
    		  <input type="text" class="form-control" id="ms_name" name="ms_name">
      		</div>
      		<label class="control-label col-sm-2" for="color">배경색:</label>
      		<div class="col-sm-3"> 
      			<input type="color" id="ms_color" name="ms_color">
        	</div>
    	</div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="msg">상태메세지:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control" id="ms_msg" name="ms_msg">
	      </div>
	    </div>
        <div class="form-group">
	      <label class="control-label col-sm-2" for="msg">프로필 사진:</label>
	      <div class="col-sm-10">   
	        <input type="file" class="form-control" id="ms_profile" name="ms_file">
	      </div>
   		</div>
        <div class="form-group">
	      <label class="control-label col-sm-2" for="msg">커버 사진:</label>
	      <div class="col-sm-10">          
	        <input type="file" class="form-control"  id="ms_cover" name="ms_file">
	      </div>
    	</div>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">등록</button>
	      </div>
	    </div>
  </form>
</div>