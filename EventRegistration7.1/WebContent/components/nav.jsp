<%@page import="com.ntier.provided.User"%>
<nav>
	<ul>

		<%
			if (session.getAttribute("user") != null) {
		%>

		<li><a href="../eventy/logout">Logout, <%=((User) session.getAttribute("user")).getUsername()%></a></li>
		<li><a href="../eventy/events">Register for event</a></li>

		<%
			} else {
		%>
		<li><a href="login.jsp">Login</a></li>
		<li><a href="registerNewUser.jsp">Register</a></li>
		<%
			}
		%>
		<li><a href="http://google.com">Contact</a></li>
	</ul>
</nav>