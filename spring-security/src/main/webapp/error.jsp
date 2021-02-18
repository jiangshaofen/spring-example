<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body>
	<div style="text-align: center">

		<h1>HTTP Status 403 - Access is denied</h1>
		<h2>${error}</h2>


		<br /> <br /> <a
			href="${pageContext.request.contextPath }/auth/login">重新登录</a>
	</div>
</body>
</html>
