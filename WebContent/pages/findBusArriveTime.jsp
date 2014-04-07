<%@ page import="model.tisseo.ArriveBM" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<form method="GET" action="arriveTimeBusMetro">
			<input type="text" placeholder="Numero de ligne" name="search">
			<input type="submit" value="Search">
</form>
		
		

<table cellpadding="0" cellspacing="0" border="1">
	<caption><b>Informations de Bus/Metro</b></caption>
	<thead>
		<tr>
			<th>Numéro</th>
			<th>Time</th>
			
		</tr>
	</thead>
	<tbody>
		<%
		ArrayList<ArriveBM> departure = (ArrayList<ArriveBM>) request.getAttribute("departure");
		for(ArriveBM d : departure){
		    out.print("<tr>");
		    out.println("<td>"+d.getNumber()+"</td>");
		    out.println("<td>"+d.getTime()+"</td>");
		    out.print("</tr>");

		}
		%>
	</tbody>
</table>

