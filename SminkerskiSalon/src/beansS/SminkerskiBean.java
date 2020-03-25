package beansS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Musterija;
import model.Sminker;
import model.Termin;

/**
 * Session Bean implementation class SminkerskiBean
 */
@Stateless
@LocalBean
public class SminkerskiBean implements SminkerskiBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SminkerskiBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Termin> vratiSveTermineSminkera(int id) {
		Date datum = new Date();
	    datum.setHours(new Date().getHours() + 2);
	    List<Termin> terminiRez = new ArrayList<>();
		Sminker sminker = em.find(Sminker.class, id);
		
		for (Termin termin: sminker.getTermins()) {
			if (termin.getMusterija() == null && termin.getDatum().getTime() >= datum.getTime()) {
				terminiRez.add(termin);
			}
		}
		
		return terminiRez;
	}

	@Override
	public Musterija login(Musterija m) {
		System.out.println("Login1 " + m.getIme() + ", " + m.getPassword());
		Query q = em.createQuery("SELECT m from Musterija m where m.password = :pass "
				+ "AND m.ime = :ime");
		q.setParameter("pass", m.getPassword());
		q.setParameter("ime", m.getIme());
		List<Musterija> lista = q.getResultList();
		if (!lista.isEmpty()) {
			return lista.get(0);
		}
		
		return null;
	}

	@Override
	public List<Termin> listaKorisnikovihTermina(int id) {
		Musterija m = em.find(Musterija.class, id);
		return m.getTermins();
	}

	@Override
	public List<Sminker> vratiSveSminkere() {
		Query q = em.createNamedQuery("Sminker.findAll");
		return q.getResultList();
	}

	@Override
	public boolean dodajKomentarNaTermin(Termin t) {
		String komentar = t.getKomentar();
		Termin termin = em.find(Termin.class, t.getId());
//		if (termin.getKomentar() != null) {
//			if (termin.getKomentar().isEmpty()) {
//				if (komentar == null || komentar.isEmpty())
//					return true;
//			}
//			return false;
//		}
		Date datum = new Date();
		datum.setHours(new Date().getHours() + 1);
		if (termin.getDatum().getTime() > datum.getTime()) {
			return false;
		}
		
		if (komentar == null || komentar.isEmpty()) {
			System.out.println("komentar u bean " + komentar);
			return true;
		}
		
		System.out.println("komentar u bean proslo" + komentar);
		
		termin.setKomentar(komentar);
		em.merge(termin);
		return true;
	}

	@Override
	public boolean zakazi(Termin t) {
		Termin termin = em.find(Termin.class, t.getId());
		Musterija musterija = em.find(Musterija.class, t.getMusterija().getId());
		termin.setMusterija(musterija);
		em.merge(termin);
		
		musterija.addTermin(termin);
		em.merge(musterija);
		return true;
	}
	
	public List<String> vratiKomentareZaSminkera(int in) {
		Sminker s = em.find(Sminker.class, in);
		List<String> komentari = new ArrayList<>();
		for (Termin t: s.getTermins()) {
			if (t.getKomentar() != null && !t.getKomentar().isEmpty()) {
				komentari.add(t.getKomentar());
			}
		}
		
		return komentari;		
	}

}
