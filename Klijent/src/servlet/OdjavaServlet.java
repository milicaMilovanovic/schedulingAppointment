package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OdjavaServlet
 */
@WebServlet("/OdjavaServlet")
public class OdjavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OdjavaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeValue("idKorisnika");
		request.getSession().removeValue("mojiTerminiFrizeri");
		request.getSession().removeValue("ime");
		request.getSession().removeValue("idTerminaSminkerskog");
		request.getSession().removeValue("frizeri");
		request.getSession().removeValue("mojiTerminiSminkeri");
		request.getSession().removeValue("terminIdFrizerski");
		request.getSession().removeValue("feniranje");
		request.getSession().removeValue("sisanje");
		request.getSession().removeValue("farbanje");
		request.getSession().removeValue("sminkeri");
		request.getSession().removeValue("imaKomentara");
		request.getSession().removeValue("zatrazeniKomentari");
		request.getSession().removeValue("komentari");
		request.getSession().removeValue("imaTerminaFrizera");
		request.getSession().removeValue("zatrazeniTerminiFrizera");
		request.getSession().removeValue("terminiFrizera");
		request.getSession().removeValue("imaTerminaSminkera");
		request.getSession().removeValue("zatrazeniTerminiSminkera");
		request.getSession().removeValue("terminiSminkera");
		
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../index.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
