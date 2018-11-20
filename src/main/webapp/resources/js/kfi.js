/*
	scroll : layout.jsp
 */
$(document).ready(function(){
  var getPageContext=$("#getPageContext").val();
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    if (this.hash !== "") {
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
        window.location.hash = hash;
      });
    }
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
  
  $(".nav > .dropdown").hover(function(){
	  $(this).find("ul").stop().slideDown(); 
  },function(){
	  $(this).find("ul").stop().slideUp();
  });
  
  $("#search").on('click',function(){
	  $.searchBig();
	  $("#headerSearch").fadeIn('slow',function(){
		  $(this).slideDown();
	  });
	  $(window).scroll(function(){
		  $.searchBig();
	  });
	  $(window).resize(function(){
		  var search=$("#search").offset();
		  var miniLogo=$(".miniLogo").offset();
		  var max_width=search.left-miniLogo.left;
		  if($(window).width()<=768){
			  $("#searchForm").css('width', $(window).width()-10);
		  }else{
			  $("#searchForm").css('position', 'absolute');
			  $("#searchForm").css('left', miniLogo.left+2);
			  $("#searchForm").css('width', max_width+50);
		  }
	  });
  });
  $.searchBig=function(){
	  if($(".affix-top").children().length>=1){
		  $(".search_bar").each(function(){
			  $(this).addClass("search_big");
			  $(this).css("border","1px solid #00cee8");
		  });
		  $("button.search_bar").each(function(){
			  $(this).addClass("search_big_w");
			  $(this).css("background-color","#00cee8");
		  });
		  $.affixSearch(50,70);
	  }else{
		  $(".search_bar").each(function(){
			 $(this).removeClass("search_big");
			 $(this).css("border","1px solid #f4511e");
		  });
		  $("button.search_bar").each(function(){
			 $(this).removeClass("search_big_w"); 
			 $(this).css("background-color","#f4511e");
		  });
		  $.affixSearch(0,50);
	  }
  }
  $.affixSearch=function(hh,ww){
	  var search=$("#search").offset();
	  var miniLogo=$(".miniLogo").offset();
	  var max_width=search.left-miniLogo.left;
	  $("#searchForm").css('position', 'absolute');
	  $("#searchForm").css('left', miniLogo.left);
	  $("#searchForm").css('top', miniLogo.top-400-hh);
	  $("#searchForm").css('width', max_width+ww);
  }
  $("#search_close").on('click',function(event){
	  event.preventDefault();
	  $("#headerSearch").css('display','none');
  });
  
  $("#writeBtn").click(function(){
	 $("#writeModal").modal();
  });
  $("#writeModal").on('show.bs.modal',function(){
	  $('body').addClass('test');
  });
  /*
   * 사진 업로드 미리보기 & 추가업로드 버튼 로드
   */
  $(document).on('change',"[name='fileP']",function(event){
	  if(event.target.files[0]!==undefined){
		  var tmppath=URL.createObjectURL(event.target.files[0]);
		  $(this).next().fadeIn("fast").attr("src", URL.createObjectURL(event.target.files[0]));
		  URL.revokeObjectURL(event.target.files[0]);
	  }else{
		  $(this).next().fadeOut("slow");
	  }
	  if($(".imgUpload").children().length<=3){
		  $("<button type='button' class='btn btn-default btn-block addImg'>" +
	  		"Upload More?</button>").appendTo(".imgUpload");
		  var n=2;
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
  /*
   * 영상 업로드 미리보기 & 추가업로드 버튼 로드
   */
  $(document).on('change',"[name='fileV']",function(event){
	  if(event.target.files[0]!==undefined){
		  var tmppath=URL.createObjectURL(event.target.files[0]);
		  $(this).next().fadeIn("fast").attr("src", URL.createObjectURL(event.target.files[0]));
		  URL.revokeObjectURL(event.target.files[0]);
	  }else{
		  $(this).next().fadeOut("slow");
	  }
	  if($(".vidUpload").children().length<=3){
		  $("<button type='button' class='btn btn-default btn-block addVid'>" +
		  "Upload More?</button>").appendTo(".vidUpload");
		  var n=2;
		  $(".vidUpload").on('click',".addVid",function(){
			  if(n>=3){
				  $(this).css('color',"red");
				  $(this).html("Up to 2 videos can be uploaded")
			  }else{
				  fileVidTemplate=document.querySelector("#fileVidTemplate").innerHTML;
				  let attachVid=fileVidTemplate.replace("{mv_savvid}", '')
				  .replace(/{i}/gi, n)
				  .replace("{label}", "Upload Video" + n++);
				  $(".vidUpload").append(attachVid);
			  }
		  });
	  }
  });
  
  $(document).on('submit',"[name='frm']",function(e){
	  e.preventDefault();
	  $(this).prop('disabled',true);
	  var form=document.frm;
	  var formData=new FormData(form);
	  var ajaxReq=$.ajax({
		  url: getPageContext + "/mypage/myboard/insert",
		  type: 'post',
		  data: formData,
		  cache: false,
		  contentType: false,
		  processData: false,
		  xhr: function(){
			  var xhr=$.ajaxSettings.xhr();
			  xhr.upload.onprogress=function(event){
				  var perc=Math.round((event.loaded/event.total) * 100);
				  $(".progress").css('opacity','1');
				  $(".progress-bar").css('width',perc + '%');
				  $(".progress-bar").prop('aria-valuenow',perc);
				  $(".progress-bar").text(perc + '%');
			  };
			  return xhr;
		  },
		  beforeSend: function(xhr){
			  $("#uploadMsg").text('');
			  $(".progress-bar").text('');
			  $(".progress-bar").css('width','0%');
			  $(".progress-bar").prop('aria-valuenow','0');
		  }
	  });
	  ajaxReq.done(function(msg){
		 $("#uploadMsg").text(msg);
		 $("input[type='file']").each(function(){
			 $(this).val('');
		 });
		 $("#sendServer").prop('disabled',false);
		 if(msg=='Post Success'){
			 setTimeout(function(){
				 location.href=getPageContext + "/mypage/main";
			 },1500);
		 }else{
			 $("#uploadMsg").css("color","red");
			 $("#uploadMsg").css("font-weight","bold");
			 setTimeout(function(){
				 $("#writeModal").modal("hide");
				 location.href=getPageContext + "/mypage/main";
			 },2500);
		 }
	  });
	  ajaxReq.fail(function(jqXHR){
		 $("#uploadMsg").text(jqXHR.responseText + '(' + jqXHR.status +
				 ' - ' + jqXHR.statusText + ')');
		 $("#sendServer").prop('disabled',false);
	  });
  });
  
  var sameDate='';
  $.getList=function(pageNum,keyword,appendWhere,selectedUserNum){
	  	var getSession=$("#getSession").val();
	  	var append="#myBoardList";
	  	if(appendWhere!==undefined){
	  		append=appendWhere;
	  	}
		$.getJSON(getPageContext + "/mypage/myboard/list",
			{"pageNum":pageNum,"keyword":keyword,"selectedUserNum":selectedUserNum},
			function(data){
				$(data.list).each(function(i,json){
					var mb_num=json.mb_num;
					var user_num=json.user_num;
					var user_id=json.user_id;
					var user_nickname=json.user_nickname;
					var user_email=json.user_email;
					var mb_title=json.mb_title;
					var mb_content=json.mb_content;
					var mb_views=json.mb_views;
					var comment_cnt=json.comment_cnt;
					var like_cnt=json.like_cnt;
					var mp_savimg=json.mp_savimg;
					var mv_savvid=json.mv_savvid;
					var msp_savimg=json.msp_savimg;
					var attachment='';
					var boardOption='';
					if(sameDate!==json.mb_date){
						$("<h1 class='text-center' id='"+ json.mb_date +"' style='margin-bottom:30px;'>" +
						  "<span style='border-bottom: 4px solid tan'>" + json.mb_date +
						  "</span></h1>")
						  .appendTo(append);
					}
					sameDate=json.mb_date;
					if(mv_savvid!==null && mv_savvid!==''){
						attachment="<video class='img-responsive center-block' controls autoplay muted='muted' loop src='"+getPageContext +"/resources/upload/vid/" + mv_savvid + "'></video>";
					}else if(mp_savimg!==null && mp_savimg!==''){
						attachment="<img class='img-responsive center-block' src='"+getPageContext +"/resources/upload/img/" + mp_savimg + "' alt='board image'>";
					}
					if(user_num==getSession){
						boardOption="<div class='dropdown boardOption'>" +
									"<button class='btn dropdown-toggle' type='button' data-toggle='dropdown'>" +
									"<span class='glyphicon glyphicon-option-vertical'></span></button>" +
									"<ul class='dropdown-menu rightOption'>" +
									"<li><a href='#updateModal' data-toggle='modal' data-mb-num='"+ mb_num +"'>" +
									"<span class='glyphicon glyphicon-edit'></span>&nbsp;&nbsp;Edit</a></li>" +
									"<li><a href='#' onclick='return false;' data-toggle='popover' data-mb-num='"+ mb_num +"'>" +
									"<span class='glyphicon glyphicon-trash'></span>&nbsp;&nbsp;Delete</a></li></ul></div>";
					}else{
						boardOption="<div class='dropdown boardOption'>" +
									"<button class='btn dropdown-toggle' type='button' data-toggle='dropdown'>" +
									"<span class='glyphicon glyphicon-option-vertical'></span></button>" +
									"<ul class='dropdown-menu rightOption'>" +
									"<li><a href='#' class='btn btn-block disabled' style='text-align: left'>" + 
									"<span class='glyphicon glyphicon-edit'></span>&nbsp;&nbsp;Edit</a></li>" +
									"<li><a href='#' class='btn btn-block disabled' style='text-align: left'>" + 
									"<span class='glyphicon glyphicon-trash'></span>&nbsp;&nbsp;Delete</a></li> +" +
									"<li><a href='"+ getPageContext +"/acinsert?mb_num="+ mb_num +"'><span class='glyphicon glyphicon-exclamation-sign'></span>&nbsp;&nbsp;Report bad contents</a></li></ul></div>";
					}
					if(i===0){
						$("<div class='panel-group'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading' id='"+ mb_num +"'>" +
						    "<blockquote class='postBlock'>" +
						  	"<h1 class='postTitle'>" + 
						  	"<a href='"+getPageContext +"/mypage/myboard/select?mb_num="+ mb_num +"&keyword="+ keyword +"' class='postA'>" + 
						  	mb_title + "</a></h1></blockquote>"+
						  	boardOption +
						  "</div>" +
						  "<div class='panel-body'>" + 
						  	"<div class='media'>" +
						  		"<div class='media-left media-top'>" +
						  		"<img src='"+ getPageContext +"/resources/upload/img/"+ msp_savimg +"' " +
						  		"class='media-object img-circle' style='width:50px;height:50px;'></div>" +
						  		"<div class='media-body' style='padding-left:5px;'>" +
						  		"<h4 class='media-body' style='text-align:left;'>" +
						  		"<a href='"+ getPageContext +"/mypage/myboard/selectList?selectedUserNum="+ user_num +"' class='userSelect'>" +
						  		"<strong>"+ user_nickname +"</strong></a></h4>" +
						  		"<p style='text-align:left;margin:0px;margin-top:-5px;'><small>"+ user_email + "</small></p></div>" +
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						  "<h4 class='postLikeComment slideanim'><span class='glyphicon glyphicon-heart-empty'></span>&nbsp;Likes " + 
						   "<span class='badge'>" +like_cnt + "</span></h4>" +
						   "<h4 class='postLikeComment slideanim'><span class='glyphicon glyphicon-comment'></span>&nbsp;Comments " + 
						   "<span class='badge'>" +comment_cnt + "</span></h4>" +
						   "<h4 class='postLikeComment slideanim'><span class='glyphicon glyphicon-signal'></span>&nbsp;Views " + 
						    mb_views + "</h4></div></div></div></div>")
						.appendTo(append);
					}else{
						$("<div class='panel-group slideanim'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading' id='"+ mb_num +"'>" +
						    "<blockquote class='postBlock'>" +
						  	"<h1 class='postTitle'>" + 
						  	"<a href='"+getPageContext +"/mypage/myboard/select?mb_num="+ mb_num +"&keyword="+ keyword +"' class='postA'>" + 
						  	mb_title + "</a></h1></blockquote>"+
						  	boardOption +
						  "</div>" +
						  "<div class='panel-body'>" + 
						  	"<div class='media'>" +
						  		"<div class='media-left media-top'>" +
					  			"<img src='"+ getPageContext +"/resources/upload/img/"+ msp_savimg +"' " +
					  			"class='media-object img-circle' style='width:50px;height:50px;'></div>" +
					  			"<div class='media-body' style='padding-left:5px;'>" +
					  			"<h4 class='media-body' style='text-align:left;margin-bottom:-5px;'>" +
					  			"<a href='"+ getPageContext +"/mypage/myboard/selectList?selectedUserNum="+ user_num +"' class='userSelect'>" +
					  			"<strong>"+ user_nickname +"</strong></a></h4>" +
					  			"<p style='text-align:left;'><small>"+ json.mb_date + "</small></p></div>" +
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						    "<h4 class='postLikeComment slideanim'><span class='glyphicon glyphicon-heart-empty'></span>&nbsp;Likes " + 
						    "<span class='badge'>" +like_cnt + "</span></h4>" +
						    "<h4 class='postLikeComment slideanim'><span class='glyphicon glyphicon-comment'></span>&nbsp;Comments " + 
						    "<span class='badge'>" +comment_cnt + "</span></h4>" +
						    "<h4 class='postLikeComment slideanim'><span class='glyphicon glyphicon-signal'></span>&nbsp;Views " + 
						    mb_views + "</h4></div></div></div></div>")
						.appendTo(append);
					}
				});
				
			});
		$("#myBoardList").on('click',".panel-heading",function(event){
			let clName=event.target.className;
			if(clName!=='postTitle' && clName!=='postBlock' && clName!=='panel-heading'){
				return;
			}
			location.href=getPageContext + "/mypage/myboard/select?mb_num=" +$(this).prop("id");
		});
		$("#myBoardList").on('mouseover',".panel-heading",function(){
			$(this).css("cursor","pointer");
		});
  }
  $.footerBtn=function(){
	  $("footer").before("<div class='container-fluid text-center'>" +
			  			 "<h2><a class='btn btn-default' href='javascript:$.getListMore()'>" +
			  			 "<span class='glyphicon glyphicon-plus'></span> More </a></h2></div>");
  }
  if($("#myBoardListHere").val()!==undefined){
	  $.getList();
	  $.footerBtn();
  }
  var more=2;
  $.getListMore=function(keyword,appendWhere,selectedUserNum){	  
	  $.getList(more++,keyword,appendWhere,selectedUserNum);
  }
  
  $("#myBoardSelect .postTitle > span").on({
	  click: function(){
		  location.reload();
	  }, mouseover: function(){
		  $(this).css("cursor","pointer");
	  }
  });
  
  $(document).on('submit',"[name='frmComment']",function(e){
	  e.preventDefault();
	  var mb_num=$("#commentForm > input[type='hidden']").val();
	  var myc_content=$("#commentForm > input[type='text']").val();
	  $.getJSON(getPageContext + "/mypage/mycomment/insert",
			  {'mb_num':mb_num,'myc_content':myc_content},
			  function(json){
				  if(json.code==='success'){
					  $("#commentForm > .help-block").html("<span class='glyphicon glyphicon-ok'></span>comment post succeded")
					  $("#commentForm > .help-block").css("opacity","1");
				  }else{
					  $("#commentForm > .help-block").html("<span class='glyphicon glyphicon-remove'></span>comment post failed")
					  $("#commentForm > .help-block").css("opacity","1");
				  }
				  $("#commentForm > input[type='text']").val('');
				  $("#commentForm > input[type='text']").focus();
				  $.getCommentList();
				  setTimeout(function(){
						 $("#commentForm > .help-block").css("opacity","0"); 
				  },5000);
			  });
  });
  
  $.getCommentList=function(pageNum){
	  var getSession=$("#getSession").val();
	  var boardWriter=$("#boardWriter").val();
	  var mb_num=$("#boardNum").val();
	  if(pageNum===undefined){
		  pageNum=1;
	  }
	  $.getJSON(getPageContext + "/mypage/mycomment/list",
		  {'pageNum':pageNum,'mb_num':parseInt(mb_num)},
		  function(data){
			  $("#commentCnt").html(data.commentCnt + " Comments");
			  $("#likeCnt").html(data.boardLikeCnt + " Likes<span class='msgSpan'></span>");
			  $("#commentList").empty();
			  $(data.commentList).each(function(i,json){
				  var myc_num=json.myc_num;
				  var mb_num=json.mb_num;
				  var user_num=json.user_num;
				  var myc_content=json.myc_content;
				  var myc_date=json.myc_date;
				  var cnt=json.cnt;
				  var user_id=json.user_id;
				  var user_nickname=json.user_nickname;
				  var msp_savimg=json.msp_savimg;
				  var optionBtn='';
				  var dropDowns='';
				  if(user_num==getSession){
					  dropDowns="<li><a class='dropDownDelete' href='"+ getPageContext +"/mypage/mycomment/delete?myc_num="+ myc_num +"' data-comm-num='"+ myc_num +"'>삭제</a></li>" +
					  			"<li><a class='dropDownUpdate' href='#' data-comm-num='"+ myc_num +"'>수정</a></li>";
				  }else if(boardWriter==getSession){
					  dropDowns="<li><a class='dropDownDelete' href='"+ getPageContext +"/mypage/mycomment/delete?myc_num="+ myc_num +"' data-comm-num='"+ myc_num +"'>삭제</a></li>";
				  }else{
					  optionBtn=" disabled";
				  }
				  var userSelect= getPageContext + "/mypage/myboard/selectList?selectedUserNum=" + user_num;
				  html=document.querySelector("#commentTemplate").innerHTML;
				  var resultHTML=html.replace("{msp_savimg}", msp_savimg)
				  		.replace("{pageNum}",pageNum)
				  		.replace("{path}", getPageContext)
				  		.replace(/{myc_num}/gi, myc_num)
				  		.replace("{userSelect}",userSelect)
				  		.replace("{user_nickname}", user_nickname)
				  		.replace("{myc_content}", myc_content)
				  		.replace("{comment_likes}", cnt)
				  		.replace("{myc_date}", myc_date)
				  		.replace("{dropDowns}", dropDowns)
				  		.replace("{optionBtn}", optionBtn);
				  $("#commentList").append(resultHTML);
			  });
			  $(".pagination").empty();
			  var startPageNum=data.pu.startPageNum;
			  var endPageNum=data.pu.endPageNum;
			  if(startPageNum>data.pu.pageBlockCount){
				  $("<li><a class='aPaging bPaging' href='javascript:$.getCommentList("+ (startPageNum-1) +")'>" +
				  	"<span class='glyphicon glyphicon-chevron-left bPaging'></span></a></li>")
				  .appendTo(".pagination");
			  }else{
				  $(".pagination")
				  .append("<li><span class='glyphicon glyphicon-chevron-left bPaging'></span></li>");
			  }
			  for(var i=startPageNum;i<=endPageNum;i++){
				  if(i===data.pu.pageNum){
					  $("<li><a class='aPaging bPaging' href='javascript:$.getCommentList("+ i +")'>" + i + "</a></li>")
					  .appendTo(".pagination")
					  .addClass("active")
				  }else{
					  $("<li><a class='aPaging bPaging' href='javascript:$.getCommentList("+ i +")'>" + i + "</a></li>")
					  .appendTo(".pagination")
				  }
			  }
			  if(endPageNum<data.pu.totalPageCount){
				  $("<li><a class='aPaging bPaging' href='javascript:$.getCommentList("+ (endPageNum+1) +")'>" +
				  	"<span class='glyphicon glyphicon-chevron-right bPaging'></span></a></li>")
				  .appendTo(".pagination");
			  }else{
				  $(".pagination")
				  .append("<li><span class='glyphicon glyphicon-chevron-right bPaging'></span></li>");
			  }
		  });
  }
  
  $("#commentList").on('click',".thumbsUp",function(e){
	  e.preventDefault();
	  var myc_num=parseInt($(this).attr("data-comm-num"));
	  $.getJSON(getPageContext + "/mypage/mycommentlike/insert",
			  {'myc_num':myc_num},
			  function(json){
				  $("span[data-comm-num='"+ myc_num +"'").text(json.commentLikeCnt);
				  var msgSpan=$("span[data-comm-num='"+ myc_num +"'").next().next();
				  if(json.code==='success'){
					  $(msgSpan).text("Thumbs Up!");
				  }else if(json.code==='duplicated'){
					  $(msgSpan).text("cancled");
				  }else{
					  $.msgBox(json.code);
				  }
				  $(msgSpan).css("opacity","1");
				  setTimeout(function(){
					  $(msgSpan).css("opacity","0"); 
				  },3000);
			  });
  });
  
  $("#myBoardSelect div.likes > a").click(function(e){
	  e.preventDefault();
	  var mb_num=parseInt($(this).attr("data-board-num"));
	  $.getJSON(getPageContext + "/mypage/myboardlike/insert",
			  {'mb_num':mb_num},
			  function(json){
				  $("#likeCnt").html(json.boardLikeCnt + " Likes<span class='msgSpan'></span>");
				  var msgSpan=$("#likeCnt > span.msgSpan");
				  if(json.code==='success'){
					  $(msgSpan).text("Like it!");
				  }else if(json.code==='duplicated'){
					  $(msgSpan).text("cancled");
				  }else{
					  $.msgBox(json.code);
				  }
				  $.getMyBoardLikeList();
				  $(msgSpan).css("opacity","1");
				  setTimeout(function(){
					  $(msgSpan).css("opacity","0"); 
				  },3000);
			  });
  });
  
  $("#commentList").on('click',".dropDownDelete",function(e){
	  e.preventDefault();
	  var myc_num=parseInt($(this).attr("data-comm-num"));
	  $("#deleteMsg").modal("show");
	  /*
	   * okBtn에 이벤트 등록할때 .click이나 .on 으로 하면
	   * 댓글 달린 갯수(dropDownDelete)만큼 이벤트가 실행되어버린다
	   * 이벤트 한번만 실행되게 하는 .one으로 등록해줘야 한번만 실행된다!
	   */
	  $("#okBtn").one('click',function(){
		  $.commentDelete(getPageContext, myc_num);
		  $("#deleteMsg").modal("hide");
	  });
  });
  
  $.commentDelete=function(getPageContext, myc_num){
	  $.getJSON(getPageContext + "/mypage/mycomment/delete",
			  {'myc_num':myc_num},
			  function(json){
				  if(json.code==='success'){
					  $.getCommentList();
				  }else{
					  $.msgBox(json.code);
				  }
			  });
  }
  
  var updateCnt=0;
  $("#commentList").on('click',".dropDownUpdate",function(e){
	  e.preventDefault();
	  var myc_num=parseInt($(this).attr("data-comm-num"));
	  var p=$(this).parent().parent().parent().parent().find("p");
	  var myc_content=$(p).text();
	  if($(p).parent().children().length>=8){
		  return;
	  }
	  $("<form class='form-horizontal updateFrm' style='width:95%;' action='"+ getPageContext +"/mypage/mycomment/update'>" +
		"<div class='input-group'>" +
		"<input type='hidden' name='myc_num' value='"+ myc_num +"'>" +
		"<input type='text' class='form-control' name='myc_content' value='"+ myc_content +"'>" +
		"<div class='input-group-btn'>" +
		"<button class='btn btn-default commentUpdateBtn' type='submit'>" +
		"<i class='glyphicon glyphicon-check'></i></button></div></div></form>").insertAfter(p);
  });
  $("#commentList").on('submit',".updateFrm",function(e){
	  e.preventDefault();
	  /*
	   * [ new FormData() ]
	   * FormData takes the dom reference as the argument, not jQuery wrapper.
	   * new FormData($(this)); [ X ]
	   * new FormData($(this).get(0)); [ O ]
	   */
	  var formData=new FormData($(this).get(0));
	  /*
	   * [ formData.entries() ]
	   * formData 객체에 들어간 값 확인할 수 있는 함수(크롬/파이어폭스최신버전에서확인가능)
	   */
	  for(var pair of formData.entries()){
		  console.log(pair[0]+ ', ' + pair[1]);
	  }
	  var pageNum=$(this).parents("div[data-comm-pagenum]").attr("data-comm-pagenum");
	  /*
	   * [ formData를 쓰려면... ]
	   * $.getJSON은 사용 못함
	   * $.ajax // contentType: false/processData: false 해줘야함 
	   */
	  $.ajax({
		  url: getPageContext + "/mypage/mycomment/update",
		  type: 'post',
		  dataType:'json',
		  data: formData,
		  cache: false,
		  contentType: false,
		  processData: false,
		  success: function(json){
			  if(json.code==='success'){
				  $.getCommentList(pageNum);
			  }else{
				  $.msgBox(json.code);
			  }
		  }
	  });
  });
  
  $.msgBox=function(msg){
	  var showMsg='';
	  if(msg==='fail'){
		  showMsg="<strong>Failed!</strong> Server processing request failed..";
	  }else {
		  showMsg="<strong>Server Msg</strong> "+ msg;
	  }
	  $(".alert-danger").html(showMsg);
	  $("#content").css({
		  "transition": "1s",
		  "opacity": "0.5"
	  });
	  $("#header").css({
		  "transition": "1s",
		  "opacity": "0.5"
	  })
	  $(".msgBox").css({
		  "top": ($(window).height()-$(".msgBox").outerHeight())/2 + $(window).scrollTop(),
		  "display": "block"
	  });
	  setTimeout(function(){
		  $(".msgBox").css("opacity","1");
		  setTimeout(function(){
			  $("#content").css("opacity","1");
			  $("#header").css("opacity","1");
			  $(".msgBox").css({
				 "opacity": "0",
			  });
			  setTimeout(function(){
				  $(".msgBox").css("display","none");
			  },1000);
		  },3500);
	  },500);
  }
  
  $(document).on('focus',"[data-toggle='popover']",function(){
	  $("button.dropdown-toggle").attr("data-toggle","off");
	  $("[data-toggle='popover']").popover({
		  title: "<h3><strong>Wanna delete?</strong></h3>" + 
		  		 "<p>please enter your password</p>",
		  content: "<form class='form-horizontal boardDelete' method='post' " + 
		  		   "action='"+ getPageContext +"/mypage/myboard/delete'>" +
		  		   "<div class='input-group input-group-lg'>" +
		  		   "<input type='hidden' name='mb_num' value='"+ $("[data-toggle='popover']").attr("data-mb-num") +"'>" +
		  		   "<input type='password' name='user_pwd' class='form-control' >" + 
		  		   "<div class='input-group-btn'>" +
		  		   "<button class='btn btn-danger' type='submit'>" +
		  		   "<i class='glyphicon glyphicon-lock' style='font-size:24px;'></i></button></div></div></form>",
		  html: true,
		  placement: "left"
	  });
  });
  $(document).on('focusout',"[data-toggle='popover']",function(){
	  $("button.dropdown-toggle").attr("data-toggle","dropdown");
  });
  
  $(document).on('submit',".boardDelete",function(e){
	  e.preventDefault();
	  var formData=new FormData($(this).get(0));
	  $.ajax({
		  url: getPageContext + "/mypage/myboard/delete",
		  type: 'post',
		  dataType: 'json',
		  data: formData,
		  cache: false,
		  contentType: false,
		  processData: false,
		  success: function(json){
			  if(json.code==='success'){
				  location.href=getPageContext + "/mypage/main";
			  }else{
				  $.msgBox(json.code);
			  }
		  }
	  });
  });
  
  $(document).on('click',"[href='#updateModal']",function(event){
	  var mb_num=$(this).attr("data-mb-num");
	  $("#updateBody").empty();
	  $.getJSON(getPageContext + "/mypage/myboard/updateModal",
			  {"mb_num":mb_num},
			  function(data){
				  var boardVo=data.boardVo;
				  var user_num=boardVo.user_num;
				  var mb_num=boardVo.mb_num;
				  var mb_title=boardVo.mb_title;
				  var mb_content=boardVo.mb_content;
				  var mb_date=boardVo.mb_date;
				  var attachImgList=document.createElement("div");
				  $(data.imgList).each(function(i,json){
					  html=document.querySelector("#fileImgTemplate").innerHTML;
					  var attachImg=html.replace("{mp_savimg}", getPageContext+"/resources/upload/img/" +json.mp_savimg)
					  			.replace(/{i}/gi, i+1)
					  			.replace("{label}", "Click, if you want change")
					  			.replace("display:none", "display:block");
					  $(attachImgList).append(attachImg);
				  });
				  var attachVidList=document.createElement("div");
				  $(data.vidList).each(function(i,json){
					  html=document.querySelector("#fileVidTemplate").innerHTML;
					  var attachVid=html.replace("{mv_savvid}", getPageContext+"/resources/upload/vid/" +json.mv_savvid)
					  			.replace(/{i}/gi, i+1)
					  			.replace("{label}", "Click, if you want change")
					  			.replace("display:none", "display:block");
					  $(attachVidList).append(attachVid);
				  });				  
				  html=document.querySelector("#updateTemplate").innerHTML;
				  var resultHTML=html.replace("{mb_num}", mb_num)
				  		.replace("{mb_title}", mb_title)
				  		.replace("{mb_content}", mb_content)
				  		.replace("{attachImgList}", $(attachImgList).html())
				  		.replace("{attachVidList}", $(attachVidList).html());
				  $("#updateBody").append(resultHTML);
			  });
  });
  
  $(document).on('submit',"[name='frmUpdate']",function(event){
	  event.preventDefault();
	  $("#sendServer_up").prop('disabled', true);
	  var formData=new FormData($(this).get(0));
	  var ajaxReq=$.ajax({
		 url: getPageContext + "/mypage/myboard/update",
		 type: 'post',
		 data: formData,
		 cache: false,
		 contentType: false,
		 processData: false,
		 xhr: function(){
			 var xhr=$.ajaxSettings.xhr();
			 xhr.upload.onprogress=function(event){
				 var perc=Math.round((event.loaded/event.total) * 100);
				 $(".progress").css("opacity", "1");
				 $(".progress-bar").css("width", perc + "%");
				 $(".progress-bar").prop("aria-valuenow", perc);
				 $(".progress-bar").text(perc + "%");
			 }
			 return xhr;
		 },
		 beforeSend: function(xhr){
			 $("#updateMsg").text("");
			 $(".progress-bar").text("");
			 $(".progress-bar").css("width", "0%");
			 $(".progress-bar").prop("aria-valuenow", "0");
		 }
	  });
	  ajaxReq.done(function(msg){
		  $("#updateMsg").text(msg);
		  $("input[type='file']").each(function(){
				 $(this).val('');
		  });
		  $("#sendServer_up").prop("disabled", false);
		  if(msg=='Edit Success'){
			  setTimeout(function(){
				  location.href=getPageContext + "/mypage/main";
			  },1500);
		  }else{
			  $("#updateMsg").css("color","red");
			  $("#updateMsg").css("font-weight","bold");
			  setTimeout(function(){
				  $("#updateModal").modal("hide");
				  location.href=getPageContext + "/mypage/main";
			  },2500);
		  }
	  });
	  ajaxReq.fail(function(jqXHR){
		  $("#updateMsg").text(jqXHR.responseText + '(' + jqXHR.status +
				  ' - ' + jqXHR.statusText + ')');
		  $("#sendServer_up").prop('disabled',false);
	  });
  });
  
  if($("#myBoardSearchListHere").val()!==undefined){
	  var keyword=$("#myBoardSearchListHere").val();
	  $.footerBtn();
	  $(document).on('focus',"[href='javascript:$.getListMore()']",function(event){
		  event.preventDefault();
		  $.getListMore(keyword,"#myBoardSearchList");
	  });
  }else if($("#myBoardSelectListHere").val()!==undefined){
	  var selectedUserNum=$("#myBoardSelectListHere").val();
	  $.footerBtn();
	  $(document).on('focus',"[href='javascript:$.getListMore()']",function(event){
		  event.preventDefault();
		  $.getListMore("","#myBoardSearchList",selectedUserNum);
	  });
  }
  
  /*
   * 동적으로 생성된 요소에 부트스트랩 툴팁 바인딩하기
   * $('[data-toggle="tooltip"]').tooltip(); 으로 하면 작동안함
   */
  $("body").tooltip({
	 selector: '[data-toggle="tooltip"]' 
  });
  $.getMyBoardLikeList=function(pageNum){
	  var mb_num=$("#boardNum").val();
	  $.getJSON(getPageContext + "/mypage/myboardlike/list",
			  {'pageNum':pageNum,'mb_num':parseInt(mb_num)},
			  function(data){
				  $(".likeUserList").empty();
				  $(data.list).each(function(i,json){
					  var mbl_num=json.mbl_num;
					  var mb_num=json.mb_num;
					  var user_num=json.user_num;
					  var user_id=json.user_id;
					  var user_nickname=json.user_nickname;
					  var user_email=json.user_email;
					  var msp_savimg=json.msp_savimg;
					  $("<img class='img-responsive img-circle' " +
					  	"src='"+ getPageContext +"/resources/upload/img/"+ msp_savimg +"' alt='likerProfiles' " +
					  	"data-toggle='tooltip' title='"+ user_nickname +"'>")
					  .appendTo(".likeUserList");
				  });
			  });
  }
  if($("#myCommentListHere").val()!==undefined){
	  $.getCommentList();
	  $.getMyBoardLikeList();
  }
  $(".editableDiv").each(function(){
	  this.contentEditable=true;
  });
  var tagSpan='';
  $(".tagsPlaceholder").click(function(){
	  $("#tags").focus();
  });
  var tagSpanAttached=false;
  var tagSpanNumbering=0;
  $("#tags").on({
	  'keydown': function(event){
		  if(event.keyCode===51){
			  tagSpanAttached=false;
			  tagSpan=document.createElement('span');
			  tagSpan.setAttribute("data-tag-num",tagSpanNumbering++);
			  $(tagSpan).addClass("tagSpan");
			  $(".tagsPlaceholder").css("opacity","0");
		  }
	  },'keyup': function(event){
		  event.preventDefault();
		  if(tagSpanAttached===false){
			  let tag_name=$("#tags").text().trim();
			  if(tag_name.lastIndexOf(" ")===-1){
				  tag_name=tag_name.substring(tag_name.lastIndexOf("#"));
			  }else{
				  tag_name=tag_name.split(" ")[0].substring(tag_name.lastIndexOf("#"));
			  }
			  if(tag_name.lastIndexOf("#")!==-1){
				  tagSpan.innerHTML=tag_name + "<span class='glyphicon glyphicon-remove-circle'></span>";
			  }
		  }
		  if(event.keyCode===32) {
			  let tag_name=$("#tags").text().trim();
			  if(tag_name!==""){
				  if(tag_name.lastIndexOf("#")!==-1){
					  if(tag_name.lastIndexOf(" ")===-1){
						  tag_name=tag_name.substring(tag_name.lastIndexOf("#") + 1);
					  }else{
						  tag_name=tag_name.split(" ")[0].substring(tag_name.lastIndexOf("#") + 1);
					  }
					  $(tagSpan).appendTo("label[for='tags']");
					  $("[for='tags']").after("<input type='hidden' name='tag_name' id='tag"+ 
							  $(tagSpan).attr("data-tag-num") +"' value='"+ tag_name +"'>");
					  $("#tags").empty();
					  tagSpanAttached=true;
					  setTimeout(function(){
						  $(tagSpan).css("opacity","1");
					  },100);
				  }else{
					  $("#tags").empty();
				  }
			  }else{
				  $("#tags").empty();
			  }
		  }
		  if($("#tags").text()===""){
			  $(".tagsPlaceholder").css("opacity","1");
		  }else{
			  $(".tagsPlaceholder").css("opacity","0");
		  }
	  }
  });
  $("label[for='tags']").on('click',".glyphicon-remove-circle",function(){
	  var tagSpanNum=$(this).parent().attr("data-tag-num");
	  $("input[type='hidden']").remove("#tag" + tagSpanNum);
	  let removeSpan=$(this).parent().css("opacity","0")
	  setTimeout(function(){
		  $(removeSpan).remove();
	  },500);
	  
  });
  /*
   * Community
   */
  $(window).blur(function(){
	  $.commuinityMainReset();
  });
  $(window).focus(function(){
	  $.commuinityMainReset();
  });
  $.commuinityMainReset=function(){
	  $(".communitySlide").each(function(){
		  $(this).stop();
		  $(this).css('left',0)
		  $(this).css('top',0)
	  });
  }
  var t;
  $.commuinityMainSlide=function(){
	  if($("#commMainHere").val()!==undefined){
		  var slides=document.getElementsByClassName("communitySlide");
		  var slidesLeft=[];
		  var slidesTop=[];
		  for(let i in slides){
			  let osLeft=slides[i].offsetLeft;
			  let osTop=slides[i].offsetTop;
			  if(!slidesLeft.includes(osLeft)){
				  slidesLeft.push(osLeft);
			  }
			  if(!slidesTop.includes(osTop)){
				  slidesTop.push(osTop);
			  }
		  }
		  slidesLeft.sort(function(a, b){return b-a});
		  slidesTop.sort(function(a, b){return b-a});
		  t=setInterval(function(){
			  $(".communitySlide").each(function(){
				  //left: 83 376 668 961
				  //top: 542 883 
				  var offsetLeft=parseInt($(this).offset().left);
				  var offsetLeftRatio=offsetLeft/slidesLeft[0];
				  var offsetTop=parseInt($(this).offset().top);
				  var offsetTopRatio=offsetTop/slidesTop[0];
				  if(offsetLeftRatio>((slidesLeft[3]+10)/slidesLeft[0]) && offsetTopRatio<((slidesTop[1]+50)/slidesTop[0])){
					  $(this).stop().animate({
						  left: "-=292"
					  },1500,function(){
						  if(offsetLeftRatio<((slidesLeft[1]-50)/slidesLeft[0])){
							  $(this).stop().animate({
								  top: "+=341",
							  },1500);
						  }
					  });
				  }else if(offsetLeftRatio<((slidesLeft[0]-50)/slidesLeft[0]) && offsetTopRatio>((slidesTop[1]+50)/slidesTop[0])){
					  $(this).stop().animate({
						  left: "+=292"
					  },1500,function(){
						  if(offsetLeftRatio>=((slidesLeft[1]-50)/slidesLeft[0])){
							  $(this).stop().animate({
								  top: "-=341"
							  },1500);
						  }
					  });
				  }
			  });
		  },3000);
	  }
  }
  $.commuinityMainSlide();
  $("#optionCnt").on({
	  change: function(){
		  var optionCnt=$(this).val();
		  $("#pollOptions").css("opacity","0");
		  setTimeout(function(){
			  $("#pollOptions").empty();
			  $("#pollOptions").append("<label for='vo_content'>"+ 
			  "<span class='glyphicon glyphicon-unchecked'></span> Options</label>" +
			  "<span class='msgSpan'></span>");
			  html=document.querySelector("#pollOptionTemplate").innerHTML;
			  for(let i=1;i<=optionCnt;i++){
				  let resultHTML=html.replace("{optionCnt}",i);
				  $("#pollOptions").append(resultHTML);
			  }
			  $("#pollOptions").css("opacity","1");
		  },500);
	  }
  });
  
  if($("#msgHere").val()!==undefined && $("#msgHere").val()!==""){
	  $.msgBox($("#msgHere").val());
  }
  
  $(document).on('submit',"[name='voteFrm']",function(event){
	  var formData=new FormData($(this).get(0));
	  for(var pair of formData.entries()){
		  console.log(pair[0] + "," + pair[1]);
		  if(pair[1]===''){
			  if(pair[0]=='vo_content'){
				  $("#pollOptions").find("span.msgSpan").each(function(){
					  let msgSpans=$(this).text("please fill in the blank");
					  $(msgSpans).css("opacity","1");
					  setTimeout(function(){
						  $(msgSpans).css("opacity","0");
					  },3000);
				  });
			  }else{
				  let msgSpan=$("#" + pair[0]).parent().find("span.msgSpan");
				  $(msgSpan).text("please fill in the blank");
				  $(msgSpan).css("opacity","1");
				  setTimeout(function(){
					  $(msgSpan).css("opacity","0");
				  },3000);
			  }
			  event.preventDefault();
		  }
	  }
  });
  
  $(".comm-vote-progress").each(function(){
	  $(this).click(function(){
		  var vote_num=parseInte($(this).attr("data-poll-vote-num"));
		  var vo_num=parseInt($(this).attr("data-poll-option-num"));
		  $.getJSON(getPageContext + "/community/votinguserlist/insert",
				  {'vote_num':vote_num,'vo_num':vo_num},
				  function(json){
					  if(json.code==='success'){
						  
					  }else {
						  $.msgBox(json.code);
					  }
				  });
	  });
  });
});

