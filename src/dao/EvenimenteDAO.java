package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Evenimente;

public class EvenimenteDAO {
	private EntityManager em;
	
	public EvenimenteDAO(EntityManager em){
		this.em = em;
	}
	
	public void adaugaEveniment(Evenimente e){
		em.persist(e);
	}
	
	public List<Evenimente> cautaEvenimenteDupaCardId(String cardId){		
		Query q = em.createNamedQuery("Evenimente.findByCardId");
		q.setParameter("cardId", cardId);
		return q.getResultList();	
	}
		
}
