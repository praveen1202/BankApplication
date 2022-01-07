<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <%
        if(session.getAttribute("name") != null){
            response.sendRedirect("features.jsp");
        }
    %>

    <div class = "form">
        <h2>Bread Bank</h2>
        <h2>Sign Up</h2>
        <form class="user-form" action="signup" method="POST">
            <label>Enter Name : </label><input type="text" name="name" required><br><br>
            <label>Enter Password : </label><input type="text" name="password1" required><br><br>
            <label>Re-Enter Password : </label><input type="text" name="password2" required><br>
            <span>${message}</span><br><br>
            <input class="btn" type="submit" value="Sign Up">
            <a href="login.jsp">Log In</a>
        </form>
    </div>
</body>
</html>