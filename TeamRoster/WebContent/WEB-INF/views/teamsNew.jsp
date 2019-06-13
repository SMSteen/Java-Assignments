<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Add New Team</title>
	<link rel="stylesheet" type="text/css" href="static/style.css">
	<link rel="stylesheet" type="text/css" href="static/forms.css">
</head>

<body>
	<div class="container">
		<form action="/TeamRoster/Teams" method="POST">
			<c:forEach var="error" items="${sessionScope.errors}">
				<p class="error">${error}</p>
			</c:forEach>
			<fieldset>
				<legend>Add a New Team</legend>
				<label for="name">Team Name:</label>
				<input type="text" name="name">
				<div class="button-container">
					<input type="submit" value="Create">
					<a class="button" href="/TeamRoster/Home">Cancel</a>
				</div>
			</fieldset>
		</form>
	</div>
</body>

</html>