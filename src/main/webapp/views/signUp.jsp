<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h2>Sign Up to ICESI Scholar</h2>
<form method="post" action="${pageContext.request.contextPath}/SubmitSignUp">
    <label for="username">Username:</label> <br>
    <input type="text" id="username" name="username" required minlength="4"> <br><br>

    <label for="password">Password:</label> <br>
    <input type="password" id="password" name="password" required minlength="4"> <br><br>

    <label for="academicDegree">Academic Degree:</label> <br>
    <select id="academicDegree" name="academicDegree" required>
        <option value="BA">Bachelor of Arts (B.A.)</option>
        <option value="BSc">Bachelor of Science (B.Sc.)</option>
        <option value="MA">Master of Arts (M.A.)</option>
        <option value="MSc">Master of Science (M.Sc.)</option>
        <option value="PhD">Doctor of Philosophy (Ph.D.)</option>
    </select> <br><br>

    <label for="fullName">Full Name:</label> <br>
    <input type="text" id="fullName" name="fullName" required minlength="4"> <br><br>

    <input type="submit" value="Sign Up!">
</form>
</body>
</html>