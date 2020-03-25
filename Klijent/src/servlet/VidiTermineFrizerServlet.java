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

import tipoviFrizer.TerminType;

/**
 * Servlet implementation class VidiTermineFrizerServlet
 */
@WebServlet("/VidiTermineFrizerServlet")
public class VidiTermineFrizerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VidiTermineFrizerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("idKorisnika") == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../index.jsp");
			requestDispatcher.forward(request, response);
		}
		int idFrizera = Integer.parseInt(request.getParameter("frizerId"));
		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/frizer/terminiFrizera");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		StringBuffer queryParam = new StringBuffer();
		queryParam.append("id=");
		queryParam.append(idFrizera);
		
		OutputStream output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		List<TerminType> slobodniTerminiFrizera = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, TerminType.class));
		conn.disconnect();
		
		if (slobodniTerminiFrizera.isEmpty()) {
			request.getSession().setAttribute("imaTerminaFrizera", false);
		}
		else {
			request.getSession().setAttribute("imaTerminaFrizera", true);
		}
		request.getSession().setAttribute("zatrazeniTerminiFrizera", true);
		request.getSession().setAttribute("terminiFrizera", slobodniTerminiFrizera);
		System.out.println(idFrizera + " idFrizera");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../pocetna.jsp");
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
