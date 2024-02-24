package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attendee;

/**
 * Servlet implementation class EditAttendeeServlet
 */
@WebServlet("/EditAttendeeServlet")
public class EditAttendeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAttendeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttendeeHelper dao = new AttendeeHelper();
		String name = request.getParameter("attendeeName");
		String email = request.getParameter("attendeeEmail");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Attendee attendeeToEdit = dao.searchForAttendeeById(tempId);
		attendeeToEdit.setAttendeeName(name);
		attendeeToEdit.setAttendeeEmail(email);
		
		dao.updateAttendee(attendeeToEdit);
		
		getServletContext().getRequestDispatcher("/ViewAllAttendeesServlet").forward(request, response);
	}

}
