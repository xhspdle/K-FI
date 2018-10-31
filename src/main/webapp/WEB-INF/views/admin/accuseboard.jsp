<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- //////////////////신고관리 페이지	//////////////////////	 -->
<div class="text-center">
<h1 id="convertform">신고관리</h1> 
</div><br>
<div id="aclistview1">
	<c:forEach var="accuse" items="${aclist }">
		<div class="col-sm-4 col-xs-12">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
				신고인 :<a data-toggle="modal" data-target="#accuse_user" class="accuse_user" id="${accuse.user1_num}"> ${accuse.user1_nickname}</a>		
				</div>
				<div class="panel-body">
					<h5>신고접수내용</h5>
					<p><strong>${accuse.ac_reason}</strong></p>
				</div>
				<div class="panel-footer">
				신고대상 :<a data-toggle="modal" data-target="#accuse_user" class="accuse_user" id="${accuse.user2_num}"> ${accuse.user2_nickname}</a>		
				</div >
					<button class="btn btn-md btn-warning">확인</button>
					<button class="btn btn-md btn-danger">삭제</button>
				<br><br>
			</div>
		</div>
	</c:forEach>
	<c:forEach var="i" begin="${apu.startpagenum }" end="${apu.endpagenum }">
			<ul class="pagination">
				<li> <a href="<c:url value='/aclist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">${i }</a></li> 
			</ul>		
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
				<td class="accusecontent">${accuse.ac_num}</td>
				<td class="accusecontent">${accuse.ac_reason}</td>
				<td><a data-toggle="modal" data-target="#accuse_user" class="accuse_user" id="${accuse.user1_num}">${accuse.user1_nickname}</a></td>
				<td><a data-toggle="modal" data-target="#accuse_user" class="accuse_user" id="${accuse.user2_num}">${accuse.user2_nickname}</a></td>
				<td><button class="btn btn-md btn-warning">확인</button></td>
				<td><button class="btn btn-md btn-danger" onclick="location.href='acdelete?ac_num=${accuse.ac_num}'">삭제</button></td>
			</tr>
		</c:forEach>	
	</table>
	<c:forEach var="i" begin="${apu.startpagenum }" end="${apu.endpagenum }">
			<ul class="pagination">
				<li> <a href="<c:url value='/aclist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">${i }</a></li> 
			</ul>		
	</c:forEach>
</div>

<!--  /////////////////////////////신고된 사용자 정보 ////////////////////////////////////-->

<div class="modal modal-dialog1 " id="accuse_user">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h4 class="modal-title">Question Editor</h4>
		</div>
		<div class="modal-body" id="userinfobody">
		
		</div>
	</div>
</div>

<script id="userinfolist-temlpate" type="text/template">
	<form class="form-horizontal" action="/action_page.php">		
		<div>
			<label class="control-label col-sm-2" for="pwd">ID:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" readonly="readonly" value={acc_id}>
			</div>
		</div>


		<div>
			<label class="control-label col-sm-2">NickName:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" readonly="readonly" value={acc_nick}>
			<div>
		</div>

		<div>
			<label class="control-label col-sm-2">Status:</label>
			<select class="form-control">
				<option>정지</option>
				<option>정상</option>
				<option>경고</option>
			</select>
		</div>		
		<div>
			<label class="control-label col-sm-2">Email:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" value={acc_email}>
			</div>
		</div>
		<div>
			<label class="control-label col-sm-2">가입일:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" readonly="readonly" value={acc_date}>
			</div>
		</div>
	</form>
	
</script>
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
	$(function(){
		$(".accuse_user").click(function(event){
			alert("aaa");
	 		$("#userinfobody").empty();
	/* 		userinfobody.empty(); */
			var user_num=event.target.id;
			$.getJSON("<c:url value='/mbgetinfo'/>",{
				user_num : user_num
			},function(data){
				alert(data.acc_id);
 				html=document.querySelector("#userinfolist-temlpate").innerHTML;
				alert(html)
 				var resultHTML=html.replace("{acc_id}", data.acc_id)
   					.replace("{acc_nick}", data.acc_nick)
					.replace("{acc_stat}", data.acc_stat)
					.replace("{acc_email}", data.acc_email)
					.replace("{acc_date}",data.acc_date);
				alert(resultHTML);  
/* 				var acc_info=[
					{data.acc_id},{data.acc_nick},{data.acc_stat},{data.acc_email},{data.acc_date}	
				];
					 */
				/* 		<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Email:</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="Enter Email">
						</div>
						</div> */
				
				$("#userinfobody").append(resultHTML);
			});
		});		
	});
	$(function(){
		$("accdelte").click
	})
	
</script>
 
