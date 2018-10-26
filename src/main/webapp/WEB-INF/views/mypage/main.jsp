<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	$(function(){
		$.getList=function(pageNum,keyword){
			$.getJSON("<c:url value='/mypage/myboard/list'/>",
				{"pageNum":pageNum,"keyword":keyword},
				function(data){
					$(data.list).each(function(i,json){
						var mb_num=json.mb_num;
						var mb_title=json.mb_title;
						var mb_content=json.mb_content;
						var mb_date=json.mb_date;
						var mb_views=json.mb_views;
						var comment_cnt=json.comment_cnt;
						var mp_savimg=json.mp_savimg;
						var mv_savvid=json.mv_savvid;
						var attachment='';
						if(mv_savvid!=null && mv_savvid!=''){
							attachment="<video class='img-responsive center-block' controls autoplay muted='muted' loop src='${pageContext.request.contextPath}/resources/upload/vid/" + mv_savvid + "'></video>";
						}else if(mp_savimg!=null && mp_savimg!=''){
							attachment="<img class='img-responsive center-block' src='${pageContext.request.contextPath}/resources/upload/img/" + mp_savimg + "'>";
						}else{
							attachment="<img class='img-responsive center-block' src='${pageContext.request.contextPath}/resources/images/logo2.png'>";
						}
						$("<div class='panel-group slideanim'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading'>" +
						  	"<h1>" + mb_title + "</h1></div>" +
						  "<div class='panel-body'>" + 
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						  	"<h4>댓글 수: " + comment_cnt + "</h4></div></div></div></div>")
						.appendTo("#myBoardList");
					});
				
				
				});
		}
		$.getList();
	});
</script>
<div id="myBoardList" class="container">
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1>글제목이 여기딱</h1>
			</div>
			<div class="panel-body">
				<p>글 내용이 여기 딱 호롤로로로로로로로</p>
				<img class="img-responsive center-block" src="<c:url value='/resources/images/logo2.png'/>">
			</div>
			<div class="panel-footer">
				<div>
					<h4>댓글내용이 여기 후루루루루</h4>
				</div>
			</div>
		</div>	
	</div>
</div>

