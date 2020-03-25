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

import tipoviFrizer.FrizerType;
import tipoviFrizer.TerminType;
import tipoviSminker.MusterijaType;
import tipoviSminker.SminkerType;

//import paketSminkerski.MusterijaType;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		boolean loginFailed = false;
		boolean pokusanLogin = false;
		boolean nijeUneto = false;
		
		String ime = request.getParameter("ime");
		String password = request.getParameter("password");
//		if (ime.equals("") || password.equals("")) {
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../index.jsp");
//			requestDispatcher.forward(request, response);
//		}
		
		if (ime.equals("") || password.equals("")) {
			pokusanLogin = true;
			nijeUneto = true;
			request.setAttribute("pokusanLogin", pokusanLogin);
			request.setAttribute("nijeUneto", nijeUneto);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../index.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
		
			URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/login");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setDoOutput(true);
			conn.connect();
			
			StringBuffer queryParam = new StringBuffer();
			queryParam.append("ime=");
			queryParam.append(ime);
			queryParam.append("&");
			queryParam.append("password=");
			queryParam.append(password);
			
			OutputStream output = conn.getOutputStream();
			output.write(queryParam.toString().getBytes());
			output.flush();
			
			conn.connect();
			InputStream in = conn.getInputStream();
	
			ObjectMapper mapper = new ObjectMapper();
			MusterijaType musterija = mapper.readValue(in, mapper.getTypeFactory().constructType(MusterijaType.class));
			conn.disconnect();
			
			if (musterija.getIme() == null || musterija.getIme().isEmpty()) {
				pokusanLogin = true;
				loginFailed = true;
				request.setAttribute("pokusanLogin", pokusanLogin);
				request.setAttribute("loginFailed", loginFailed);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../index.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
			
				//inicijalizovanje za sledecu stranicu
				
				//sviFrizeri
			    url = new URL("http://localhost:8080/RestZakazivanje/rest/frizer/all");
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				in = conn.getInputStream();
		
				mapper = new ObjectMapper();
				List<FrizerType> sviFrizeri = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, FrizerType.class));
				conn.disconnect();
				
				//moji termini za frizerski salon
				url = new URL("http://localhost:8080/RestZakazivanje/rest/terminFrizerski/musterije");
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setRequestProperty("charset", "utf-8");
				conn.setDoOutput(true);
				conn.connect();
				
				queryParam = new StringBuffer();
				queryParam.append("id=");
				queryParam.append(musterija.getId());
				
				output = conn.getOutputStream();
				output.write(queryParam.toString().getBytes());
				output.flush();
				
				conn.connect();
				in = conn.getInputStream();
		
				mapper = new ObjectMapper();
				List<TerminType> mojiTerminiFrizeri = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, TerminType.class));
				conn.disconnect();
				
				request.getSession().setAttribute("frizeri", sviFrizeri);
				request.getSession().setAttribute("mojiTerminiFrizeri", mojiTerminiFrizeri);
				
				request.getSession().setAttribute("idKorisnika", musterija.getId());
				request.getSession().setAttribute("ime", musterija.getIme());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../pocetna.jsp");
				requestDispatcher.forward(request, response);
				
			}
		}
		
	}

}
