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
    <form action="auth" method="POST">
        Enter Username : <input type="text" name="name"><br>
        Enter Password : <input type="text" name="password"><br>
        <input type="submit" name="submit">
    </form>
</body>
</html>