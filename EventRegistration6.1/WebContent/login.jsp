<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Eventy | Login</title>
<link rel="stylesheet" type="text/css"
	href="vendor/css/Normalize.3.0.2.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>

	<div id="headerArea">
		<nav id="navNotLoggedIn"><jsp:include page="components/nav.jsp" /></nav>
		<header id="header"><jsp:include page="components/header.jsp" /></header>
	</div>
	<div id="main">
		<div>
			<h2>Login</h2>
			<jsp:include page="components/message.jsp" />
			<form method="post" action="../eventy/login">
				<input type="text" name="username" placeholder="username"></input> <input
					type="password" name="password" placeholder="password"></input>
				<button>Login</button>
			</form>
		</div>
	</div>
	<footer id="footer"></footer>
</body>

<script type="text/javascript" src="../vendor/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>