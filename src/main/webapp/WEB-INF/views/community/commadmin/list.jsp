<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
tbody tr{
	cursor: pointer;
}
tbody tr:nth-child(2n+1) {
 	background-color: #e3f2fd;
}

</style>

<div id="commuserlist">
	<div class="container">
		<!-- <button class="btn btn-md" onclick="location.href='/kfi/adminlist'">관리자정보</button> -->
		<div class="btn-group">
			<button type="button" class="btn btn-primary">MEMBERS</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/communityskin'">SKIN</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<br><br>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nickname</th>
					<th>Email</th>
					<th>Status</th>
		 	<!-- 		<th>권한양도</th>  -->
					<th>강퇴</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="commuserlist" items="${commuserlist }">
				<tr>
					<td hidden="hidden">${commuserlist.user_num }</td>
					<td class="commuser">${commuserlist.user_id}</td>
					<td class="commuser">${commuserlist.user_nickname}</td>
					<td class="commuser">${commuserlist.user_email}</td>
					<td class="commuser">${commuserlist.cul_status}</td>
					<td><button type="button" class="btn btn-danger btn-sm commforcedexit">강퇴</button></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<div class="modal" id="commforcedexitform">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #e3f2fd">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
					<div style="font-size: 20px; font: bold;">사용자 강퇴</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" class="form-control" name="user_num">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<!-- <input type="text" class="form-control" name="user_id" readonly="readonly" style="background-color: white"> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<!-- <input type="text" class="form-control" name="user_nickname" readonly="readonly"> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Email:</label>
						<div class="col-sm-10">
							<!-- <input type="text" class="form-control" name="user_email" readonly="readonly"> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">사유:</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="4"></textarea> 
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default" data-dismiss="modal">작성</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="commusermodify">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #e3f2fd">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">사용자 수정</h4>
			</div>
			<div class="modal-body">
				<div class="form-horizontal">
					<input type="hidden" class="form-control" name="user_num"
						id="modifyuser_num">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_id" readonly="readonly" id="modifyuser_id">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_nickname"
								id="modifyuser_nickname">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_email"
								id="modifyuser_email">
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="btn-group pull-left">
								<button type="button" class="btn btn-primary">관리자권한양도</button>
								<button type="button" class="btn btn-danger">강퇴</button>	
							</div>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		$(".commuser").attr({'data-toggle':'modal','data-target':'#commusermodify'});
		$(".commforcedexit").attr({'data-toggle':'modal','data-target':'#commforcedexitform'});
		
		$(".commforcedexit").on("click",function(){
			alert("bbb");
			var str="";
			var tdArr=new Array();
			var tr=$(this).closest('tr');
			var td=tr.children();
			console.log(tr.text());
			$("#commforcedexitform").
			td.each(function(i){
				tdArr.push(td.eq(i).text());
			});
			
		});
		
		$(".commuser").click(function(){
			alert("aaa");
			console.log($(this).parent().children().first().text());		
			var user_num=$(this).parent().children().first().text();
		 	$.getJSON("<c:url value='/mbgetinfo'/>",{
				user_num : user_num
			},function(data){			
				$("#modifyuser_num").val(user_num);
				$("#modifyuser_id").val(data.user_id);
				$("#modifyuser_pwd").val(data.user_pwd);
				$("#modifyuser_nickname").val(data.user_nick);
				$("#modifyuser_email").val(data.user_email);
				$("select[name=user_status] option[value="+data.user_stat+"]").prop("selected",true);
			}); 
		});
		$(".userdelete").click(function(){
			var result=confirm("정말로????");
			var user_num=$(this).parent().parent().children().first().text();
 			if(result){
				location.href="mbdelete?user_num="+user_num;
			}else{
				return false;
			}
		});
	});



</script>