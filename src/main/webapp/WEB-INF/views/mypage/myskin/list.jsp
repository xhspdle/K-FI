<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="myskin">
	<div style="width: 126.5%;background-color: cornflowerblue;height: 80px; margin: -2% 0% 0% -21%; padding: 2% 0% 0% 50%;">
    <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="padding: 6px 78px;">My Skin
    <span class="caret"></span></button>
    <ul id="myskin_dropmenu" class="dropdown-menu" style="width: 19%;">
     	<c:forEach var="list" items="${msvlist }">
	    	 <li id="${list.ms_num }"><a href="#contact">${list.ms_name }</a></li>
	    </c:forEach>
      <li class="divider"></li>
    </ul>
   	<a class="myskin_ud_add" href="<c:url value='/mypage/myskin/insertForm' />">스킨 추가</a>
	<a class="myskin_ud_default" href="<c:url value='/mypage/myskin/default' />">기본 이미지로 변경</a>
  </div>
	</div>
		<a class="myskin_ud_apply" href="#">적용</a>
		<a class="myskin_ud_update" href="#">수정</a> 
		<a class="myskin_ud_del" href="#">삭제</a>
		<div class="pre_cover" id="myskin_list_cover" style="margin-top: 2%;background-size: cover !important;">
			<img src="" class="img-circle"
				style="margin-top: 60px;width: 150px;height: 150px;background-color: white;display: block;
				margin-left: auto;margin-right: auto; border: white 4px solid">
			<h4><span id="myskin_list_nickname">${user_nickname}</span></h4> 
			<p><span id="myskin_list_msg" style="width: max-content;color:black;border-bottom: 2px solid white;display: block;margin-left: auto;margin-right: auto;margin-top: -25px;"></span></p> 
			<div class="collapse navbar-collapse" style="border-radius:10px;" id="myskin_list_nav">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#contact">COMMUNITY</a></li>
					<li class="dropdown"><a href="#contact">MYPAGE</a></li>
					<li><button type="button" id="myskin_list_icon" class="btn btn-default btn-lg" style="border-radius:10px;" ><span class="glyphicon glyphicon-search"></span></button></li>
				</ul>
			</div>
		</div>
</div>