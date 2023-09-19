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
            <th>Title</th>
            <th>Magazine Name</th>
            <th>Category</th>
            <th>Status</th>
        </tr>
        </thead>

        <tbody>
            ${articles}
        </tbody>
    </table>
    <br>
        <a href="${pageContext.request.contextPath}/addArticle">Add Article</a>
    <br>

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
            ${projects}
        </tbody>
    </table>
    <br>
        <a href="${pageContext.request.contextPath}/AddProject">Add Project</a>
    <br>
</body>
</html>
