<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" id="getPageContext" value="<c:url value='/'/>" >
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
						id:'${list.cc_num}', 
					  title: '${list.cc_name}',  
	                   start: '${list.cc_begin}',
	                   end: '${list.cc_end}',
	                   url: getPageContext+'/mypage/mycommcalendar'
				}, 
				</c:forEach>
				],
				eventMouseover:function(calEvent,jsEvent,view){
					//alert("title: "+calEvent.title);
					//alert("jsEvent: "+jsEvent.pageX);
					$(this).css('border-color','red');
					$('<div class="calevent">'+calEvent.title+'</div>').appendTo(this).css({zIndex:999,'border':'lightpink 1px solid','backgroundColor':'lightpink',pageX:jsEvent.pageX+100,pageY:jsEvent.pageY+100});
				},
				eventMouseout:function(calEvent,jsEvent,view){
					$(".calevent").empty();
				},
				eventClick:function(event){
					/* if(event.url){
						location.href=event.url;
						// window.open(event.url);
						return false;
					} */
				}
		})
	});
</script>
<div id="mypage_comm_calendar_wrap"
	style="width: 90%; margin: auto; margin-top: 30px;">
	<div id='mypage_comm_calendar'></div>
</div>
