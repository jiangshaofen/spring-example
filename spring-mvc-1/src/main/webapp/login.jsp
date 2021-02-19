<%@ page contentType="text/html;charset=UTF-8" language="java"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>登录</title>
</head>
<body>
	<h3>this is login page</h3>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}" /></font>
	</c:if>

	<form action="${pageContext.request.contextPath }/loginCheck" method="post">
		userName:<input type="text" name="userName"> 
		<br /> 
		passWord:<input	type="password" name="passWord"> 
		<br />
		 <input type="submit" value="login" />
		 <input type="reset" value="reset" />

	</form>
</body>
</html>
