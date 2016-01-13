package com.psamp.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher dispatch = request.getRequestDispatcher("welcome.jsp");
		dispatch.forward(request, response);
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

		UserDB db = UserDB.getInstance();

		HttpSession session = request.getSession();
		RequestDispatcher dispatch = null;

		if (request.getSession().getAttribute("user") != null) {

			request.setAttribute("message", "You're already logged in.");
			dispatch = request.getRequestDispatcher("welcome.jsp");
			dispatch.forward(request, response);

		}

		synchronized (this) {

			if (db.containsUser(username) && password.equals(db.getUser(username).getPassword())) {

				User usr = db.getUser(username);
				session.setAttribute("user", usr);
				dispatch = request.getRequestDispatcher("welcome.jsp");
				dispatch.forward(request, response);

			} else {
				request.setAttribute("message", "Please try again.");
				dispatch = request.getRequestDispatcher("login.jsp");
				dispatch.forward(request, response);

			}

		}
	}

}
