<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$("#adminlist_btn").click(
				function() {
					if ($("#memberslist").css("display") == "block") {
						$("#adminlist table tr:first").nextAll().empty();
						var html = document.querySelector("#adminlist-template").innerHTML;
						$.ajax({
							url : "<c:url value='/adminlist'/>",
							dataType : "json",
							success : function(data) {							
								for (var i = 0; i < data.length; i++) {
									var resultHTML= html.replace("{admin_num}", data[i].admin_num)
		 		                      					.replace("{admin_id}", data[i].admin_id)
		 		                      					.replace("{admin_nick}", data[i].admin_nick)
		 												.replace("{admin_email}", data[i].admin_email)
		 												.replace("{admin_regdate}", data[i].admin_regdate);														
									var admin_id='<c:out value="${sessionScope.admininfo.admin_id}"/>';				
									$("#adminlist table tr:last").after(resultHTML);
									if(admin_id==data[i].admin_id){
										var admin_modify_btn='<button class="btn btn-sm btn-primary" id="adminmodifybtn"' 
										+'>수정</button>';
										$("#adminlist table tr td:last").append(admin_modify_btn);					
									}
									$("#adminmodifybtn").attr({'data-toggle':'modal','data-target':'#admininfo-template'});
									$("#adminmodifybtn").click(function(){
										alert("이게버튼이냐?");									
										var admin_num=$(this).parent().parent().children().first().text();
										$.getJSON("<c:url value='/addetail'/>",{
											admin_num : admin_num
										},function(data){
											$("#admininfo_num").val(data.admin_num);
											$("#admininfo_id").text(data.admin_id);
											$("#admininfo_nick").val(data.admin_nick);
											$("#admininfo_pwd").val(data.admin_pwd);
											$("#admininfo_email").val(data.admin_email);
											$("#admininfo_regdate").text(data.admin_regdate);										
										});							
									});					
								} 						
							}
						});
						$("#memberslist").css("display", "none");
						$("#adminlist").css("display", "block");
					}
				});
	});
	$(function() {
		$("#memberslist_btn").click(function() {
			if ($("#memberslist").css("display") == "none") {
				$("#memberslist").css("display", "block");
				$("#adminlist").css("display", "none");
			}
		});
	});
	$(function() {
		$(".usercontent").attr({'data-toggle':'modal','data-target':'#myModal'});
		$(".usercontent").click(function(){
			
		});
	});
</script>

<script id="adminlist-template" type="text/template">
	<tr>	
		<td>{admin_num}</td>
		<td>{admin_id}</td>
		<td>{admin_nick}</td>
		<td>{admin_email}</td>
		<td>{admin_regdate}</td>
		<td></td>
	</tr>
</script>
<c:set var="admin" value="${sessionScope.admininfo}" /> 
<div id="memberslist"> 
	<h1>
		회원정보
		<button class="btn btn-md" id="adminlist_btn">관리자정보</button>
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
				<td><a href="mbdelete?user_num=${user.user_num }"><i class="glyphicon glyphicon-remove"></i></a></td>
			</tr>
		</c:forEach>
	</table>		
	<div class="btn-group">
		<button class="btn btn-lg" data-toggle="modal" data-target="#myModal">등록</button>
		<button class="btn btn-lg">체크박스</button>
	</div>
</div>

<div id="adminlist" class="hidediv">
	<h1>
		관리자정보<button class="btn btn-md" id="memberslist_btn">회원정보</button>
	</h1>
	<table class="table table-striped">
		<tr>
			<th>관리자번호</th>
			<th>관리자ID</th>
			<th>관리자NICKNAME</th>
			<th>관리자EMAIL</th>
			<th>가입일</th>
			<th>관리자정보</th>
		</tr>
	</table>
</div>
<div id="testinfo"></div>

<div class="modal" id="myModal">
	<div class="modal-dialog1">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Question Editor</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="/action_page.php">
					<div class="form-group">
						<label class="control-label col-sm-2">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Enter ID">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="Enter password">
						</div>
					</div>
	<!-- 				<div class="form-group">
						<label class="control-label col-sm-2">Password:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="Enter password">
						</div>
					</div> -->
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Enter NickName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="Enter Email">
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

<div class="container modal modal-dialog1 modal-content" id="admininfo-template" >
	<form class="form-horizontal " action="<c:url value='/admodify'/>" method="post">
	 	<input type="hidden" id="admininfo_num" name="admin_num">
		<div class="form-group">
			<label class="control-label col-sm-2" >ID:</label>
			<div class="col-sm-10">
				<p class="form-control-static" id="admininfo_id" ></p>
			</div> 
		</div>
		<div class="form-group ">
			<label class="control-label col-sm-2" >NICKNAME:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="admininfo_nick" name="admin_nick">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Password:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="admininfo_pwd" name="admin_pwd">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Email:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="admininfo_email" name="admin_email">
			</div>
		</div>
		<div class="form-group ">
			<label class="control-label col-sm-2">가입일:</label>
			<div class="col-sm-10">
				<p class="form-control-static" id="admininfo_regdate"></p>
			</div>
		</div>
		<div class="form-group">        
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Submit</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</form>
</div>



