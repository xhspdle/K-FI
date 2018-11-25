<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.sidenav {
	    height: 100%; /
	    width: 0; 
	    position: fixed; 
	    z-index: 1; 
	    top: 0;
	    left: 0;
	    background-color: #111; 
	    overflow-x: hidden; 
	    padding-top: 60px; 
	    transition: 0.5s; 
	}
	.sidenav a {
	    padding: 8px 8px 8px 32px;
	    text-decoration: none;
	    font-size: 25px;
	    color: #818181;
	    display: block;
	    transition: 0.3s;
	}
	.sidenav a:hover {
	    color: #f1f1f1;
	}
	.sidenav .closebtn {
	    position: absolute;
	    top: 50;
	    right: 25px;
	    font-size: 36px;
	    margin-left: 50px;
	}
	#statMain {
	    transition: margin-left .5s;
	    padding: 20px;
	}
	@media screen and (max-height: 450px) {
	    .sidenav {padding-top: 15px;}
	    .sidenav a {font-size: 18px;}
	}
	.numbering {
		-webkit-transition: all 0.5s ease-in-out;
		transition: all 0.5s ease-in-out;
	}
	.image-container {
		position: relative;
		height: 120px;
	}
	.statBig {
		-webkit-transition: all 0.5s ease-in-out;
		transition: all 0.5s ease-in-out;
		-webkit-box-shadow: 0 1px 7px rgba(0,0,0,0.25);
		box-shadow: 0 1px 7px rgba(0,0,0,0.25);
		background-color: white;
		color: black;
		font-size: 2vw; 
		font-weight: bold;
		margin: 0 auto;
		padding: 10px;
		width: 50%;
		text-align: center;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		mix-blend-mode: screen;
	}
	.pies {
		height: 600px;
		width: 800px;
		margin: auto;
	}
</style>
<script type="text/javascript">
	$(function(){
		new numberCounter("totalMemCnt", "${totalMemCnt}");
		new numberCounter("totalCommCnt", "${totalCommCnt}");
		//commMemCnt - table
		google.charts.load('current', {'packages':['table']});
	    google.charts.setOnLoadCallback(drawTable1);
		function drawTable1(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Community Name');
			data.addColumn('number', 'Number of Members');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' 명',fractionDigits: 0 });
			<c:forEach var="vo" items="${commMemCnt }">
			data.addRows([["${vo.comm_name}", {v: ${vo.cnt}, f: formatter.formatValue("${vo.cnt}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("commMemCnt_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
		//commMemCnt - pie
		google.charts.load('current', {'packages':['corechart']});
	    google.charts.setOnLoadCallback(drawChart1);
	    function drawChart1() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'Community Name');
			data.addColumn('number', 'Number of Members');
			<c:forEach var="vo" items="${commMemCnt }">
			data.addRows([["${vo.comm_name}", ${vo.cnt}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of Community Members'
			};
			var chart = new google.visualization.PieChart(document.getElementById('commMemCnt_chart'));
			chart.draw(data, options);
		}
	    //commViewSum - table
	    google.charts.setOnLoadCallback(drawTable2);
	    function drawTable2(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Community Name');
			data.addColumn('number', 'Sum of Views');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' Views',fractionDigits: 0 });
			<c:forEach var="vo" items="${commViewSum }">
			data.addRows([["${vo.comm_name}", {v: ${vo.sum}, f: formatter.formatValue("${vo.sum}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("commViewSum_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
	    //commViewSum - pie
	    google.charts.setOnLoadCallback(drawChart2);
	    function drawChart2() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'Community Name');
			data.addColumn('number', 'Sum of Views');
			<c:forEach var="vo" items="${commViewSum }">
			data.addRows([["${vo.comm_name}", ${vo.sum}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of Community Views'
			};
			var chart = new google.visualization.PieChart(document.getElementById('commViewSum_chart'));
			chart.draw(data, options);
		}
	    //periodMemCntWeek - table
	    google.charts.setOnLoadCallback(drawTable3);
	    function drawTable3(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Members');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' 명',fractionDigits: 0 });
			<c:forEach var="vo" items="${periodMemCntWeek }">
			data.addRows([["${vo.user_regdate}", {v: ${vo.sum}, f: formatter.formatValue("${vo.sum}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("periodMemCntWeek_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
	    //periodMemCntWeek - aria
	    google.charts.setOnLoadCallback(drawChart3);
	    function drawChart3() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Members');
			<c:forEach var="vo" items="${periodMemCntWeek }">
			data.addRows([["${vo.user_regdate}", ${vo.sum}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of Members in weeks',
				hAxis: {title: 'RegDate'},
				vAxis: {minValue: 0}
			};
			var chart = new google.visualization.AreaChart(document.getElementById('periodMemCntWeek_chart'));
			chart.draw(data, options);
		}
	    //periodMyBoardCntWeek - table
	    google.charts.setOnLoadCallback(drawTable4);
	    function drawTable4(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Posts');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' posts',fractionDigits: 0 });
			<c:forEach var="vo" items="${periodMyBoardCntWeek }">
			data.addRows([["${vo.mb_date}", {v: ${vo.cnt}, f: formatter.formatValue("${vo.cnt}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("periodMyBoardCntWeek_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
	    //periodMyBoardCntWeek - aria
	    google.charts.setOnLoadCallback(drawChart4);
	    function drawChart4() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Posts');
			<c:forEach var="vo" items="${periodMyBoardCntWeek }">
			data.addRows([["${vo.mb_date}", ${vo.cnt}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of MyBoard Posts in week',
				hAxis: {title: 'Post Date'},
				vAxis: {minValue: 0}
			};
			var chart = new google.visualization.AreaChart(document.getElementById('periodMyBoardCntWeek_chart'));
			chart.draw(data, options);
		}
	    //periodCommBoardCntWeek - table
	    google.charts.setOnLoadCallback(drawTable5);
	    function drawTable5(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Posts');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' posts',fractionDigits: 0 });
			<c:forEach var="vo" items="${periodCommBoardCntWeek }">
			data.addRows([["${vo.cb_date}", {v: ${vo.cnt}, f: formatter.formatValue("${vo.cnt}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("periodCommBoardCntWeek_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
	    //periodCommBoardCntWeek - aria
	    google.charts.setOnLoadCallback(drawChart5);
	    function drawChart5() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Posts');
			<c:forEach var="vo" items="${periodCommBoardCntWeek }">
			data.addRows([["${vo.cb_date}", ${vo.cnt}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of CommBoard Posts in week',
				hAxis: {title: 'Post Date'},
				vAxis: {minValue: 0}
			};
			var chart = new google.visualization.AreaChart(document.getElementById('periodCommBoardCntWeek_chart'));
			chart.draw(data, options);
		}
	    //periodMyViewSumWeek - table
	    google.charts.setOnLoadCallback(drawTable6);
	    function drawTable6(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Posts');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' Views',fractionDigits: 0 });
			<c:forEach var="vo" items="${periodMyViewSumWeek }">
			data.addRows([["${vo.mb_date}", {v: ${vo.sum}, f: formatter.formatValue("${vo.sum}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("periodMyViewSumWeek_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
	    //periodMyViewSumWeek - aria
	    google.charts.setOnLoadCallback(drawChart6);
	    function drawChart6() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'User RegeDate');
			data.addColumn('number', 'Posts');
			<c:forEach var="vo" items="${periodMyViewSumWeek }">
			data.addRows([["${vo.mb_date}", ${vo.sum}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of MyBoard Views in week',
				hAxis: {title: 'Date'},
				vAxis: {minValue: 0}
			};
			var chart = new google.visualization.AreaChart(document.getElementById('periodMyViewSumWeek_chart'));
			chart.draw(data, options);
		}
	    //periodCommViewSumWeek - table
	    google.charts.setOnLoadCallback(drawTable7);
	    function drawTable7(){
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'CommBoard RegeDate');
			data.addColumn('number', 'Views');
			var formatter = new google.visualization.NumberFormat(
					{suffix: ' Views',fractionDigits: 0 });
			<c:forEach var="vo" items="${periodCommViewSumWeek }">
			data.addRows([["${vo.cb_date}", {v: ${vo.sum}, f: formatter.formatValue("${vo.sum}")}]]);
			</c:forEach>
			var table = new google.visualization.Table(document.getElementById("periodCommViewSumWeek_table"));
			table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
		}
	    //periodCommViewSumWeek - aria
	    google.charts.setOnLoadCallback(drawChart7);
	    function drawChart7() {
	    	var data = new google.visualization.DataTable();
	    	data.addColumn('string', 'CommBoard RegeDate');
			data.addColumn('number', 'Views');
			<c:forEach var="vo" items="${periodCommViewSumWeek }">
			data.addRows([["${vo.cb_date}", ${vo.sum}]]);
			</c:forEach>
			var options = {
				chartArea: {width:'70%',height:'70%'},
				height: 600,
				width: 800,
				title: 'Number of CommBoard Views in week',
				hAxis: {title: 'Date'},
				vAxis: {minValue: 0}
			};
			var chart = new google.visualization.AreaChart(document.getElementById('periodCommViewSumWeek_chart'));
			chart.draw(data, options);
		}
	});
	function numberCounter(target_frame, target_number){
		this.count=0;
		this.diff=0;
		this.target_count=parseInt(target_number);
		this.target_frame=document.getElementById(target_frame);
		this.timer=null;
		this.counter();
	};
	numberCounter.prototype.counter=function(){
		var self=this;
		this.diff=this.target_count-this.count;
		if(this.diff>0){
			self.count+=Math.ceil(this.diff/5);
		}
		this.target_frame.innerHTML=this.count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		if(this.count<this.target_count){
			this.timer=setTimeout(function(){ self.counter();}, 20);
		}else{
			clearTimeout(this.timer);
		}
	};
	function openNav(where) {
	    document.getElementById(where).style.width = "300px";
	    document.getElementById("statMain").style.marginLeft = "300px";
	}
	function closeNav(where) {
	    document.getElementById(where).style.width = "0";
	    document.getElementById("statMain").style.marginLeft= "0";
	}
	function commMembers(){
		document.getElementById("commViews").style.display = "none";
		document.getElementById("commMembers").style.display = "block";
	}
	function commViews(){
		document.getElementById("commMembers").style.display = "none";
		document.getElementById("commViews").style.display = "block";
	}
	function periodStats(where){
		$(".periodics").each(function(){
			$(this).css("display", "none");
		});
		$("#" + where).css("display", "block");
	}
</script>
<div id="statMain">
	<div class="container">
		<h2>Statistics</h2>
		<p>Site analysis</p>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<li><a data-toggle="tab" href="#comm">Community</a></li>
			<li><a data-toggle="tab" href="#period">Periodic</a></li>
		</ul>
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
			<h3>Home</h3>
				<div class="image-container">
					<div class="statBig text-center">Total Members : <span id="totalMemCnt" class="numbering"></span></div>
				</div>
				<div class="image-container">
					<div class="statBig text-center">Total Communities : <span id="totalCommCnt" class="numbering"></span></div>
				</div>
			</div>
			<div id="comm" class="tab-pane fade">
				<div id="mySidenav" class="sidenav">
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav('mySidenav')">&times;</a><br><br>
					<a href="javascript:commMembers()">Community Members</a>
					<a href="javascript:commViews()">Community Views</a>
				</div>
				<span style="font-size:30px;cursor:pointer" onclick="openNav('mySidenav')">&#9776; Menu</span>
				<div id="commMembers">
					<h3>Community Statistic - Members</h3>
					<div class="row">
						<h4 class="text-center">Number of Community Members Top 10</h4>
						<div id="commMemCnt_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of Community Members Top 10</h4>
						<div id="commMemCnt_table"></div>
					</div>
				</div>
				<div id="commViews" style="display:none;">
					<h3>Community Statistic - Views</h3>
					<div class="row">
						<h4 class="text-center">Number of Community Views Top 10</h4>
						<div id="commViewSum_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of Community Views Top 10</h4>
						<div id="commViewSum_table"></div>
					</div>
				</div>
			</div>
			<div id="period" class="tab-pane fade">
				<div id="mySidenavPeriod" class="sidenav">
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav('mySidenavPeriod')">&times;</a><br><br>
					<a href="javascript:periodStats('periodMemCntWeek')">Members</a>
					<a href="javascript:periodStats('periodMyBoardCntWeek')">MyBoard Posts</a>
					<a href="javascript:periodStats('periodCommBoardCntWeek')">CommBoard Posts</a>
					<a href="javascript:periodStats('periodMyViewSumWeek')">MyBoard Views</a>
					<a href="javascript:periodStats('periodCommViewSumWeek')">CommBoard Views</a>
				</div>
				<span style="font-size:30px;cursor:pointer" onclick="openNav('mySidenavPeriod')">&#9776; Menu</span>
				<div id="periodMemCntWeek" class="periodics">
					<h3>Periodic Statistic - Members</h3>
					<div class="row">
						<h4 class="text-center">Number of Members in weeks</h4>
						<div id="periodMemCntWeek_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of Members in weeks</h4>
						<div id="periodMemCntWeek_table"></div>
					</div>
				</div>
				<div id="periodMyBoardCntWeek" style="display:none;" class="periodics">
					<h3>Periodic Statistic - MyBoard</h3>
					<div class="row">
						<h4 class="text-center">Number of MyBoard Posts in week</h4>
						<div id="periodMyBoardCntWeek_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of MyBoard Posts in week</h4>
						<div id="periodMyBoardCntWeek_table"></div>
					</div>
				</div>
				<div id="periodCommBoardCntWeek" style="display:none;" class="periodics">
					<h3>Periodic Statistic - CommBoard</h3>
					<div class="row">
						<h4 class="text-center">Number of CommBoard Posts in week</h4>
						<div id="periodCommBoardCntWeek_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of CommBoard Posts in week</h4>
						<div id="periodCommBoardCntWeek_table"></div>
					</div>
				</div>
				<div id="periodMyViewSumWeek" style="display:none;" class="periodics">
					<h3>Periodic Statistic - MyBoard</h3>
					<div class="row">
						<h4 class="text-center">Number of MyBoard Views in week</h4>
						<div id="periodMyViewSumWeek_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of MyBoard Views in week</h4>
						<div id="periodMyViewSumWeek_table"></div>
					</div>
				</div>
				<div id="periodCommViewSumWeek" style="display:none;" class="periodics">
					<h3>Periodic Statistic - CommBoard</h3>
					<div class="row">
						<h4 class="text-center">Number of CommBoard Views in week</h4>
						<div id="periodCommViewSumWeek_chart" class="pies"></div>
					</div>
					<div class="row">
						<h4 class="text-center">Number of CommBoard Views in week</h4>
						<div id="periodCommViewSumWeek_table"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>