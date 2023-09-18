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
    <title>Add Project</title>
</head>
<body>
    <h1>Add Project</h1>

    <form method="post" action="${pageContext.request.contextPath}/SubmitAddProject">
        <label for="title">Title:</label> <br>
        <input type="text" id="title" name="title" required minlength="4"> <br><br>

        <label for="StudentsCount">Students Count:</label> <br>
        <input type="number" id="StudentsCount" name="studentsCount" required min="1"> <br><br>

        <input type="radio" id="completed" name="projectStatus" value="COM">
        <label for="completed">Completed</label><br>

        <input type="radio" id="in_progress" name="projectStatus" value="PRO">
        <label for="in_progress">In Progress</label><br> <br>

        <input type="submit" value="New Project">

        <br> <br>

        <a href="${pageContext.request.contextPath}/GoBack">Go back to welcome page</a>
        <br>
    </form>
</body>
</html>
