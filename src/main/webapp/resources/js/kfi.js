/*
	scroll : layout.jsp
 */
$(document).ready(function(){
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
	  $("#searchForm").css('left', miniLogo.left+2);
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
  $.getList=function(pageNum,keyword){
	  	var getPageContext=$("#getPageContext").val();
		$.getJSON(getPageContext + "/mypage/myboard/list",
			{"pageNum":pageNum,"keyword":keyword},
			function(data){
				$(data.list).each(function(i,json){
					var mb_num=json.mb_num;
					var mb_title=json.mb_title;
					var mb_content=json.mb_content;
					var mb_date=json.mb_date;
					var mb_views=json.mb_views;
					var comment_cnt=json.comment_cnt;
					var mp_savimg=json.mp_savimg;
					var mv_savvid=json.mv_savvid;
					var attachment='';
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
						  "<div class='panel-heading'>" +
						  	"<h1>" + mb_title + "</h1></div>" +
						  "<div class='panel-body'>" + 
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						  	"<h4>댓글 수: " + comment_cnt + "</h4></div></div></div></div>")
						.appendTo("#myBoardList");
					}else{
						$("<div class='panel-group slideanim'>" +
						  "<div class='panel panel-default'>" +
						  "<div class='panel-heading'>" +
						  	"<h1>" + mb_title + "</h1></div>" +
						  "<div class='panel-body'>" + 
						  	"<p>" + mb_content + "</p>" + 
						  	attachment + "</div>" +
						  "<div class='panel-footer'><div>" +
						  	"<h4>댓글 수: " + comment_cnt + "</h4></div></div></div></div>")
						.appendTo("#myBoardList");
					}
				});
			});
  }
  if($("#getPageContext").val()!==undefined){
	  $.getList();
  }
});

