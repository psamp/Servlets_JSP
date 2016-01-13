<!DOCTYPE html>
<%@page import="com.ntier.provided.User" errorPage="error.jsp"%>
<html>

<head>
<meta charset="UTF-8">
<title>Eventy</title>
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
		<div id="welcome">
			<h2>
				Welcome<%
				out.print(this.welcomeUser(session));
			%>
			</h2>
			<jsp:include page="components/message.jsp" />
			<p>Chuck prosciutto frankfurter strip steak. Cow pork loin shank,
				corned beef capicola drumstick biltong chicken swine brisket. Boudin
				pancetta spare ribs ham hock filet mignon bresaola. Ground round
				pastrami rump capicola boudin, shoulder pork loin spare ribs turkey
				beef pork belly. Pork belly hamburger chuck filet mignon biltong
				kevin cupim cow bresaola salami landjaeger ham hock corned beef
				jerky capicola. Sirloin turducken boudin turkey alcatra, ham hock
				filet mignon. Meatball cow cupim, tenderloin leberkas shoulder
				salami corned beef boudin pork belly capicola jerky pastrami pork
				loin. Pork chop swine t-bone, shank chicken brisket porchetta
				landjaeger capicola. Pig ball tip swine tri-tip, cupim ham pastrami
				ham hock frankfurter. Picanha capicola ham cow tongue boudin.
				Prosciutto sausage ham hock salami pork belly pork loin.</p>
		</div>
		<aside id="sidebar">Bacon ipsum dolor amet biltong ham pork
			belly, jerky rump kevin frankfurter meatloaf picanha kielbasa sausage
			andouille.</aside>
	</div>
	<footer id="footer"></footer>
</body>
</html>

<%!private String welcomeUser(HttpSession sess) {
		String rtn = "";
		User usr = (User) sess.getAttribute("user");

		if (usr != null) {
			rtn = ", " + usr.getUsername();
		}

		return rtn;
	}%>