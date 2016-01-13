package com.psamp.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntier.provided.Event;
import com.ntier.provided.EventDB;

/**
 * Servlet implementation class EventListServlet
 */
public class EventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = null;
		request.setAttribute("why", "hello");

		if (request.getSession().getAttribute("user") != null) {

			EventDB db = EventDB.getInstance();
			List<Event> events = (List<Event>) db.getAllEvents();
			
			request.setAttribute("events", events);

			dispatch = request.getRequestDispatcher("events.jsp");
			dispatch.forward(request, response);

		} else {

			request.setAttribute("message", new Message("You must log in to view events."));

			dispatch = request.getRequestDispatcher("welcome.jsp");
			dispatch.forward(request, response);
		}
	}
}
