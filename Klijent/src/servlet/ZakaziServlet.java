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
import javax.ws.rs.FormParam;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ZakaziServlet
 */
@WebServlet("/ZakaziServlet")
public class ZakaziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZakaziServlet() {
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
		//zakazivanje frizera
		int idTerminaF = Integer.parseInt(request.getSession().getAttribute("terminIdFrizerski").toString());
		boolean sisanje = Boolean.parseBoolean(request.getSession().getAttribute("sisanje").toString());
		boolean feniranje = Boolean.parseBoolean(request.getSession().getAttribute("feniranje").toString());
		boolean farbanje = Boolean.parseBoolean(request.getSession().getAttribute("farbanje").toString());
		
		URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminFrizerski/zakazi");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		StringBuffer queryParam = new StringBuffer();
		queryParam.append("id=");
		queryParam.append(idTerminaF);
		queryParam.append("&");
		queryParam.append("idMusterija=");
		queryParam.append(request.getSession().getAttribute("idKorisnika"));
		queryParam.append("&");
		queryParam.append("sisanje=");
		queryParam.append(sisanje);
		queryParam.append("&");
		queryParam.append("feniranje=");
		queryParam.append(feniranje);
		queryParam.append("&");
		queryParam.append("farbanje=");
		queryParam.append(farbanje);
		
		OutputStream output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		boolean uspeloF = mapper.readValue(in, mapper.getTypeFactory().constructType(Boolean.class));
		conn.disconnect();
		
		
		//zakazivanje sminkera
		int idTerminaS = Integer.parseInt(request.getParameter("terminIdS"));
		int idMusterije = Integer.parseInt(request.getSession().getAttribute("idKorisnika").toString());
		
		url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/zakazi");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setDoOutput(true);
		conn.connect();
		
		queryParam = new StringBuffer();
		queryParam.append("id=");
		queryParam.append(idTerminaS);
		queryParam.append("&");
		queryParam.append("idMusterije=");
		queryParam.append(idMusterije);
			
		output = conn.getOutputStream();
		output.write(queryParam.toString().getBytes());
		output.flush();
		
		conn.connect();
		in = conn.getInputStream();

		mapper = new ObjectMapper();
		boolean uspeloS = mapper.readValue(in, mapper.getTypeFactory().constructType(Boolean.class));
		conn.disconnect();
		
		if (uspeloF && uspeloS) {
			request.setAttribute("uspesno", true);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../zakazivanjeSminkanja.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
