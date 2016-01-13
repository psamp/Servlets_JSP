package com.psamp.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntier.provided.Event;
import com.ntier.provided.EventDB;
import com.ntier.provided.EventException;
import com.ntier.provided.User;

/**
 * Servlet implementation class EventRegistration
 */
public class EventRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long eventID = Long.parseLong(request.getParameter("eventID"));
		EventDB db = EventDB.getInstance();

		try {

			Event requested = db.getEvent(eventID);
			requested.register((User) request.getSession().getAttribute("user"));
			request.setAttribute("message", new Message("Registered for " + requested.getName() + "."));

		} catch (EventException e) {
			request.setAttribute("message", new Message(e.getMessage() + "."));
		}

		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

}
