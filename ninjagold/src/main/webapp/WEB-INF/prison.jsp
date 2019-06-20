<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/prison.css">
    <title>Ninja Gold - Debtors Prison</title>
</head>

<body>
    <div class="container">
        <div class="prison">
            <h1>Game Over!</h1>
            <h2>Oh no! You've accumulated debt in the amount of
                <c:out value="${sessionScope.gold}" /> and have gone to debtors prison!!</h2>
            <a href="/reset" class="button">Wash dishes, peel potatoes and try again!</a>
        </div>
    </div>

</body>

</html>