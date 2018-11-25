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
		var url=$('#getContextPath').val();
		/* 		$('#calendar').fullCalendar('removeEvents');
		 $('#calendar').fullCalendar('refetchEvents'); */
		/* var title = $("input[name=cc_name] schedule-title").val();
		var start = $("input[name=start").val();
		var end = $("input[name=end").val(); */
		$('#calendar').fullCalendar({
			displayEventTime : false,
			editable : false,
			selectable : true,
			eventLimit : true,
			header : {
				left : '',
				center : 'prevYear prev title next nextYear',
				right : 'today'
			},
			events : [ 
				<c:forEach var="list" items="${list}"> 
				{
						id:'${list.cc_info}', 
					  title: '${list.cc_name}',  
	                   start: '${list.cc_begin}',
	                   end: '${list.cc_end}',
				}, 
				</c:forEach>
				],
			        eventClick: function(event, jsEvent, view) {
			            console.log(event.start.format());
			            console.log(event.title);
			            $('#fullCalModal').modal();
			            var r = confirm("Delete " + event.title);
			            if (r === true) {
			              $('#calendar').fullCalendar('removeEvents', event._id);
			            } 
					}
		});
 	$('#addevent-btn').on('click', function() {
			alert("complete");
 	});
 	$('#calendar').fullCalendar({
 		  eventClick: function(event, jsEvent, element) {

 		    event.title = "CLICKED!";
 		   $('#fullCalModal').modal();
 		  }
 		});
 	$('.fc-content').on('click', function(){
 		var cc_name = $("#schedule-title").val();
 		alert(cc_name);
 		alert("삭제하시겠습니까?");
 		$.ajax({
			async : false,
			type : "GET",
			url : url + '/community/delete',
			data : {
				'cc_title' : cc_title
			},
			dataType : "json",
			success : function(data) {
				console.log(data)
				
				}
			
 	});
 	});
 	$("#update-btn").on('click', function(){
 		
 	});
	});
</script>

<div class="container">
	<input type="hidden" id="getContextPath" value="<c:url value='/'/>">
	<div id='createSchedule'>
		<button class="btn btn-info" id="schedule-btn" data-toggle="modal"
			data-target="#myModal">Add Event</button>
	</div>
	<div id='calendar' style="z-index: 999"></div>
</div>

<!-- ///////////////////////////////// Add Event  //////////////////-->
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
				<form action="<c:url value='/community/commcalendar'/>"
					name="addevent" role="form" id="addevent-form" class=""
					method="post">
					<div class="form-box">
						<div class="form-group">
							<label class="form-control-label" for="findpwd-email">Title</label><br>
							<input type="text" name="cc_name" id="schedule-title"
								class="form-control" placeholder="Title" maxlength="50">
						</div>
						<div class="form-group">
							<label for="findpwd-code">Description</label> <input type="text"
								name="cc_info" id="findpwd-code" class="form-control"
								placeholder="Description" maxlength="200">
							<div class="startDate">
								<div>
									<label for="">Start Date</label>
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="far fa-calendar-alt"></i></span> <input type="date" id="start"
										class="startpickDate" name="cc_begin" placeholder="Date">
								</div>
							</div>
						</div>
						<div class="endDate">
							<div>
								<label for="">End Date</label>
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="far fa-calendar-alt"></i></span> <input type="date" id="end"
									class="endpickDate" name="cc_end" placeholder="Date">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default" id="addevent-btn">OK</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- ///////////////////////////////// Edit Event  //////////////////-->

<div id="fullCalModal" class="modal fade in" role="dialog"
	style="display:">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<div>
					<label class="form-control-label" for="" id="schedule-header">Edit
						Event</label>
				</div>
			</div>
			<div class="modal-body" id="modalBody">
				<form action="<c:url value='/community/delete'/>" name="eventedit"
					role="form" id="addevent-form" class="" method="post">
					<input type="hidden" name="cc_num" id="cc_num">
					<div class="form-box">
						<div class="form-group">
							<input type="hidden" name="cc_num" id="cc_num"> <label
								class="form-control-label" for="findpwd-email">Title</label><br>
							<input type="text" name="cc_name" id="schedule-title"
								class="form-control" placeholder="Title" value="" maxlength="50">
						</div>
						<div class="form-group">
							<label for="findpwd-code">Description</label> <input type="text"
								name="cc_info" id="findpwd-code" class="form-control"
								placeholder="Description" value="" maxlength="200">
							<div class="startDate">
								<div>
									<label for="">Start Date</label>
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="far fa-calendar-alt"></i></span> <input type="date" id="start"
										class="startpickDate" name="cc_begin" value=""
										placeholder="Date">
								</div>
							</div>
						</div>
						<div class="endDate">
							<div>
								<label for="">End Date</label>
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="far fa-calendar-alt"></i></span> <input type="date" id="end"
									class="endpickDate" name="cc_end" value="" placeholder="Date">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-info" id="update-btn">Edit</button>
						<button type="submit" class="btn btn-danger" id="del-btn">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



