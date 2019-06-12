<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Roster</title>
	<link rel="stylesheet" type="text/css" href="static/style.css">
</head>

<body>
	<div class="container">
		<h1>Team Roster</h1>
		<a href="/TeamRoster/Teams">Add a New Team</a>

		<table>
			<thead>
				<th>Team Name</th>
				<th>Players</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}" varStatus="idx">
					<tr>
						<td>${team.teamName}</td>
						<td>${team.getNumPlayers()}</td>
						<td>
							<a href="/TeamRoster/Teams?id=${idx.index}">Details</a>
							<a href="/TeamRoster/Teams?delete=true&id=${idx.index}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>