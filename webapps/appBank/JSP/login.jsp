<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="login-body">
    <%
        if(session.getAttribute("name") != null){
            response.sendRedirect("features.jsp");
        }
    %>
    <div class="form">
        <h2>Bread Bank</h2>
        <h2>Log In</h2>
        <form class="user-form" action="auth" method="POST" onsubmit="return login(this);">       <%-- remove sample function (just a example for js validation --%>

            <label>Enter UserID : </label><input type="text" name="custID" required><br><br>
            <label>Enter Password : </label><input type="password" name="password" required><br>
            <span>${message}</span><br>
            <input class="btn" type="submit" value="Log In">
            <a href="signup.jsp">Create Account</a>
        </form>
        
    </div>
    <script type="text/javascript" src="js/logReq.js"></script>
</body>
</html>