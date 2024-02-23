package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table()
public class EventDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="EVENT_NAME")
	String eventName;

	@Column(name="LOCATION")
	String location;
	
	@Column(name="EVENT_DATE")
	LocalDate eventDate;
	
	@Column(name="EVENT_TIME")
	LocalTime eventTime;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	Host host;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	List<Attendee> listOfAttendees;

	
	public EventDetails() {
		super();
	}
	
	public EventDetails(int id, String eventName, String location, LocalDate eventDate, LocalTime eventTime, Host host, List<Attendee> listOfAttendees) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.location = location;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.host = host;
		this.listOfAttendees = listOfAttendees;
	}
	
	public EventDetails(String eventName, String location, LocalDate eventDate, LocalTime eventTime, Host host, List<Attendee> listOfAttendees) {
		super();
		this.eventName = eventName;
		this.location = location;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.host = host;
		this.listOfAttendees = listOfAttendees;
	}
	
	public EventDetails(String eventName, String location, LocalDate eventDate, LocalTime eventTime, Host host) {
		super();
		this.eventName = eventName;
		this.location = location;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.host = host;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	
	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public List<Attendee> getListOfAttendees() {
		return listOfAttendees;
	}

	public void setListOfAttendees(List<Attendee> listOfAttendees) {
		this.listOfAttendees = listOfAttendees;
	}

	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", eventName=" + eventName + ", location=" + location + ", eventDate="
				+ eventDate + ", eventTime=" + eventTime + ", host=" + host + ", listOfAttendees=" + listOfAttendees
				+ "]";
	}

}
