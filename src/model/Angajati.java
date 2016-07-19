package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the angajati database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Angajati.findAll", query="SELECT a FROM Angajati a"),
	@NamedQuery(name="Angajati.findByName", query="SELECT a FROM Angajati a WHERE a.nume=:nume"),
	@NamedQuery(name="Angajati.findByCardId", query="SELECT a FROM Angajati a WHERE a.cardId=:cardId"),
	@NamedQuery(name="Angajati.findByFullName", query="SELECT a FROM Angajati a WHERE a.nume=:nume AND a.prenume=:prenume")
})
public class Angajati implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cardId;

	private String depId;

	private String nume;

	private String prenume;

	public Angajati() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getDepId() {
		return this.depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

}