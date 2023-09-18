<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h2>Sign In to ICESI Scholar</h2>
<form method="post" action="${pageContext.request.contextPath}/SubmitSignIn">
    <label for="username">Username:</label> <br>
    <input type="text" id="username" name="username" required minlength="4"> <br><br>

    <label for="password">Password:</label> <br>
    <input type="password" id="password" name="password" required minlength="4"> <br><br>

    <input type="submit" value="Sign In!">
</form>
</body>
</html>