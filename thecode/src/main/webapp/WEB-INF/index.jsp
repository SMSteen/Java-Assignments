<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Secret Code</title>
</head>

<body>
    <div class="container">
        <form action="/login" method="POST">
            <p class="error">
                <c:out value="${error}" />
            </p>
            <fieldset>
                <legend>Enter the Code</legend>
                <input type="password" name="pwd">
                <input type="submit" value="Try Code">
            </fieldset>
        </form>
    </div>
</body>

</html>