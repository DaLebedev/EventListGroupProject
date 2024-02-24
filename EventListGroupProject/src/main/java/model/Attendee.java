package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ATTENDEES")
public class Attendee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ATTENDEE_NAME")
	private String attendeeName;
	
	@Column(name="ATTENDEE_EMAIL")
	private String attendeeEmail;

	public Attendee() {
		super();
	}
	
	public Attendee(String attendeeName, String attendeeEmail) {
		super();
		this.attendeeName = attendeeName;
		this.attendeeEmail =  attendeeEmail;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

	public String getAttendeeEmail() {
		return attendeeEmail;
	}

	public void setAttendeeEmail(String attendeeEmail) {
		this.attendeeEmail = attendeeEmail;
	}

	@Override
	public String toString() {
		return "Attendee [id=" + id + ", attendeeName=" + attendeeName + ", attendeeEmail=" + attendeeEmail + "]";
	}
}