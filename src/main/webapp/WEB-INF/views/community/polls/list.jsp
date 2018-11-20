<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="commPollsHere" value="CPH">
<input type="hidden" id="msgHere" value="${msg }">
<div id="commPollList" class="container text-center">
	<div class="row" style="margin-bottom: 10px;">
		<div class="col-sm-offset-4 col-sm-4">
			<a href="#pollsModal" data-toggle="modal" class="btn btn-poll btn-block"><span class="glyphicon glyphicon-plus"></span>Add Polls</a>
		</div>
		
	</div>
	<c:forEach var="vo" items="${list }">
	<div class="panel-group col-sm-4">
		<div class="panel panel-default">
			<div class="panel-heading text-left">
				<h3><span class="glyphicon glyphicon-stats"></span>${vo.vote_title }</h3>
				<p><small style="color:#818181">${vo.cnt } votesㆍ${vo.remain } days left</small></p>
			</div>
			<div class="panel-body poll-body">
				<div class="poll-list-options">
					<c:forEach var="optionList" items="${vo.list }">
					<a href="<c:url value='/community/votingUserList/insert?vo_num=${optionList.vo_num }'/>" 
					class="btn btn-info btn-block">${optionList.vo_content }</a>
					</c:forEach>
				</div>
			</div>
			<div class="panel-footer">
				<div class="media">
					<div class="media-left media-top">
						<img src="<c:url value='/resources/upload/img/${vo.msp_savimg }'/>" class="media-object img-circle" style="width:50px;height:50px">
					</div>
					<div class="media-body text-left" style="padding-left:5px;">
						<h4 class="media-heading"><a href="<c:url value='/mypage/myboard/selectList?selectedUserNum=${vo.user_num }'/>"><strong>${vo.user_nickname }</strong></a></h4>
						<p style="margin:0px;margin-top:-5px;"><small>${vo.user_email }</small></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
</div>
<div class="row">
	<div class="text-center">
		<ul class="pagination">
		<c:choose>
			<c:when test="${pu.startPageNum > pu.pageBlockCount }">
			<li>
				<a class="aPaging bPaging" 
				href="<c:url value='/community/polls/list?pageNum=${pu.startPageNum-1 }'/>">
				<span class="glyphicon glyphicon-chevron-left bPaging"></span>
				</a>
			</li>
			</c:when>
			<c:otherwise>
			<li><span class="glyphicon glyphicon-chevron-left bPaging"></span></li>
			</c:otherwise>
		</c:choose>	
		<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
			<li <c:if test="${i==pu.pageNum }">class='active'</c:if>>
				<a class="aPaging bPaging" 
				href="<c:url value='/community/polls/list?pageNum=${i }'/>">${i }</a>
			</li>
		</c:forEach>
		<c:choose>
			<c:when test="${pu.endPageNum < pu.totalPageCount }">
			<li>
				<a class="aPaging bPaging" 
				href="<c:url value='/community/polls/list?pageNum=${pu.endPageNum+1 }'/>">
				<span class="glyphicon glyphicon-chevron-right bPaging"></span>
				</a>
			</li>
			</c:when>
			<c:otherwise>
			<li><span class="glyphicon glyphicon-chevron-right bPaging"></span></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
</div>
<!-- polls Modal -->
<div class="modal fade" id="pollsModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content writeModal">
			<div class="modal-header" style="padding:35px 50px;">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h1><span class="glyphicon glyphicon-stats"></span> Poll</h1>
			</div>
			<div class="modal-body" style="padding:40px 50px;">
				<form method="post" action="<c:url value='/community/polls/insert'/>" name="voteFrm">
					
					<div class="form-group">
						<label for="vote_title"><span class="glyphicon glyphicon-pencil"></span> Title</label><span class="msgSpan"></span>
						<input type="text" class="form-control" id="vote_title" name="vote_title" placeholder="Enter Title">
					</div>
					<div class="form-group">
						<label for="vote_info"><span class="glyphicon glyphicon-info-sign"></span> Info</label><span class="msgSpan"></span>
						<textarea class="form-control" rows="5" id="vote_info" name="vote_info" placeholder="Poll's info"></textarea>
					</div>
					<div class="form-group">
						<label for="vote_end"><span class="glyphicon glyphicon-calendar"></span> Until</label><span class="msgSpan"></span>
						<input type="date" class="form-control" id="vote_end" name="vote_end">
					</div>
					<div class="form-group">
						<label for="optionCnt"><span class="glyphicon glyphicon-th-list"></span> Number of options</label><span class="msgSpan"></span>
						<select class="form-control" id="optionCnt">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group" id="pollOptions">
						<label for="vo_content"><span class="glyphicon glyphicon-unchecked"></span> Options</label><span class="msgSpan"></span>
						<div class="input-group">
							<span class="input-group-addon">1</span>							
							<input type="text" class="form-control" name="vo_content" placeholder="write some options">
						</div>
					</div>
					<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-ok"></span> Write</button>
				</form>
			</div>
			<div class="modal-footer">
			  <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
			  <p id="uploadMsg">Add some polls!</p>
			</div>
		</div> 
	</div>
</div> 

<script id="pollOptionTemplate" type="text/template">
<div class="input-group slide">
	<span class="input-group-addon">{optionCnt}</span>							
	<input type="text" class="form-control" name="vo_content" placeholder="write some options">
</div>
</script>