import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import controller.EventDetailsHelper;
import controller.HostHelper;
import model.Attendee;
import model.EventDetails;
import model.Host;

public class EventDetailsTester {
	
	public static void main(String[] args) {	
		
		Host jake = new Host("Jake");
	 	EventDetailsHelper edh = new EventDetailsHelper();
	    Attendee daniel = new Attendee("Daniel", "dalebedev@dmacc.edu");
	    Attendee joshua = new Attendee("Joshua", "jmtegeler@dmacc.edu");
	    List<Attendee> jakesAttendees = new ArrayList<Attendee>();
	    jakesAttendees.add(daniel);
	    jakesAttendees.add(joshua);
	    
	    EventDetails jakesEvent = new EventDetails("Jake's Birthday Party!", "Jake's House", LocalDate.now(), LocalTime.now(), jake);
	    jakesEvent.setListOfAttendees(jakesAttendees);
	    
	    edh.insertNewEventDetails(jakesEvent);
	    
	    List<EventDetails> allEvents = edh.getEvents();
	    
	    for (EventDetails a : allEvents) {
	        System.out.println(a.toString());
	    }
	}
	
}
