package service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import beansF.FrizerskiBean;
import model.MilicaMFrizer;
import model.MilicaMFrizura;
import model.MilicaMMusterija;
import model.MilicaMTermin;
import service.FrizerType;
import service.Frizerski;
import service.FrizuraType;
import service.TerminType;

@WebService(serviceName = "Frizerski", endpointInterface = "service.Frizerski", targetNamespace = "http://www.example.org/Frizerski/")
public class FrizerskiImpl implements Frizerski {
	
	@Inject
	FrizerskiBean bean;
	
	public java.util.List<service.TerminType> slobodniTerminiFrizera(int in) {
		List<MilicaMTermin> terminiM = bean.slobodniTerminiFrizera(in);
		List<TerminType> terminiS = new ArrayList<>();
		for (MilicaMTermin ter: terminiM) {
			TerminType t = konvertuj(ter);
			terminiS.add(t);
		}
		
		return terminiS;

	}

	public boolean zakaziTermin(service.TerminType in) {
		
		MilicaMMusterija musterijaM = new MilicaMMusterija();
		musterijaM.setId(in.getMusterija().getId());
		
		MilicaMFrizura frizuraM = new MilicaMFrizura();
		if (in.getFrizura().isFarbanje()) {
			frizuraM.setFarbanje((byte) 1);
		}
		else {
			frizuraM.setFarbanje((byte) 0);
		}
		if (in.getFrizura().isSisanje()) {
			frizuraM.setSisanje((byte) 1);
		}
		else {
			frizuraM.setSisanje((byte) 0);
		}
		if (in.getFrizura().isFeniranje()) {
			frizuraM.setFeniranje((byte) 1);
		}
		else {
			frizuraM.setFeniranje((byte) 0);
		}
		
		MilicaMTermin terminM = new MilicaMTermin();
		terminM.setId(in.getId());
		terminM.setMilicaMfrizura(frizuraM);
		terminM.setMilicaMmusterija(musterijaM);
		
		return bean.zakaziTermin(terminM);
	}

	public java.util.List<service.TerminType> terminiMusterije(int in) {
		List<MilicaMTermin> terminiM = bean.terminiMusterije(in);
		List<TerminType> terminiS = new ArrayList<>();
		for (MilicaMTermin ter: terminiM) {
			TerminType t = konvertuj(ter);
			terminiS.add(t);
		}
		
		return terminiS;
	}

	public java.util.List<service.FrizerType> vratiSveFrizere(java.lang.String in) {
		List<MilicaMFrizer>frizeriM = bean.vratiSveFrizere();
		List<FrizerType> frizeriS = new ArrayList<>();
		for (MilicaMFrizer f: frizeriM) {
			FrizerType ft = new FrizerType();
			ft.setId(f.getId());
			ft.setIme(f.getIme());
			ft.setPrezime(f.getPrezime());
			ft.setStaz(f.getStaz());
			frizeriS.add(ft);
		}
		
		return frizeriS;
	}
	
	private TerminType konvertuj(MilicaMTermin termin) {
		FrizerType frizer = new FrizerType();
		frizer.setId(termin.getMilicaMfrizer().getId());
		frizer.setIme(termin.getMilicaMfrizer().getIme());
		frizer.setPrezime(termin.getMilicaMfrizer().getPrezime());
		frizer.setStaz(termin.getMilicaMfrizer().getStaz());
		
		TerminType t = new TerminType();
		t.setId(termin.getId());
		t.setFrizer(frizer);
		t.setDatum(termin.getDatum().toString());
		
		if (termin.getMilicaMfrizura() != null) {
			FrizuraType frizura = new FrizuraType();
			frizura.setId(termin.getMilicaMfrizura().getId());
			if (termin.getMilicaMfrizura().getFarbanje() == 0) {
				frizura.setFarbanje(false);
			}
			else {
				frizura.setFarbanje(true);
			}
			if (termin.getMilicaMfrizura().getFeniranje() == 0) {
				frizura.setFeniranje(false);
			}
			else {
				frizura.setFeniranje(true);
			}
			if (termin.getMilicaMfrizura().getSisanje() == 0) {
				frizura.setSisanje(false);
			}
			else {
				frizura.setSisanje(true);
			}
			t.setFrizura(frizura);
		}
		
		
		return t;
		
	}
	
}