package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Attendee;

public class AttendeeHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EventListGroupProject");

	public void insertAttendee(Attendee a) {
		// Creates EntityManager for database operations
		EntityManager em = emfactory.createEntityManager();
		// Starts database transaction
		em.getTransaction().begin();
		// Inserts list item into database
		em.persist(a);
		// Commits changes to database
		em.getTransaction().commit();
		// Closes EntityManager 
		em.close();
	}
	
	public void deleteAttendee(Attendee toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Queries for objects which match the input store and item
		TypedQuery<Attendee> typedQuery = em.createQuery
				("SELECT a FROM Attendee a where a.attendeeName = :selectedName and a.attendeeEmail = :selectedEmail", Attendee.class);
		// Substitutes parameters with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getAttendeeName());
		typedQuery.setParameter("selectedEmail", toDelete.getAttendeeEmail());
		// Maximum of 1 result allowed
		typedQuery.setMaxResults(1);
		// Saves result in a new list item
		Attendee result = typedQuery.getSingleResult();
		// Deletes the item
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateAttendee(Attendee toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Attendee searchForAttendeeById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Attendee found = em.find(Attendee.class, idToEdit);
		em.close();
		return found;
	}

	public List<Attendee> searchForAttendeeByName(String attendeeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Attendee> typedQuery = em.createQuery
				("SELECT a FROM Attendee a WHERE a.attendeeName = :selectedName", Attendee.class);
		typedQuery.setParameter("selectedName", attendeeName);
		List<Attendee> foundAttendees = typedQuery.getResultList();
		em.close();
		return foundAttendees;
	}

	public List<Attendee> searchForAttendeeByEmail(String attendeeEmail) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Attendee> typedQuery = em.createQuery
				("SELECT a FROM Attendee a WHERE a.attendeeEmail = :selectedEmail", Attendee.class);
		typedQuery.setParameter("selectedEmail", attendeeEmail);
		List<Attendee> foundAttendees = typedQuery.getResultList();
		em.close();
		return foundAttendees;
	}
	
	public List<Attendee> showAllAttendees() {
		
		System.out.println();
		
		// Queries all fields in table object
		EntityManager em = emfactory.createEntityManager();
	    List<Attendee> allAttendees = em.createQuery
	    		("SELECT i FROM Attendee i", Attendee.class).getResultList();
	    return allAttendees;
	}

	
	public void cleanUp(){
		emfactory.close();
	}
	
}

