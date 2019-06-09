<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Doggie Info</title>
	<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<div class="container pet-container">
		<p>You created a
			<c:out value="${dog.getBreed()}" />.
		</p>
		<p>
			<c:out value="${dog.showAffection()}" />
		</p>
	</div>
</body>

</html>