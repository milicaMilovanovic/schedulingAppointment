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

import tipoviSminker.TerminType;

/**
 * Servlet implementation class VidiKomentareServlet
 */
@WebServlet("/VidiKomentareServlet")
public class VidiKomentareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VidiKomentareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSminkera = Integer.parseInt(request.getParameter("sminkerId"));
		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/komentari");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		StringBuffer queryParam = new StringBuffer();
		queryParam.append("id=");
		queryParam.append(idSminkera);
		
		OutputStream output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		List<String> komentari = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, String.class));
		conn.disconnect();
		
		if (komentari.isEmpty()) {
			request.getSession().setAttribute("imaKomentara", false);
		}
		else {
			request.getSession().setAttribute("imaKomentara", true);
		}
		request.getSession().setAttribute("zatrazeniKomentari", true);
		request.getSession().setAttribute("komentari", komentari);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../zakazivanjeSminkanja.jsp");
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
