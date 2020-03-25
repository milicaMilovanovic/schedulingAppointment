package beansF;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.MilicaMFrizer;
import model.MilicaMFrizura;
import model.MilicaMMusterija;
import model.MilicaMTermin;

/**
 * Session Bean implementation class FrizerskiBean
 */
@Stateless
@LocalBean
public class FrizerskiBean implements FrizerskiBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    public FrizerskiBean() {
        
    }

	@Override
	public List<MilicaMTermin> slobodniTerminiFrizera(int id) {
		Date datum = new Date();
	    datum.setHours(new Date().getHours() + 2);
		List<MilicaMTermin> terminiRez = new ArrayList<>();
		MilicaMFrizer frizer = em.find(MilicaMFrizer.class, id);
		
		for (MilicaMTermin termin: frizer.getMilicaMtermins()) {
			if (termin.getMilicaMmusterija() == null && termin.getDatum().getTime() >= datum.getTime()) {
				terminiRez.add(termin);
			}
		}
		
		return terminiRez;
		
//		Query q = em.createQuery("SELECT t FROM MilicaMTermin t WHERE "
//		+ "t.milicaMmusterija = null "
//		+ "AND t.datum > :today");
	}

	//termin je vec postojao, treba samo da mu setujem musteriju frizuru i merge
	@Override
	public boolean zakaziTermin(MilicaMTermin ter) {
		MilicaMTermin termin = em.find(MilicaMTermin.class, ter.getId());
		MilicaMMusterija musterija = em.find(MilicaMMusterija.class, ter.getMilicaMmusterija().getId());
		termin.setMilicaMmusterija(musterija);
		Query q = em.createQuery("SELECT f from MilicaMFrizura f WHERE f.sisanje = :sisanje "
				+ "AND f.farbanje = :farbanje "
				+ "AND f.feniranje = :feniranje");
		q.setParameter("feniranje", ter.getMilicaMfrizura().getFeniranje());
		q.setParameter("farbanje", ter.getMilicaMfrizura().getFarbanje());
		q.setParameter("sisanje", ter.getMilicaMfrizura().getSisanje());
		MilicaMFrizura frizura = (MilicaMFrizura) q.getResultList().get(0); 		
		termin.setMilicaMfrizura(frizura);
		em.merge(termin);
		
		musterija.addMilicaMtermin(termin);
		em.merge(musterija);
		
		frizura.addMilicaMtermin(termin);
		em.merge(frizura);
		
		MilicaMFrizer frizer = em.find(MilicaMFrizer.class, termin.getMilicaMfrizer().getId());
		frizer.addMilicaMtermin(termin);
		em.merge(frizer);
		
		return true;
	}

	@Override
	public List<MilicaMTermin> terminiMusterije(int id) {
		MilicaMMusterija musterija = em.find(MilicaMMusterija.class, id);
		return musterija.getMilicaMtermins();
//		Query q = em.createQuery("SELECT t FROM MilicaMTermin WHERE t.milicaMmusterija.id = :id");
//		q.setParameter("id", id);
//		
//		return q.getResultList();
	}

	@Override
	public List<MilicaMFrizer> vratiSveFrizere() {
		List<MilicaMFrizer> frizeri = em.createNamedQuery("MilicaMFrizer.findAll").getResultList();
		return frizeri;
	}
    
    

}
