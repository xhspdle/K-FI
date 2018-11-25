<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function(){
		var getPageContext=$('#getPageContext').val(); 
		$('#mypage_comm_calendar').fullCalendar({
				header : {
				left : '',
				center : 'prevYear prev title next nextYear' ,
				right : 'today'
			},
			defaultDate : new Date(),
			navLinks : true, 
			editable : false,
			eventLimit : true,
			events : [ 
				<c:forEach var="list" items='${monthlist }'> 
				{
					id:'${list.cc_info}', 
					  title: '${list.cc_name}',  
	                   start: '${list.cc_begin}',
	                   end: '${list.cc_end}',
	                   url: getPageContext+'/community?comm_num=${list.comm_num}'
				}, 
				</c:forEach>
				],
				selectable: true,
				selectHelper: true,
				eventMouseover:function(event, jsEvent, view){
					$(this).attr({
						'data-toggle':'tooltip',
						'data-placement':'top',
						'title':event.id
					});
				},
	        eventColor: '#00cee8'
		})
		$("#mypage_communitylist").on('change',function(){
			var comm_num=$('#mypage_communitylist option:selected').val();
			var gathering=$('#comm_gathering option:selected').val();
			var comm_name=$('#mypage_communitylist option:selected').text();
			location.href=getPageContext+"/mypage/mycomm/calendar?comm_num="+comm_num
					+"&comm_name="+comm_name+"&gathering="+gathering;
		});
		$("#comm_gathering").on('change',function(){
			var comm_num=$('#mypage_communitylist option:selected').val();
			var gathering=$('#comm_gathering option:selected').val();
			var comm_name=$('#mypage_communitylist option:selected').text();
			location.href=getPageContext+"/mypage/mycomm/calendar?comm_num="+comm_num
					+"&comm_name="+comm_name+"&gathering="+gathering;
		});
		
	});
	
</script>
<div class="container">
<div id="mypage_comm_calendar_wrap" >
	<div style="display: -webkit-box;width: 50%;padding-top: 2%;">
		<p style="width: 49%;">
			<select id="mypage_communitylist" class="form-control" >
			<option value="all">커뮤니티</option>
			<c:forEach var="communitylist" items="${ communitylist}">
			<option value="${communitylist.comm_num }" <c:if test="${communitylist.comm_name ==comm_name }"> selected="selected"</c:if>>${communitylist.comm_name }</option> 
			</c:forEach>
			</select>
		</p> &nbsp;&nbsp;
		<p style="width: 25%;">
			<select id="comm_gathering" class="form-control" >
				<option value="gathering">전체</option>
				<option value="attend" <c:if test="${gathering =='attend' }"> selected="selected"</c:if>>참석</option>
				<option value="not_attend" <c:if test="${gathering =='not_attend' }"> selected="selected"</c:if>>불참</option>
			</select>
		</p>
	</div>
	<br>
	<div id='mypage_comm_calendar'></div>
</div>
</div>