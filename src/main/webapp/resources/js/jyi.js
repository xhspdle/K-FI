/**
 * jyi.js
 */
	/*$("a").click(function(event){
			event.preventDefault();
			var year=Number(${year });
			var month=Number(${month});
			var day=parseInt($(this).text());
			$.ajax({
				url:"<c:url value='/mypage/find'/>",
				dataType:"json",
				type:"post",
				data:{"year":year,"month":month,"day":day},
				success:function(data){
					alert("!!");
				}
			}); 
		});*/
$(function(){
	$("#leftside").css("display","none");
	$("#rightside").css("display","none");
	$("#leftside").removeClass("col-sm-3 sidenav").hide();
	$("#rightside").removeClass("col-sm-3").hide();
	$("#center").removeClass("col-sm-offset-3 col-sm-6");
	$("#center").addClass("col-sm-12");

	$("#mycomm_cal_profile").click(function(){
		$("#leftside").css("display","block");
		$("#leftside").addClass("col-sm-3 sidenav").show();
	//	$("#rightside").addClass("col-sm-3").show();
		$("#center").removeClass("col-sm-12");
		$("#center").addClass("col-sm-offset-3 col-sm-9").show();
	});
	
});