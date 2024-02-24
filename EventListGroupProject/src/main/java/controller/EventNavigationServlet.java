package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EventDetails;

/**
 * Servlet implementation class EventNavigationServlet
 */
@WebServlet("/EventNavigationServlet")
public class EventNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDetailsHelper dao = new EventDetailsHelper();
		String act = request.getParameter("doThisToEvent");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/ViewAllEventsServlet").forward(request, response);
		} 
		
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				EventDetails eventToDelete = dao.searchForListDetailsById(tempId);
				dao.deleteEvent(eventToDelete);
			} 
			
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an option");
			} 
			
			finally {
				getServletContext().getRequestDispatcher("/ViewAllEventsServlet").forward(request, response);
			}
		}
		
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				EventDetails eventToEdit = dao.searchForListDetailsById(tempId);
				request.setAttribute("eventToEdit", eventToEdit);
				
				request.setAttribute("month", eventToEdit.getEventDate().getMonthValue());
				request.setAttribute("day", eventToEdit.getEventDate().getDayOfMonth());
				request.setAttribute("year", eventToEdit.getEventDate().getYear());
				request.setAttribute("hour", eventToEdit.getEventTime().getHour());
				request.setAttribute("minute", eventToEdit.getEventTime().getMinute());
				
				AttendeeHelper daoForAttendees = new AttendeeHelper();
				
				request.setAttribute("allAttendees", daoForAttendees.showAllAttendees());
			
				if (daoForAttendees.showAllAttendees().isEmpty()) {
					request.setAttribute("allAtendees", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-event.jsp").forward(request, response);

			} 
			
			catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllEventsServlet").forward(request, response);
			}
		} 
		
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/AddAttendeesToEventServlet").forward(request, response);
		}
	}

}