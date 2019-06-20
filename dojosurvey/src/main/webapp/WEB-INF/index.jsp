<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Dojo Survey</title>
</head>

<body>
    <div class="container">
        <form action="/" method="POST">
            <p class="error">
                <c:out value="${error}" />
            </p>
            <fieldset>
                <legend>Take the Survey</legend>

                <label for="name">Your Name:</label>
                <input type="text" name="name">

                <label for="dojo">Dojo location:</label>
                <select name="dojo">
                    <option value="Online">Online</option>
                    <option value="Wilmington NC">Wilmington</option>
                    <option value="Seattle WA">Seattle</option>
                    <option value="Burbank CA">Burbank</option>
                    <option value="Washington DC">Washington DC</option>
                </select>

                <label for="language">Favorite Language:</label>
                <select name="language">
                    <option value="JavaScript">JavaScript</option>
                    <option value="Python">Python</option>
                    <option value="HTML">HTML</option>
                    <option value="CSS">CSS</option>
                    <option value="Java">Java</option>
                </select>

                <label for="comment">Comment (optional):</label>
                <textarea name="comment" cols="85" rows="5"></textarea>

                <input type="submit" value="Submit">
            </fieldset>
        </form>
    </div>
</body>

</html>