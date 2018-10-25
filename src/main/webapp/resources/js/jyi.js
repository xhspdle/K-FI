/**
 * jyi.js
 */
/*
 * $("a").click(function(event){ event.preventDefault(); var year=Number(${year
 * }); var month=Number(${month}); var day=parseInt($(this).text()); $.ajax({
 * url:"<c:url value='/mypage/find'/>", dataType:"json", type:"post",
 * data:{"year":year,"month":month,"day":day}, success:function(data){
 * alert("!!"); } }); });
 */

/*
 * $("#leftside").css("display", "none");
		$("#rightside").css("display", "none");
		$("#leftside").removeClass("col-sm-3 sidenav").hide();
		$("#rightside").removeClass("col-sm-3").hide();
		$("#center").removeClass("col-sm-offset-3 col-sm-6");
		$("#center").addClass("col-sm-12");
 * 
 * */
$(function() {
	openLeft();
	var n = 1;

	//left side bar 닫기
	function closeLeft() {
		$("#leftside").css("display", "none");
		$("#leftside").removeClass("col-sm-3 sidenav").hide();
		$("#center").removeClass("col-sm-offset-3 col-sm-6");
		$("#center").addClass("col-sm-offset-3 col-sm-9");
	}
	
	//right side bar 닫기
	function closeRight() {
		$("#rightside").css("display", "none");
		$("#rightside").removeClass("col-sm-3").hide();
		$("#center").removeClass("col-sm-offset-3 col-sm-6");
		$("#center").addClass("col-sm-offset-3 col-sm-9");
	}

	//left side bar 보이기
	function openLeft(){
		$("#leftside").css("display", "block");
		$("#leftside").addClass("col-sm-3 sidenav").show();
		var center=$("#center").prop("class");
		if(center === "col-sm-12"){
			$("#center").removeClass("col-sm-12");
			$("#center").addClass("col-sm-offset-3 col-sm-9").show();
		}else if(center === "col-sm-offset-3 col-sm-9"){
			$("#center").removeClass("col-sm-offset-3 col-sm-9");
			$("#center").addClass("col-sm-offset-3 col-sm-6").show();
		}
	}

	//right side bar 보이기
	function openRight(){
		$("#rightside").css("display", "block");
		$("#rightside").addClass("col-sm-3").show();
		var center=$("#center").prop("class");
		if(center === "col-sm-12"){
			$("#center").removeClass("col-sm-12");
			$("#center").addClass("col-sm-offset-3 col-sm-9").show();
		}else if(center === "col-sm-offset-3 col-sm-9"){
			$("#center").removeClass("col-sm-offset-3 col-sm-9");
			$("#center").addClass("col-sm-offset-3 col-sm-6").show();
		}
	}
	
	//left side bar 열고 닫기
	$("#mycomm_cal_profile").click(function() {
		if (n % 2 == 0) {
			openLeft();
		}else{
			closeLeft();
		}
		n++;
	});

});