<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transport en Common UPS</title>
</head>
<body>
<h2>hello world</h2>
<%
	if(request.getParameter("content").equals("first")){
%>
	<%@ include file="body.jsp"%>    
	
<%
}
%>
</body>
</html>