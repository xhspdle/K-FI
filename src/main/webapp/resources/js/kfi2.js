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
		$("#wrap_icon_calendar").addClass("well").css("width",245);
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
		if(year > nowDateYear ){
			nowDateYear=year;
		}
		var monthEng=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep',
				'Oct', 'Nov', 'Dec'];
		$("#wrap_icon_calendar").append(
				"<h4 id='miniym'><span><a id='prevmon' class='btn btn-default' role='button'> < </a>"
				+"<select id='yearArr'></select></span><span>"+" "+monthEng[month]+" "
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
			if((parseInt(month)+1)==m[i]) {
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
		var top=$("#"+parseInt(year)+"-"+(parseInt(month)+1)+"-"+parseInt(day)).offset().top; 
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
		// 비밀번호 체크 
		var pwdck =/^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/; 
		if(!pwdck.test(user_pwd)){
			alert('영문, 숫자, 특수문자 포함해야합니다. (8~15자)');
			return false;	
		}
		if(user_pwd.search(/\s/) != -1) { 
			alert('비밀번호에 공백을 제거해주세요');
			return false; 
		}
		// 닉네임 체크
		var user_nickname=$("input[name=user_nickname]").val();
		if(user_nickname==''){
			alert('닉네임을 입력해주세요');
			return false;
		}
		var isNick = /^[a-zA-Z0-9가-힣]{4,15}$/; 
		if(user_nickname.search(/\s/) != -1){
			alert('닉네임에 공백을 제거해주세요');
			return false;
		}
		if(!isNick.test(user_nickname)){
			alert('영문,한글,숫자를 사용한 4~15자의 닉네임을 만들어 주세요');
			return false;
		}
		var user_email=$("input[name=user_email]").val();
		if(user_email==''){
			alert('이메일을 입력해주세요');
			return false;
		}
		$.getJSON(getPageContext+'/mypage/myinfo/updateJSON',{user_pwd:user_pwd,user_nickname:user_nickname,user_email:user_email},
				function(data){
			if(data.nickOk>1){
				alert('사용 중인 닉네임입니다');
			}else{
				if(data.result<0){
					alert("오류로 인해 회원정보 수정에 실패했습니다");
				}else{
					alert("회원정보 수정에 성공했습니다");
				}
				location.href=getPageContext+"/mypage/myinfo/list";
			}
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
		var user_pwd=$("input[name=myinfo_delete_user_pwd]").val();
		$.getJSON(getPageContext+'/mypage/myinfo/deleteJSON',{user_pwd:user_pwd},function(data){
			if(data.result>0){
				location.href=getPageContext+"/";
			}else{
				alert("비밀번호가 일치하지 않아요");
			}
		});
	});
	
	$('.myskin li').on('click',function(){
		var ms_num=$(this).prop('id');
		var getPageContext=$('#getPageContext').val();
		$.getJSON(getPageContext+'/mypage/myskin/select',{ms_num:ms_num},function(data){
			var vo=data.vo;
			$('#applyMySkin')
			.prop('href',getPageContext+'/mypage/myskin/applySkin?ms_num='+vo.ms_num)
			.css({
				'display':'block',
				'background-color':vo.ms_color
			}); 
			$('#updateMySkin').prop('href',getPageContext+'/mypage/myskin/updateform?ms_num='+vo.ms_num).css({'display':'block','background-color':vo.ms_color});
			$('#deleteMySkin').prop('href',getPageContext+'/mypage/myskin/delete?ms_num='+vo.ms_num).css({'display':'block','background-color':vo.ms_color});
			$('#myskin_list_cover').css({
				'display':'block',
				'background': 'url('+getPageContext+'/resources/upload/img/'+vo.msc_savimg+')'
			});
			$('.pre_cover img').prop('src',getPageContext+'/resources/upload/img/'+vo.msp_savimg);
			$('#myskin_list_nav').css('background-color',vo.ms_color);
			$('#myskin_list_icon').css({
				'border':vo.ms_color,
				'background-color':vo.ms_color
			});
			$('#myskin_list_msg').text(vo.ms_msg);
		});
	});
	
	$('#ms_color').on('change',function(){
		var vv=$(this).val();
	});
	
	/////////////////////////새 커뮤니티 등록하기
	
	/* 미리보기 */
	$('input[name=comm_name]').on('keyup',function(){
		var comm_name=$(this).val();
		$('#pre_newComm_name').html('');
		$('#pre_newComm_name').html('<b>'+comm_name+'</b>');
	});

	$('input[name=cs_color]').on('change',function(event){
		var color=$(this).val();
		$('#new_comm_myNavbar').css('background-color',color);
		$('#new_comm_search').css('background-color',color);
	});

	$('input[name=comm_content]').on('keyup',function(){
		var comm_content=$(this).val();
		$('#pre_newComm_content').text('');
		$('#pre_newComm_content').text(comm_content);
	});
	
	$('input[name=comm_skin_profile]').on('change',function(event){
		var file=event.target.files[0];
		var filePath=URL.createObjectURL(file);
		$("#new_community_profile").prop('src',filePath);
	});

	$('input[name=comm_skin_cover]').on('change',function(event){
		var file=event.target.files[0];
		var filePath=URL.createObjectURL(file);
		$("#new_community_cover").prop('src',filePath);
	});
	
	$('#new_community .form-horizontal').on('submit',function(){
		var comm_name=$('input[name=comm_name]').val();
		if(comm_name===''){
			alert('커뮤니티명을 입력해주세요');
			return false;
		}
		var comm_content=$('input[name=comm_content]').val();
		if(comm_content===''){
			alert('커뮤니티 소개 문구를 입력해주세요');
			return false;
		}
		return true;
	});
	
	
	
});






/* 해당 스킨 적용하기 */
/*function mySkinApply(num){
	var getPageContext=$("#getPageContext").val();
	$.getJSON(getPageContext+'/mypage/myskin/selectApply',{ms_num:num},function(data){
		var vo=data.vo;
		$("#profileImg").prop('src',getPageContext+'/resources/upload/img/'+vo.msp_savimg);
		$("#mypageJumbo div").css({
			'background':'url('+getPageContext+'/resources/upload/img/'+vo.msc_savimg+')',
			'background-size':'cover !important',
			'background-repeat':'no-repeat !important'
		});
		$('#mypageJumbo p span').text(vo.ms_msg);
		$('.navbar').css('background-color',vo.ms_color);
		$('#search').css('background-color',vo.ms_color);
	});
}*/