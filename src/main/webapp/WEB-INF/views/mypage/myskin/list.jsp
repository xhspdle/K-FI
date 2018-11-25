<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="myskin">
	<div style="margin:auto;background-color: #00cee8;">
	    <div class="dropdown">
	    	<div style="padding: 1%;padding-left: 43%;">
		    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="padding: 6px 78px;">My Skin
		    <span class="caret"></span></button>
		    <ul class="dropdown-menu" style="top: auto;left: auto;">
		      <c:forEach var="list" items="${msvlist }">
			    	 <li id="${list.ms_num }"><a href="#contact">${list.ms_name }</a></li>
			    </c:forEach>
		    </ul>
		    <input type="hidden" id="myskinColorOne" value="${msv.ms_color }">
		    <a class="myskin_ud_add" href="<c:url value='/mypage/myskin/insertForm' />" >Add</a>
			<a class="myskin_ud_default" href="<c:url value='/mypage/myskin/default' />">Default</a>
		    </div>
		  </div>
	</div>
		<span style="position:absolute;right:-10px;z-index:99;float:right;width: 18%;display: flex;margin-right: 17%;margin-top: 3%;}">
			<!-- class="myskin_ud" -->
			<a  href="#" id="applyMySkin" class="myskin_ud_add" style="display:none;">적용</a>&nbsp;
			<a  href="#" id="updateMySkin" class="myskin_ud_add" style="display:none;">수정</a>&nbsp;
			<a  href="#" id="deleteMySkin" class="myskin_ud_add" style="display:none;">삭제</a>&nbsp;
		</span>
		
		<div class="container">
		<div id="new_community" >
		<div class="w3-row-padding w3-margin-top" style="height:370px;">
			<div class="w3-third" style="width: 80%;margin-left: 10%;">
				<div class="w3-card" id="noneCover" style="display:none !important;">
				<div class="pre_cover center-block" id="myskin_list_cover">
					<img id="profile_preview" class="img-responsive img-circle" src="<c:url value='/resources/images/default-profile.png'/>">
					<h4><span id="myskin_list_nickname" >${user_nickname}</span></h4>
   					<span id="myskin_list_msg" style="width: max-content;color:white;border-bottom: 2px solid white;display: block;margin-left: auto;margin-right: auto;margin-top: -25px;"></span>
     			</div>
						<div class="w3-container" style="padding: 0;">
						<div class="collapse navbar-collapse" id="myskin_list_nav" style="display:none !important;">
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
									<a href="#contact">COMMUNITY</a>
								</li>
								<li class="dropdown">
									<a href="#contact">MYPAGE</a>
								</li>
								<li><button type="button" class="btn btn-default btn-lg" id="myskin_list_icon" >
								<span class="glyphicon glyphicon-search"></span></button></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	<br>
</div>
</div></div>
