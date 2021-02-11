<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="org.springframework.web.context.support.ServletContextResource"/ %>
<%@ page import="org.springframework.core.io.Resource"/ %>
<%@ page import="org.springframework.web.util.WebUtils"%>

<%
	Resource res = new ServletContextResource(application, "/WEB-INF/classes/config/file.txt");
	out.print(res.getFilename() + "<br/>");
	out.print(WebUtils.getTempDir(application).getAbsolutePath());
%>
<html>
<body>this is test ServletContetxtResource jsp.
</body>
</html>
