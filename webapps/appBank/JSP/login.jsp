<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <%
        if(session.getAttribute("name") != null){
            response.sendRedirect("features.jsp");
        }
    %>
    <form action="auth" method="POST">
        Enter UserID : <input type="text" name="custID"><br>
        Enter Password : <input type="text" name="password"><br>
        <span>${message}</span><br>
        <input type="submit" value="Log In">
    </form>
    <a href="signup.jsp"><button>Sign Up</button></a>
</body>
</html>