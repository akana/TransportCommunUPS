<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="pages/header.jsp" %>  
</head>
<body>
<img src="images/logo.jpg" style="clear: both;display: block;margin:auto;">
<%@ include file="pages/menu.jsp" %>  

<%
String content = request.getParameter("content");
if(content==null)
    content = "findBusArriveTime";
if(content.equals("findBusArriveTime")){
%>
	<%@ include file="pages/findBusArriveTime.jsp" %>    
	
<%
}else if(content.equals("findAvalaibleBicycle")){
%>
	<%@ include file="pages/findAvalaibleBicycle.jsp" %>    
<%
}
%>
</body>
</html>