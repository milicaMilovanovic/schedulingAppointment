package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import tipoviSminker.SminkerType;

/**
 * Servlet implementation class DodajKomentarServlet
 */
@WebServlet("/DodajKomentarServlet")
public class DodajKomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajKomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("idKorisnika") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../login.jsp");
			requestDispatcher.forward(request, response);
		}
		
		int terminId = Integer.parseInt(request.getParameter("terminIdSminkerskiKomentar"));
		
		System.out.println(terminId + " servleeeeeeeeeeeeeeet");
		
		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/dodajKomentar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		StringBuffer queryParam = new StringBuffer();
		queryParam.append("id=");
		queryParam.append(terminId);
		queryParam.append("&");
		queryParam.append("komentar");
		queryParam.append("");
		
		OutputStream output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		boolean moze = mapper.readValue(in, mapper.getTypeFactory().constructType(Boolean.class));
		conn.disconnect();
		
		if (moze) {
			request.getSession().setAttribute("idTerminaSminkerskog", terminId);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../unosKomentara.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../zakazivanjeSminkanja.jsp");
			requestDispatcher.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
