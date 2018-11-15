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
	                   url: getPageContext+'/mypage/mycommcalendar'
				}, 
				</c:forEach>
				],
				eventMouseover:function(calEvent,jsEvent,view){
				 	$(".fc-unthemed .fc-content, .fc-unthemed .fc-divider, .fc-unthemed .fc-list-heading td, .fc-unthemed .fc-list-view, .fc-unthemed .fc-popover, .fc-unthemed .fc-row, .fc-unthemed tbody, .fc-unthemed td, .fc-unthemed th, .fc-unthemed thead").css({
						'overflow': 'visible'
					}); 
					$('<div class="calevent">'+calEvent.id+'</div>')
					.appendTo(this).parent().css({pageX:jsEvent.pageX,pageY:jsEvent.pageY,'overflow': 'visible'});
				},
				eventMouseout:function(calEvent,jsEvent){
					$(this).children('.calevent').css('display','none');
				},
				/* eventClick:function(event){
					if(event.url){
						location.href=event.url;
						return false;
					}
				}, */ eventColor: '#00cee8'
		})
		$("#mypage_communitylist").on('change',function(){
			var comm_num=$('#mypage_communitylist option:selected').val();
			var gathering=$('#comm_gathering option:selected').val();
			var comm_name=$('#mypage_communitylist option:selected').text();
			location.href=getPageContext+"/mypage/mycommcalendar?comm_num="+comm_num
					+"&comm_name="+comm_name+"&gathering="+gathering;
		});
		$("#comm_gathering").on('change',function(){
			var comm_num=$('#mypage_communitylist option:selected').val();
			var gathering=$('#comm_gathering option:selected').val();
			var comm_name=$('#mypage_communitylist option:selected').text();
			location.href=getPageContext+"/mypage/mycommcalendar?comm_num="+comm_num
					+"&comm_name="+comm_name+"&gathering="+gathering;
		});
	});
</script>
<div id="mypage_comm_calendar_wrap" style="width: 90%; margin: auto; margin-top: 30px;">
	<span>
		<select id="mypage_communitylist" class="form-control" style="width:20%;" >
		<option value="all">커뮤니티</option>
		<c:forEach var="communitylist" items="${ communitylist}">
		<option value="${communitylist.comm_num }" <c:if test="${communitylist.comm_name ==comm_name }"> selected="selected"</c:if>>${communitylist.comm_name }</option> 
		</c:forEach>
		</select>
		<select id="comm_gathering" class="form-control" style="width:10%;margin: -2.5% 0% 0% 21%;">
			<option value="gathering">전체</option>
			<option value="attend" <c:if test="${gathering =='attend' }"> selected="selected"</c:if>>참석</option>
			<option value="not_attend" <c:if test="${gathering =='not_attend' }"> selected="selected"</c:if>>불참</option>
		</select>
	</span>
	<br>
	<div id='mypage_comm_calendar'></div>
</div>
