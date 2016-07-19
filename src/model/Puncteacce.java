package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puncteacces database table.
 * 
 */
@Entity
@Table(name="puncteacces")
@NamedQuery(name="Puncteacce.findAll", query="SELECT p FROM Puncteacce p")
public class Puncteacce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String denumire;

	public Puncteacce() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

}