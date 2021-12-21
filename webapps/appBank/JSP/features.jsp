
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="css/styles.css" >
	<title>Features</title>
</head>
<body>


	<%
		if(session.getAttribute("name") == null){
			response.sendRedirect("login.jsp");
		}
%>
	hi, ${name}

	<br>
	<button id="withDraw">Withdraw</button><br>
	<div id="withdrawDiv">
		<form action = "withdraw" method = "POST">
			Enter Amount to be Withdrawn: <input type="text" name="amt" >
			<input type="submit" value="Withdraw">
		</form>
	</div>
	
	<button id="deposit">Deposit</button><br>
	<div id="depositDiv">
		<form action = "deposit" method = "POST">
			Enter Amount to be Deposited: <input type="text" name="amt" >
			<input type="submit" value="Deposit">
		</form>
	</div>

	<button id="neft">Net Banking</button><br>
	<div id="neftDiv">Bye</div>

	<a href="transaction.jsp"><button>View Transaction History</button></a>
	<form action = "logout" method = "POST">
		<input type="submit" value="Log out">
	</form>
	<%-- <% 	
		response.setIntHeader("Refresh", 5);

		String name = request.getParameter("name").toString();
		out.println(name);
		String lab = request.getAttribute("lab").toString();
		out.println(lab);
	%> --%>
	<%-- <c:out value = "${name}" /> --%>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>