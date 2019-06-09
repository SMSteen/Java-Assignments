<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Clicker Game</title>
	<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<div class="container">
		<form action="/ButtonClicker/Counter" method="post">
			<input type="submit" name="button" value="Click Me!">
		</form>
		<p>
			You've clicked the button
			<span>
				<c:out value="${sessionScope.counter}" />
			</span>
			times!
		</p>
		<p>
			<a href="/ButtonClicker/Counter?reset=true">Reset Counter</a>
		</p>
	</div>
</body>

</html>