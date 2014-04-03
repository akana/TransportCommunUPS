<%@page import="model.tisseo.Stops" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
ArrayList<Stops> stations = (ArrayList<Stops>) request.getAttribute("stops");
for(Stops s : stops){
    out.println("Stops: <br>");
    out.println(s.getStopsName()+"<br>");
    out.println("<br>");
}
%>