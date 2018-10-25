/*
	scroll : layout.jsp
 */
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
    var search=$("#search").offset();
	var miniLogo=$(".miniLogo").offset();
	var max_width=search.left-miniLogo.left;
	$("#searchForm").css('position', 'absolute');
	$("#searchForm").css('left', miniLogo.left+2);
	$("#searchForm").css('top', miniLogo.top);
	$("#searchForm").css('width', max_width+50);
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
  $("#search_close").on('click',function(event){
	  event.preventDefault();
	  $("#headerSearch").css('display','none');
  });
});

