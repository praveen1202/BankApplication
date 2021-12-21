<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Transaction Details</title>
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="response"></div>
	<%
		if(session.getAttribute("name") == null){
			response.sendRedirect("login.jsp");
		}
	%>
	<button id="viewtransaction">View Transaction History</button>
	<div class="balance"></div>
	<button id="viewbalance">View Balance</button>
	<a href="features.jsp"><button>Features</button></a>
	<form action = "logout" method = "POST">
		<input type="submit" value="Log out">
	</form>
	<script type="text/javascript" src="js/transactionReq.js"></script>
</body>
</html>
