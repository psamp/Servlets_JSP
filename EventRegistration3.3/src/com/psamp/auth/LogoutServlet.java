package com.psamp.auth;

import java.io.IOException;
import java.io.PrintWriter;

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

		PrintWriter out = response.getWriter();

		if (session.getAttribute("user") == null) {
			out.println("<html>");
			out.println("<p>");
			out.println("You are not logged in.");
			out.println("</p>");
			out.println("</html>");
		} else {
			session.invalidate();

			out.println("<html>");
			out.println("<p>");
			out.println("You are logged out.");
			out.println("</p>");
			out.println("</html>");
		}

	}

}
