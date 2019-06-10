<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="static/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="static/script.js"></script>
	<title>Great Number Game</title>
</head>

<body>
	<div class="container">
		<h1>Welcome to the Great Number Game, Again!</h1>
		<h2>I am thinking of a number between
			<c:out value="${sessionScope.min}" /> and
			<c:out value="${sessionScope.max}" />.</h2>
		<c:choose>
			<c:when test="${sessionScope.chances > 1}">
				<h3>Can you guess it in
					<c:out value="${sessionScope.chances}" /> attempts or less?
				</h3>
			</c:when>
			<c:otherwise>
				<h3>Can you guess it in only 1 attempt?</h3>
			</c:otherwise>
		</c:choose>

		<!-- display win or loss or game still in progress -->
		<c:choose>
			<c:when test="${empty sessionScope.result}">
				<!-- display form for guessing -->
				<form action="/GreatNumberGame/Home" method="post">
					<input type="number" name="guess" min="<c:out
							value='${sessionScope.min}' />" max="<c:out
							value='${sessionScope.max}' />">
					<input type="submit" value="Guess">
				</form>
			</c:when>

			<c:otherwise>
				<c:choose>
					<c:when test="${sessionScope.result.equals('win')}">
						<div class="correct">
							<h3>You must be psychic! The number was
								<c:out value="${sessionScope.randNum}" />.
							</h3>
							<c:choose>
								<c:when test="${sessionScope.numTries == 1}">
									<p>It only took you
										<span>
											<c:out value="${sessionScope.numTries}" />
										</span>
										guess to get it right.</p>
								</c:when>
								<c:otherwise>
									<p>It took you
										<span>
											<c:out value="${sessionScope.numTries}" />
										</span>
										guesses to get it right.</p>
								</c:otherwise>
							</c:choose>

							<form action="/GreatNumberGame/Home" method="post">
								<input type="submit" name="playagain" value="Play Again!">
							</form>
						</div>
					</c:when>

					<c:when test="${sessionScope.result.equals('lose')}">
						<div class="wrong">
							<h3>Oh, you were on the edge of getting it right, but you ran out of chances!</h3>
							<p>The number was
								<c:out value="${sessionScope.randNum}" />.
							</p>
							<form action="/GreatNumberGame/Home" method="post">
								<input type="submit" name="playagain" value="Play Again!">
							</form>
						</div>
					</c:when>

					<c:otherwise>
						<div class="wrong">
							<h2>Nope, too
								<c:out value="${sessionScope.result}" />.
							</h2>

							<c:choose>
								<c:when test="${sessionScope.chances > 1}">
									<p>You have
										<c:out value="${sessionScope.chances - sessionScope.numTries}" />
										attempts left.
									</p>
								</c:when>
								<c:otherwise>
									<p>You only have 1 attempt left.</p>
								</c:otherwise>
							</c:choose>

						</div>

						<!-- display form for guessing -->
						<form action="/GreatNumberGame/Home" method="post">
							<input type="number" name="guess" min="<c:out value='${sessionScope.min}' />"
								max="<c:out value='${sessionScope.max}' />">
							<input type="submit" value="Guess">
						</form>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>


		<div class="custom-range">
			<h3>Want to try a different range?</h3>
			<button>Change Range!</button>

			<form action="/GreatNumberGame/Home" method="post">
				<label for="min">Bottom of range</label>
				<input type="number" name="min">
				<label for="max">Top of range</label>
				<input type="number" name="max">
				<input type="submit" name="customRange" value="Apply">
			</form>
		</div>

	</div>
</body>

</html>