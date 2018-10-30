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
</script>
<h1>Q and A</h1>
<table class="table table-striped">
	<tr>
		<th>게시물번호</th>
		<th>회원ID</th>
		<th>제목</th>
		<th>게시일</th>
		<th>관리자 ID</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="faqlist" items="${faqlist }">
		<tr>
			<td class="faqcontent">${faqlist.qa_num}</td>
			<td class="faqcontent">${faqlist.user_num }</td>
			<td class="faqcontent">${faqlist.qa_title }</td>
			<td	class="faqcontent">${faqlist.qa_date }</td>
			<td	class="faqcontent">${faqlist.admin_num }</td>				
			<td><a><i class="glyphicon glyphicon-remove"></i></a></td>
		</tr>
	</c:forEach>	
</table>
	
<a href="faqinsert" class="btn btn-default">글작성</a>