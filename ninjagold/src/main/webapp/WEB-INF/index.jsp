<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Ninja Gold, yet again</title>
</head>

<body>
    <div class="container">
        <div class="header">
            <h2>Your Gold:
                <c:out value="${sessionScope.gold}" />
            </h2>
            <a href="/reset" class="button">Start Over</a>
        </div>

        <div class="building farm">
            <h3>Farm</h3>
            <p>(earns 10-20 gold)</p>
            <form action="/gold" method="POST">
                <input type="hidden" name="building" value="farm">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="building cave">
            <h3>Cave</h3>
            <p>(earns 5-10 gold)</p>
            <form action="/gold" method="POST">
                <input type="hidden" name="building" value="cave">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="building house">
            <h3>House</h3>
            <p>(earns 2-5 gold)</p>
            <form action="/gold" method="POST">
                <input type="hidden" name="building" value="house">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="building casino">
            <h3>Casino</h3>
            <p>(earns/takes 0-50 gold)</p>
            <form action="/gold" method="POST">
                <input type="hidden" name="building" value="casino">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="building spa">
            <h3>Spa</h3>
            <p>(takes 5-20 gold)</p>
            <form action="/gold" method="POST">
                <input type="hidden" name="building" value="spa">
                <input type="submit" value="Relax!">
            </form>
        </div>

        <h2>Activities</h2>
        <div class="activities">
            <c:forEach var="activity" items="${sessionScope.activities}">
                <p class='${activity.get("class")}'>
                    ${activity.get('result')}
                </p>
            </c:forEach>
        </div>
    </div>

</body>

</html>