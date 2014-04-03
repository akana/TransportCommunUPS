package service;

import java.io.IOException;
import java.util.ArrayList;

import model.arrete_ups.Stops;
import model.velo_toulouse.Station;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.RetrieveHTTPData;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String content = request.getParameter("content");
	    if(content==null)
	        content="findBusArriveTime";
	    RequestDispatcher dispatcher;
	    if(content.equals("findBusArriveTime")){
	    	ArrayList<Stops> stops = new ArrayList<Stops>();
	    	String data = RetrieveHTTPData.getHTTPData("http://pt.data.tisseo.fr/stopPointsList?bbox=1.4512%2C43.5595%2C1.4651%2C43.57361&key=a03561f2fd10641d96fb8188d209414d8");
	    	JSONArray dataArray;
	    	try {
                dataArray = new JSONArray(data);
            
    	        JSONObject temp;
    	        for(int i=0;i<dataArray.length();i++){
    	            temp=dataArray.getJSONObject(i);
    	            stops.add(
    	                    new Stops( 
    	                            temp.getString("name")
    	                            )
    	                    );
    	        }
	    	}catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                request.setAttribute("stops", stops);
	        dispatcher= request.getRequestDispatcher ("index.jsp?content=findBusArriveTime");
	    }
	    else if(content.equals("findAvalaibleBicycle")){
	        ArrayList<Station> stations = new ArrayList<Station>();
	        String data = RetrieveHTTPData.getHTTPData("https://api.jcdecaux.com/vls/v1/stations?contract=Toulouse&apiKey=06332805f697b637331587197aca029cf3d1ab12");
	        JSONArray dataArray;
            try {
                dataArray = new JSONArray(data);
            
    	        JSONObject temp;
    	        for(int i=0;i<dataArray.length();i++){
    	            temp=dataArray.getJSONObject(i);
    	            stations.add(
    	                    new Station( 
    	                            temp.getInt("number"),
    	                            temp.getString("name"),
    	                            temp.getString("address"),
    	                            temp.getJSONObject("position").getDouble("lat"),
    	                            temp.getJSONObject("position").getDouble("lng"),
    	                            temp.getBoolean("banking"),
    	                            temp.getBoolean("bonus"),
    	                            temp.getString("status"),
    	                            temp.getString("contract_name"),
    	                            temp.getInt("bike_stands"),
    	                            temp.getInt("available_bike_stands"),
    	                            temp.getInt("available_bikes"),
    	                            temp.getLong("last_update")
    	                            )
    	                    );
    	        }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.setAttribute("stations", stations);
	        dispatcher= request.getRequestDispatcher ("index.jsp?content=findAvalaibleBicycle");
	    }else
            dispatcher= request.getRequestDispatcher ("index.jsp?content=findBusArriveTime");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
