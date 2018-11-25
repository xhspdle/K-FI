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
		var getContextPath=$('#getContextPath').val();
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
			<c:forEach var="vo" items="${list}"> 
			{
				id:'${vo.cc_num}', 
		 		title: '${vo.cc_name}',  
                start: '${vo.cc_begin}',
                end: '${vo.cc_end}'
			}, 
			</c:forEach>
			],
	        eventClick: function(event, jsEvent, view) {
	            $.getJSON(getContextPath + "/community/commcalendar/select",
	            		{'cc_num':event.id},
	            		function(json){
	            			var select=json.select;
	            			var cc_num=select.cc_num;
							var comm_num=select.comm_num;
							var cc_name=select.cc_name;
							var cc_info=select.cc_info;
							var cc_begin=select.cc_begin;
							var cc_end=select.cc_end;
							$("input[name='cc_num']").val(cc_num);
							$("input[name='comm_num']").val(comm_num);
							$("input[name='cc_name']").val(cc_name);
							$("input[name='cc_info']").val(cc_info);
							$("input[name='cc_begin']").val(cc_begin);
							$("input[name='cc_end']").val(cc_end);
	            		});
	            $('#fullCalModal').modal();
			}
		});
	 	$("#del-btn").click(function(event){
	 		event.preventDefault();
	 		var cc_num=$(this).parent().parent().find("input[name='cc_num']").val();
	 		$.getJSON(getContextPath + "/community/commcalendar/delete",
					{'cc_num':cc_num},
					function(json){
						var code=json.code;
						if(code==='success'){
							location.href=getContextPath + "/community/commcalendar/list";
						}else {
							$.msgBox(code);
						}
					});	
	 	});
	 	$("#update-btn").click(function(event){
	 		event.preventDefault();
	 		var formData=new FormData($(this).parent().parent().get(0));
	 		$.ajax({
	 			url: getContextPath + "/community/commcalendar/update",
	 			type: 'post',
	 			dataType: 'json',
	 			data: formData,
	 			cache: false,
	 			contentType: false,
	 			processData: false,
	 			success: function(json){
	 				if(json.code==='success'){
	 					location.href=getContextPath + "/community/commcalendar/list";
	 				}else{
	 					$.msgBox(json.code);
	 				}
	 			}
	 		});
	 	});
	});
</script>
<input type="hidden" id="isSelect" value="${select.cc_num }">
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
				<form action="<c:url value='/community/commcalendar/insert'/>"
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
										class="startpickDate" name="cc_begin" placeholder="Date" value="">
								</div>
							</div>
						</div>
						<div class="endDate">
							<div>
								<label for="">End Date</label>
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="far fa-calendar-alt"></i></span> 
									<input type="date" id="end"
									class="endpickDate" name="cc_end" placeholder="Date" value="">
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
					role="form" id="editevent-form" class="" method="post">
					<input type="hidden" name="cc_num" id="" value="${select.cc_num }">
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



