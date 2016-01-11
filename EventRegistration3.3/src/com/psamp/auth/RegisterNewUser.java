package com.psamp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntier.provided.User;
import com.ntier.provided.UserDB;

public class RegisterNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resMessage = "<p>Registration failed.</p>";
		String resLink = "<p><a href='../app/registerNewUser.html'>Try Again</a></p>";

		response.setContentType("text/html");

		String email;
		String username;
		String password;
		boolean passwordValid;

		UserDB db = UserDB.getInstance();
		PrintWriter out = response.getWriter();

		synchronized (this) {
			Validator v = new Validator();

			username = request.getParameter("username");
			email = request.getParameter("email");
			password = request.getParameter("password");
			passwordValid = v.checkThatStringIsOfProperLength(request.getParameter("password"),
					Integer.parseInt(this.getInitParameter("minPassLength")))
					&& v.matchTwoStrings(request.getParameter("password"), request.getParameter("passwordConfirm"));
		}

		if (passwordValid & !(db.containsUser(username))) {
			db.addUser(new User(username, password, email));

			resMessage = "<p>You have successfully registered.</p>";
			resLink = "<p><a href='../app/auth.html'>Welcome Page</a></p>";
		}

		out.print("<html>" + resMessage);
		out.print(resLink + "</html>");
		out.close();

	}

}
