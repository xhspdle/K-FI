<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 300px;
	text-align: center;
	font-family: arial;

}

.title {
	color: grey;
	font-size: 18px;
}

button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

a {
	text-decoration: none;
	color: black;
}

button:hover, a:hover {
	opacity: 0.7;
	
}
#adminimg {
	width:100%;
	  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;

    background-image: url("<c:url value='/resources/images/ysy/ccc.gif'/>");
}
</style>

<div class="container" id="adminimg" >
	<h2 style="text-align: center">관리자</h2>	
	<div class="card">
		<img src="<c:url value='/resources/images/ysy/1 (19).jpg'/>" alt="John" style="width: 100%">
		<h1>John Doe</h1>
		<p class="title">CEO Founder, Example</p>
		
		<div style="margin: 24px 0;">
			<a href="#"><i class="fa fa-dribbble"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-facebook"></i></a>
		</div>
		<p>
			<button>Contact</button>
		</p>
	</div>
</div>

<input type="button" value="스킨바꾸기" id="changeskin">


<script>
	$("#changeskin").click(function(){
		alert("bbb");
	});
</script>