<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.fiform-group input {
	width: 400px;
}

.fiform-group-code input {
	width: 200px;
}

.form-control {
	display: inline-block;
}

.btn btn-default {
	display: inline;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="container">
		<label>아이디 찾기</label>
		<form class="" action="<c:url value='/login/findpid'/>" method="post">
			<div class="form-group">
				<label class="form-control-label" for="fpemail">Email</label> <input
					type="email" class="form-control" id="fiemail" name="fiemail"
					placeholder="Enter Email"> <span id="emailMsg"
					class="help-block" style="opacity: 1;"></span>
			</div>
		</form>
		<form class="navbar-form navbar-left" action="/action_page.php">
			<div class="form-group">
				<label class="form-control-label" for="ficode">Code</label><br>
				<input type="text" class="form-control" id="ficode" name="ficode"
					placeholder="Enter Code">
				<button type="submit" class="btn btn-default">Submit</button>
				<span id="idMsg" class="help-block" style="opacity: 1;"></span>
			</div>
			<div class="col-xs-3">
    <label for="ex2">col-xs-3</label>
    <input class="form-control" id="ex2" type="text">
  </div>
		</form>

	</div>
</body>
</html>