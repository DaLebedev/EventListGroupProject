package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.EventDetails;

public class EventDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EventListGroupProject");
			
			public void insertNewEventDetails(EventDetails s) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				em.persist(s);
				em.getTransaction().commit();
				em.close();
			}
			
			public List<EventDetails> getEvents() {
				EntityManager em = emfactory.createEntityManager();
				List<EventDetails> allDetails = em.createQuery("SELECT d FROM EventDetails d").getResultList();
				return allDetails;
			}
			
			public EventDetails searchForListDetailsById(Integer tempId) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				EventDetails found = em.find(EventDetails.class, tempId);
				return found;
			}
			
			public void deleteEvent(EventDetails toDelete) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				
				TypedQuery<EventDetails> typedQuery = em.createQuery("SELECT detail FROM EventDetails detail WHERE detail.id = :selectedId", EventDetails.class);
				typedQuery.setParameter("selectedId", toDelete.getId());
				typedQuery.setMaxResults(1);
				
				EventDetails result = typedQuery.getSingleResult();
				
				em.remove(result);
				em.getTransaction().commit();
				em.close();
				
			}

			public void updateEvent(EventDetails toEdit) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();
			}
	
}
