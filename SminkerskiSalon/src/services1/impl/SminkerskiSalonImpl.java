package services1.impl;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import beansS.SminkerskiBean;
import model.Musterija;
import model.Sminker;
import model.Termin;
import services1.MusterijaType;
import services1.SminkerType;
import services1.SminkerskiSalon;
import services1.TerminType;


@WebService(serviceName = "SminkerskiSalon", endpointInterface = "services1.SminkerskiSalon", targetNamespace = "http://www.example.org/SminkerskiSalon/")
public class SminkerskiSalonImpl implements SminkerskiSalon {
	
	@Inject 
	SminkerskiBean bean;
	
	public java.util.List<services1.TerminType> vratiSveTermineSminkera(int in) {
		List<Termin> termini = bean.vratiSveTermineSminkera(in);
		List<TerminType> lista = new ArrayList<>();
		
		for (Termin t: termini) {
			TerminType tp = new TerminType();
			tp.setDatum(t.getDatum().toString());
			tp.setId(t.getId());
			tp.setKomentar(t.getKomentar());
			tp.setSminker(konvertujSminkera(t.getSminker()));
			lista.add(konvertujTermin(t));
		}
		
		return lista;
	}

	public services1.MusterijaType login(services1.MusterijaType in) {
		Musterija inMusterija = new Musterija();
		inMusterija.setPassword(in.getPassword());
		inMusterija.setIme(in.getIme());
		Musterija outMusterija = bean.login(inMusterija);
		if (outMusterija != null) {
			return konvertujMusteriju(outMusterija);
		}
		else {
			return new MusterijaType();
		}
	}

	public java.util.List<services1.TerminType> listaKorisnikovihTermina(int in) {
		List<Termin> termini = bean.listaKorisnikovihTermina(in);
		List<TerminType> lista = new ArrayList<>();
		for (Termin t: termini) {
			lista.add(konvertujTermin(t));
		}
		
		return lista;
	}

	public java.util.List<services1.SminkerType> vratiSveSminkere(java.lang.String in) {
		List<Sminker> sminkeri = bean.vratiSveSminkere();
		List<SminkerType> sminkeriT = new ArrayList<>();
		
		for (Sminker s: sminkeri) {
			sminkeriT.add(konvertujSminkera(s));
		}
		
		return sminkeriT;
	}

	public boolean dodajKomentarNaTermin(services1.TerminType in) {
		Termin t = new Termin();
		t.setId(in.getId());
		t.setKomentar(in.getKomentar());
		System.out.println("KOMENTAR IMPL " + in.getKomentar());
		return bean.dodajKomentarNaTermin(t);
	}

	public boolean zakazi(services1.TerminType in) {
		Termin t = new Termin();
		t.setId(in.getId());
		Musterija m = new Musterija();
		m.setId(in.getMusterija().getId());
		t.setMusterija(m);
		return bean.zakazi(t);
	}
	
	public java.util.List<java.lang.String> vratiKomentareZaSminkera(int in) {
		return bean.vratiKomentareZaSminkera(in);
	}
	
	private TerminType konvertujTermin(Termin t) {
		TerminType tp = new TerminType();
		tp.setDatum(t.getDatum().toString());
		tp.setId(t.getId());
		tp.setKomentar(t.getKomentar());
		//tp.setMusterija(konvertujMusteriju(t.getMusterija()));
		tp.setSminker(konvertujSminkera(t.getSminker()));
		return tp;
	}
	
	private MusterijaType konvertujMusteriju(Musterija m) {
		MusterijaType mt = new MusterijaType();
		mt.setBrojTelefona(m.getBrojTelefona());
		mt.setId(m.getId());
		mt.setIme(m.getIme());
		mt.setPassword(m.getPassword());
		mt.setPrezime(m.getPrezime());
		return mt;
	}
	
	private SminkerType konvertujSminkera(Sminker s) {
		SminkerType st = new SminkerType();
		st.setId(s.getId());
		st.setIme(s.getIme());
		st.setPrezime(s.getPrezime());
		st.setStaz(s.getStaz());
		return st;
	}
	
}	