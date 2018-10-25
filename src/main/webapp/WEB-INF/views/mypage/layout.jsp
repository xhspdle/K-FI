<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title>K-FI Main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/kfi.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/jyi.css'/>">
<script src="<c:url value='/resources/js/kfi.js'/>"></script>
<script src="<c:url value='/resources/js/jyi.js'/>"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="content" class="container-fluid">
		<div class="row">
			<div class="col-sm-3 sidenav" id="leftside">
				<tiles:insertAttribute name="leftside" />
			</div>
			<div class="col-sm-offset-3 col-sm-6" id="center">
				<div class="container-fluid">
					<tiles:insertAttribute name="content"/>
				</div>		
			</div>
			<div class="col-sm-3" id="rightside">
				<tiles:insertAttribute name="rightside"/>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="writeModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding:35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-edit"></span> Write</h4>
				</div>
				<div class="modal-body" style="padding:40px 50px;">
					<form role="form">
						<div class="form-group">
							<label for="title"><span class="glyphicon glyphicon-pencil"></span> Title</label>
							<input type="text" class="form-control" id="title" name="title" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="content1"><span class="glyphicon glyphicon-menu-hamburger"></span> Content</label>
							<textarea class="form-control" rows="5" id="content1" name="content"></textarea>
						</div>
						<div class="form-group" id="imgUpload">
							<label for="fileP1" class="btn btn-primary btn-block btn-file"><span class="glyphicon glyphicon-picture"></span> Upload Photo</label>
							<input type="file" class="form-control" id="fileP1" name="fileP1" accept=".jpg, .jpeg, .png">
							<img id="fimg1" src="" style="display:none;width:100%;">
						</div>
						<div class="form-group" id="vidUpload">
							<label for="fileV1" class="btn btn-info btn-block btn-file"><span class="glyphicon glyphicon-facetime-video"></span> Upload Video</label>
							<input type="file" class="form-control" id="fileV1" name="fileV1" style="display:none;" accept=".avi, .wmv, .mp4">
						</div>
						<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-ok"></span> Write</button>
					</form>
				</div>
				<div class="modal-footer">
				  <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				  <p>upload picture and video!</p>
				</div>
			</div> 
			<!--  
			<div class="modal-content" id="modalSide" style="margin-left:30px;width:30%;display:none;">
				<div class="modal-header">
					<h1>asd</h1>
				</div>
				<div class="modal-body">
					<h1>asd</h1>
				</div>
			</div>
			--> 
		</div>
	</div> 
</div>