<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- //////////////////신고관리 페이지	//////////////////////	 -->
<div class="text-center">
<a href="acinsert">작성</a>
<h1 id="convertform">신고관리</h1> 
</div><br>
<div id="aclistview1">
	<c:forEach var="accuse" items="${aclist }">
		<div style="width: 30%; height: 100%;" class="pull-right">
			<div>
			신고인 :<a data-toggle="modal" data-target="#accuse_user" class="accuse_user" id="${accuse.user1_num}"> ${accuse.user1_nickname}</a>	
			</div>
			<div>
								<h5>신고접수내용</h5>
					<p><strong>${accuse.ac_reason}</strong></p>
			</div>
			<div>
			신고대상 :<a data-toggle="modal" data-target="#accuse_user" class="accuse_user" id="${accuse.user2_num}"> ${accuse.user2_nickname}</a>
			</div>	
			<div>
				<button class="btn btn-md btn-warning">확인</button>
					<button class="btn btn-md btn-danger" onclick="return acdeletecheck(${accuse.ac_num})">삭제</button>
			</div>	
		</div>
	
<%-- 		<div class="col-sm-4 col-xs-12">
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
					<button class="btn btn-md btn-danger" onclick="return acdeletecheck(${accuse.ac_num})">삭제</button>
				<br><br>
			</div>
		</div> --%>
	</c:forEach>
	<div>
		<ul class="pagination">
			<li class="previous"><a href="#"><i class="glyphicon glyphicon-triangle-left"></i></a></li>
			<c:forEach var="i" begin="${apu.startpagenum }" end="${apu.endpagenum }">
				<li><a href="<c:url value='/aclist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">${i }</a></li> 
			</c:forEach>
			<li class="next"><a href="#"><i class="glyphicon glyphicon-triangle-right"></i></a></li>
			<li></li>
		</ul>				
	</div>
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
				<td><button class="btn btn-md btn-danger" onclick="return acdeletecheck(${accuse.ac_num})">삭제</button></td>
			</tr>
		</c:forEach>	
	</table>
	<div>
		<ul class="pagination">
			<li class="previous"><a href="#"><i class="glyphicon glyphicon-triangle-left"></i></a></li>
			<c:forEach var="i" begin="${apu.startpagenum }" end="${apu.endpagenum }">
				<li><a href="<c:url value='/aclist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">${i }</a></li> 
			</c:forEach>
			<li class="next"><a href="#"><i class="glyphicon glyphicon-triangle-right"></i></a></li>
			<li></li>
		</ul>				
	</div>	
</div>

<!--  /////////////////////////////신고된 사용자 정보 ////////////////////////////////////-->
 
<div class="modal" id="accuse_user">
	<div class="modal-dialog1">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">신고</h4>
			</div>
			<div class="modal-body" id="userinfobody">
			
			</div>
		</div>
	</div>
</div>
<script id="userinfotemlpate" type="text/template">
<form class="form-horizontal" action="{mburl}" method="post">	
	<input type="hidden" class="form-control" value={user_num} name="user_num">
	<div class="form-group">
		<label class="control-label col-sm-2">ID:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" readonly="readonly" value={acc_id}>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">NickName:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" readonly="readonly" value={acc_nick}>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Email:</label> 
		<div class="col-sm-10">
			<input type="text" class="form-control" readonly="readonly" value={acc_email}>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">가입일:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" readonly="readonly" value={acc_date}>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">상태정보:</label>
		<div class="col-sm-10">
			<select class="form-control" name="user_status">
				<option value="1">1번 정상</option>
				<option value="2">2번 기간정지</option>
				<option value="3">3번 정지</option>
			</select>
		</div>
	</div>
		<div class="modal-footer">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
			var user_num=event.target.id;
			$.getJSON("<c:url value='/mbgetinfo'/>",{
				user_num : user_num
			},function(data){
				alert(data.user_id);
 				var html=document.querySelector("#userinfotemlpate").innerHTML;
				alert(html)
 				var resultHTML=html.replace("{mburl}","<c:url value='/mbupdate'/>")
 					.replace("{acc_id}", data.user_id)
   					.replace("{user_num}", user_num)
 					.replace("{acc_nick}", data.user_nick)	
					.replace("{acc_stat}", data.user_stat)
					.replace("{acc_email}", data.user_email)
					.replace("{acc_date}",data.user_date);				
				alert(resultHTML);
				$("#userinfobody").append(resultHTML);
				console.log(data.user_stat)
				$("select[name=user_status] option[value="+data.user_stat+"]").prop("selected",true);
			});
		});		
	});
	function acdeletecheck(ac_num){
		var result=confirm("정말로????");
		if(result==true){
			location.href="acdelete?ac_num="+ac_num;
			return true;
		}else{
			return false;
		}
	}
</script>
 
