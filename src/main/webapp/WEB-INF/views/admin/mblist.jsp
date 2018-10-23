<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>	
<script type="text/javascript">
	$(document).ready(function(){
		var id=$("#mbgetinfo").val();
		alert(id);	
	});
</script> 
<h1>회원정보</h1>
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
				<td><a data-toggle="modal" data-target="#myModal" id="mbgetinfo" value="${user.user_num}">${user.user_num}</a></td>
				<td>${user.user_id }</td>
				<td>${user.user_nickname }</td>
				<td>${user.user_email }</td>
				<td>${user.user_regdate }</td>				
				<td><a href="mbdelete?user_num=${user.user_num }"><i class="glyphicon glyphicon-remove"></i></a></td>
			</tr>
		</c:forEach>
	</table>

<div class="container">
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">   
      <!-- Modal content-->
      <div class="modal-content">
        <div >
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 >사용자 정보</h4>
        </div>
        <div>
        	회원ID<input type="text" value="${mbinfo.user_id }"><br>
        	회원비밀번호<input type="text"><br>
        	회원NICKNAME<input type="text"><br>
        	회원EMAIL<input type="text"><br>
        	회원가입일<input type="text"><br>    	
        </div>
        <div>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>