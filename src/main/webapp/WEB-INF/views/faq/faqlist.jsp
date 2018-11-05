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
 			var qa_num=$(this).siblings('input').val()
 			console.log($(this).parent().parent().children().last());
 			var faqcomm = $(this).parent().parent().children().last();				
 			if(faqcomm.css("display")=="none"){
 				faqcomm.css("display","block");
			}else{
				faqcomm.css("display","none");
			} 
 			$.getJSON("<c:url value='/faqcomment'/>",{
 				qa_num : qa_num
 			},function(data){
 				for(var i=0;i<data.length;i++){
 					alert(html);
 					var html=document.querySelector("#faqcomment_template").innerHTML;
 					var resultHTML=html.replace("{qa_num}", data[i].qa_num)
   						.replace("{user_num}", data[i].user_num)
 						.replace("{qa_title}", data[i].qa_title)
						.replace("{qa_content}", data[i].qa_content)
						.replace("{qa_date}", data[i].qa_date)
						.replace("{ref}",data[i].ref)
						.replace("{lev}",data[i].lev)
						.replace("{step}",data[i].step)
						.replace("{admin_num}",data[i].admin_num);
 						faqcomm.after(resultHTML);
 				/* 	var html=data[i].qa_num+"//////"+data[i].qa_num+"////////"+data[i].qa_num+"//////////" */
 				/* 	$("#faqcomment"+data[i].qa_ref}).appendto(html); */	
 				}
 			});
		});
	});
	
	$("#faqcomminsert").click(function(){
		
	});
	

</script>
<script id="faqcomment_template" type="text/template">

<div class="faq_comment" id="faq_comments">
	<form action="faqinsert" method="post">	
		<input type="hidden" name="qa_num" value={qa_num}>
		<input type="hidden" name="ref" value={ref}>
		<input type="hidden" name="lev" value={lev}>
		<input type="hidden" name="step" value={step}>
		<div class="media">
			<div class="media-left media-top">
				<img src="2.png" class="media-object" style="width:60px">
			</div>
				<div class="media-body">
				<h4 class="media-heading">Media Top</h4>
				{qa_content}
			</div>
		</div>				
	</form>
</div>	 
</script>
<c:set var="admin" value="${sessionScope.admininfo }" />
<h1>Q and A</h1>
	<h2>Panels with Contextual Classes</h2>
	<div class="panel-group">
	<c:forEach var="faqlist" items="${faqlist }" varStatus="status">	
		<div class="panel panel-default">
			<div class="panel-heading" >	
				<a href="#myPage"><img style="width:50px; height:50px;border-radius:50px;" class="miniLogo" alt="simpleLogo" src="<c:url value='/resources/images/1 (1).jpg'/>"></a>
				${faqlist.user_num }
				${faqlist.qa_title }		
			</div>
			<div class="panel-body">
				<input type="hidden" value="${faqlist.qa_num}">
				${faqlist.qa_content}<br>
				${faqlist.qa_date }
				${faqlist.admin_num }
				<button class="btn btn-default faqcommbtn">댓글</button>
			</div>
			<form class="hidediv" action="">
				<div class="media">
					<div class="media-left media-top">
						<img src="2.png" class="media-object" style="width:60px">
					</div>
					<div class="media-body panel-body">
						<input type="hidden" name="ref" value=${faqlist.ref }>
						<input type="hidden" name="lev" value=${faqlist.lev }>
						<input type="hidden" name="step" value=${faqlist.step }>
						<div class="input-group well-lg">
							<input type="text" class="form-control" name="qa_content">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit" id="faqcomminsert">
									<i class="glyphicon glyphicon-pencil"></i>
								</button>
							</div>
						</div>
					</div>
				</div>		
			</form>	
		</div>
	</c:forEach>
</div>	


<a href="faqinsert" class="btn btn-default">글작성</a>
<!--  		 	if($(".faq_comment").css("display")=="none"){
		 		$(".faq_comment").css("display","block");
			}else{
				$(".faq_comment").css("display","none");
			}   -->
 
