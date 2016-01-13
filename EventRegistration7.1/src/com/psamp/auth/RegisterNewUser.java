package com.psamp.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntier.provided.User;
import com.ntier.provided.UserDB;
import com.psamp.app.Message;

public class RegisterNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = null;
		UserDB db = UserDB.getInstance();
		Validator v = new Validator();

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean passwordValid = v.checkThatStringIsOfProperLength(request.getParameter("password"),
				Integer.parseInt(this.getInitParameter("minPassLength")))
				&& v.matchTwoStrings(request.getParameter("password"), request.getParameter("passwordConfirm"));

		if (passwordValid & !(db.containsUser(username))) {

			db.addUser(new User(username, password, email));
			User usr = db.getUser(username);

			request.getSession().setAttribute("user", usr);

			dispatch = request.getRequestDispatcher("welcome.jsp");
			dispatch.forward(request, response);

		} else {
			request.setAttribute("message", new Message("Something went wrong, please try again."));
			dispatch = request.getRequestDispatcher("registerNewUser.jsp");
			dispatch.forward(request, response);
		}

	}

}
