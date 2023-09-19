<%--
  Created by IntelliJ IDEA.
  User: lyca22
  Date: 9/17/23
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Article</title>
</head>
<body>
<h2>Add a new article</h2>
<form method="post" action="${pageContext.request.contextPath}/SubmitArticle">
    <label for="title">Title:</label> <br>
    <input type="text" id="title" name="title" required minlength="4"> <br><br>
    <label for="magazine">Magazine:</label> <br>
    <select id="magazine" name="magazine" required>
        ${magazines}
    </select> <br><br>
    State: <br>
    <label for="accepted">Accepted</label>
    <input type="radio" id="accepted" name="state" value="ACP"><br>

    <label for="in-revision">In revision</label>
    <input type="radio" id="in-revision" name="state" value="REV"><br>

    <label for="development">Development</label>
    <input type="radio" id="development" name="state" value="DES"><br>

    <input type="submit" value="Submit article!">
</form>
<br>
<a href="${pageContext.request.contextPath}/${username}">Welcome</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/AddMagazine">Add Magazine</a>
<br>
</body>
</html>
