<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$("#checkid").click(function() {
			alert("aaa");
			var id = $("#id").val();
			alert(id);
			$.getJSON("<c:url value='/checkid'/>", {
				id : id
			}, function(data) {
				$("#checkedid").html(data.msg);
			});
		});
	});
</script>
<div class="container">
	<h2>회원 가입</h2>
	<form method="post" action="adjoin">
		<label>ID:</label>	
		<div class="input-group form-group">
			<input type="text" class="form-control" name="admin_id" id="id">
			<div class="input-group-btn">
					<input type="button" class="btn btn-default" id="checkid" value="중복확인" >
			</div>
		</div>
		
<!-- 		    <div class="form-group has-success has-feedback">
      <label class="col-sm-2 control-label" for="inputSuccess">Input with success and glyphicon</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputSuccess">
        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
      </div>
    </div> -->
		
		<div id="checkedid"></div>
		
		<div class="form-group">
			<label>Password:</label>
			<input type="password" class="form-control" name="admin_pwd" id="pwd">
		</div>
		<div class="form-group">
			<label>Password:</label> 
			<input type="password" class="form-control" id="checkpwd">
		</div>
		<div class="form-group">
			<label>NickName:</label> 
			<input type="text" class="form-control" name="admin_nickname">
		</div>
		<div class="form-group">
			<label>E-mail:</label> 
			<input type="text" class="form-control" name="admin_email">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>
