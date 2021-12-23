<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
</head>
<body>
    <form action="signup" method="POST">
        Enter Name : <input type="text" name="name"><br>
        Enter Password : <input type="text" name="password1"><br>
        Re-Enter Password : <input type="text" name="password2"><br>
        <input type="submit" value="Sign Up">
    </form>
</body>
</html>