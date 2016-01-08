package com.psamp.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In UserAuth init.");
	}
	
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("In UserAuth destroy.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		PrintWriter out = response.getWriter();
		StringBuffer message = new StringBuffer();

		if ("ash".equals(user.trim()) && "pokemon".equals(pass.trim())) {
			message.append("<html>");
			message.append("<p color='green'>");
			message.append("You have successfully logged in, " + user + ".");
			message.append("</p>");
			message.append("</html>");
		} else {
			message.append("<html>");
			message.append("<p color='red'>");
			message.append("Please try again.");
			message.append("</p>");
			message.append("</html>");

		}

		out.print(message);
		out.close();
	}

}
