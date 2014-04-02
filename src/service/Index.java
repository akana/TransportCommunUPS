package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	    System.out.println("hello");
	    String content = request.getParameter("content");
	    if(content==null)
	        content="findBusArriveTime";
	    RequestDispatcher dispatcher;
	    if(content.equals("findBusArriveTime"))
	        dispatcher= request.getRequestDispatcher ("index.jsp?content=findBusArriveTime");
	    else if(content.equals("findAvalaibleBicycle"))
            dispatcher= request.getRequestDispatcher ("index.jsp?content=findAvalaibleBicycle");
	    else
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
