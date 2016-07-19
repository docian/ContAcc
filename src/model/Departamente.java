package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamente database table.
 * 
 */
@Entity
@NamedQuery(name="Departamente.findAll", query="SELECT d FROM Departamente d")
public class Departamente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cod;

	public Departamente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

}