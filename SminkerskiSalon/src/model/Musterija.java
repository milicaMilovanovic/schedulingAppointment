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
 * The persistent class for the musterija database table.
 * 
 */
@Entity
@NamedQuery(name="Musterija.findAll", query="SELECT m FROM Musterija m")
public class Musterija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String brojTelefona;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Termin
	@OneToMany(fetch = FetchType.EAGER, mappedBy="musterija")
	private List<Termin> termins = new ArrayList<>();

	public Musterija() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrojTelefona() {
		return this.brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Termin> getTermins() {
		return this.termins;
	}

	public void setTermins(List<Termin> termins) {
		this.termins = termins;
	}

	public Termin addTermin(Termin termin) {
		getTermins().add(termin);

		return termin;
	}

	public Termin removeTermin(Termin termin) {
		getTermins().remove(termin);
		termin.setMusterija(null);

		return termin;
	}

}