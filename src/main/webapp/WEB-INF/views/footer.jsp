<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="contact" class="container-fluid">
	<h2 class="text-center">CONTACT</h2>
	<div class="row">
		<div class="col-sm-offset-2 col-sm-5">
			<p>Contact us and we'll get back to you within 24 hours.</p>
			<p><span class="glyphicon glyphicon-map-marker"></span> Jongno, KR</p>
			<p><span class="glyphicon glyphicon-phone"></span> +81 01000000000</p>
			<p><span class="glyphicon glyphicon-envelope"></span> k-fi@k-fi.com</p>
		</div>
		<div class="col-sm-5 slideanim">
			<div class="row">
				<div class="col-sm-6 form-group">
					<input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
				</div>
				<div class="col-sm-6 form-group">
					<input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
				</div>
			</div>
			<textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
			<div class="row">
				<div class="col-sm-12 form-group">
					<button class="btn btn-default pull-right" type="submit">Send</button>
				</div>
			</div>
		</div>
	</div>
</div>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Bootstrap Theme Made By <a href="https://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a></p>
</footer>
</body>
</html>