<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<br>
	<h2>My Community</h2>
	<span style="margin-top: -5%; display: table-cell; float: right;">
		<a href="<c:url value='/mypage/mycomm/list'/>">
			<button class="w3-btn w3-black w3-round-xxlarge"
				style="background-color:${msv.ms_color} !important;">전체</button>
	</a> <a href="<c:url value='/mypage/mycomm/list?commAdmin=true'/>">
			<button class="w3-btn w3-black w3-round-xxlarge"
				style="background-color:${msv.ms_color} !important;">관리 중인
				커뮤니티</button>
	</a> <a href="<c:url value='/mypage/mycomm/list?commAdmin=false'/>">
			<button class="w3-btn w3-black w3-round-xxlarge"
				style="background-color:${msv.ms_color} !important;">가입한
				커뮤니티</button>
	</a>
	</span>
	<!-- class="w3-row-padding w3-margin-top" -->
	<div style="width:100%;">
		<c:forEach var="list" items="${list }">
			<c:forEach var="csplist" items="${csplist }">
				<c:if test="${list.comm_num == csplist.comm_num }">
					<div class="w3-third" style="width:33%;padding: 0.8%;">
						<div class="w3-card" style="height: 300px;">
							<!-- 해당 커뮤니티 페이지로 이동하기 -->
							<a href="<c:url value='/community?comm_num=${list.comm_num }'/>">
								<img src="<c:url value='/resources/upload/img/${csplist.csp_savimg}'/>"
								style="height: 78%;width: 100%">
							</a>
							<div class="w3-container"
								style="background-color:${list.cs_color}">
								<h4>
									<b>${list.comm_name }</b>
								</h4>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</c:forEach>
	</div>

</div>