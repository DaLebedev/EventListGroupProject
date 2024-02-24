package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attendee;
import model.EventDetails;
import model.Host;

/**
 * Servlet implementation class EditEventDetailsServlet
 */
@WebServlet("/EditEventDetailsServlet")
public class EditEventDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEventDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EventDetailsHelper dao = new EventDetailsHelper();
		AttendeeHelper ah = new AttendeeHelper();
		HostHelper hh = new HostHelper();
	
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		EventDetails eventToUpdate = dao.searchForListDetailsById(tempId);
	
		String newEventName = request.getParameter("eventName");
		
		String location = request.getParameter("location");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minute");
		
		String hostName = request.getParameter("hostName");
		Host host = hh.findHost(hostName);
		
		LocalDate ld;
		LocalTime lt;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			lt = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute));
		} 
		
		catch (NumberFormatException ex) {
			ld = LocalDate.now();
			lt = LocalTime.now();
		}
		
		try {
			String[] selectedAttendees = request.getParameterValues("allAttendeesToAdd");
			List<Attendee> selectedAttendeesInList = new ArrayList<Attendee>();
		
			for (int i = 0; i < selectedAttendees.length; i++) {
				System.out.println(selectedAttendees[i]);
				Attendee c = ah.searchForAttendeeById(Integer.parseInt(selectedAttendees[i]));
				selectedAttendeesInList.add(c);
			
			}
			
			eventToUpdate.setListOfAttendees(selectedAttendeesInList);
		} 
		
		catch (NullPointerException ex) {
			List<Attendee> selectedAttendeesInList = new ArrayList<Attendee>();
			eventToUpdate.setListOfAttendees(selectedAttendeesInList);
		}
		
		eventToUpdate.setEventName(newEventName);
		eventToUpdate.setLocation(location);
		eventToUpdate.setEventDate(ld);
		eventToUpdate.setEventTime(lt);
		eventToUpdate.setHost(host);
		
		dao.updateEvent(eventToUpdate);
		
		getServletContext().getRequestDispatcher("/ViewAllEventsServlet").forward(request, response);
	}

}