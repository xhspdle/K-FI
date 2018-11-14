<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/resources/js/admin.js'/>"></script>

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
				return false;
			}
		});
	});
	$(function(){
		$(".abcontent").attr({'data-toggle':'modal','data-target':'#adminboardupdate'});
		$(".abcontent").click(function(){
			var ab_num=$(this).parent().children().first().text();
		 	$.getJSON("<c:url value='/abdetail'/>",{
		 		ab_num : ab_num
			},function(data){
				$("#abupdate_num").val(ab_num);
				$("#abupdate_title").val(data.ab_title);
				$("#abupdate_content").text(data.ab_content);
				$("#abupdate_adnum").val(data.admin_num);	
				$("input:radio[name='ab_notice']:radio[value="+ data.ab_notice +"]").prop("checked","checked"); 
				$("#abupdate_date").text(data.ab_date);
			}); 
		});
	});
/* 	
	$(function(){
		if(checkpopup("close")){
			$("#abpopup").css("display","none");
		}else{
			$.getJSON("<c:url value='/abpopup'/>",function(data){	
				for(var i=0;i<data.length;i++){
					console.log(data[i].ab_title);
					console.log(data[i].ab_num);
					console.log(data[i].ab_content);
					var html=template(data[i].ab_title,data[i].ab_content);
					$("#abpopupcontent").append(html);
					$("#abpopup").css("display","block");		 
				};
			});
		};
	});*/
	function template(ab_title,ab_content){
 		var html="<div class='well'>"
 				+"<h4>"+ab_title+"</h4><hr>"
 				+"<div>"+ab_content+"</div>"
 				+"</div>"
		return html;
 	}

	 
	$(function(){
		if(checkpopup("close")){
			$("#noticebtn").css("display","none");
		}else{
			$.getJSON("<c:url value='/abpopup'/>",function(data){	
				console.log(data);
				if(data!=null && data!=""){
					$("#noticebtn").css("display","block");
				}else{
					return false;
				}
				$("#popupbtn").click(function(){
					$("#abpopupcontent").empty();
					alert("시작");
					console.log("시작");
					for(var i=0;i<data.length;i++){
						console.log(data[i].ab_title);
						console.log(data[i].ab_num);
						console.log(data[i].ab_content);
						var html=template(data[i].ab_title,data[i].ab_content);
						$("#abpopupcontent").append(html);					
					};
				});
			});
		};
	});
	 

	
 	function setCookie(name, value, expiredays){
 		var today=new Date();
 		alert(today);
 		today.setDate(today.getDate()+expiredays);
 		document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + today.toGMTString() + ";"
 	}	
 	function checkpopup(cookiename){
 		var cookie= document.cookie;
 		alert(cookie);
  		if(cookie.length>0){
 			startIndex=cookie.indexOf(cookiename);
 			alert(startIndex)
 			if(startIndex != -1){
 				return true;
 			}else{
 				return false;
 			}
 		}else{
 			return false;
 		}	
 		return false;
 	}
 	function closepopup(){
 		setCookie("close","close",1);
 		$("#noticebtn").css("display","none");
 		$("#abpopup").css("display","none");
 	}
	function deletecookie(){
		setCookie("close","",-1);
	}


</script>
<c:set var="admin" value="${sessionScope.admininfo }" />
<%-- <button class="btn btn-lg" data-toggle="modal"
	data-target="#abmodify-modal">확인</button>
<c:choose>
	<c:when test="${not empty admin}"> --%>
<h1>공지사항</h1>
<input type="button" onclick="deletecookie()" value="삭제">
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
			<td class="abcontent">${ablist.admin_nick }</td>
			<c:choose>
				<c:when test="${ablist.ab_notice==1 }">
					<td class="abcontent">게시</td>
				</c:when>
				<c:otherwise>
					<td class="abcontent">미게시</td>
				</c:otherwise>
			</c:choose>
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
					<input type="hidden" class="form-control" name="ab_num" id="abupdate_num">
					<div class="form-group">
						<label class="control-label col-sm-2">제목:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="ab_title" id="abupdate_title">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">내용:</label>
						<div class="col-sm-10">
							  <textarea class="form-control" rows="5" name="ab_content" id="abupdate_content"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="admin_num" readonly="readonly" id="abupdate_adnum">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">상태정보:</label>
						<div class="col-sm-10">
							<label class="radio-inline">
								<input type="radio" name="ab_notice" value="1" >게시
							</label>
							<label class="radio-inline">
								<input type="radio" name="ab_notice" value="2">미게시
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">등록일자:</label>
						<div class="col-sm-10" id="abupdate_date"></div>
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

		<div>
		
				
				<%-- <a href="<c:url value='/ablist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">
			<button type="button" class="btn btn-primary ">${i }</button></a> --%>
	<%-- 			<ul class="pagination">
					<li><a
						href="<c:url value='/ablist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">
							${i }</a></li>
				</ul>
				 --%>
			<ul class="pagination">
				<li class="previous"><a href="#"><i class="glyphicon glyphicon-triangle-left"></i></a></li>
				<c:forEach var="i" begin="${apu.startpagenum }" end="${apu.endpagenum }">
					<li><a href="<c:url value='/ablist?pagenum=${i }&field=${field }&keyword=${keyword }'/>">${i }</a></li>	 
				</c:forEach>
				<li class="next"><a href="#"><i class="glyphicon glyphicon-triangle-right"></i></a></li>
			</ul>
		</div>
<div class="container">
	<div class="row">
		<div class="col-md-2 form-group">
			<select class="form-control" name="field">
				<option value="ab_title">글제목</option>
				<option value="admin_num">작성자</option>
				<option value="ab_content">내용</option>
				<option value="ab_notice">게시</option>
			</select>		
		</div>
		<div class="col-md-4 input-group">
			<input type="text" class="form-control" placeholder="Search"name="keyword">
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<i class="glyphicon glyphicon-search"></i>
				</button>	
			</div>
			<a href="abinsert" class="btn btn-default pull-right">글작성</a>	
		</div>
	</div>
</div>
<%-- 		<form method="post" action="<c:url value='/ablist'/>">
			<div class="row">
				<div class="form-group">
					<select name="field">
						<option value="ab_title">글제목</option>
						<option value="admin_num">작성자</option>
						<option value="ab_content">내용</option>
						<option value="ab_notice">게시</option>
					</select>
				</div>
				<div class="form-group ">
					<input type="text" class="form-control" placeholder="Search"
						name="keyword">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>	
					</div>
					<a href="abinsert" class="btn btn-default pull-right">글작성</a>	
				</div>	
			</div>
		</form> --%>
	

		
<div id="abpopup">	
	<div class="modal-header">
		<div style="color:orange; font-size:20px; font-weight: bold">공지사항</div>	
	</div>
	<div id="abpopupcontent"></div>
	<div class="modal-footer">
		
		<input class="pull-right btn btn-default" style="width:45%" value="하루닫기" onclick="closepopup()">
		<input class="pull-right btn btn-default" style="width:45%" value="닫기"  onclick="$('#abpopup').css('display','none')"> 
		
	</div>
</div>
<div id="noticebtn" class="hidediv" style="position: fixed;bottom: 20px;right: 20px;">
	<h1><span id="popupbtn"class="glyphicon glyphicon-exclamation-sign" style="color:gold; " onclick="$('#abpopup').css('display','block')"></span></h1> 
</div>
<%-- 	</c:when>
	<c:otherwise>
		<meta http-equiv="refresh" content="0; url=<c:url value='/adlogin'/>"></meta>
	</c:otherwise>
</c:choose> --%>