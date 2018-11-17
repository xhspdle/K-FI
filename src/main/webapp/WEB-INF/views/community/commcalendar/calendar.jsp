<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<style>
body {
	margin: 0;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

.createSchedule button {
	font-size: 30px;
}

#calendar {
	max-width: 900px;
	margin: 50px auto;
}

#createSchedule {
	float: right;
	margin-right: 12%;
	font-size: 20px;
}

#schedule-btn {
	font-family: "Montserrat", sans-serif;
	font-size: 18px;
}

.form-box {
	margin: 5%;
}

#schedule-header {
	font-size: 20px;
	text-align: center;
}
</style>
<script>
	$(function() { 
		$('#calendar').fullCalendar(
				{
					editable : false,
					selectable : true,
					eventLimit : true, 
					header : {
						left : 'today',
						center : 'prevYear prev title next nextYear',
						right : ''
					},
					views : {
						agendaTwoDay : {
							type : 'agenda',
							duration : {
								days : 2
							},

							groupByResource : false

						}
					},

					resources : [ {
						id : 'a',
						title : '일정 2'
					}, {
						id : 'b',
						title : '일정 1',
						
					}, {
						id : 'c',
						title : 'Room C',
						eventColor : 'orange'
					}, {
						id : 'd',
						title : 'Room D',
						eventColor : 'red'
					} ],
					events : [ {
						id : '1',
						resourceId : 'b',
						start : '2018-11-06',
						end : '2018-11-08',
						title : '일정 1'
					}, {
						id : '2',
						resourceId : 'a',
						start : '2018-11-20T09:00:00',
						end : '2018-11-20T14:00:00',
						title : '일정 2'
					}, {
						id : '3',
						resourceId : 'b',
						start : '2018-11-17T09:00:00',
						end : '2018-11-18T09:00:00',
						title : '바쁜 일정1'
					}, {
						id : '3',
						resourceId : 'b',
						start : '2018-11-17T11:00:00',
						end : '2018-11-18T13:00:00',
						title : '바쁜일정 2'
					}, {
						id : '3',
						resourceId : 'b',
						start : '2018-11-17T13:00:00',
						end : '2018-11-18T14:00:00',
						title : '바쁜 일정3'
					}, {
						id : '3',
						resourceId : 'b',
						start : '2018-11-17T20:00:00',
						end : '2018-11-18T21:00:00',
						title : '바쁜 일정4'
					}, {
						id : '3',
						resourceId : 'b',
						start : '2018-11-17T20:00:00',
						end : '2018-11-18T21:00:00',
						title : '바쁜 일정5'
					}, {
						id : '4',
						resourceId : 'c',
						start : '2018-11-01T11:30:00',
						end : '2018-11-01T16:30:00',
						title : '정모'
					}, {
						id : '5',
						resourceId : 'd',
						start : '2018-11-23T10:00:00',
						end : '2018-11-23T15:00:00',
						title : '뒷풀이'
					} ],

					/* select : function(start, end, jsEvent) {
						console.log('select', start.format(), end.format());
						alert(start.format());
						alert(end.format());
					}, */
					dayClick : function(date, jsEvent, view, resource) {
						console.log('dayClick', date.format(),
								alert(date.format())+
								resource ? resource.id : '(no resource)');
					}
					
				});
	});
</script>

<!-- ///////////////////////////////// 모달 //////////////////-->
<div class="container">
	<div id='createSchedule'>
		<button class="btn btn-info" id="schedule-btn" data-toggle="modal"
			data-target="#myModal">Add Event</button>
	</div>
	<div id='calendar'></div>
</div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<div>
					<label class="form-control-label" for="" id="schedule-header">Add
						Event</label>
				</div>
			</div>
			<div class="modal-body">
				<div class="form-box">
					<form action="<c:url value=''/>" name="addevent" role="form"
						id="addevent-form" class="" method="post">
						<div class="form-group">
							<label class="form-control-label" for="findpwd-email">Title</label><br>
							<input type="text" name="user_email" id="schedulename"
								class="form-control" placeholder="Title" maxlength="50">
						</div>
						<div class="form-group">
							<label for="findpwd-code">Description</label> <input type="text"
								name="" id="findpwd-code" class="form-control"
								placeholder="Description" maxlength="200">
							<div class="startDate">
							<div>
								<label for="">Start Date</label>
							</div>
								 <input type="text" id="date"class="startpickDate" name="startDate" placeholder="Date">
								 <i class="far fa-calendar-alt"></i>
							</div>
							<div class="endDate">
								<div>
									<label for="">End Date</label>
								</div>
								<input type="text" id="date" class="endpickDate"
									placeholder="Date"><i class="far fa-calendar-alt"></i>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- ///////////////////////////////// 모달 //////////////////-->