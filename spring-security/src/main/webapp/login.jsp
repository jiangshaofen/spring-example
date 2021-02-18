<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Login Page</h1>

		<div id="login-error">${error}</div>

		<form action="${pageContext.request.contextPath }/login" method="post">
			<p>
				<label for="username">Username</label> <input id="username"
					name="username" type="text" />
			</p>

			<p>
				<label for="password">Password</label> <input id="password"
					name="password" type="password" />
			</p>

			<input type="submit" value="Login" />

		</form>
	</div>
</body>
</html>
