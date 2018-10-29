/**
 * jyi.js
 */

$(function() {
	var url=$("#url").val();
	var n=1;
	
	/* mypage calendar에 날짜넣기 */
	$("#icon_calendar").click(function(){
		if(n%2==0){
			$(this).empty();
			$("#wrap_icon_calendar").removeClass("well").css("width",0);
		}else{
			$("#wrap_icon_calendar").addClass("well").css("width",320);
			var year=$("#year").val();
			var month=$("#month").val();
			var date=new Date();
			if(year==="year"){
				year=date.getFullYear();
				month=date.getMonth();
				date=new Date(year,month);
			}
			var monthEng=['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September',
					'October', 'November', 'December'];
			$(this).append("<h4 id='miniym'><span><a id='prevmon' class='btn btn-default' role='button'> < </a>"
					+" "+year+" "+monthEng[month]+" "
					+"<a id='aftmon' class='btn btn-default' role='button'> > </a>"
					+"</span></h4>");
			var week=['SUN','MON','TUE','WED','THU','FRI','SAT'];
			for(var i=0;i<week.length;i++){
				$(this).append("<div class='mini_cal_week'>"+week[i]+"</div>");
			}
			var total=0;
			var w=new Date(year,month,1).getDay();
			//앞공백
			for(var i=0;i<w;i++){ 
				$(this).append("<div class='mini_cal'></div>");
				total+=1;
			}
			var m=['4','6','9','11'];
			var end=31;
			for(var i=0;i<m.length;i++){
				if((month+1)===m[i]) end=30;
			}
			if((year%4==0 && year%100!=0||year%400==0) && month==1) end=29;
			for(var i=1;i<=end;i++){
				if(total%7==0){
					$(this).append("<div class='mini_cal'><a href='#' id='"+i+"' class='mini_cal_a' style='color:red;'>"+i+"</a></div>");
				}else if(total%7==6){
					$(this).append("<div class='mini_cal'><a href='#' id='"+i+"' class='mini_cal_a' style='color:blue;'>"+i+"</a></div>");
				}else{
					$(this).append("<div class='mini_cal'><a href='#' id='"+i+"' class='mini_cal_a' >"+i+"</a></div>");
				}
				total+=1;
			}
			//뒷공백
			if(total>(7*5)) total=(7*6)-total;
			else if(total>(7*4)) total=(7*5)-total;
			for(var i=0;i<total;i++){ 
				$(this).append("<div class='mini_cal'></div>");
			}
			$("#year").html(year);
			$("#month").html(month);
			$("#ym").text(year+" "+month);
		}
		n++;
	
	});
	
	/*
	$("#prevmon").click(function(){
		
		
	});
	
	$("#aftmon").click(function(){
		
		
	});
	*/
	
	
	//mycommcalendar의 calendar의 달력 mouseover시 일정보이기 
	$(".jyi_a").hover(function(){
		var year=$("#year").html();
		var month=$("#month").html();
		var day=$(this).prop("id");
		var url=$("#url").val();
		$.getJSON(url+"/mycommCalendar/list",{year:year,month:month,day:day},function(data){
			
			
		});
	},function(){
		
		
	});
	
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