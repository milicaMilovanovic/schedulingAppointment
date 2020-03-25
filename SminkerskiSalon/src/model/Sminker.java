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
 * The persistent class for the sminker database table.
 * 
 */
@Entity
@NamedQuery(name="Sminker.findAll", query="SELECT s FROM Sminker s")
public class Sminker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ime;

	private String prezime;

	private int staz;

	//bi-directional many-to-one association to Termin
	@OneToMany(fetch = FetchType.EAGER, mappedBy="sminker")
	private List<Termin> termins = new ArrayList<>();

	public Sminker() {
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

	public int getStaz() {
		return this.staz;
	}

	public void setStaz(int staz) {
		this.staz = staz;
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
		termin.setSminker(null);

		return termin;
	}

}