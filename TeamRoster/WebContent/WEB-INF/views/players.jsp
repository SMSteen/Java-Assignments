<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>
		<c:out value="${team.teamName}" />
		Team
	</title>
	<link rel="stylesheet" type="text/css" href="static/style.css">
</head>

<body>
	<div class="container">
		<h1>
			<c:out value="${team.teamName}" />
			Roster
		</h1>
		<a href="/TeamRoster/Players?id=${teamID}">Add a New Player</a>

		<table>
			<thead>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach var="player" items="${team.getPlayers()}" varStatus="idx">
					<tr>
						<td>${player.firstName}</td>
						<td>${player.lastName}</td>
						<td>${player.age}</td>
						<td>
							<a href="/TeamRoster/Players?delete=true&teamid=${teamID}&playerid=${idx.index}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/TeamRoster/Home">View Teams</a>
	</div>
</body>

</html>