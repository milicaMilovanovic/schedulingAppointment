package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import paketSminkerski.SminkerType;
import paketSminkerski.SminkerskiSalon;
import paketSminkerski.SminkerskiSalon_Service;

@Path("sminker")
public class SminkerRestImpl {

	private SminkerskiSalon_Service service;
	private SminkerskiSalon port;
	
	{
		service = new SminkerskiSalon_Service();
		port = service.getSminkerskiSalonImplPort();
	}
	
	@Path("sve")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<SminkerType> vratiSveSminkere() {
		return port.vratiSveSminkere("");
	}
	
}
