<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>common</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Common Page</h1>

		<p>每个人都能访问的页面.</p>
		<br /> 
		<br /> 
		<a href="${pageContext.request.contextPath }/auth/denied"> Go Denied Page </a> 
		<br /> 
		<br /> 
		<a href="${pageContext.request.contextPath }/main/admin"> Go Admin Page </a> 
		<br />
		<br />
		<a href="${pageContext.request.contextPath }/auth/logout">退出登录</a>
	</div>
</body>
</html>
