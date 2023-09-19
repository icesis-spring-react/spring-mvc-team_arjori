<%--
  Created by IntelliJ IDEA.
  User: lyca22
  Date: 9/17/23
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Magazine</title>
</head>
<body>
    <h1>Add Project</h1>

    <form method="post" action="${pageContext.request.contextPath}/SubmitAddMagazine">
        <label for="title">Title:</label> <br>
        <input type="text" id="title" name="title" required minlength="4"> <br><br>

        <label for="ISBN">ISBN:</label> <br>
        <input type="text" id="ISBN" name="isbn" required min="5"> <br><br>

        <input type="radio" id="indexed" name="magazineType" value="IDX">
        <label for="indexed">Indexed</label><br>

        <input type="radio" id="non_indexed" name="magazineType" value="NONIDX">
        <label for="non_indexed">Non Indexed</label><br> <br>

        <input type="submit" value="New Magazine">

        <br> <br>

        <a href="${pageContext.request.contextPath}/GoBack">Go back to article page</a>
        <br>
    </form>
</body>
</html>
