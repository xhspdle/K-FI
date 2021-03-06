<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div style="width: 100%;">
	<c:choose>
		<c:when test="${!empty list }">
			<c:forEach var="vo" items="${list }">
				<div class="w3-third" style="width: 33%; padding: 0.8%;">
					<div class="w3-card"
						style="height: 100px; border-radius: 25px; background-color:${vo.cs_color};overflow: hidden;">
						<div class="myFriendContainer">
						<a href="#" style="text-decoration: none;">
						  <img src="<c:url value='/resources/upload/img/${vo.csp_savimg}'/>">
						  <p><span><b> ${vo.comm_name }</b></span>
						  <br><span style="font-size: 15px;">${vo.comm_content }</span></p>
						</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach var="clist" items="${clist }">
				<c:forEach var="csplist" items="${csplist }">
					<c:if test="${clist.comm_num == csplist.comm_num }">
					<div class="w3-third" style="width: 33%; padding: 0.8%;">
						<div class="w3-card"
							style="height: 100px; border-radius: 25px; background-color:${clist.cs_color};overflow: hidden;">
							<div class="myFriendContainer">
							<a href="<c:url value='/community?comm_num=${clist.comm_num }'/>" style="text-decoration: none;">
							  <img src="<c:url value='/resources/upload/img/${csplist.csp_savimg}'/>">
							  <p><span><b> ${clist.comm_name }</b></span>
							  <br><span style="font-size: 15px;">${clist.comm_content }</span></p>
							</a>
							</div>
						</div>
					</div>
					</c:if>
				</c:forEach>
			</c:forEach>
		</c:otherwise>
	</c:choose>
		
	</div>
</div>
    
    