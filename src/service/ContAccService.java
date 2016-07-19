package service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AngajatiDAO;
import dao.EvenimenteDAO;
import model.Angajati;
import model.Evenimente;

public class ContAccService {
	
	private EntityManagerFactory emf;
	
	private ContAccService(){
		emf = Persistence.createEntityManagerFactory("ContAcc");		
	}
		
	private static final class SingletonHolder{
		private static ContAccService SINGLETON = new ContAccService();
		
	}
	
	public static ContAccService getInstance(){
		return SingletonHolder.SINGLETON;
	}

	public void adaugaAngajat(String nume, String prenume, String cardId, String depId){
		EntityManager em = null;
		AngajatiDAO aDao = null;
		
		try{
			em = emf.createEntityManager();
			aDao = new AngajatiDAO(em);
			em.getTransaction().begin();
			Angajati a = new Angajati();
			a.setCardId(cardId);
			a.setDepId(depId);
			a.setNume(nume);
			a.setPrenume(prenume);
			aDao.adaugaAngajat(a);
			em.getTransaction().commit();			
		}finally{
			if(em != null)
				em.close();
		}		
	}
	
	public void adaugaEveniment(String cardId, String punctAcces, Date time){
		EntityManager em;
		EvenimenteDAO evDao;
		try{
			Evenimente ev = new Evenimente();
			em = emf.createEntityManager();
			evDao = new EvenimenteDAO(em);			
			em.getTransaction().begin();
			ev.setCardId(cardId);
			ev.setPunctAcces(punctAcces);
			ev.setTime(time);
			evDao.adaugaEveniment(ev);
			em.getTransaction().commit();
		}finally{
			
		}
	}
	
	public List<Angajati> regasesteAngajatiNume(String nume){
		EntityManager em = null;
		AngajatiDAO aDao= null;
		List<Angajati> la = null;
		try{
			em = emf.createEntityManager();
			aDao = new AngajatiDAO(em);
			la = aDao.regasesteAngajatDupaNume(nume);
		}finally{
			if(em != null)
				em.close();
		}
		return la;		
	}
	
	public List<Angajati> regasesteAngajatNumeComplet(String nume, String prenume){
		EntityManager em = null;
		AngajatiDAO aDao= null;
		List<Angajati> la = null;
		try{
			em = emf.createEntityManager();
			aDao = new AngajatiDAO(em);
			la = aDao.regasesteAngajatDupaNumeComplet(nume, prenume);
		}finally{
			if(em != null)
				em.close();
		}
		return la;
	}
}
