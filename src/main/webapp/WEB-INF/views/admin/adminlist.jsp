<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="admin" value="${sessionScope.admininfo}" /> 
<script>
	$(function(){
		$("#adminmodifybtn").click(function(){
			alert("aaa");
			var admin_num=$(this).parent().parent().children().first().text();
			$.getJSON("<c:url value='/addetail'/>",{
				admin_num : admin_num
			},function(data){
				$("#admininfo_num").val(data.admin_num);
				$("#admininfo_id").text(data.admin_id);
				$("#admin_id").val(data.admin_id);
				$("#admininfo_nick").val(data.admin_nick);
				$("#admininfo_pwd").val(data.admin_pwd);
				$("#admininfo_email").val(data.admin_email);
				$("#admininfo_regdate").text(data.admin_regdate);										
			});							
		});
	});
</script>
<div id="adminlist">
	<h1>
		관리자정보<button class="btn btn-md" onclick="location.href='/kfi/mblist'">회원정보</button>
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
 		<c:forEach var="adminlist" items="${adminlist }"> 
 			<tr>
				<td>${adminlist.admin_num}</td>
				<td>${adminlist.admin_id }</td>
				<td>${adminlist.admin_nick }</td>
				<td>${adminlist.admin_email }</td>
				<td>${adminlist.admin_regdate }</td>
				<c:choose> 
				<c:when test="${admin.admin_num eq adminlist.admin_num}">							
					<td><button class="btn btn-sm btn-primary" id="adminmodifybtn" data-toggle="modal" data-target="#admininfo-template">수정</button></td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>					
				</c:choose>
			</tr>
		</c:forEach>
	</table>		
</div>

<div class=" modal modal-content" id="admininfo-template" >
	<form class="form-horizontal " action="<c:url value='/admodify'/>" method="post">
	 	<input type="hidden" id="admininfo_num" name="admin_num">
		<div class="form-group">
			<label class="control-label col-sm-2" >ID:</label>
			<div class="col-sm-10">
				<p class="form-control-static" id="admininfo_id"></p>
			</div> 
		</div>
		<input type="hidden" id="admin_id" name="admin_id">
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
