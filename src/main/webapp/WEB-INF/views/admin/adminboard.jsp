<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
	
<script type="text/javascript">
/* 	$(function() {
		$(".abcontent")
				.click(
						function(event) {
							$("#abmodifymodal").insertAfter("#wrap");
							$("#wrap").css("opacity", "0.1"); 

							var ab_num = (event.target.className);
							console.log(ab_num);
							$
									.getJSON(
											"<c:url value='/abdetail'/>",
											{
												ab_num : ab_num
											},
											function(data) {

												var board = document
														.getElementById("abmodifymodal");
												var div = document
														.createElement("div");
												var img = document
														.createElement("img");
												var p = document
														.createElement("p");
												div.style.width = "600px";
												div.style.height = "auto";
												div.style.border = "1px solid #000";
												div.style.marginTop = "10px";
												div.style.backgroundColor = "green";
												div.style.marginLeft = "10px";
												div.style.cssFloat = "left";

												img.style.width = "auto";
												img.style.maxWidth = "100%";
												img.style.height = "auto";
												img.style.maxHeight = "auto";

												div.innerHTML = "우화와와와와와오 레드벨벳이다";
												p.innerHTML = "멋지네요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
												img.src = "<c:url value='/resources/images/1 ("
														+ i + ").jpg'/>";
												board.appendChild(div)
														.appendChild(img);
												div.appendChild(p);
											});

							$("#abmodifymodal").css("display", "block");
						});
	});
	 */
	
	$(function(){
		$(".abdelete").click(function(){
			var result=confirm("진짜로????");	
			var ab_num=$(this).parent().parent().children().first().text();
 			if(result){
				location.href="abdelete?ab_num="+ab_num;
			}else{
				return;
			}
		});
	});
	$(function(){
		$(".abcontent").attr({'data-toggle':'modal','data-target':'#adminboardupdate'});
		$(".abcontent").click(function(){
			console.log($(this).parent().children().first().text());
			var ab_num=$(this).parent().children().first().text();
		 	$.getJSON("<c:url value='/abdetail'/>",{
		 		ab_num : ab_num
			},function(data){
				
				console.log(data.ab_num);
				$("#abupdate_title").val(data.ab_title);
				$("#abupdate_comment").text(data.ab_content);
				$("#abupdate_adnum").val(data.admin_num);
				$("#abupdate_notice").val(data.ab_notice);
				$("#abupdate_date").val(data.ab_date);
			}); 
		});
	});
 	$(function(){
		$.getJSON("<c:url value='/abpopup'/>", function(data){
			for(var i=0;i<data.length;i++){
				alert(data[i].admin_num)
				console.log(data[i].admin_num);
				console.log(data[i].ab_content);
				console.log(data[i].ab_title);
				var content=data[i].ab_content;
				$("#aaaaa").css("display","block");
				alert("aaaa");
				$("#aaaaa").append(content);
			}
		});
	}); 
</script>
<c:set var="admin" value="${sessionScope.admininfo }" />
<%-- <button class="btn btn-lg" data-toggle="modal"
	data-target="#abmodify-modal">확인</button>
<c:choose>
	<c:when test="${not empty admin}"> --%>
<h1>공지사항</h1>
<input type="button" value="aaa" id="popupbtn">
<table class="table table-striped">
	<tr>
		<th>게시물번호</th>
		<th>회원ID</th>
		<th>게시상황</th>
		<th>제목</th>
		<th>게시일</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="ablist" items="${ablist }">
		<tr>
			<td class="abcontent">${ablist.ab_num}</td>
			<td class="abcontent">${ablist.admin_num }</td>
			<td class="abcontent">${ablist.ab_notice }</td>
			<td class="abcontent">${ablist.ab_title }</td>
			<td class="abcontent">${ablist.ab_date }</td>
			<td><i class="glyphicon glyphicon-remove abdelete"></i></td>
		</tr>
	</c:forEach>
</table>
<div class="modal" id="adminboardupdate">
	<div class="modal-dialog1">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Question Editor</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="abupdate" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2">제목:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="ab_title" readonly="readonly" id="abupdate_title">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">내용:</label>
						<div class="col-sm-10">
							  <textarea class="form-control" rows="5" id="abupdate_comment"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="admin_num" id="abupdate_adnum">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">상태정보:</label>
						<div class="col-sm-10">
							<label class="radio-inline">
								<input type="radio" name="optradio" checked>게시
							</label>
							<label class="radio-inline">
								<input type="radio" name="optradio">미게시
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">등록일자:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="ab_date" id="abupdate_date">
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

		<div class="container">
			<c:forEach var="i" begin="${apu.startpagenum }"
				end="${apu.endpagenum }">
				<%-- <a href="<c:url value='/ablist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">
			<button type="button" class="btn btn-primary ">${i }</button></a> --%>
				<ul class="pagination">
					<li><a
						href="<c:url value='/ablist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">
							${i }</a></li>
				</ul>

			</c:forEach>
		</div>

		<div class="container">
			<form method="post" action="<c:url value='/ablist'/>">
				<div class="form-group row">
					<select name="field" class="dropdown-menu">
						<option value="ab_title">글제목</option>
						<option value="admin_num">작성자</option>
						<option value="ab_content">내용</option>
						<option value="ab_notice">게시</option>
					</select>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="keyword">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>


		<a href="abinsert" class="btn btn-default">글작성</a>
<div id="aaaaa">
	

	<input type="button" value="닫기" onclick=""> 
</div>
<%-- 	</c:when>
	<c:otherwise>
		<meta http-equiv="refresh" content="0; url=<c:url value='/adlogin'/>"></meta>
	</c:otherwise>
</c:choose> --%>