<%@ page import="model.tisseo.ArriveBM" %>
<%@ page import="model.tisseo.LineEvaluation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
			<th>Destination</th>
			<th>Like</th>
			<th>Unlike</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<%
		ArrayList<LineEvaluation> lines = (ArrayList<LineEvaluation>) request.getAttribute("linesInfo");
		Map<String,LineEvaluation> lineMaps = new HashMap<String,LineEvaluation>();
		for(LineEvaluation line : lines){
		    lineMaps.put(line.getLineNumber(),line);
		}
		
		
		ArrayList<ArriveBM> departure = (ArrayList<ArriveBM>) request.getAttribute("departure");
		for(ArriveBM d : departure){
		    out.print("<tr>");
		    out.println("<td>"+d.getNumber()+"</td>");
		    out.println("<td>"+d.getTime()+"</td>");
		    out.println("<td>"+d.getDestination()+"</td>");
			out.println("<td>"+lineMaps.get(d.getNumber()).getNumLike()+"</td>");
			out.println("<td>"+lineMaps.get(d.getNumber()).getNumUnlike()+"</td>");
			out.println("<td><form method=\"post\" action=\"arriveTimeBusMetro\">");
			out.println("<input type=\"hidden\" name=\"id\" value=\""+lineMaps.get(d.getNumber()).get_id()+"\" />");
			out.println("<input type=\"hidden\" name=\"rev\" value=\""+lineMaps.get(d.getNumber()).get_rev()+"\"/>");
			out.println("<input type=\"hidden\" name=\"like\" value=\"like\"/>");
			out.println("<input type=\"submit\" value=\"Like\">");
			out.println("</form></td>");
			out.println("<td><form method=\"post\" action=\"arriveTimeBusMetro\">");
			out.println("<input type=\"hidden\" name=\"id\" value=\""+lineMaps.get(d.getNumber()).get_id()+"\" />");
			out.println("<input type=\"hidden\" name=\"rev\" value=\""+lineMaps.get(d.getNumber()).get_rev()+"\"/>");
			out.println("<input type=\"hidden\" name=\"unlike\" value=\"unlike\"/>");
			out.println("<input type=\"submit\" value=\"Unlike\">");
			out.println("</form></td>");
			out.print("</tr>");
			}
		%>
	</tbody>
</table>


