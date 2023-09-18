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
    <title>Welcome to ICESI Scholar</title>
</head>
<body>

    <h1>Projects Table</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Students Count</th>
                <th>Status</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="proyecto" items="${proyectos}">
                <tr>
                    <td>${proyecto.title}</td>
                    <td>${proyecto.studentCount}</td>
                    <td>${proyecto.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
