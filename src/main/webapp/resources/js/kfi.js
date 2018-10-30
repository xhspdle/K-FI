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
  $(".dropdown").hover(function(){
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
				  	"<input type='file' class='form-control' id='fileP"+n +"' name='fileP' accept='.jpg, .jpeg, .png'>" +
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
				  	"<input type='file' class='form-control' id='fileV"+nn +"' name='fileV' accept='.avi, .wmv, .mp4'>" +
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
	  console.log(getPageContext);
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
		 }
	  });
	  ajaxReq.fail(function(jqXHR){
		 $("#uploadMsg").text(jqXHR.responseText + '(' + jqXHR.status +
				 ' - ' + jqXHR.statusText + ')');
		 $("#sendServer").prop('disabled',false);
	  });
  });
  $.jsonDate=function(json){
	  var dates=json.split("-");
	  var day=parseInt(dates[2])+1
	  return dates[0] + "-" + dates[1] + "-" + day.toString();
  }
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
						  "<span style='border-bottom: 4px solid black'>" + $.jsonDate(json.mb_date) +
						  "</span></h1>")
						  .appendTo("#myBoardList");
					}
					sameDate=json.mb_date;
					if(mv_savvid!=null && mv_savvid!=''){
						attachment="<video class='img-responsive center-block' controls autoplay muted='muted' loop src='"+getPageContext +"/resources/upload/vid/" + mv_savvid + "'></video>";
					}else if(mp_savimg!=null && mp_savimg!=''){
						attachment="<img class='img-responsive center-block' src='"+getPageContext +"/resources/upload/img/" + mp_savimg + "'>";
					}else{
						attachment="<img class='img-responsive center-block' src='"+getPageContext +"/resources/images/logo2.png'>";
					}
					if(i==0){
						$("<div class='panel-group'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading' id='"+ mb_num +"'>" +
						    "<blockquote class='postBlock'>" +
						  	"<h1 class='postTitle'>" + 
						  	"<a href='"+getPageContext +"/mypage/myboard/select?mb_num="+ mb_num +"' class='postA'>" + mb_title + "</a></h1></blockquote></div>" +
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
						  	"<a href='"+getPageContext +"/mypage/myboard/select?mb_num="+ mb_num +"' class='postA'>" + mb_title + "</a></h1></blockquote></div>" +
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
			location.href=getPageContext + "/mypage/myboard/select?mb_num=" +$(this).prop("id") ;
		})
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
  $("#myBoardSelect .panel-heading").click(function(){
	  location.reload();
  });
});

