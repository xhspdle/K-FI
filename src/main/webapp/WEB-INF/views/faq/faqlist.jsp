<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function(){
		$(".faqcontent").click(function(event){
			var qa_num=$(this).parent().children().first().text();	
		 	location.href="<c:url value='/faqdetail?qa_num="+qa_num+"'/>";
		});
	});
	$(function(){
		$("#faqcommbtn").click(function(){
			if($("#faqcomm").css("display")=="block"){
				$("#faqcomm").css("display","none");
			}else{
				$("#faqcomm").css("display","block");
			}
		});
	});
	
</script>
<c:set var="admin" value="${sessionScope.admininfo }" />
<h1>Q and A</h1>
<div>
	<h2>Panels with Contextual Classes</h2>
	<div class="panel-group">
	<c:forEach var="faqlist" items="${faqlist }">	
		<div class="panel panel-warning">
			<div class="panel-heading">
				${faqlist.qa_title }<br>
				${faqlist.user_num }
			</div>
			<div class="panel-body">
				${faqlist.qa_num}<br>
				${faqlist.qa_content}<br>
				<button class="btn btn-default" id="faqcommbtn">댓글</button>
			</div>
				${faqlist.qa_date }
				${faqlist.admin_num }
			<div class="hidediv" id="faqcomm">
				<form>
					${admin.admin_nick }
					<input class="form-group form-control" type="text">
					<input type="submit" value="작성">
				</form>		
			</div>
	    </div>
	</c:forEach>
	</div>
</div>
<a href="faqinsert" class="btn btn-default">글작성</a>

<!-- <div class="container">
  <h2>Panels with Contextual Classes</h2>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">Panel with panel-default class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-primary">
      <div class="panel-heading">Panel with panel-primary class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-success">
      <div class="panel-heading">Panel with panel-success class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-info">
      <div class="panel-heading">Panel with panel-info class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-warning">
      <div class="panel-heading">Panel with panel-warning class</div>
      <div class="panel-body">Panel Content</div>
    </div>

    <div class="panel panel-danger">
      <div class="panel-heading">Panel with panel-danger class</div>
      <div class="panel-body">Panel Content</div>
    </div>
  </div>
</div> -->