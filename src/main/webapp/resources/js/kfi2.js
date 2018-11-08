/**
 * kfi2.js
 */

////////////////////////////////////////////////////////////mini calendar 

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

	
	
//////////////////////////////////////////////////////////myskin
	
	/* myskin insert 미리보기 */
	$('#ms_color').on('change',function(){
		var color=$(this).val();
		$("#preview_navbar").css({
			'background-color':color,
			'zIndex':1
		});
		$("#preview_cover button").css({
			'background-color':color,
			'zIndex':2
		});
		
		
	});

	var once=0;
	$('#ms_msg').on('keyup',function(){
		++once;
		if(once==1){
			$("#preview_msg").setTimer=function(){
				$(this).html('');
			}
		}
		var msg=$('#ms_msg').val();
		$("#preview_msg").html(msg);
	});

	$('#ms_profile').on('change',function(event){
		var file=event.target.files[0];
		var filePath=URL.createObjectURL(file);
		$("#profile_preview").prop('src',filePath);
	});
	

	$('#ms_cover').on('change',function(event){
		var file=event.target.files[0];
		var filePath=URL.createObjectURL(file);
		$("#preview_cover").css('background','url('+filePath+')');
	});
	
	
	/////////////////////////회원정보 확인
	$('#myinfo_pwd_submit').on('click',function(){
		var password=$('#myinfo_pwd').val();
		if(password==''){
			$('#myinfo_pwd_result').text('비밀번호를 입력해주세요').css('color','red');
			return false;
		}
	});
	
	$('#myinfo_pwdChk_frm').submit(function(event){
		event.preventDefault();
		$('#myinfo_pwd_result').text('');
		var getPageContext=$('#getPageContext').val();
		var password=$('#myinfo_pwd').val();
		if(password==''){
			$('#myinfo_pwd_result').text('비밀번호를 입력해주세요').css('color','red');
			return false;
		}
		$.getJSON(getPageContext+'/mypage/myinfo/passwordChk',{password:password},function(data){
			if(eval(data.code)){
				location.href=getPageContext+"/mypage/myinfo/list";
			}else{
				$('#myinfo_pwd_result').text('비밀번호가 올바르지 않습니다').css('color','red');
			}
		});
	});
	
	//수정하기
	$("#myinfo_update_submit").on('click',function(){
		var user_pwd=$("input[name=user_pwd]").val();
		if(user_pwd==''){
			alert('비밀번호를 입력해주세요');
			return false;
		}
		var user_nickname=$("input[name=user_nickname]").val();
		if(user_nickname==''){
			alert('닉네임을 입력해주세요');
			return false;
		}
		var user_email=$("input[name=user_email]").val();
		if(user_email==''){
			alert('이메일을 입력해주세요');
			return false;
		}
		return true;
	});
	
	$("#myinfo_list").submit(function(event){
		event.preventDefault();
		var getPageContext=$('#getPageContext').val();
		var user_pwd=$("input[name=user_pwd]").val();
		if(user_pwd==''){
			alert('비밀번호를 입력해주세요');
			return false;
		}
		var user_nickname=$("input[name=user_nickname]").val();
		if(user_nickname==''){
			alert('닉네임을 입력해주세요');
			return false;
		}
		var user_email=$("input[name=user_email]").val();
		if(user_email==''){
			alert('이메일을 입력해주세요');
			return false;
		}
		$.getJSON(getPageContext+'/mypage/myinfo/updateJSON',{user_pwd:user_pwd,user_nickname:user_nickname,user_email:user_email},
				function(data){
			
			
			
		});
		
	});
	
	//탈퇴하기
	$("#myinfo_delete").on('click',function(){
		var myinfo_delete_user_pwd=$("input[name=myinfo_delete_user_pwd]").val();
		if(myinfo_delete_user_pwd==''){
			alert('비밀번호를 입력해주세요');
			return false;
		}
		return true;
	});
	
	$("#myinfo_delete_frm").submit(function(event){
		event.preventDefault();
		var getPageContext=$('#getPageContext').val();
		var myinfo_delete_user_pwd=$("input[name=myinfo_delete_user_pwd]").val();
		$.getJSON(getPageContext+'/mypage/myinfo/deleteJSON',{user_pwd:myinfo_delete_user_pwd},function(data){
			if(data.result==0){
				location.href=".main";
			}else{
				alert("비밀번호가 일치하지 않아요");
			}
		});
	});
});

/* 해당 스킨 적용하기 */
function mySkinApply(num){
	var getPageContext=$("#getPageContext").val();
	$.getJSON(getPageContext+'/mypage/myskin/select',{ms_num:num},function(data){
		var vo=data[0];
		alert(vo);
		$("#profileImg").prop('src',getPageContext+'/resources/upload/img/'+vo.msp_savimg);
		$("#mypageJumbo > div:after").css('background','url('+getPageContext+'/resources/upload/img/'+vo.msc_savimg+')');
	});
}