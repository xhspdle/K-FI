<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="admin" value="${sessionScope.admininfo}" />
<div id="pricing" class="container-fluid">
	<div class="text-center">
		<h2>금일업무</h2>
	</div>
	<div class="row slideanim">
		<div class="col-sm-4 col-xs-12">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h1>신고접수</h1>
				</div>
				<div class="panel-body">
	
				</div>
				<div class="panel-footer">
					<h3>$19</h3>
					<h4>per month</h4>
					<button class="btn btn-lg">Sign Up</button>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-xs-12">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h1>Q&#38;A</h1>
				</div>
				<div class="panel-body">

				</div>
				<div class="panel-footer">
					<h3>$29</h3>
					<h4>per month</h4>
					<button class="btn btn-lg">Sign Up</button>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-xs-12">
			<div class="panel panel-default text-center">
				<div class="panel-heading">
					<h1>추가된회원</h1>
				</div>
				<div class="panel-body">
	
				</div>
				<div class="panel-footer">
					<h3>$49</h3>
					<h4>per month</h4>
					<button class="btn btn-lg">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
</div>
