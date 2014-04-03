<%@page import="model.velo_toulouse.Station" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
ArrayList<Station> stations = (ArrayList<Station>) request.getAttribute("stations");
for(Station s : stations){
    out.println("Station: <br>");
    out.println(s.getNumber()+"<br>");
    out.println(s.getName()+"<br>");
    out.println(s.getAddress()+"<br>");
    out.println(s.getAvailableBikeStand()+"<br>");
    out.println("<br>");
}
%>