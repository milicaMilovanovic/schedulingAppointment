package main;

import java.util.List;

import paket.TerminType;
import paketSminkerski.SminkerskiSalon;
import paketSminkerski.SminkerskiSalon_Service;

public class Main {

	public static void main(String [] args) throws Exception {
		
//		for (TerminType tp: termini) {
//			System.out.println(tp.getFrizer().getId() + ", datum: " + tp.getDatum());
//		}
//		
//		System.out.println("MUSTERIJA");
//		List<TerminType> terminiMusterije = port.terminiMusterije(1);
//		for (TerminType tp: terminiMusterije) {
//			System.out.println(tp.getFrizer().getId() + ", datum: " + tp.getDatum());
//		}
		
//		TerminType termin = new TerminType();
//		termin.setId(6);
//		MusterijaType m = new MusterijaType();
//		m.setId(1);
//		FrizuraType frizura = new FrizuraType();
//		frizura.setFarbanje(false);
//		frizura.setFeniranje(true);
//		frizura.setSisanje(true);
//		
//		termin.setMusterija(m);
//		termin.setFrizura(frizura);
//		port.zakaziTermin(termin);

		SminkerskiSalon_Service service1 = new SminkerskiSalon_Service();
		SminkerskiSalon port1 = service1.getSminkerskiSalonImplPort();
//		paketSminkerski.MusterijaType musterija = new paketSminkerski.MusterijaType();
//		musterija.setPassword("ime");
//		musterija.setIme("ime");
//		musterija.setId(1);
//		paketSminkerski.TerminType tp = new paketSminkerski.TerminType();
//		tp.setMusterija(musterija);
//		tp.setId(2);
//		port1.zakazi(tp);
		
		List<paketSminkerski.TerminType> termini = port1.listaKorisnikovihTermina(1);
		for (paketSminkerski.TerminType tp: termini) {
			System.out.println(tp.getId() + ", " + tp.getDatum());
		}
		
//		paketSminkerski.TerminType tp = new paketSminkerski.TerminType();
//		tp.setId(1);
//		tp.setKomentar("Najbolji sminker ikad");
//		port1.dodajKomentarNaTermin(tp);
		
//		for(SminkerType st: port1.vratiSveSminkere("")) {
//			System.out.println(st.getIme());
//		}
		
		
		
	}
	
}
