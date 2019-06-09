<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Add a Pet</title>
	<link rel="stylesheet" type="text/css" href="static/style.css" />
</head>

<body>
	<div class="container">
		<form action="/Pets/Dogs" method="get">
			<fieldset>
				<legend>Create a Dog</legend>
				<label for="name">Name of Dog</label>
				<input type="text" name="name">
				<label for="breed">Breed</label>
				<input type="text" name="breed">
				<label for="weight">Weight</label>
				<input type="number" name="weight">
				<button type="submit">Create a Dog</button>
			</fieldset>
		</form>
		<form action="/Pets/Cats" method="get">
			<fieldset>
				<legend>Create a Cat</legend>
				<label for="name">Name of Cat</label>
				<input type="text" name="name">
				<label for="breed">Breed</label>
				<input type="text" name="breed">
				<label for="weight">Weight</label>
				<input type="number" name="weight">
				<button type="submit">Create a Cat</button>
			</fieldset>
		</form>
	</div>
</body>

</html>