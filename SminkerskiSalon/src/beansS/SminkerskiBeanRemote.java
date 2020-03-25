package beansS;

import java.util.List;

import javax.ejb.Remote;

import model.Musterija;
import model.Sminker;
import model.Termin;

@Remote
public interface SminkerskiBeanRemote {
	
	public List<Termin> vratiSveTermineSminkera(int id);

	public Musterija login(Musterija m);
	
	public List<Termin> listaKorisnikovihTermina(int id);

	public List<Sminker> vratiSveSminkere();
	
	public boolean dodajKomentarNaTermin(Termin t);
	
	public boolean zakazi(Termin t);
	
	public List<String> vratiKomentareZaSminkera(int in);
	
}
