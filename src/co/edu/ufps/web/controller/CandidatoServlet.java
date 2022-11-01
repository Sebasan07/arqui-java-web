package co.edu.ufps.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.web.dao.CandidatoDAO;
import co.edu.ufps.web.model.Candidato;

/**
 * Servlet implementation class CandidatoServlet
 */
@WebServlet("/CandidatoServlet")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDAO candidatoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidatoServlet() throws SQLException {
		super();
		candidatoDAO= new CandidatoDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Servlet Candidato");
		String action = request.getParameter("action");
		System.out.println("action");

		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditor(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Candidato");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Integer eleccion = Integer.parseInt(request.getParameter("eleccion").split(" - ")[0]);
		Integer id = candidatoDAO.buscarUltimoID();
		
		Candidato cl = new Candidato(id+1, request.getParameter("documento"), request.getParameter("nombre"), 
				request.getParameter("apellido"), eleccion, Integer.parseInt(request.getParameter("numero")));
		candidatoDAO.insertar(cl);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidatos/registro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidatos/mostrar.jsp");
		List<Candidato> list = candidatoDAO.list();
		request.setAttribute("lista", list);
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato cl = candidatoDAO.buscar(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("candidato", cl);

		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidatos/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato cl = new Candidato(Integer.parseInt(request.getParameter("id")), request.getParameter("documento"), request.getParameter("nombre"), 
				request.getParameter("apellido"), Integer.parseInt(request.getParameter("eleccion")), Integer.parseInt(request.getParameter("numero")));
		candidatoDAO.actualizar(cl);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato cl = candidatoDAO.buscar(Integer.parseInt(request.getParameter("id")));
		candidatoDAO.eliminar(cl.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);

	}

}
