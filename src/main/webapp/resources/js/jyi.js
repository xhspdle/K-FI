/**
 * jyi.js
 */

$(function() {
	var url=$("#url").val();
	
	/* mypage calendar에 날짜넣기 */
	$("#icon_calendar").click(function(){
		$(this).empty();
		$.getJSON(url+"/mypage/mycalendarscroll",function(data){
			var cal=$("#icon_calendar");
			var week=data.week;
			var arr=data.arr;
			cal.empty();
			cal.append("<h4>"+data.year+" "+data.mon+"</h4>");
			cal.append("<table class='table table-bordered' id='jyi_calendar'>");
			cal.append("<tr>");
			for(var i=0;i<week.length;i++){
				cal.append("<th class='jyi_week'>"+week[i]+"</th>");
			}
			cal.append("</tr>");
			var j=0;
			cal.append("<tr>");
			for(var i=0;i<arr.length;i++){
				if(arr[i]==0){
					cal.append("<td class='jyi_cal_sc'></td>");
				}else if(j%7==0){
					cal.append("<tr></tr>");
					cal.append("<td class='jyi_cal_sc'><a class='jyi_a' href='#' style='color:red;'>"+arr[i]+"</a></td>");
				}else if(j%7==6){
					cal.append("<td class='jyi_cal_sc'><a class='jyi_a' href='#' style='color:blue;'>"+arr[i]+"</a></td>");
				}else{
					cal.append("<td class='jyi_cal_sc'><a class='jyi_a' href='#'>"+arr[i]+"</a></td>");
				}
				j++;
			}
			cal.append("</tr>");
			cal.append("</table>");
			$("#mycalendarscroll").css({
				zIndex:999,
				drag:false
			});
		});
	});
	
	//mycommcalendar의 calendar의 달력 mouseover시 일정보이기 
	$(".jyi_a").hover(function(){
		var year=$("#year").val();
		var month=$("#month").val();
		var day=$(this).prop("id");
		var url=$("#url").val();
		$.getJSON(url+"/mycommCalendar/list",{year:year,month:month,day:day},function(data){
			
			
		});
	},function(){
		
		
	});
	
	
	// left side bar 열고 닫기
	$("#mycomm_cal_profile").click(function() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6" || center === "col-sm-offset-3 col-sm-9" ) {
			/* left right 모두 열린 상태 */
			closeLeft();
		} else if (center === "col-sm-9" || center === "col-sm-12") {
			/* left right 모두 닫힌 상태 */
			openLeft();
		}
	});

	// left side bar 닫기
	function closeLeft() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6" ) {
		$("#leftside").removeClass("col-sm-3 sidenav").hide();
		$("#center").removeClass("col-sm-offset-3 col-sm-6");
		$("#center").addClass("col-sm-9");
		}else if(center === "col-sm-offset-3 col-sm-9" ){
			$("#leftside").removeClass("col-sm-3 sidenav").hide();
			$("#center").removeClass("col-sm-offset-3 col-sm-9");
			$("#center").addClass("col-sm-12");
		}
	}

	// left side bar 열기
	function openLeft() {
		$("#leftside").addClass("col-sm-3 sidenav").show();
		var center = $("#center").prop("class");
		if (center === "col-sm-9") {
			$("#center").removeClass("col-sm-9");
			$("#center").addClass("col-sm-offset-3 col-sm-6").show();
		} else if (center === "col-sm-12") {
			$("#center").removeClass("col-sm-12");
			$("#center").addClass("col-sm-offset-3 col-sm-9").show();
		}
	}

	// right side bar 열고 닫기
	$("#mycomm_cal_chat").click(function() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6"  || center === "col-sm-9") {
			closeRight();
		} else if (center === "col-sm-offset-3 col-sm-9" || center === "col-sm-12") {
			openRight();
		}
	});

	// right side bar 닫기
	function closeRight() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6" ) {
			$("#rightside").removeClass("col-sm-3").hide();
			$("#center").removeClass("col-sm-offset-3 col-sm-6");
			$("#center").addClass("col-sm-offset-3 col-sm-9").show();
		}else if(center === "col-sm-9"){
			$("#rightside").removeClass("col-sm-3").hide();
			$("#center").removeClass("col-sm-9");
			$("#center").addClass("col-sm-12").show();
		}
	}

	// right side bar 열기
	function openRight() {
		$("#rightside").addClass("col-sm-3").show();
		var center = $("#center").prop("class");
		if (center === "col-sm-12") {
			$("#center").removeClass("col-sm-12");
			$("#center").addClass("col-sm-9").show();
		} else if (center === "col-sm-offset-3 col-sm-9") {
			$("#center").removeClass("col-sm-offset-3 col-sm-9");
			$("#center").addClass("col-sm-offset-3 col-sm-6").show();
		}
	}
	
	// left side bar의 달력 날짜 클릭하면 해당 날짜의 게시물 위치로 이동
	$(".jyi_cal_left a").click(function(event){
		event.preventDefault();
		var year=$("#year").val();
		var month=$("#month").val(); 
		var m=month.slice(1,2);
		if(m==='') {
			month=parseInt(month);
			month+=1;
			if(month<10){
				month=month.toString();
				month="0"+month;
			}
		}
		var day=$(this).prop("id");
		var d=day.slice(1,2);
		if(d==='') day="0"+day;
		alert("#"+year+month+day);
		var top=$("#"+year+month+day).offset().top; 
		// 상단을 기준으로 #요소가 위치한 거리를 절대좌표로 반환
		$("html, body").animate({
			scrollTop:top
		},1000);
	});
	
	
	
});