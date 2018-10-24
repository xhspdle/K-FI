<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="pricing">
	<div class="text-center">
		<h2>신고관리</h2>
	</div>
	<c:forEach var="accuse" items="${aclist }">
		<div>
			<div class="col-sm-4 col-xs-12">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<div>신고접수내용</div>
					</div>
					<div class="panel-body">
						<p><strong>${accuse.ac_reason}</strong></p>
					</div>
					<div class="panel-footer">
						<h4>신고대상 : ${accuse.user1_num}</h4>
						<h4>신고인 : ${accuse.user2_num}</h4>
					</div>
					<button class="btn btn-md btn-warning">확인</button>
					<button class="btn btn-md btn-danger">삭제</button>
					<br><br>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

