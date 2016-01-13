<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>An error has occured</title>
<link rel="stylesheet" type="text/css"
	href="vendor/css/Normalize.3.0.2.css">
</head>
<body>
	<h3>Details</h3>
	<p>
		<%this.printST(exception);%>
	</p>
</body>
</html>

<%!void printST(Throwable e) {
		e.printStackTrace();
	}%>