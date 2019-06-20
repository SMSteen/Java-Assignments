<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Dojo Survey Results</title>
</head>

<body>
    <div class="container">
        <h2>Submitted Info</h2>

        <div class="labels">
            <p>Name:</p>
            <p>Dojo Location:</p>
            <p>Favorite Language:</p>
            <p>Comment:</p>
        </div>

        <div class="values">
            <p>
                <c:out value="${sessionScope.name}" />
            </p>
            <p>
                <c:out value="${sessionScope.dojo}" />
            </p>
            <p>
                <c:out value="${sessionScope.language}" />
            </p>
            <p>
                <c:out value="${sessionScope.comment}" />
            </p>
        </div>

        <a class="button" href="/">Go Back</a>
    </div>
</body>

</html>