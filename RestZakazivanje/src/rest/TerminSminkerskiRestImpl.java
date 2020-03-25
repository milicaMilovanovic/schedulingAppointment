package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import paketSminkerski.MusterijaType;
import paketSminkerski.SminkerType;
import paketSminkerski.SminkerskiSalon;
import paketSminkerski.SminkerskiSalon_Service;
import paketSminkerski.TerminType;

@Path("terminSminkerski")
public class TerminSminkerskiRestImpl {

	private SminkerskiSalon_Service service;
	private SminkerskiSalon port;
	
	{
		service = new SminkerskiSalon_Service();
		port = service.getSminkerskiSalonImplPort();
	}
	
	@Path("sminkera")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<TerminType> terminiSminkera(@FormParam("id") int id) {
		return port.vratiSveTermineSminkera(id);
	}
	
	@Path("korisnika")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<TerminType> terminiKorisnika(@FormParam("id") int id) {
		return port.listaKorisnikovihTermina(id);
	}
	
	@Path("komentari")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> vratiKomentare(@FormParam("id") int id) {
		return port.vratiKomentareZaSminkera(id);
	}
	
	@Path("login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public MusterijaType login(@FormParam("password") String password, 
			@FormParam("ime") String ime) {
		MusterijaType mt = new MusterijaType();
		mt.setIme(ime);
		mt.setPassword(password);
		MusterijaType mtreturn = port.login(mt);
		return mtreturn;
	}
	
	@Path("dodajKomentar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean dodajKomentar(@FormParam("id") int id, 
			@FormParam("komentar") String komentar) {
		TerminType tp = new TerminType();
		tp.setId(id);
		tp.setKomentar(komentar);
		System.out.println("KOMENTAR REST " + komentar);
		return port.dodajKomentarNaTermin(tp);
	}
	
	@Path("zakazi")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean zakazi(@FormParam("id") int id, 
			@FormParam("idMusterije") int idMusterije) {
		TerminType tp = new TerminType();
		tp.setId(id);
		MusterijaType mt = new MusterijaType();
		mt.setId(idMusterije);
		tp.setMusterija(mt);
		return port.zakazi(tp);
	}
	
	
}
