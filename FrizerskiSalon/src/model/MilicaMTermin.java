package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the MilicaMTermin database table.
 * 
 */
@Entity
@NamedQuery(name="MilicaMTermin.findAll", query="SELECT m FROM MilicaMTermin m")
public class MilicaMTermin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	//bi-directional many-to-one association to MilicaMFrizer
	@ManyToOne
	@JoinColumn(name="frizer_id")
	private MilicaMFrizer milicaMfrizer;

	//bi-directional many-to-one association to MilicaMMusterija
	@ManyToOne
	@JoinColumn(name="musterija_id")
	private MilicaMMusterija milicaMmusterija;

	//bi-directional many-to-one association to MilicaMFrizura
	@ManyToOne
	@JoinColumn(name="frizura_id")
	private MilicaMFrizura milicaMfrizura;

	public MilicaMTermin() {
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

	public MilicaMFrizer getMilicaMfrizer() {
		return this.milicaMfrizer;
	}

	public void setMilicaMfrizer(MilicaMFrizer milicaMfrizer) {
		this.milicaMfrizer = milicaMfrizer;
	}

	public MilicaMMusterija getMilicaMmusterija() {
		return this.milicaMmusterija;
	}

	public void setMilicaMmusterija(MilicaMMusterija milicaMmusterija) {
		this.milicaMmusterija = milicaMmusterija;
	}

	public MilicaMFrizura getMilicaMfrizura() {
		return this.milicaMfrizura;
	}

	public void setMilicaMfrizura(MilicaMFrizura milicaMfrizura) {
		this.milicaMfrizura = milicaMfrizura;
	}

}