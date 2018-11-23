<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function(){
		var totalMemCnt="${totalMemCnt}";
		var totalCommCnt="${totalCommCnt}";
		new numberCounter("totalMemCnt", totalMemCnt);
		new numberCounter("totalCommCnt", totalCommCnt);
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
</script>
<style>
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
</style>
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
				<div class="statBig text-center">Total Community : <span id="totalCommCnt" class="numbering"></span></div>
			</div>
		</div>
		<div id="comm" class="tab-pane fade">
		<h3>Community Statistic</h3>
		
		</div>
		<div id="period" class="tab-pane fade">
		<h3>Periodic Statistic</h3>
		
		</div>
	</div>
</div>