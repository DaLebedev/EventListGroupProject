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
 * Servlet implementation class CreateNewEventServlet
 */
@WebServlet("/CreateNewEventServlet")
public class CreateNewEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AttendeeHelper ah = new AttendeeHelper();
		String eventName = request.getParameter("eventName");
		String location = request.getParameter("location");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minute");
		String hostName = request.getParameter("hostName");
		LocalDate ld;
		LocalTime lt;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			lt = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
			lt = LocalTime.now();
		}
		
		String[] selectedAttendees = request.getParameterValues("allAttendeesToAdd");
		List<Attendee> selectedAttendeesInList = new ArrayList<Attendee>();
		
		if(selectedAttendees != null && selectedAttendees.length > 0) {
			for (int i =0; i<selectedAttendees.length; i++) {
				System.out.println(selectedAttendees[i]);
				Attendee c = ah.searchForAttendeeById(Integer.parseInt(selectedAttendees[i]));
				selectedAttendeesInList.add(c);
			}
		}
		
		Host host = new Host(hostName);
		EventDetails hed = new EventDetails(eventName, location, ld, lt, host);
		hed.setListOfAttendees(selectedAttendeesInList);
		EventDetailsHelper edh = new EventDetailsHelper();
		edh.insertNewEventDetails(hed);
		
		System.out.println("Success!");
		System.out.println(edh.toString());
		
		getServletContext().getRequestDispatcher("/ViewAllEventsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}