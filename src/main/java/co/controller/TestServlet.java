package co.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import co.dao.CyclistaDaoMySQL;

import co.model.Cyclista;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProyectoServlet
 */
@WebServlet("/")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CyclistaDaoMySQL proyectoDao;

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

    	this.proyectoDao = new CyclistaDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action){

			default:
				listProyectos(request,response);
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
	

	
	private void listProyectos(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{

		List<Cyclista> proyectos = this.proyectoDao.selectAll();
		//CONEXION CON ITEM
		request.setAttribute("proyectos", proyectos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("eventosProyectos.jsp");
		dispatcher.forward(request, response);
	}

}