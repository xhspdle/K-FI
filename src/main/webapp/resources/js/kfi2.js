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
	
	$('#myskinFrm').on('click',function(){
		var skinName=$('#ms_name').val();
		if(skinName == ''){
			alert('스킨명을 입력해주세요');
			return false;
		}
		return true;
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
			$('#noneCover').css('display','block');
			$('#myskin_list_nav').css('display','block');
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
	
	var myskinColorOne=$('#myskinColorOne').val();
	if(myskinColorOne != null){
		$('.myskin_ud_add').css('background-color',myskinColorOne);
		$('.myskin_ud_default').css('background-color',myskinColorOne);
	}
	
	
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
	
	/////////////////////community 회원유무 확인 후 글쓰기 disabled 효과주기
	var cul_status=$('#cul_status').val();
	if(parseInt(cul_status)!=1){
		$('#commWrite').attr('href','#');
		//addClass, removeClass
	}
	
	
	
	/////////////////////////커뮤니티 게시물 등록할 때
	$('#insertCommBoardSub').on('click',function(){
		var cbTitle=$('#cb_title').val();
		if(cbTitle==''){
			alert('제목을 입력해주세요');
			return false;
		}
		var cbContent=$('#cb_content').val();
		if(cbContent==''){
			alert('내용을 입력해주세요');
			return false;
		}
		return true;
	});
	
	/////////////////////////커뮤니티 게시물 업데이트할 때 
	$('#updateCommBoardSub').on('click',function(){
		var cbTitle=$('#cb_title').val();
		if(cbTitle==''){
			alert('제목을 입력해주세요');
			return false;
		}
		var cbContent=$('#cb_content').val();
		if(cbContent==''){
			alert('내용을 입력해주세요');
			return false;
		}
		return true;
	});
	
	/////////////////////////커뮤니티 게시물 좋아요
	getBoardLikeUserList();
	
	$('#comm_like').on('click',function(event){
		event.preventDefault();
		var getPageContext=$('#getPageContext').val();
		var cb_num=parseInt($('#cb_num').val());
		$.getJSON(getPageContext+'/commboardlike/insert?cb_num='+cb_num,function(data){
			var result=data.result;
			$('#commBoardSelect #likeCnt').attr('data-like-cnt',result);
			$('#commBoardSelect #likeCnt').text(result+' Likes');
			getBoardLikeUserList();
		});
	});
	
	///////////커뮤니티 게시글 댓글리스트 불러오기
	var cbNum=$('#cb_num').val();
	if(cbNum!=undefined){
		getBoardCommentList(1);
	}
	
	//댓글 추가하기
	$("#commBoardSelect #commentForm").submit(function(event){
		event.preventDefault();
		var getPageContext=$('#getPageContext').val();
		var cb_num=parseInt($("#cb_num").val());
		var commc_content=$("input[name='commc_content']").val();
		$.getJSON(getPageContext+'/commcomment/insert',{cb_num:cb_num,commc_content:commc_content},function(result){
			$("input[name='commc_content']").val('');
			getBoardCommentList();
		});
	});
	
	//댓글 삭제
	 $('#commBoardSelect').on('click','.dropDownDelete',function(event){
		  event.preventDefault();
		  var commc_num=parseInt($(this).attr("data-comm-num"));
		  var getPageContext=$('#getPageContext').val();
		  $.getJSON(getPageContext+'/communityBoard/comment/delete?commc_num='+commc_num,function(){
			  getBoardCommentList();
		  });
	 });
	 
	//댓글 수정	 
	  $('#commBoardSelect').on('click','.dropDownUpdate',function(event){
		  event.preventDefault();
		  var getPageContext=$('#getPageContext').val();
		  var commc_num=parseInt($(this).attr("data-comm-num"));
		  var p=$(this).parent().parent().parent().parent().find("p");
		  var commc_content=$(p).text();
		  if($(p).parent().children().length>=8){
			  return;
		  }
		  $("<form class='form-horizontal updateFrm' id='updateCommComment' style='width:95%;' action='"+ getPageContext +"/communityBoard/comment/update'>" +
			"<div class='input-group'>" +
			"<input type='hidden' name='commc_num' value='"+ commc_num +"'>" +
			"<input type='text' class='form-control' name='commc_content' value='"+ commc_content +"'>" +
			"<div class='input-group-btn'>" +
			"<button class='btn btn-default commentUpdateBtn' type='submit'>" +
			"<i class='glyphicon glyphicon-check'></i></button></div></div></form>").insertAfter(p);
	  });
	  
	  $(document).on('submit','#updateCommComment',function(event){
		  event.preventDefault();
	  	  var getPageContext=$('#getPageContext').val();
	  	  var commc_num=$('input[name="commc_num"]').val();
	  	  var commc_content=$(this).find('input[name="commc_content"]').val();
	  	  console.log(commc_num+"/"+commc_content);
	  	  $.getJSON(getPageContext+'/communityBoard/comment/update',{commc_num:commc_num,commc_content:commc_content},function(result){
	  		  getBoardCommentList();
	  	  });
	  });
	  
	//////커뮤니티 게시글 조회수 올리기
	var cb_num=$('#cb_num').val();
	if(cb_num != null){
		var getPageContext=$('#getPageContext').val();
		$.getJSON(getPageContext+'/community/board/updateViews?cb_num='+cb_num,function(data){
			var views=data.result;
			var viewNum=' Views ' +views;
			$('#viewsCnt').text(viewNum);
		});
	}
	
	//좋아요 등록, 취소
	 $("#commCommentList").on('click',".thumbsUp",function(event){
		  event.preventDefault();
		  var commc_num=parseInt($(this).attr("data-comm-num"));
		  $.getJSON(getPageContext + "/communityBoard/commCommentLike/insert",{commc_num:commc_num},
				  function(resultMap){
					  $("span[data-comm-num='"+ commc_num +"'").text(resultMap.commentLikeCnt);
					  var msgSpan=$("span[data-comm-num='"+ commc_num +"'").next().next();
					  if(resultMap.result==1){
						  $(msgSpan).text("Thumbs Up!");
					  }else if(resultMap.result==0){
						  $(msgSpan).text("cancled");
					  }else{
						  $.msgBox(resultMap.result);
					  }
					  $(msgSpan).css("opacity","1");
					  setTimeout(function(){
						  $(msgSpan).css("opacity","0"); 
					  },3000);
				  });
	  });
	
	$('#updateCommBoard .glyphicon-remove-circle').on('click',function(){
		 var tagSpanNum=$(this).parent().attr("data-tag-num");
		 console.log(tagSpanNum);
		 $("input[type='hidden']").remove("#tag" + tagSpanNum);
		 let removeSpan=$(this).parent().css("opacity","0")
		 setTimeout(function(){
			  $(removeSpan).remove();
		 },500);
		 var delTag='<input type="hidden" name="del_Tags" value="'+tagSpanNum+'">';
		 $('#del_TagList').append(delTag);
	});
	 
	 
	//파일 미리보기
	var imgListSize=$('#imgListSize').val();
	if(imgListSize!=undefined){
		var imgSize=parseInt(imgListSize);
		for(var i=0;i<5;i++){
			console.log(imgSize);
			fileP(i);
		}
	}
	
	function fileP(i){
		$(document).on('change',"[name='fileP"+(i+1)+"']",function(event){
			  if(event.target.files[i]!==undefined){
				  var tmppath=URL.createObjectURL(event.target.files[i]);
				  $(this).next().fadeIn("fast").attr("src", URL.createObjectURL(event.target.files[i]));
				  URL.revokeObjectURL(event.target.files[0]);
			  }else{
				  $(this).next().fadeOut("slow");
			  }
			  if($(".imgUpload").children().length<=3){
				  $("<button type='button' class='btn btn-default btn-block addImg'>" +
			  		"Upload More?</button>").appendTo(".imgUpload");
				  console.log("??");
				  var n=imgSize;
				  $(".imgUpload").on('click',".addImg",function(){
					  if(n>=6){
						  $(this).css('color',"red");
						  $(this).html("Up to 5 photos can be uploaded")
					  }else{
						  fileImgTemplate=document.querySelector("#fileImgTemplate").innerHTML;
						  let attachImg=fileImgTemplate.replace("{mp_savimg}", '')
						  			.replace(/{i}/gi, n)
						  			.replace("{label}", "Upload Photo" + n++);
						  $(".imgUpload").append(attachImg);
					  }
				  });
			  }
		  });
	} 
	 
	 
	 
	 
	 
	 
	 
});

//추천 유저 목록 불러오기
function getBoardLikeUserList(){
	var getPageContext=$('#getPageContext').val();
	var cb_num=$('#cb_num').val();
	$.getJSON(getPageContext+'/commboardlike/list',{cb_num:cb_num},function(data){
		$("#commBoardSelect .likeUserList img").remove();
		var list=data.list;
		$(list).each(function(i){
			$("<img class='img-responsive img-circle' " +
				"src='"+ getPageContext +"/resources/upload/img/"+list[i].msp_savimg +"' alt='likerProfiles' " +
				"data-toggle='tooltip' title='"+ list[i].user_nickname +"'>")
				.appendTo("#commBoardSelect .likeUserList");
		});
	});		
}

//댓글 목록 불러오기
function getBoardCommentList(pageNum){
	  var getPageContext=$('#getPageContext').val();
	  if(pageNum==undefined){
		pageNum=1;  
	  }
	  var cb_num=$("#cb_num").val();
	  console.log(cb_num+"///cb_num");
	  $.getJSON(getPageContext+'/community/board/commentList',{pageNum:pageNum,cb_num:cb_num},
		  function(result){
			  $("#commBoardSelect #commentCnt").text(result.commentCnt + " Comments");
			  $("#commCommentList").empty();
			  $(result.list).each(function(i,comment){
				  var optionBtn='';
				  var dropDowns='';
				  var user_num=$('#user_num').val(); //로그인한 사용자
				  var commBoardUserNum=$('#commBoardUserNum').val(); //게시물 작성자
				  var commentWriterNum=comment.user_num; //댓글 작성자
				  if(user_num==commentWriterNum){
					  dropDowns="<li><a class='dropDownDelete' href='"+ getPageContext +"/communityBoard/comment/delete?commc_num="+ comment.commc_num +"' data-comm-num='"+ comment.commc_num +"'>삭제</a></li>" +
					  			"<li><a class='dropDownUpdate' href='"+ getPageContext +"/communityBoard/comment/update?commc_num="+ comment.commc_num +"' data-comm-num='"+ comment.commc_num +"'>수정</a></li>";
				  }else if(user_num==commBoardUserNum){
					  dropDowns="<li><a class='dropDownDelete' href='"+ getPageContext +"/communityBoard/comment/delete?commc_num="+ comment.commc_num +"' data-comm-num='"+ comment.commc_num +"'>삭제</a></li>";
				  }else{
					  optionBtn=" disabled";
				  }
				  var userSelect= getPageContext + "/mypage/myboard/selectList?selectedUserNum=" + commentWriterNum;
				  html=document.querySelector("#commentTemplate").innerHTML;
				  var j=0;
				  $(result.msvvolist).each(function(i,msv){
					  var msp_savimg=msv.msp_savimg;
					  var user_nickname=msv.user_nickname;
					  if(j!=1 && commentWriterNum == msv.user_num){
						  j=1;
						  var resultHTML=html.replace("{msp_savimg}", msp_savimg)
					  		.replace("{pageNum}",pageNum)
					  		.replace("{path}", getPageContext)
					  		.replace(/{myc_num}/gi, comment.commc_num)
					  		.replace("{userSelect}",userSelect)
					  		.replace("{user_nickname}", user_nickname)
					  		.replace("{myc_content}", comment.commc_content)
					  		.replace("{myc_date}", comment.commc_date)
					  		.replace("{comment_likes}", comment.commc_like)
					  		.replace("{myc_date}", comment.commc_date)
					  		.replace("{dropDowns}", dropDowns)
					  		.replace("{optionBtn}", optionBtn);
					  $("#commCommentList").append(resultHTML);
					  }
				  });
			  });
			  
			  //페이징 처리
			  $(".pagination").empty();
			  var startPageNum=result.startPageNum;
			  var endPageNum=result.endPageNum;
			  if(startPageNum > result.pageBlockCount){
				  $("<li><a class='aPaging bPaging' href='javascript:getBoardCommentList("+ (startPageNum-1) +")'>" +
				  	"<span class='glyphicon glyphicon-chevron-left bPaging'></span></a></li>")
				  .appendTo(".pagination");
			  }else{
				  $(".pagination")
				  .append("<li><span class='glyphicon glyphicon-chevron-left bPaging'></span></li>");
			  }
			  for(var i=startPageNum;i<=endPageNum;i++){
				  if(i==result.pageNum){
					  $("<li><a class='aPaging bPaging' href='javascript:getBoardCommentList("+ i +")'>" + i + "</a></li>")
					  .appendTo(".pagination")
					  .addClass("active");
				  }else{
					  $("<li><a class='aPaging bPaging' href='javascript:getBoardCommentList("+ i +")'>" + i + "</a></li>")
					  .appendTo(".pagination");
				  }
			  }
			  if(endPageNum < result.totalPageCount){
				  $("<li><a class='aPaging bPaging' href='javascript:getBoardCommentList("+ (endPageNum+1) +")'>" +
				  	"<span class='glyphicon glyphicon-chevron-right bPaging'></span></a></li>")
				  .appendTo(".pagination");
			  }else{
				  $(".pagination")
				  .append("<li><span class='glyphicon glyphicon-chevron-right bPaging'></span></li>");
			  }
		  });
}





//커뮤니티 게시글 페이징 처리
function getCommBoard(){
	var pageNum=parseInt($('#pageNum').val())+1;
	var getPageContext=$('#getPageContext').val();
	$.getJSON(getPageContext+'/community/board/list?pageNum='+pageNum,function(result){
		var page=result.pageNum;
		$('#pageNum').val(page);
		var list=result.list; //List<CommBoardVo>
		if(list.length==0){
			alert('마지막 게시물 입니다');
			return false;
		}
		var proflist=result.proflist; //List<CommBoardProfileVo>
		var cbclist=result.cbclist; //List<CommBoardCntVo>
		var cplist=result.cplist; //List<CommPhotoVo>
		var cvlist=result.cvlist; //List<CommVideoVo>
		
		html=document.querySelector('#commBoardListTemplate').innerHTML;
		
		$(list).each(function(i,board){
			var date=$('#'+board.cb_date).val();
			if(date==undefined){
				date='<h1 class="text-center" id="'+board.cb_date +'" style="margin-bottom: 30px;">'
					+'<span style="border-bottom: 4px solid tan">'+board.cb_date +'</span></h1>';
				$("#moreCommBoard").append(date);
			}
			var user_num=board.user_num;
			var sessionUser=$('#user_num').val();
			var liType="";
			var comm_adminNum=$('#comm_adminNum').val();
			if(user_num == sessionUser){
				liType='<li><a href="'+getPageContext+'/community/board/updateForm?cb_num='+board.cb_num +'" data-toggle="modal" data-cb-num="{'+board.cb_num+'}">'
					+'<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit</a></li>'
					+'<li><a href="#delete" onclick="return false;" data-toggle="popover" data-popover-type="commBoard" data-cb-num="'+board.cb_num+'">'
					+'<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete</a></li>';
			}else if(sessionUser == comm_adminNum){
				liType='<li><a href="#delete" onclick="return false;" data-toggle="popover" data-popover-type="commBoard" data-cb-num="'+board.cb_num+'">'
				+'<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete</a></li>';
			}else if(user_num != sessionUser){
				liType='<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>';
			}
			var mediaDiv="<span></span>";
			$(proflist).each(function(j,pro){
				var proCbnum=pro.cb_num;
				if(proCbnum==board.cb_num){
					mediaDiv='<div class="media"><div class="media-left media-top">'
							+'<img src="'+getPageContext+'/resources/upload/img/'+pro.msp_savimg +'" class="media-object img-circle" style="width:50px;height:50px"></div>'
							+'<div class="media-body text-left" style="padding-left:5px;"><h4 class="media-heading">'
							+'<a href="'+getPageContext+'/mypage/myboard/selectList?selectedUserNum='+board.user_num +'" class="userSelect">'
							+'<strong>'+pro.user_nickname +'</strong></a></h4><p style="margin:0px;margin-top:-5px;"><small>'+pro.user_email+'</small></p></div></div>';
				}
			});
			var cvCnt=0;
			var video='<span></span>';
			if(cvlist != null){
				$(cvlist).each(function(v,vi){
					if(vi!=null){
						var vidnum=vi.cb_num;
						if(vidnum == board.cb_num ){
							video='<video class="img-responsive center-block" controls autoplay muted="muted" loop' 
									+'src="'+getPageContext+'/resources/upload/vid/'+vi.cv_savvid+'"></video>';
							cvCnt=1;
						}
					}
				});
			}
			var photo ='<span></span>';
			if(cvCnt!=1 && cplist != null){
				$(cplist).each(function(p,pt){
					if(pt!=null){
						var ptcbnum=pt.cb_num;
						if(ptcbnum==board.cb_num){
							photo ='<img class="img-responsive center-block" src="'+getPageContext+'/resources/upload/img/'+pt.cp_savimg +'" alt="board image">';
						}
					}
				});
			}
			var cblcnt = 0;
			var cmcnt = 0;
			var cvcnt = 0;
			$(cbclist).each(function(c,cnt){
				if(cnt!=null){
					var cntnum=cnt.cb;
					if(board.cb_num == cntnum){
						cblcnt=cnt.cblcnt;
						cmcnt=cnt.cmcnt;
						cvcnt =cnt.cvcnt;
					}
				}
			});
			var selectCb_num=getPageContext+'/community/board/select?cb_num='+board.cb_num;
			var resultHTML=html.replace(/{/gi, "")
	  			.replace(/}/gi, "")
	  			.replace(/cb_num/gi, board.cb_num)
	  			.replace("selectCbNum", selectCb_num)
				.replace(/cb_title/gi,board.cb_title)
		  		.replace("liType", liType)
		  		.replace("mediaDiv", mediaDiv)
		  		.replace(/cb_content/gi, board.cb_content)
		  		.replace("video", video)
		  		.replace("photo", photo)
		  		.replace("cblcnt", cblcnt)
		  		.replace("cmcnt", cmcnt)
		  		.replace("cvcnt", cvcnt);
			$("#moreCommBoard").append(resultHTML);
			
		});
	});
}


//////////////////////popular 게시글 페이징 처리
function getCommBoardPopular(){
	var pageNum=parseInt($('#pageNum').val())+1;
	var getPageContext=$('#getPageContext').val();
	$.getJSON(getPageContext+'/community/board/popular/list?pageNum='+pageNum,function(result){
		var page=result.pageNum;
		$('#pageNum').val(page);
		var list=result.list; //List<CommBoardVo>
		var proflist=result.proflist; //List<CommBoardProfileVo>
		var cbclist=result.cbclist; //List<CommBoardCntVo>
		var cplist=result.cplist; //List<CommPhotoVo>
		var cvlist=result.cvlist; //List<CommVideoVo>
		
		html=document.querySelector('#commBoardPopularListTemplate').innerHTML;
		
		$(list).each(function(i,board){
			var user_num=board.user_num;
			var sessionUser=$('#user_num').val();
			var disabled="";
			var liType="";
			var comm_adminNum=$('#comm_adminNum').val();
			if(user_num == sessionUser){
				liType='<li><a href="#updateModal" data-toggle="modal" data-cb-num="{'+board.cb_num+'}">'
					+'<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit</a></li>'
					+'<li><a href="#delete" onclick="return false;" data-toggle="popover" data-popover-type="commBoard" data-cb-num="'+board.cb_num+'">'
					+'<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete</a></li>';
			}else if(sessionUser == comm_adminNum){
				liType='<li><a href="#delete" onclick="return false;" data-toggle="popover" data-popover-type="commBoard" data-cb-num="'+board.cb_num+'">'
				+'<span class="glyphicon glyphicon-trash"></span>&nbsp;&nbsp;Delete</a></li>';
			}else if(user_num != sessionUser){
				disabled="disabled";
				liType='<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;&nbsp;Report bad contents</a></li>';
			}
			var mediaDiv="<span></span>";
			$(proflist).each(function(j,pro){
				var proCbnum=pro.cb_num;
				if(proCbnum==board.cb_num){
					mediaDiv='<div class="media"><div class="media-left media-top">'
							+'<img src="'+getPageContext+'/resources/upload/img/'+pro.msp_savimg +'" class="media-object img-circle" style="width:50px;height:50px"></div>'
							+'<div class="media-body text-left" style="padding-left:5px;"><h4 class="media-heading">'
							+'<a href="'+getPageContext+'/mypage/myboard/selectList?selectedUserNum='+board.user_num +'" class="userSelect">'
							+'<strong>'+pro.user_nickname +'</strong></a></h4><p style="margin:0px;margin-top:-5px;"><small>'+pro.user_email+'</small></p></div></div>';
				}
			});
			var cvCnt=0;
			var video='<span></span>';
			if(cvlist != null){
				$(cvlist).each(function(v,vi){
					if(vi!=null){
						var vidnum=vi.cb_num;
						if(vidnum == board.cb_num ){
							video='<video class="img-responsive center-block" controls autoplay muted="muted" loop' 
									+'src="'+getPageContext+'/resources/upload/vid/'+vi.cv_savvid+'"></video>';
							cvCnt=1;
						}
					}
				});
			}
			var photo ='<span></span>';
			if(cvCnt!=1 && cplist != null){
				$(cplist).each(function(p,pt){
					if(pt!=null){
						var ptcbnum=pt.cb_num;
						if(ptcbnum==board.cb_num){
							photo ='<img class="img-responsive center-block" src="'+getPageContext+'/resources/upload/img/'+pt.cp_savimg +'" alt="board image">';
						}
					}
				});
			}
			var cblcnt = 0;
			var cmcnt = 0;
			var cvcnt = 0;
			$(cbclist).each(function(c,cnt){
				if(cnt!=null){
					var cntnum=cnt.cb;
					if(board.cb_num == cntnum){
						cblcnt=cnt.cblcnt;
						cmcnt=cnt.cmcnt;
						cvcnt =cnt.cvcnt;
					}
				}
			});
			var selectCb_num=getPageContext+'/community/board/select?cb_num='+board.cb_num;
			var resultHTML=html.replace(/{/gi, "")
	  			.replace(/}/gi, "")
	  			.replace(/cb_num/gi, board.cb_num)
	  			.replace("selectCbNum", selectCb_num)
				.replace(/cb_title/gi,board.cb_title)
				.replace("disabled", disabled)
		  		.replace("liType", liType)
		  		.replace("mediaDiv", mediaDiv)
		  		.replace(/cb_content/gi, board.cb_content)
		  		.replace("video", video)
		  		.replace("photo", photo)
		  		.replace("cblcnt", cblcnt)
		  		.replace("cmcnt", cmcnt)
		  		.replace("cvcnt", cvcnt);
			$("#moreCommBoardPopular").append(resultHTML);
		});
	});
}




