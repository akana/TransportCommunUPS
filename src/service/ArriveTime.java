package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tisseo.ArriveBM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.RetrieveHTTPData;

/**
 * Servlet implementation class ArriveBM
 */
@WebServlet("/arriveTime")
public class ArriveTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArriveTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String BMToSearch = request.getParameter("searchBM");
        if(BMToSearch==null){
            BMToSearch="";
        }
        ArrayList<ArriveBM> arrivals = new ArrayList<ArriveBM>();
        String data = RetrieveHTTPData.getHTTPData("http://pt.data.tisseo.fr/departureBoard?stopPointId=1970324837185012&format=json&key=a03561f2fd10641d96fb8188d209414d8");
        JSONArray dataArray;
        try {
            dataArray = new JSONArray(data);
            JSONObject temp;
            if(BMToSearch.equals("")){
                for(int i=0;i<dataArray.length();i++){
                    temp=dataArray.getJSONObject(i);
                    arrivals.add(
                            new ArriveBM( 
                                    temp.getString("name"),
                                    temp.getString("shortName"),
                                    temp.getString("dateTime")
                                    )
                            );
                }
            }else{
                for(int i=0;i<dataArray.length();i++){
                    temp=dataArray.getJSONObject(i);
                        arrivals.add(
                                new ArriveBM( 
                                		temp.getString("name"),
                                        temp.getString("shortName"),
                                        temp.getString("dateTime")
                                        )
                                );
                }
            }
            
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("arrivals", arrivals);
        RequestDispatcher dispatcher= request.getRequestDispatcher ("index.jsp?content=findBusArriveTime");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}
}

