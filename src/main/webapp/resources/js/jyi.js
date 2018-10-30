/**
 * jyi.js
 */

$(function() {
	var url=$("#url").val();
	
	/* mypage mini calendar에 날짜넣기 */
	$("#icon_calendar").click(function(){
		var calendarClass=$("#wrap_icon_calendar").prop("class");
		if(calendarClass==='well'){
			$("#wrap_icon_calendar").empty();
			$("#wrap_icon_calendar").removeClass("well").css("width",0);
		}else{
			var year=$("#year").val();
			var month=$("#month").val();
			makeCalendar(year, month);
		}
	});
	
	function makeCalendar(year, month){
		$('#wrap_icon_calendar').empty();
		$("#wrap_icon_calendar").addClass("well").css("width",320);
		var date=new Date();
		if(year==="year"){
			year=date.getFullYear();
			month=date.getMonth();
			date=new Date(year,month);
		}
		if (month == -1) {
			year -= 1;
			month = 11;
		}else if (month == 12) {
			year += 1;
			month = 0;
		}
		var nowDateYear=new Date().getFullYear();
		var monthEng=['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September',
				'October', 'November', 'December'];
		$("#wrap_icon_calendar").append(
				"<h4 id='miniym'><span><a id='prevmon' class='btn btn-default' role='button'> < </a>"
				+"<select id='yearArr'></select>"+" "+monthEng[month]+" "
				+"<a id='aftmon' class='btn btn-default' role='button'> > </a>"
				+"</span></h4>");
		for(var i=nowDateYear;i>=2000;i--){
			$('#yearArr').append("<option value='"+i+"'>"+i+"</option>");
		}
		$('#yearArr').val(year);
		var week=['SUN','MON','TUE','WED','THU','FRI','SAT'];
		for(var i=0;i<week.length;i++){
			$("#wrap_icon_calendar").append("<div class='mini_cal_week'>"+week[i]+"</div>");
		}
		var total=0;
		var w=new Date(year,month,1).getDay();
		//앞공백
		for(var i=0;i<w;i++){ 
			$("#wrap_icon_calendar").append("<div class='mini_cal'></div>");
			total+=1;
		}
		var m=['4','6','9','11'];
		var end=31;
		for(var i=0;i<m.length;i++){
			if((month+1)==m[i]) {
				end=30;
			}
		}
		if((year%4==0 && year%100!=0||year%400==0) && month==1) {
			end=29;
		}else if(month==1){
			end=28;
		}
		for(var i=1;i<=end;i++){
			if(total%7==0){
				$("#wrap_icon_calendar").append("<div class='mini_cal'><a href='#' id='"+i+"' class='mini_cal_a' style='color:red;'>"+i+"</a></div>");
			}else if(total%7==6){
				$("#wrap_icon_calendar").append("<div class='mini_cal'><a href='#' id='"+i+"' class='mini_cal_a' style='color:blue;'>"+i+"</a></div>");
			}else{
				$("#wrap_icon_calendar").append("<div class='mini_cal'><a href='#' id='"+i+"' class='mini_cal_a' >"+i+"</a></div>");
			}
			total+=1;
		}
		//뒷공백
		if(total>(7*5)) total=(7*6)-total;
		else if(total>(7*4)) total=(7*5)-total;
		else if(total=(7*4)) total=0;
		for(var i=0;i<total;i++){ 
			$("#wrap_icon_calendar").append("<div class='mini_cal'></div>");
		}
		$("#year").val(year);
		$("#month").val(month);
		$("#ym").text(year+' '+month);
	}
	
	/* 클릭한 연도의 달력 출력*/
	$('#wrap_icon_calendar').on('change','#yearArr',function(){
			var year=parseInt($(this).val());
			var month=parseInt($("#month").val());
			makeCalendar(year, month);
	});

	/* 현재 날짜의 이전달 달력 출력 */
	$('#wrap_icon_calendar').on('click','#prevmon',function(){
		var year=parseInt($("#year").val());
		var month=parseInt($("#month").val());
		month-=1;
		makeCalendar(year, month);
	});

	/* 현재 날짜의 다음달 달력 출력 */
	$('#wrap_icon_calendar').on('click','#aftmon',function(){
		var year=parseInt($("#year").val());
		var month=parseInt($("#month").val());
		month+=1;
		makeCalendar(year, month);
	});
	
	// 달력 날짜 클릭하면 해당 날짜의 게시물 위치로 이동
	$("#wrap_icon_calendar").on('click','.mini_cal_a',function(event){
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
		var top=$("#"+year+"-"+month+"-"+day).offset().top; 
		// 상단을 기준으로 #요소가 위치한 거리를 절대좌표로 반환
		$("html, body").animate({
			scrollTop:top
		},1000);
	});

	//마이페이지 전체 일정
	var now=new Date().getFullYear();
	for(var i=now;i>=2000;i--){
		$('#mycomm_year').append('<option>'+i+'</option>');
	}
	
	$('#mycommunitylist').on('click',function(){
		var url=$('#url').val();
		$.getJSON(url+'/mycomm/mycommunitylist',function(data){
			alert("??");			
			/*for(var i=0;i<data.length;i++){
				$("#mycommunitylist").append('<option>'+data[i].comm_name+'</option>');
			}*/
		});
	});
	
	//마이페이지 전체일정 달력 mouseover하면 해당날짜 상세 일정보이기 
	$(".mycomm_a").parent().hover(function(){
		var year=$("#year").val().slice(2,4);
		var month=$("#month").val();
		if(month.slice(1,2)===''){
			month='0'+month;
		}
		var day=$(this).children().prop("id");
		if(day.slice(1,2)===''){
			day='0'+day;
		}
		var url=$("#url").val();
		$.getJSON(url+"/mycommCalendar/list",{year:year,month:month,day:day},function(data){
			//$('#'+day).parent().empty();
			var begin=data.list;
			if(day===begin){
				$('<div>'+data.cc_info+'</div>').appendTo('#'+day).parent().css({width:100,height:100,zIndex:999,backgroundcolor:'orange'});
			}
		});
	},function(){
		
		
	});
	
	$('#mycommunitylist').on('change',function(){
		$(this).val();
		
		
	});
	
	
	
	
	
	
});