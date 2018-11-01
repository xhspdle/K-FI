<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
<script type="text/javascript">
	$(function(){
		$(".userdelete").click(function(){
			var result=confirm("정말로????");
			var user_num=$(this).parent().parent().children().first().text();
 			if(result){
				location.href="mbdelete?user_num="+user_num;
			}else{
				return;
			}
		});
	});
	$(function(){
		$(".usercontent").attr({'data-toggle':'modal','data-target':'#usermodify'});
		$(".usercontent").click(function(){
			alert("aaaa");
			console.log($(this).parent().children().first().text());
			var user_num=$(this).parent().children().first().text();
		 	$.getJSON("<c:url value='/mbgetinfo'/>",{
				user_num : user_num
			},function(data){
				alert(data.user_id);
				console.log(data.user_id);
				$("#modifyuser_id").val(data.user_id);
				$("#modifyuser_pwd").val(data.user_pwd);
				$("#modifyuser_nickname").val(data.user_nick);
				$("#modifyuser_email").val(data.user_email);
			}); 
		});
	});
</script>
<div id="memberslist"> 
	<h1>
		회원정보
		<button class="btn btn-md" onclick="location.href='/kfi/adminlist'">관리자정보</button>
	</h1>
	<table class="table table-striped">
		<tr>
			<th>회원번호</th>
			<th>회원ID</th>
			<th>회원NICKNAME</th>
			<th>회원EMAIL</th>
			<th>가입일</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="user" items="${mblist }">
			<tr>
				<td class="usercontent" >${user.user_num}</td>
				<td class="usercontent">${user.user_id }</td>
				<td class="usercontent">${user.user_nickname }</td>
				<td class="usercontent">${user.user_email }</td>
				<td class="usercontent">${user.user_regdate }</td>
				<td><i class="glyphicon glyphicon-remove userdelete"></i></td>
			</tr>
		</c:forEach>
	</table>		
	<div class="btn-group">
		<button class="btn btn-lg" data-toggle="modal" data-target="#userinsert">등록</button>
		<button class="btn btn-lg">체크박스</button>
	</div>
	<div class="container">
	<c:forEach var="i" begin="${apu.startpagenum }" end="${apu.endpagenum }">
			<%-- <a href="<c:url value='/ablist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">
		<button type="button" class="btn btn-primary ">${i }</button></a> --%>
		<ul class="pagination">
			<li><a href="<c:url value='/mblist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">${i }</a></li>
		</ul>
	</c:forEach>
</div>
</div>

<div class="modal" id="userinsert">
	<div class="modal-dialog1">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Question Editor</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="mbinsert" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_id">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="user_pwd">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_nickname">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_email">
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>		
		</div>
	</div>
</div>
<div class="modal" id="usermodify">
	<div class="modal-dialog1">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Question Editor</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="mbmodify" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_id" readonly="readonly" id="modifyuser_id">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="user_pwd" id="modifyuser_pwd">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_nickname" id="modifyuser_nickname">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user_email" id="modifyuser_email">
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>		
		</div>
	</div>
</div>


