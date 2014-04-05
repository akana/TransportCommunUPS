package service;

import java.io.IOException;
import java.util.ArrayList;

import model.tisseo.ArriveBM;
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
	        dispatcher= request.getRequestDispatcher ("index.jsp?content=findBusArriveTime");
		}else if(content.equals("findAvalaibleBicycle")){
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
