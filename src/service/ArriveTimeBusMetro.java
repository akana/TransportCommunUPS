package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.tisseo.ArriveBM;
import model.velo_toulouse.Station;
import util.RetrieveHTTPData;

/**
 * Servlet implementation class ArriveTimeBusMetro
 */
@WebServlet("/arriveTimeBusMetro")
public class ArriveTimeBusMetro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArriveTimeBusMetro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lineToSearch = request.getParameter("search");
        if(lineToSearch==null){
        	lineToSearch="";
        }
		String data = RetrieveHTTPData.getHTTPData("http://pt.data.tisseo.fr/departureBoard?stopPointId=1970324837185012&format=json&key=a03561f2fd10641d96fb8188d209414d8");
		ArrayList<ArriveBM> arriveBM = new ArrayList<ArriveBM>();
		
			JSONObject jsonObject;
			String lineName="";
			
			String destination="";
			try {
				jsonObject = new JSONObject(data);
				if(lineToSearch.equals("")){
				for(int i=0; i<jsonObject.length()-1; i++){					
					JSONObject stopAreaObject = jsonObject.getJSONObject("departures");
					JSONArray departureArray = stopAreaObject.getJSONArray("departure");
					for(int j=0; j<departureArray.length()-1; j++){
						JSONObject departureObject = departureArray.getJSONObject(j);
						String arriveTime = departureObject.getString("dateTime");
						
						JSONObject lineObject = departureArray.getJSONObject(j).getJSONObject("line");
						lineName = lineObject.getString("shortName");
						
						JSONArray destinationArray = departureObject.getJSONArray("destination");
						JSONObject destinationObject = destinationArray.getJSONObject(0);
						destination = destinationObject.getString("name");
						arriveBM.add(new ArriveBM(lineName, arriveTime,destination));
						
					}
					
				}
				}else {
					for(int i=0; i<jsonObject.length()-1; i++){		
						JSONObject stopAreaObject = jsonObject.getJSONObject("departures");
						JSONArray departureArray = stopAreaObject.getJSONArray("departure");
						for(int j=0; j<departureArray.length()-1; j++){
							JSONObject departureObject = departureArray.getJSONObject(j);
							String arriveTime = departureObject.getString("dateTime");
							
							JSONObject lineObject = departureArray.getJSONObject(j).getJSONObject("line");
							lineName = lineObject.getString("shortName");
							
							JSONArray destinationArray = departureObject.getJSONArray("destination");
							JSONObject destinationObject = destinationArray.getJSONObject(0);
							destination = destinationObject.getString("name");
							if(lineName.equals(lineToSearch))
								arriveBM.add(new ArriveBM(lineName, arriveTime,destination));
							}
						
					}

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("departure", arriveBM);
	        RequestDispatcher dispatcher= request.getRequestDispatcher ("index.jsp?content=findBusArriveTime");
	        dispatcher.forward(request, response);
		
	}
	

	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
