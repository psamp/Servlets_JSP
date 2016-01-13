<!DOCTYPE html>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="java.util.*, com.ntier.provided.*, com.psamp.app.*"
	errorPage="error.jsp"%>
<html>

<head>
<meta charset="UTF-8">
<title>Eventy | Register For Event</title>
<link rel="stylesheet" type="text/css"
	href="vendor/css/Normalize.3.0.2.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>

	<div id="headerArea">
		<nav id="navNotLoggedIn"><jsp:include page="components/nav.jsp" /></nav>
		<header id="header"><jsp:include page="components/header.jsp" /></header>
	</div>
	<div class="main">
		<h2>Events</h2>
		<%
			List<Event> eventList = (ArrayList<Event>) request.getAttribute("events");

			for (Event evt : eventList) {
		%>

		<ul>
			<li>Name: <%=evt.getName()%></li>
			<li>Location: <%=evt.getLocation()%></li>
			<li>Date: <%=evt.getDateTime()%></li>
		</ul>

		<form method="post" action="../eventy/attend">
			<input type="hidden" name="eventID" value="<%=evt.getId()%>"></input>
			<button>Register</button>
		</form>
		<hr>

		<%
			}
		%>

	</div>
	<footer id="footer"></footer>
</body>
</html>