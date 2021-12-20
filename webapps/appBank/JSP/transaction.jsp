<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="css/styles.css">
	<title>Features</title>
	<script type="text/javascript" src="js/transactionReq.js"></script>
</head>
<body>
	<div class="response"></div>
	<%
		if(session.getAttribute("name") == null){
			response.sendRedirect("login.jsp");
		}
	%>
	<a href="features.jsp"><button>Features</button></a>
	<form action = "logout" method = "POST">
		<input type="submit" value="Log out">
	</form>
</body>
</html>
