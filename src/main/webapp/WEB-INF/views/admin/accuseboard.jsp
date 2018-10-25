<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="text-center">
	<h1 id="convertform">신고관리</h1> 
	</div><br>
<div id="aclistview1">
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
<div id="aclistview2" class="hidediv">
	<table class="table table-striped">
		<tr>
			<th>신고번호</th>
			<th>신고내용</th>
			<th>신고대상</th>
			<th>신고인</th>
			<th>확인</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="accuse" items="${aclist }">
			<tr>
				<td>${accuse.ac_num}</td>
				<td>${accuse.ac_reason}</td>
				<td>${accuse.user1_num}</td>
				<td>${accuse.user2_num}</td>
				<td><button class="btn btn-md btn-warning">확인</button></td>
				<td><button class="btn btn-md btn-danger">삭제</button></td>
			</tr>
		</c:forEach>	
	</table>
</div>

<script type="text/javascript">
	$(function(){
		$("#convertform").click(function(){
			if($("#aclistview1").css("display")=="block"){
				$("#aclistview1").css("display","none");
				$("#aclistview2").css("display","block");
			}else{
				$("#aclistview1").css("display","block");
				$("#aclistview2").css("display","none");
			}
		});
	});
</script>
