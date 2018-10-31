<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>
<script type="text/javascript">
	$(function() {
		$(".abcontent")
				.click(
						function(event) {
							$("#abmodifymodal").insertAfter("#wrap");
							/* 		$("#wrap").css("opacity", "0.1"); */

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
</script>
<c:set var="admin" value="${sessionScope.admininfo }" />
<button class="btn btn-lg" data-toggle="modal"
	data-target="#abmodify-modal">확인</button>
<c:choose>
	<c:when test="${not empty admin}">
		<h1>공지사항</h1>
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
				<tr class="abcontent">
					<td class="${ablist.ab_num}">${ablist.ab_num}</td>
					<td>${ablist.admin_num }</td>
					<td>${ablist.ab_notice }</td>
					<td>${ablist.ab_title }</td>
					<td>${ablist.ab_date }</td>
					<td><a href="abdelete?ab_num=${ablist.ab_num}"><i
							class="glyphicon glyphicon-remove"></i></a></td>
				</tr>
			</c:forEach>
		</table>
		<!-- <div class="container">
  <h2>Button Group</h2>
  <p>The .btn-group class creates a button group:</p>
  <div class="btn-group">
    <button type="button" class="btn btn-primary">Apple</button>
    <button type="button" class="btn btn-primary">Samsung</button>
    <button type="button" class="btn btn-primary">Sony</button>
  </div>
</div>
<div> -->


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

		<div class="modal modal-dialog1" id="abmodify-modal">
			<h2>Column Sizing</h2>
			<form class="form-horizontal" action="/action_page.php">
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email"
							placeholder="Enter email" name="email">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="pwd"
							placeholder="Enter password" name="pwd">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><input type="checkbox" name="remember">
								Remember me</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</div>



		<a href="abinsert" class="btn btn-default">글작성</a>

		<div id="aaa"></div>

		<div id="abmodifymodal">
			<%-- 	<form>
		<div>
			게시물번호<input type="text" value="${abdetail.admin_num }"><br>
			제목<input type="text"><br>
			내용<textarea rows="5" cols="100"></textarea><br>
			관리자ID<input type="text"><br>
			게시<input type="text"><br>			
		</div>
		<input type="submit" value="수정">
	</form> --%>
		</div>
	</c:when>
	<c:otherwise>
		<meta http-equiv="refresh" content="0; url=<c:url value='/adlogin'/>"></meta>
	</c:otherwise>
</c:choose>