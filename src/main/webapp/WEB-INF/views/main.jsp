<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron text-center">
	<h1><img class="logoImg" alt="logo" src="<c:url value='/resources/images/logo2.png'/>"></h1>
	<p>We love Korea!</p> 
	<form>
		<div class="input-group col-sm-offset-4 col-sm-4">
			<input type="email" class="form-control" placeholder="what is you're favorite k-culture?" required>
			<div class="input-group-btn">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</div>
	</form>
</div>
<div id="about" class="container-fluid">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-6">
			<h2>About K-FI</h2><br>
			<h4>Korea, K-POP, K-Drama, Red Velvet, Twice, BTS</h4><br>
			<p>K-POP 좋아하는 사람 모여라! 덕질하기 가장 좋은 싸이트는 바로 여기! 수다, 사진, 영상 모두 모두 나누자!
			너도 나도 K-POP! 드라마도 한국 드라마가 최고!! 미스터 선샤인 짱짱맨 오예!! 트와이스 사나 모모 짱짱 레드벨벳도 짱짱 방탄소년단도 호올
			신나게 모이자!!
			</p>
			<br><button class="btn btn-default btn-lg">Join Us</button>
		</div>
		<div class="col-sm-4">
			<span class="glyphicon glyphicon-signal logo"></span>
		</div>
	</div>
</div>

<div id="explore" class="container-fluid bg-grey">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-6">
			<!-- img class="img-responsive slideanim" -->
			<img class="img-responsive slideanim" alt="kpop로고" src="<c:url value='/resources/images/Kpoplogo.png'/>">
		</div>
		<div class="col-sm-4">
			<h2>Best Community</h2><br>
			<h4><strong>Share:</strong> K-POP과 함께 즐거운 순간을 공유하자! </h4><br>
			<p><strong>MeetUp:</strong> K-POP팬들과 함께 만나서 놀자!</p>
		</div>
	</div>
</div>