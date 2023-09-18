<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to ICESI Scholar</title>
</head>
<body>
    <h2>Welcome ${fullName}.</h2>
    <h3>Academic Grade: ${academicGrade}.</h3>

    <h2>Articles</h2>

    <table border="1">
        <thead>
        <tr>
            <th>Magazine Name</th>
            <th>Category</th>
            <th>Status</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="article" items="${articles}">
            <tr>
                <td>${article.title}</td>
                <td>${article.studentCount}</td>
                <td>${article.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table> <br> <button id="addArticle" name="addArticle">+</button> <br>

    <h2>Projects</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Students Count</th>
                <th>Status</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.title}</td>
                    <td>${project.studentCount}</td>
                    <td>${project.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table> <br> <button id="addProject" name="addProject">+</button> <br>
</body>
</html>
