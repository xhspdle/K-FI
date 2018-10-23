
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
  <h2>Log in</h2>
  <form method="post" action="adlogin">
    <div class="form-group">
      <label for="usr">ID:</label>
      <input type="text" class="form-control" name="id">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
