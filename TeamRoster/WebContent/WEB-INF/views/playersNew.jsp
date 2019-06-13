<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Add New Player</title>
	<link rel="stylesheet" type="text/css" href="static/style.css">
	<link rel="stylesheet" type="text/css" href="static/forms.css">
</head>

<body>
	<div class="container">
		<form action="/TeamRoster/Players?id=${teamID}" method="POST">
			<c:forEach var="error" items="${sessionScope.errors}">
				<p class="error">${error}</p>
			</c:forEach>
			<fieldset>
				<legend>Add a New Player</legend>
				<label for="firstName">First Name:</label>
				<input type="text" name="firstName">

				<label for="lastName">Last Name:</label>
				<input type="text" name="lastName">

				<label for="age">Age:</label>
				<input type="number" name="age">
				<div class="button-container">
					<input type="submit" value="Add Player">
					<a class="button" href="/TeamRoster/Teams?id=${teamID}">Cancel</a>
				</div>
			</fieldset>
		</form>
	</div>
</body>

</html>