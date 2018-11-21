$(document).ready(function() {

	$('#external-events .fc-event').each(function() {

		// store data so the calendar knows to render an event upon drop
		$(this).data('event', {
			title: $.trim($(this).text()), // use the element's text as the event title
			stick: true, // maintain when user navigates (see docs on the renderEvent method),
		});

		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,
			revert: true,      // will cause the event to go back to its
			revertDuration: 0  //  original position after the drag
		});

	});

	$('#calendar').fullCalendar({

		events: 'model/getDiaryList.php',
		firstDay: 0, // 0=�쇱슂��, 1=�붿슂��
		weekNumbers: false, // true�쇰븣 ��(Month) �좏깮�� 二쇱감 �쒖떆, false �쇨꼍�� 二쇱감 �쒖떆 �덊븿.
		weekNumbersWithinDays: true,
		weekNumberCalculation: 'ISO',
		locale: 'ko',
		
		eventClick: function(event, calEvent, jsEvent, view) {
			clickEvent(event, calEvent);
		},
		eventDrop: function( event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view ) {
			moveEvent(event);
		},
		eventResize:function( event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view ) { 
			resizeEvent(event);
		},

		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay,listWeek'
		},
		navLinks: true, // can click day/week names to navigate views

		editable: true, // true �쇰븣 �쒕옒洹� �먮뒗 �ъ씠利� 議곗젙�� �섎룄濡앺븿, false �쇨꼍�� �쒕옒洹� �먮뒗 �ъ씠利� 議곗젙�� �섏� �딆쓬
		droppable: true, // �щ젰�� �쒕옒洹명빐�� �⑥뼱�몃젮以꾩닔 �덇쾶 �쒕떎.
		drop: function(date , jsEvent , ui , resourceId) {
			// is the "remove after drop" checkbox checked?
			if ($('#drop-remove').is(':checked')) {
				//$(this).remove(); // if so, remove the element from the "Draggable Events" list

				var bg_color = $(this).attr("bg_color");
				var text_color = $(this).attr("text_color");
				putDiaryInsert(date["_d"].toJSON(), bg_color, text_color); // �쇱젙 異붽��섍린
			}
		},

		/** �쒕옒洹몃줈 ��젣�섎뒗 湲곕뒫 A */
		eventDragStop: function( event, jsEvent, ui, view ) {
			if (isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
					$('#calendar').fullCalendar('removeEvents', event._id);
					var el = $( "<div class='fc-event'>" ).appendTo( '#external-events-listing' ).text( event.title );
					el.draggable({
						zIndex: 999,
						revert: true, 
						revertDuration: 0 
					});
						
					$.ajax({
						url:"model/putDiaryTrashDelete.php",
						type:"post",
						data:{"seq":event.id}
					});

					el.data('event', { title: event.title, id :event.id, stick: true });
					
			}
		},
		
		/**  留덉�留� �좎쭨 由щ줈�� */
		defaultDate: localStorage.getItem('defaultFullCalendarDate'),
		viewRender: function(view) {
			var currentDate = $('#calendar').fullCalendar('getDate').toDate();
			localStorage.setItem('defaultFullCalendarDate', currentDate);
		},


	});

	/** �쒕옒洹� ��젣湲곕뒫 B */
	var isEventOverDiv = function(x, y) {
		var external_events = $( '#external-events' );
		var offset = external_events.offset();
		offset.right = external_events.width() + offset.left;
		offset.bottom = external_events.height() + offset.top;

		// Compare
		if (x >= offset.left && y >= offset.top && x <= offset.right && y <= offset .bottom) { 
			if (!confirm("�뺣쭚濡� ��젣�섏떆寃좎뒿�덇퉴?")) return;
			return true; 
		}
		return false;
	}
	
	startApplycation(); // �댄뵆由ъ��댁뀡 �쒖옉
});

$(document).ready(function() {

	/** �섏젙 紐⑤뱶�먯꽌 �ъ빱�� 湲곕뒫 */
	$('#fullCalModal').on('shown.bs.modal', function () {
	    $('#titleValue').focus();
	});

	/** �덈줈怨좎묠 */
	$('.fc-center').click(function () {
		location.reload();
	});

	/** �좎쭨�대┃ 湲곕뒫 ��젣 */
	$(".fc-day-number").removeAttr("data-goto");


});


//�댄뵆由ъ��댁뀡 �쒖옉
function startApplycation() {
	
}

// 罹섎┛�� 媛깆떊
function fullCalendarRefresh() {

	if (!checkLogin()) return;

	$('#calendar').fullCalendar('removeEvents');
	$('#calendar').fullCalendar('refetchEvents');
}

// 濡쒓렇�� 泥댄겕
function checkLogin() {
	return $("input[name=checkLogin]").val() ? true : false;
}

// �대┃ �대깽��
function clickEvent(event, calEvent) {
	//console.log(event); console.log(calEvent);

	$('#titleValue').val(event.title);
	$("input[name=eventId]").val(event.id);
	$('#fullCalModal').modal();

	// ���댄� �됱긽 SELECT
	var eventTitleColor = event.color == "#3a87ad" ? "default" : event.color;
	$(".colorSelect option").each( function(index, Element) {
		if (this.value == eventTitleColor) {
			$(this).prop("selected", "selected");
		} else {
			$(this).removeAttr("selected");
		}
	});
	
}

// �대룞 �대깽��
function moveEvent(event) {
	//console.log(event);

	var seq = event["id"];
	var startDate = event["start"]["_d"].toJSON();
	var EndDate = checkNullEndDate(event);

	putDiaryMoveUpdate(seq, startDate, EndDate);
}

// 由ъ궗�댁쫰 �대깽��
function resizeEvent(event) {
	//console.log(event);

	var seq = event["id"];
	var startDate = event["start"]["_d"].toJSON();
	var EndDate = checkNullEndDate(event);

	putDiaryResizeUpdate(seq, startDate, EndDate);
}

// endDate �� 泥댄겕
function checkNullEndDate(event) {
	return endDate = (event["end"]) ? event["end"]["_d"].toJSON() : null;
}


// �쇱젙 異붽� �대깽��
function putDiaryInsert(dateValue, bg_color, text_color) {
	$.ajax({
		url:'model/putDiaryInsert.php',
		dataType:'json',
		async: false,
		data:{"dateValue":dateValue, "bg_color":bg_color, "text_color":text_color},
		success:function(data) {} 
	});

	fullCalendarRefresh();
	
} // End of function

// �쇱젙 �대룞 �대깽��
function putDiaryMoveUpdate(seq, startDate, EndDate) {
	$.ajax({
		url:'model/putDiaryMoveUpdate.php',
		dataType:'json',
		data:{"seq":seq, "startDate":startDate, "EndDate":EndDate},
		success:function(data) {} 
	});
} // End of function

// �쇱젙 由ъ궗�댁쫰 �대깽��
function putDiaryResizeUpdate(seq, startDate, EndDate) {
	$.ajax({
		url:'model/putDiaryResizeUpdate.php',
		dataType:'json',
		data:{"seq":seq, "startDate":startDate, "EndDate":EndDate},
		success:function(data) {} 
	});
} // End of function


// �쇱젙 ���댄� �섏젙
function putTitleUpdate() {
	var title = $("input[name=titleValue]").val();
	var eventId = $("input[name=eventId]").val();
	var colorSelect= $("select[name=colorSelect]").val();

	$.ajax({
		url:'model/putTitleUpdate.php',
		async: false,
		data:{"title":title, "seq":eventId, "colorSelect":colorSelect},
		success:function(data) {
			fullCalendarRefresh();
			$('#fullCalModal').modal('hide');

			if (!checkLogin()) {
				alert("誘몃줈洹몄씤 �곹깭�먯꽌�� 諛섏쁺�섏� �딆뒿�덈떎.");
			}

		} 
	});
	
}

// 濡쒓렇��
function submitLogin() {
	if (!checkLoginInput()) return;
	
	$("input[name=loginMode]").val("login");

	var formObj = document.loginForm;
	formObj.action = "login.php";
	formObj.submit();
}

// 濡쒓렇�꾩썐
function userLogout() {
	if (!confirm('濡쒓렇�꾩썐 �섏떆寃좎뒿�덇퉴?')) return;

	$("input[name=loginMode]").val("logout");

	var formObj = document.loginForm;
	formObj.action = "login.php";
	formObj.submit();
}

// �깅줉
function submitRegister() {
	if (!checkLoginInput()) return;
	if (!confirm('�깅줉 �섏떆寃좎뒿�덇퉴?')) return;

	$("input[name=loginMode]").val("register");

	var formObj = document.loginForm;
	formObj.action = "login.php";
	formObj.submit();
}

// 濡쒓렇�� 諛� �깅줉 input 泥댄겕
function checkLoginInput() {
	if (!$("input[name=username]").val()) {
		alert("�꾩씠�붾� �낅젰�댁＜�몄슂.");
		$("input[name=username]").focus();
		return;
	}

	if (!$("input[name=password]").val()) {
		alert("鍮꾨�踰덊샇瑜� �낅젰�댁＜�몄슂.");
		$("input[name=password]").focus();
		return;
	}

	return true;
}

// �대깽�� 諛뺤뒪 �덈줈怨좎묠
function refreshEventBox() {
	location.reload();
}