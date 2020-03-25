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

/**
 * Servlet implementation class PostaviKomentarServlet
 */
@WebServlet("/PostaviKomentarServlet")
public class PostaviKomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostaviKomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer terminId = Integer.parseInt(request.getSession().getAttribute("idTerminaSminkerskog").toString());
		String komentar = request.getParameter("komentar");
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
		queryParam.append(komentar);
		System.out.println(komentar + " KOMENTAR U SERVLETU");
		
		OutputStream output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		boolean moze = mapper.readValue(in, mapper.getTypeFactory().constructType(Boolean.class));
		conn.disconnect();
		
		//moji termini za sminkera
		url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/korisnika");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		queryParam = new StringBuffer();
		queryParam.append("id=");
		queryParam.append(request.getSession().getAttribute("idKorisnika"));
		
		output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		in = conn.getInputStream();

		mapper = new ObjectMapper();
		List<tipoviSminker.TerminType> mojiTerminiSminkeri = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, tipoviSminker.TerminType.class));
		conn.disconnect();
		
		request.getSession().setAttribute("mojiTerminiSminkeri", mojiTerminiSminkeri);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../zakazivanjeSminkanja.jsp");
		requestDispatcher.forward(request, response);
	}

}
