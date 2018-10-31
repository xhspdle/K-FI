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
		$(".faqcommbtn").click(function(){
			alert("aaaa");
			var faqcomm = $(this).parent().parent().children().last();
			if(faqcomm.css("display")=="none"){
				faqcomm.css("display","block");
			}else{
				faqcomm.css("display","none");
			}
		});
	});
	
</script>
<c:set var="admin" value="${sessionScope.admininfo }" />
<h1>Q and A</h1>

	<h2>Panels with Contextual Classes</h2>
	<div class="panel-group">
	<c:forEach var="faqlist" items="${faqlist }" varStatus="status">	
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#myPage"><img style="width:50px; height:50px;border-radius:50px;" class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/1 (1).jpg'/>"></a>
				${faqlist.user_num }
				${faqlist.qa_title }
				
			</div>
			<div class="panel-body">
				${faqlist.qa_num}<br>
				${faqlist.qa_content}<br>
				<button class="btn btn-default faqcommbtn">댓글</button>
			</div>
				${faqlist.qa_date }
				${faqlist.admin_num }
			<div class="hidediv" >
				<form action="faqcomm" method="post">
					${admin.admin_nick }
					<input class="form-group form-control" type="text">
					<input type="submit" value="작성">
				</form>
			</div>
	    </div>
	</c:forEach>
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