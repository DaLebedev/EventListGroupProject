package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attendee;

/**
 * Servlet implementation class AddAttendeeServlet
 */
@WebServlet("/AddAttendeeServlet")
public class AddAttendeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("attendeeName");
		String email = request.getParameter("attendeeEmail");
		
		Attendee a = new Attendee(name, email);
		AttendeeHelper dao = new AttendeeHelper();
		dao.insertAttendee(a);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
