
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로그인 페이지 -->
<div class="container">
  <h2>Log in</h2>
  <form method="post" action="adlogin">
    <div class="form-group">
      <label for="usr">ID:</label>
      <input type="text" class="form-control" name="admin_id">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="admin_pwd">
    </div>
    <button type="submit" class="btn btn-default">로그인</button>
  </form>
</div>
