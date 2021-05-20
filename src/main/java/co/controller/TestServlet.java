package co.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import co.dao.CyclistaDao;

import co.model.Cyclista;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CyclistaServlet
 */
@WebServlet({ "/test", "/" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CyclistaDao cyclistaDao;

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

    	this.cyclistaDao = new CyclistaDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action){

			default:
				listCyclistas(request,response);
				break;
			}
		}catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	
	private void listCyclistas(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{

		List<Cyclista> cyclistas = this.cyclistaDao.selectAll();
		//CONEXION CON ITEM
		request.setAttribute("cyclistas", cyclistas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("eventosCyclistas.jsp");
		dispatcher.forward(request, response);
	}

}