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
 * The persistent class for the MilicaMFrizura database table.
 * 
 */
@Entity
@NamedQuery(name="MilicaMFrizura.findAll", query="SELECT m FROM MilicaMFrizura m")
public class MilicaMFrizura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte farbanje;

	private byte feniranje;

	private byte sisanje;

	//bi-directional many-to-one association to MilicaMTermin
	@OneToMany(fetch = FetchType.EAGER, mappedBy="milicaMfrizura")
	private List<MilicaMTermin> milicaMtermins = new ArrayList<>();

	public MilicaMFrizura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getFarbanje() {
		return this.farbanje;
	}

	public void setFarbanje(byte farbanje) {
		this.farbanje = farbanje;
	}

	public byte getFeniranje() {
		return this.feniranje;
	}

	public void setFeniranje(byte feniranje) {
		this.feniranje = feniranje;
	}

	public byte getSisanje() {
		return this.sisanje;
	}

	public void setSisanje(byte sisanje) {
		this.sisanje = sisanje;
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
		milicaMtermin.setMilicaMfrizura(null);

		return milicaMtermin;
	}

}