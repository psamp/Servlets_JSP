package com.psamp.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		RequestDispatcher dispatch = null;

		if (session.getAttribute("user") == null) {

			request.setAttribute("message", "You're not logged in. You can't log out.");
			dispatch = request.getRequestDispatcher("welcome.jsp");
			dispatch.forward(request, response);

		} else {

			session.invalidate();
			request.setAttribute("message", "You are now logged out.");
			dispatch = request.getRequestDispatcher("welcome.jsp");
			dispatch.forward(request, response);
		}

	}

}
