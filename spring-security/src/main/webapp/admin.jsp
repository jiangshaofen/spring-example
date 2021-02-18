<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Admin Page</h1>

		<p>管理员页面</p>
		<br /> 
		<br /> 
		<a href="${pageContext.request.contextPath }/main/common"> Go Common Page </a>
		<br /> 
		<br /> 
		<a href="${pageContext.request.contextPath }/auth/logout">退出登录</a>
	</div>
</body>
</html>
