<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bank Application</title>
    </head>
    <body>
        <%
            if(session.getAttribute("name") != null){
                response.sendRedirect("JSP/features.jsp");
            }
        %>
        New User? <a href="JSP/signup.jsp"><button id="signup">Sign Up</button></a>
        
        <br>
        Registered User? <a href="JSP/login.jsp"><button id="login">Log In</button></a>
        <br>
    </body>
</html>