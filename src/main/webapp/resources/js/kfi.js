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
	  var search=$("#search").offset();
	  var miniLogo=$(".miniLogo").offset();
	  var max_width=search.left-miniLogo.left;
	  $("#searchForm").css('position', 'absolute');
	  $("#searchForm").css('left', miniLogo.left+2);
	  $("#searchForm").css('top', miniLogo.top);
	  $("#searchForm").css('width', max_width+50);
	  $("#headerSearch").fadeIn('slow',function(){
		  $(this).slideDown();
	  });
	  $(window).scroll(function(){
		  var search=$("#search").offset();
		  var miniLogo=$(".miniLogo").offset();
		  var max_width=search.left-miniLogo.left;
		  $("#searchForm").css('position', 'absolute');
		  $("#searchForm").css('left', miniLogo.left+2);
		  $("#searchForm").css('top', miniLogo.top);
		  $("#searchForm").css('width', max_width+50);
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
  $("#search_close").on('click',function(event){
	  event.preventDefault();
	  $("#headerSearch").css('display','none');
  });
});

