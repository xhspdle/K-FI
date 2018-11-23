<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
tbody tr{
	cursor: pointer;
}
tbody tr:nth-child(2n+1) {
 	background-color: #e3f2fd;
}
.colwhite{
	color: white;
}

</style>

<div id="commuserlist">
	<div class="container">
		<!-- <button class="btn btn-md" onclick="location.href='/kfi/adminlist'">관리자정보</button> -->
		<div class="btn-group">
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commprofile?comm_num=${comm_num}'">PROFILE</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commskin?comm_num=${comm_num}'">SKIN</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/kfi/community/commadmin/commuserlist?comm_num=${comm_num}'">MEMBERS</button>
		</div><!-- <br><br> -->
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nickname</th>
					<th>Email</th>
					<th>Status</th>
		 	<!-- 		<th>권한양도</th>  -->
					<th>강퇴</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="commuserlist" items="${commuserlist }">
				<tr>
					<td hidden="text">${comm_num}</td>
					<td hidden="hidden">${commuserlist.cul_num }</td>
					<td hidden="hidden">${commuserlist.user_num }</td>
					<td class="commuser">${commuserlist.user_id}</td>
					<td class="commuser">${commuserlist.user_nickname}</td>
					<td class="commuser">${commuserlist.user_email}</td>
					<c:choose>
						<c:when test="${commuserlist.cul_status eq 1}">
							<td class="commuser">정상</td>	
						</c:when>
						<c:otherwise>
							<td class="commuser">확인바람</td>
						</c:otherwise>
					</c:choose>	
					
					<c:choose>
						<c:when test="${commadmin_num eq commuserlist.user_num}">
							<td>관리자</td>
						</c:when>
						<c:otherwise>
							<td><button type="button" class="btn btn-danger btn-sm commforcedexitbtn">강퇴</button></td>
						</c:otherwise>
					</c:choose>	
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<div class="modal" id="commforcedexitmodal">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #0c558d">
			<div class="modal-header">
				<div style="font-size: 20px; font: bold; color:white">사용자 강퇴</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="commforcedexitform" action="<c:url value='/community/commrefuse/insert'/>" method="post">
					<input type="hidden" class="form-control" readonly="readonly" name="comm_num" id="efcomm_num">
					<input type="hidden" class="form-control colwhite" name="cul_num" id="culnum">
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" readonly="readonly" id="efid">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" readonly="readonly" id="efnick"> 
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" readonly="readonly" id="efmail">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">사유:</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="4" name="cr_refuse"></textarea> 
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default" id="efbtn">작성</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="commadminauthmodal">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #0c558d">
			<div class="modal-header">
				<h4 class="modal-title colwhite" >사용자 수정</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="commadminauthform" action="<c:url value='/community/commadmin/commadminauth'/>" method="post">
					<input type="hidden" class="form-control" name="comm_num" id="commnum">
					<input type="hidden" class="form-control" name="user_num" id="commusernum">
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">ID:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="commuserid" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">NickName:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="commusernick">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 colwhite">Email:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="commuseremail">
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="btn-group pull-left">
								<button type="button" class="btn btn-success" id="commadminauthbtn">관리자권한양도</button>
							</div>
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(function(){
		$(".commuser").attr({'data-toggle':'modal','data-target':'#commadminauthmodal'});
		$(".commforcedexitbtn").attr({'data-toggle':'modal','data-target':'#commforcedexitmodal'});
		$(".commforcedexitbtn").on("click",function(){
			var tr=$(this).closest('tr');
			var td=tr.children();
			$("#efcomm_num").val(td.eq(0).text());
			$("#culnum").val(td.eq(1).text());
			$("#efid").val(td.eq(3).text());
			$("#efnick").val(td.eq(4).text());
			$("#efmail").val(td.eq(5).text());		
		});
		
		$(".commuser").click(function(){
			var commadmin_num = "<c:out value='${commadmin_num}'/>";
			alert(commadmin_num);
			alert("aaa");
			var tr=$(this).closest('tr');
			var td=tr.children();
			$("#commnum").val(td.eq(0).text());
			$("#commusernum").val(td.eq(2).text());
			$("#commuserid").val(td.eq(3).text());
			$("#commusernick").val(td.eq(4).text());
			$("#commuseremail").val(td.eq(5).text());
			
/* 			console.log($(this).parent().children().first().text());		
			var user_num=$(this).parent().children().first().text();
		 	$.getJSON("<c:url value='/mbgetinfo'/>",{
				user_num : user_num
			},function(data){			
				$("#modifyuser_num").val(user_num);
				$("#modifyuser_id").val(data.user_id);
				$("#modifyuser_pwd").val(data.user_pwd);
				$("#modifyuser_nickname").val(data.user_nick);
				$("#modifyuser_email").val(data.user_email);
				$("select[name=user_status] option[value="+data.user_stat+"]").prop("selected",true);
			});  */
		});
/* 		$(".userdelete").click(function(){
			var result=confirm("정말로????");
			var user_num=$(this).parent().parent().children().first().text();
 			if(result){
				location.href="mbdelete?user_num="+user_num;
			}else{
				return false;
			}
		}); */
		

	});
 	$("#efbtn").on("click",function(){
 		var result=confirm("강제퇴장 시키겠습니까?");
 		if(result){
 			$("#commforcedexitform").submit();
 		}else{
 			return false;
 		}
	});
	$("#commadminauthbtn").on("click",function(){ 		
		var result=confirm("권한을 양도합니까??");
 		if(result){
 			$("#commadminauthform").submit();
 		}else{
 			return false;
 		}
	});



</script>