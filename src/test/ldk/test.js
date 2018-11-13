/**
 * 
 */
  if($("#commMainHere").val()!==undefined){
	  var slides=document.getElementsByClassName("communitySlide");
	  var slidesLeft=[];
	  var slidesTop=[];
	  var maxLeft=0;
	  var maxTop=0;
	  for(let i in slides){
		  slidesLeft[i]=slides[i].offsetLeft;
		  slidesTop[i]=slides[i].offsetTop;
		  let slideLeft=slides[i].offsetLeft;
		  let slideTop=slides[i].offsetTop;
		  if(maxLeft<slideLeft){
			  maxLeft=slideLeft;
		  }
		  if(maxTop<slideTop){
			  maxTop=slideTop;
		  }
	  }
	  slidesLeft.sort(function(a, b){return b-a});
	  slidesTop.sort(function(a, b){return b-a});
	  
	  console.log("maxLeft: " +maxLeft);
	  console.log("maxLeft: " +maxTop);
	  console.log("slidesLeft: " +slidesLeft);
	  console.log("aaaaaaa");
	  setInterval(function(){
		  $(".communitySlide").each(function(){
			  //left: 83 376 668 961
			  //top: 542 883 
			  var offsetLeft=parseInt($(this).offset().left);
			  var offsetLeftRatio=offsetLeft/maxLeft;
			  var offsetTop=parseInt($(this).offset().top);
			  var offsetTopRatio=offsetTop/maxTop;
			  //console.log("offsetLeft: "+ offsetLeft);
			  //console.log("offsetTop: " + offsetTop);
			  if(offsetLeftRatio>(100/maxLeft) && offsetTopRatio<(600/maxTop)){
				  $(this).animate({
					  left: "-=292"
				  },1500,function(){
					  if(offsetLeftRatio<(500/maxLeft)){
						  $(this).animate({
							  top: "+=341"
						  },1500);
					  }
				  });
			  }else if(offsetLeftRatio<(800/maxLeft) && offsetTopRatio>(600/maxTop)){
				  $(this).animate({
					  left: "+=292"
				  },1500,function(){
					  if(offsetLeftRatio>(500/maxLeft)){
						  $(this).animate({
							  top: "-=341"
						  },1500);
					  }
				  });
			  }
			  
		  });
	  },3000);
  }

if($("#commMainHere").val()!==undefined){
	  var slides=document.getElementsByClassName("communitySlide");
	  var maxLeft=0;
	  for(var i in slides){
		  let slideLeft=slides[i].offsetLeft;
		  if(maxLeft<slideLeft){
			  maxLeft=slideLeft;
		  }
	  }
	  console.log(maxLeft);
	  console.log("aaaaaaa");
	  setInterval(function(){
		  $(".communitySlide").each(function(){
			  //left: 83 376 668 961 -208 -501.5 -794 -1086.5 -1379
			  //top: 542 883 1224
			  //ratioLeft(1350): 0.06 0.27 
			  //ratioTop: 
			  var left=parseInt($(this).css("left"));
			  var offsetLeft=parseInt($(this).offset().left);
			  var top=parseInt($(this).css("top"));
			  var offsetTop=parseInt($(this).offset().top);
			  var moveLeft=left-292;
			  var moveTop=top-341;
			  //console.log("offsetLeft: "+ offsetLeft);
			  console.log("ratioLeft: "+ offsetLeft/maxLeft);
			  //console.log("offsetTop: " + offsetTop);
			  $(this).animate({
				  left: moveLeft
			  },1000,function(){
				  if(offsetLeft<0){
					  $(this).animate({
						 left: 0
					  },1000,function(){
						 /*
						  * 여기할차례
						  */
					  });
				  }
			  });
			  
		  });
	  },2000);
/*	  $(document).on('mouseover',".communitySlide",function(){
		  setInterval(function(){
			  var left=$(this).css("left");
			  console.log(left);
			  var moveLeft=parseInt(left)-283;
			  $(this).animate({
				  left: moveLeft
			  },1000,function(){
				  
			  });
			  
		  },2000);
		  
	  });*/
}