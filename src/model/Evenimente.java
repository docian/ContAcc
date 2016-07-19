package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evenimente database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Evenimente.findAll", query="SELECT e FROM Evenimente e"),
	@NamedQuery(name="Evenimente.findByCardId", query="SELECT e FROM Evenimente e WHERE e.cardId=:cardId"),
	@NamedQuery(name="Evenimente.findAccessPoint", query="SELECT e FROM Evenimente e WHERE e.punctAcces=:punctAcces")
	})
public class Evenimente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cardId;

	private String punctAcces;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	public Evenimente() {
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

	public String getPunctAcces() {
		return this.punctAcces;
	}

	public void setPunctAcces(String punctAcces) {
		this.punctAcces = punctAcces;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}