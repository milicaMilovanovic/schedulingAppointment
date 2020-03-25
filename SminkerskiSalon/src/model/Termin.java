package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the termin database table.
 * 
 */
@Entity
@NamedQuery(name="Termin.findAll", query="SELECT t FROM Termin t")
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	private String komentar;

	//bi-directional many-to-one association to Musterija
	@ManyToOne
	private Musterija musterija;

	//bi-directional many-to-one association to Sminker
	@ManyToOne
	private Sminker sminker;

	public Termin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Musterija getMusterija() {
		return this.musterija;
	}

	public void setMusterija(Musterija musterija) {
		this.musterija = musterija;
	}

	public Sminker getSminker() {
		return this.sminker;
	}

	public void setSminker(Sminker sminker) {
		this.sminker = sminker;
	}

}