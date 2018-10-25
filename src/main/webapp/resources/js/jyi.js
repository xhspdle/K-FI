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

$(function() {

	// left side bar 열고 닫기
	$("#mycomm_cal_profile").click(function() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6" || center === "col-sm-offset-3 col-sm-9" ) {
			/* left right 모두 열린 상태 */
			closeLeft();
		} else if (center === "col-sm-9" || center === "col-sm-12") {
			/*  left right 모두 닫힌 상태 */
			openLeft();
		}
	});

	// left side bar 닫기
	function closeLeft() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6" ) {
		$("#leftside").removeClass("col-sm-3 sidenav").hide();
		$("#center").removeClass("col-sm-offset-3 col-sm-6");
		$("#center").addClass("col-sm-9");
		}else if(center === "col-sm-offset-3 col-sm-9" ){
			$("#leftside").removeClass("col-sm-3 sidenav").hide();
			$("#center").removeClass("col-sm-offset-3 col-sm-9");
			$("#center").addClass("col-sm-12");
		}
	}

	// left side bar 열기
	function openLeft() {
		$("#leftside").addClass("col-sm-3 sidenav").show();
		var center = $("#center").prop("class");
		if (center === "col-sm-9") {
			$("#center").removeClass("col-sm-9");
			$("#center").addClass("col-sm-offset-3 col-sm-6").show();
		} else if (center === "col-sm-12") {
			$("#center").removeClass("col-sm-12");
			$("#center").addClass("col-sm-offset-3 col-sm-9").show();
		}
	}

	// right side bar 열고 닫기
	$("#mycomm_cal_chat").click(function() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6"  || center === "col-sm-9") {
			closeRight();
		} else if (center === "col-sm-offset-3 col-sm-9" || center === "col-sm-12") {
			openRight();
		}
	});

	// right side bar 닫기
	function closeRight() {
		var center = $("#center").prop("class");
		if (center === "col-sm-offset-3 col-sm-6" ) {
			$("#rightside").removeClass("col-sm-3").hide();
			$("#center").removeClass("col-sm-offset-3 col-sm-6");
			$("#center").addClass("col-sm-offset-3 col-sm-9").show();
		}else if(center === "col-sm-9"){
			$("#rightside").removeClass("col-sm-3").hide();
			$("#center").removeClass("col-sm-9");
			$("#center").addClass("col-sm-12").show();
		}
	}

	// right side bar 열기
	function openRight() {
		$("#rightside").addClass("col-sm-3").show();
		var center = $("#center").prop("class");
		if (center === "col-sm-12") {
			$("#center").removeClass("col-sm-12");
			$("#center").addClass("col-sm-9").show();
		} else if (center === "col-sm-offset-3 col-sm-9") {
			$("#center").removeClass("col-sm-offset-3 col-sm-9");
			$("#center").addClass("col-sm-offset-3 col-sm-6").show();
		}
	}
});