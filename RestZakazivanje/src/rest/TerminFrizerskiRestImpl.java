package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import paket.Frizerski;
import paket.Frizerski_Service;
import paket.FrizuraType;
import paket.MusterijaType;
import paket.TerminType;

@Path("terminFrizerski")
public class TerminFrizerskiRestImpl {

	private Frizerski_Service service;
	private Frizerski port;
	
	{
		service = new Frizerski_Service();
		port = service.getFrizerskiImplPort();
	}
	
	@Path("zakazi")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean zakaziTermin(@FormParam("id") int id,
			@FormParam("idMusterija") int idMusterija, 
			@FormParam("farbanje") boolean farbanje, 
			@FormParam("sisanje") boolean sisanje, 
			@FormParam("feniranje") boolean feniranje) { 

		System.out.println("FENIRANJEEEEEEEEEEEEE " + feniranje + ", " + sisanje);
		
		MusterijaType musterija = new MusterijaType();
		musterija.setId(idMusterija);
		
		TerminType termin = new TerminType();
		termin.setId(id);
		FrizuraType ft = new FrizuraType();
		
//		ft.setFarbanje(true);
//		ft.setFeniranje(true);
//		ft.setSisanje(true);
		
		ft.setFarbanje(farbanje);
		ft.setFeniranje(feniranje);
		ft.setSisanje(sisanje);
		termin.setFrizura(ft);
		termin.setMusterija(musterija);
		
		return port.zakaziTermin(termin);
	}
	
	@Path("musterije")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<TerminType> terminiMusterije(@FormParam("id") int id) {
		return port.terminiMusterije(id);
	}
	
}
