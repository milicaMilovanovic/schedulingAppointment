package beansF;

import java.util.List;

import javax.ejb.Remote;

import model.MilicaMFrizer;
import model.MilicaMTermin;

@Remote
public interface FrizerskiBeanRemote {

	public List<MilicaMTermin> slobodniTerminiFrizera(int id);
	
	public boolean zakaziTermin(MilicaMTermin termin);
	
	public List<MilicaMTermin> terminiMusterije(int id);
	
	public List<MilicaMFrizer> vratiSveFrizere();
	
}
