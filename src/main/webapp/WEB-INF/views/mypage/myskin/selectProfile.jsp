<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  없는 자식테이블 데이터 select하면 500 오류남 -->
<!-- org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.kfi.mybatis.jyi.MySkinProfileMapper.select__myskin_profile
### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.kfi.mybatis.jyi.MySkinProfileMapper.select__myskin_profile
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:982)
	org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:635)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:742)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
	
	 -->
<h1>${n }</h1>