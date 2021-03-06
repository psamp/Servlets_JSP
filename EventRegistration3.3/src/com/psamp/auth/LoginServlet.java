package com.psamp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ntier.provided.User;
import com.ntier.provided.UserDB;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		UserDB db = UserDB.getInstance();

		StringBuffer message = new StringBuffer();
		HttpSession session = request.getSession();

		message.append("<html>");
		message.append("<p>");

		synchronized (db) {

			if (request.getSession().getAttribute("user") != null) {

				message.append("You are already logged in.");

			} else if (db.containsUser(username) && password.equals(db.getUser(username).getPassword())) {

				User usr = db.getUser(username);
				session.setAttribute("user", usr);
				message.append("You have successfully logged in, " + username + ".");

			} else {
				message.append("Please try again.");
			}

		}

		message.append("</p>");
		message.append("</html>");

		out.println(message);
		out.close();
	}

}
