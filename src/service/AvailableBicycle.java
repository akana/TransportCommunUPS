package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.velo_toulouse.Station;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.RetrieveHTTPData;

/**
 * Servlet implementation class AvailableBicycle
 */
@WebServlet("/availableBicycle")
public class AvailableBicycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableBicycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String stationToSearch = request.getParameter("search");
        if(stationToSearch==null){
            stationToSearch="";
        }
        ArrayList<Station> stations = new ArrayList<Station>();
        String data = RetrieveHTTPData.getHTTPData("https://api.jcdecaux.com/vls/v1/stations?contract=Toulouse&apiKey=06332805f697b637331587197aca029cf3d1ab12");
        JSONArray dataArray;
        try {
            dataArray = new JSONArray(data);
            String nameBrut;
            JSONObject temp;
            if(stationToSearch.equals("")){
                for(int i=0;i<dataArray.length();i++){
                    temp=dataArray.getJSONObject(i);
                    nameBrut = temp.getString("name").substring(8);
                    stations.add(
                            new Station( 
                                    temp.getInt("number"),
                                    nameBrut,
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
            }else{
                for(int i=0;i<dataArray.length();i++){
                    temp=dataArray.getJSONObject(i);
                    nameBrut = temp.getString("name").substring(8);
                    if(nameBrut.equals(stationToSearch)){
                        stations.add(
                                new Station( 
                                        temp.getInt("number"),
                                        nameBrut,
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
                }
            }
            
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("stations", stations);
        RequestDispatcher dispatcher= request.getRequestDispatcher ("index.jsp?content=findAvalaibleBicycle");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}
}
