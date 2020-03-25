package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the MilicaMMusterija database table.
 * 
 */
@Entity
@NamedQuery(name="MilicaMMusterija.findAll", query="SELECT m FROM MilicaMMusterija m")
public class MilicaMMusterija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to MilicaMTermin
	@OneToMany(fetch = FetchType.EAGER, mappedBy="milicaMmusterija")
	private List<MilicaMTermin> milicaMtermins = new ArrayList<>();

	public MilicaMMusterija() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<MilicaMTermin> getMilicaMtermins() {
		return this.milicaMtermins;
	}

	public void setMilicaMtermins(List<MilicaMTermin> milicaMtermins) {
		this.milicaMtermins = milicaMtermins;
	}

	public MilicaMTermin addMilicaMtermin(MilicaMTermin milicaMtermin) {	
		getMilicaMtermins().add(milicaMtermin);

		return milicaMtermin;
	}

	public MilicaMTermin removeMilicaMtermin(MilicaMTermin milicaMtermin) {
		getMilicaMtermins().remove(milicaMtermin);
		milicaMtermin.setMilicaMmusterija(null);

		return milicaMtermin;
	}

}