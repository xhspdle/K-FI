/*
	scroll : layout.jsp
 */
$(document).ready(function(){
  //var getPageContext=$("#getPageContext").val();
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
  var imgUpload=$("#imgUpload");
  $("#fileP1").change(function(event){
	  var tmppath=URL.createObjectURL(event.target.files[0]);
	  $("#fimg1").fadeIn("fast").attr("src",URL.createObjectURL(event.target.files[0]));
	  if($("#imgUpload").children().length<=3){
		  $("<button type='button' class='btn btn-default btn-block' id='addImg'>" +
	  		"추가 업로드</button>").appendTo(imgUpload);
		  var n=2;
		  $("#imgUpload").on('click',"#addImg",function(){
			  //시간되면 추가버튼 눌렀을때 나타나는 버튼 위치로 스크롤바 이동시키기
			  if(n>=6){
				  $(this).css('color','red');
				  $(this).html("사진은 5장까지 업로드 가능합니다");
			  }else{
				  $("<label for='fileP"+ n +"' class='btn btn-primary btn-block btn-file'>" +
				  	"<span class='glyphicon glyphicon-picture'></span> Upload Photo"+n +"</label>" +
				  	"<input type='file' class='form-control myboardFile' id='fileP"+n +"' name='fileP' accept='.jpg, .jpeg, .png, .gif'>" +
				  	"<img id='fimg"+ n +"' src='' style='display:none;width:100%'>")
				  .appendTo(imgUpload);
				  $("#imgUpload").on('change','#fileP' + n, function(event1){
					  var tmppath1=URL.createObjectURL(event1.target.files[0]);
					  let imgTag="#fimg" + n++;
					  $(imgTag).fadeIn("fast").prop("src",URL.createObjectURL(event1.target.files[0]));
				  });
			  }  
		  });
	  }
  });
  var vidUpload=$("#vidUpload");
  $("#fileV1").change(function(event){
	  var tmppath=URL.createObjectURL(event.target.files[0]);
	  $("#fvid1").fadeIn("fast").attr("src",URL.createObjectURL(event.target.files[0]));
	  if($("#vidUpload").children().length<=3){
		  $("<button type='button' class='btn btn-default btn-block' id='addVid'>" +
	  		"추가 업로드</button>").appendTo(vidUpload);
		  var nn=2;
		  $("#vidUpload").on('click',"#addVid",function(){
			  if(nn>=3){
				  $(this).css('color','red');
				  $(this).html("영상은 2개까지 업로드 가능합니다");
			  }else{
				  $("<label for='fileV"+ nn +"' class='btn btn-info btn-block btn-file'>" +
				  	"<span class='glyphicon glyphicon-facetime-video'></span> Upload Video"+nn +"</label>" +
				  	"<input type='file' class='form-control myboardFile' id='fileV"+nn +"' name='fileV' accept='.avi, .wmv, .mp4'>" +
				  	"<video id='fvid"+ nn +"' controls autoplay muted='muted' loop src='' style='display:none;width:100%'>")
				  .appendTo(vidUpload);
				  $("#vidUpload").on('change','#fileV' + nn, function(event2){
					  var tmppath2=URL.createObjectURL(event2.target.files[0]);
					  let vidTag="#fvid" + nn++;
					  $(vidTag).fadeIn("fast").prop("src",URL.createObjectURL(event2.target.files[0]));
				  });
			  }  
		  });
	  }
  });
  $("#sendServer").click(function(e){
	  var getPageContext=$("#getPageContext").val();
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
				 html=document.querySelector("#modalForm").innerHTML;
				 $(".modal-body").empty();
				 $(".modal-body").append(html);
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
  $.getList=function(pageNum,keyword){
	  	var getPageContext=$("#getPageContext").val();
		$.getJSON(getPageContext + "/mypage/myboard/list",
			{"pageNum":pageNum,"keyword":keyword},
			function(data){
				$(data.list).each(function(i,json){
					var mb_num=json.mb_num;
					var user_num=json.user_num;
					var mb_title=json.mb_title;
					var mb_content=json.mb_content;
					var mb_views=json.mb_views;
					var comment_cnt=json.comment_cnt;
					var like_cnt=json.like_cnt;
					var mp_savimg=json.mp_savimg;
					var mv_savvid=json.mv_savvid;
					var attachment='';
					if(sameDate!==json.mb_date){
						$("<h1 class='text-center' id='"+ json.mb_date +"' style='margin-bottom:30px;'>" +
						  "<span style='border-bottom: 4px solid black'>" + json.mb_date +
						  "</span></h1>")
						  .appendTo("#myBoardList");
					}
					sameDate=json.mb_date;
					if(mv_savvid!==null && mv_savvid!==''){
						attachment="<video class='img-responsive center-block' controls autoplay muted='muted' loop src='"+getPageContext +"/resources/upload/vid/" + mv_savvid + "'></video>";
					}else if(mp_savimg!==null && mp_savimg!==''){
						attachment="<img class='img-responsive center-block' src='"+getPageContext +"/resources/upload/img/" + mp_savimg + "'>";
					}
					if(i===0){
						$("<div class='panel-group'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading' id='"+ mb_num +"'>" +
						    "<blockquote class='postBlock'>" +
						  	"<h1 class='postTitle'>" + 
						  	"<a href='"+getPageContext +"/mypage/myboard/select?mb_num="+ mb_num +"' class='postA'>" + 
						  	mb_title + "</a></h1></blockquote></div>" +
						  "<div class='panel-body'>" + 
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						    "<h4 class='postLikeComment'>Likes: " + like_cnt + "</h4>" +
						  	"<h4 class='postLikeComment'>Comments: " + comment_cnt + "</h4></div></div></div></div>")
						.appendTo("#myBoardList");
					}else{
						$("<div class='panel-group slideanim'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading' id='"+ mb_num +"'>" +
						    "<blockquote class='postBlock'>" +
						  	"<h1 class='postTitle'>" + 
						  	"<a href='"+getPageContext +"/mypage/myboard/select?mb_num="+ mb_num +"' class='postA'>" + 
						  	mb_title + "</a></h1></blockquote></div>" +
						  "<div class='panel-body'>" + 
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						    "<h4 class='postLikeComment'>Likes: " + like_cnt + "</h4>" +
						  	"<h4 class='postLikeComment'>Comments: " + comment_cnt + "</h4></div></div></div></div>")
						.appendTo("#myBoardList");
					}
				});
				
			});
		$("#myBoardList").on('click',".panel-heading",function(){
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
  $.getListMore=function(){	  
	  $.getList(more++);
  }
  $("#myBoardSelect .postTitle > span").on({
	  click: function(){
		  location.reload();
	  }, mouseover: function(){
		  $(this).css("cursor","pointer");
	  }
  });
  $("#commentForm > button[type='submit']").click(function(e){
	  e.preventDefault();
	  var getPageContext=$("#getPageContext").val();
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
	  var getPageContext=$("#getPageContext").val();
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
				  html=document.querySelector("#commentTemplate").innerHTML;
				  var resultHTML=html.replace("{msp_savimg}", "kpop콘.gif")
				  		.replace("{pageNum}",pageNum)
				  		.replace("{path}", getPageContext)
				  		.replace(/{myc_num}/gi, myc_num)
				  		.replace("{user_id}", user_id)
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
				  $("<li><a class='aPaging bPaging' href='javascript:$.getCommentList("+ (startPageNum-1) +")'>" +
				  	"<span class='glyphicon glyphicon-chevron-right bPaging'></span></a></li>")
				  .appendTo(".pagination");
			  }else{
				  $(".pagination")
				  .append("<li><span class='glyphicon glyphicon-chevron-right bPaging'></span></li>");
			  }
		  });
  }
  if($("#myCommentListHere").val()!==undefined){
	  $.getCommentList();
  }
  $('[data-toggle="tooltip"]').tooltip();
  $("#commentList").on('click',".thumbsUp",function(e){
	  e.preventDefault();
	  var getPageContext=$("#getPageContext").val();
	  var myc_num=parseInt($(this).attr("data-comm-num"));
	  $.getJSON(getPageContext + "/mypage/mycommentlike/insert",
			  {'myc_num':myc_num},
			  function(json){
				  var msgSpan=$("span[data-comm-num='"+ myc_num +"'").next().next();
				  if(json.code==='success'){
					  var commentLikes=$("span[data-comm-num='"+ myc_num +"'").text();
					  $("span[data-comm-num='"+ myc_num +"'").text(parseInt(commentLikes)+1);
					  $(msgSpan).text("Thumbs Up!");
				  }else if(json.code==='duplicated'){
					  $(msgSpan).text("You've already clicked Likes");
				  }else{
					  $.msgBox(json.code);
				  }
				  $(msgSpan).css("opacity","1");
				  setTimeout(function(){
					  $(msgSpan).css("opacity","0"); 
				  },3000);
			  });
  });
  $("div.likes > a").click(function(e){
	  e.preventDefault();
	  var getPageContext=$("#getPageContext").val();
	  var mb_num=parseInt($(this).attr("data-board-num"));
	  $.getJSON(getPageContext + "/mypage/myboardlike/insert",
			  {'mb_num':mb_num},
			  function(json){
				  $("#likeCnt").html(json.boardLikeCnt + " Likes<span class='msgSpan'></span>");
				  var msgSpan=$("#likeCnt > span.msgSpan");
				  if(json.code==='success'){
					  $(msgSpan).text("Like it!");
				  }else if(json.code==='duplicated'){
					  $(msgSpan).text("You've already clicked Likes");
				  }else{
					  $(msgSpan).text("error...");
				  }
				  $(msgSpan).css("opacity","1");
				  setTimeout(function(){
					  $(msgSpan).css("opacity","0"); 
				  },3000);
			  });
  });
  $("#commentList").on('click',".dropDownDelete",function(e){
	  e.preventDefault();
	  var getPageContext=$("#getPageContext").val();
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
	  var getPageContext=$("#getPageContext").val();
	  var myc_num=parseInt($(this).attr("data-comm-num"));
	  var p=$(this).parent().parent().parent().parent().find("p");
	  var myc_content=$(p).text();
	  console.log($(p).parent().children().length);
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
	  var getPageContext=$("#getPageContext").val();
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
	   * $.ajax/contentType: false/processData: false 해줘야함 
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
	  })
  });
  $.msgBox=function(msg){
	  var showMsg='';
	  if(msg==='fail'){
		  showMsg="<strong>Failed!</strong> Server processing request failed..";
	  }else {
		  showMsg="<string>Server Msg</strong> "+ msg;
	  }
	  $(".alert-danger").html(showMsg);
	  $(".msgBox").show();
	  $(".msgBox").animate({
		  "top": ($(window).height()-$(".msgBox").outerHeight())/2 + $(window).scrollTop(),
		  }, 1500,function(){
			  setTimeout(function(){
				  $(".msgBox").css("transition","1s");
				  $(".msgBox").css("top",$(document).height());
				  setTimeout(function(){
					  $(".msgBox").css("display","none");
				  },500);
			  },2500);
		  });
  }
});

