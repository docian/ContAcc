package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Angajati;

public class AngajatiDAO {
	private EntityManager em;
	
	public AngajatiDAO(EntityManager em){
		this.em = em;
	}
	
	public void adaugaAngajat(Angajati a){
		em.persist(a);
	}
	
	public List<Angajati> listeazaTotiAngajatii(){
		Query q = em.createNamedQuery("Angajati.findAll");
		List<Angajati> lstA = q.getResultList();
		return lstA;
	}
	
	public List<Angajati> regasesteAngajatDupaNume(String nume){
		Query q = em.createNamedQuery("Angajati.findByName");
		q.setParameter("nume", nume);
		return (List<Angajati>)q.getResultList();
	}
	
	public List<Angajati> regasesteAngajatDupaNumeComplet(String nume, String prenume){
		Query q = em.createNamedQuery("Angajati.findByName");
		q.setParameter("nume", nume);
		q.setParameter("prenume", prenume);
		return (List<Angajati>)q.getResultList();
	}

	public List<Angajati> regasesteAngajatDupaCardId(String cardId){
		Query q = em.createNamedQuery("Angajati.findByCardId");
		q.setParameter("cardId", cardId);
		return (List<Angajati>)q.getResultList();
	}
	

	
}
