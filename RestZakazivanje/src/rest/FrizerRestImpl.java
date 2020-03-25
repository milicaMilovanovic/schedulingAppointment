package rest;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import paket.FrizerType;
import paket.Frizerski;
import paket.Frizerski_Service;
import paket.TerminType;

@Path("frizer")
public class FrizerRestImpl {

	private Frizerski_Service service;
	private Frizerski port;
	
	{
		service = new Frizerski_Service();
		port = service.getFrizerskiImplPort();
	}
	
	@Path("terminiFrizera")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<TerminType> slobodniTerminiFrizera(@FormParam("id") int id) {
		return port.slobodniTerminiFrizera(id);
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FrizerType> getFrizeri() {
		return port.vratiSveFrizere("");
	}
	
}
