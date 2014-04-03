<%@page import="model.velo_toulouse.Station" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<form method="GET" action="availableBicycle">
	<input type="text" placeholder="Chercher station de vélo" name="search">
	<input type="submit" value="Submit">
</form>
<table cellpadding="0" cellspacing="0" border="1">
	<caption><b>Station Vélo Toulouse</b></caption>
	<thead>
		<tr>
			<th>Numéro</th>
			<th>Nom</th>
			<th>Address</th>
			<th>Vélo disponible</th>
			
		</tr>
	</thead>
	<tbody>
		<%
		ArrayList<Station> stations = (ArrayList<Station>) request.getAttribute("stations");
		for(Station s : stations){
		    out.print("<tr>");
		    out.println("<td>"+s.getNumber()+"</td>");
		    out.println("<td>"+s.getName()+"</td>");
		    out.println("<td>"+s.getAddress()+"</td>");
		    out.println("<td>"+s.getAvailableBikeStand()+"</td>");
		    out.print("</tr>");
		}
		%>
	</tbody>
</table>

