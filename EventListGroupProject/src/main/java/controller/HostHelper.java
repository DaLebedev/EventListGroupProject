package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Host;

public class HostHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EventListGroupProject");

	public void insertHost(Host h) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Host> showAllHosts() {
		EntityManager em = emfactory.createEntityManager();
		List<Host> allHosts = em.createQuery("SELECT h FROM Host h").getResultList();
		return allHosts;
	}
	
	public Host findHost(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Host> typedQuery = em.createQuery("SELECT h FROM Host h where h.hostName = :selectedName", Host.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Host foundHost;
		
		try {
			foundHost = typedQuery.getSingleResult();
		} 
		catch (NoResultException ex) {
			foundHost = new Host(nameToLookUp);
		}
		em.close();
		return foundHost;
	
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
