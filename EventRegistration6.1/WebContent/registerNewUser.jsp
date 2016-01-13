<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Eventy | Register</title>
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

		<h2>Register</h2>

		<jsp:include page="components/message.jsp" />

		<form name="registerForm" method="post" action="../eventy/register">
			<p id="userInfo">
				<input required type="text" placeholder="email" name="email">
				<input required type="text" placeholder="username" name="username">
				<input required type="password" placeholder="password"
					name="password"> <input required type="password"
					placeholder="confirm password" name="passwordConfirm">
			</p>

			<button onclick="validateFields()">Register</button>
			<button type="reset">Reset Form</button>
		</form>

	</div>
	<footer id="footer"></footer>
</body>

<script type="text/javascript" src="../vendor/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>