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
 * Servlet implementation class SacuvajTerminFrizerski
 */
@WebServlet("/SacuvajTerminFrizerski")
public class SacuvajTerminFrizerski extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajTerminFrizerski() {
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
		int terminId = Integer.parseInt(request.getParameter("terminId"));
		String sisanje = request.getParameter("sisanje");
		String feniranje = request.getParameter("feniranje");
		String farbanje = request.getParameter("farbanje");
		
		boolean sisanjeb = false;
		boolean feniranjeb = false;
		boolean  farbanjeb = false;
		
		if (sisanje != null) {
			sisanjeb = true;
		}
		if (feniranje != null) {
			feniranjeb = true;
		}
		if (farbanje != null) {
			farbanjeb = true;
		}
		
		request.getSession().setAttribute("terminIdFrizerski", terminId);
		request.getSession().setAttribute("sisanje", sisanjeb);
		request.getSession().setAttribute("feniranje", feniranjeb);
		request.getSession().setAttribute("farbanje", farbanjeb);
		
		request.setAttribute("cuvaSeTermin", true);
		
		if (!sisanjeb && !feniranjeb && !farbanjeb) {
			request.setAttribute("izabranaUsluga", false);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../pocetna.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			request.setAttribute("izabranaUsluga", true);
			
			//moji termini za sminkera
			URL url = new URL("http://localhost:8080/RestZakazivanje/rest/terminSminkerski/korisnika");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setDoOutput(true);
			conn.connect();
			
			StringBuffer queryParam = new StringBuffer();
			queryParam.append("id=");
			queryParam.append(request.getSession().getAttribute("idKorisnika"));
			
			OutputStream output = conn.getOutputStream();
			output.write(queryParam.toString().getBytes());
			output.flush();
			
			conn.connect();
			InputStream in = conn.getInputStream();
	
			ObjectMapper mapper = new ObjectMapper();
			List<tipoviSminker.TerminType> mojiTerminiSminkeri = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, tipoviSminker.TerminType.class));
			conn.disconnect();
			
			//svi sminkeri
			url = new URL("http://localhost:8080/RestZakazivanje/rest/sminker/sve");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			in = conn.getInputStream();
	
			mapper = new ObjectMapper();
			List<SminkerType> sviSminkeri = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, SminkerType.class));
			conn.disconnect();
			
			
			request.getSession().setAttribute("sminkeri", sviSminkeri);
			request.getSession().setAttribute("mojiTerminiSminkeri", mojiTerminiSminkeri);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../zakazivanjeSminkanja.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
