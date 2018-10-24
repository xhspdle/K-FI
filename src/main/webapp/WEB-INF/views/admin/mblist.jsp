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
				<td><a data-toggle="modal" data-target="#mbgetinfo_modal" id="mbgetinfo" value="${user.user_num}">${user.user_num}</a></td>
				<td>${user.user_id }</td>
				<td>${user.user_nickname }</td>
				<td>${user.user_email }</td>
				<td>${user.user_regdate }</td>				
				<td><a href="mbdelete?user_num=${user.user_num }"><i class="glyphicon glyphicon-remove"></i></a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="btn-group">
		<button class="btn btn-lg" data-toggle="modal" data-target="#mbgetinfo_modal" id="mbgetinfo">등록</button>
		<button class="btn btn-lg">체크박스</button>
	</div>

<div class="container">
  <div class="modal fade" id="mbgetinfo_modal" role="dialog">
    <div class="modal-dialog ">   
      <!-- Modal content-->
      <div class="modal-content">
        <div>
          <h3>사용자 등록</h3>
        </div>
        <div class="panel-body">
        <form class="form-horizontal" action="/action_page.php">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">ID:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">NickName:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Email:</label>
    <div class="col-sm-10"> 
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
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
   
      </div>
    </div>

</div>