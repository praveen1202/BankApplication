
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Features</title>
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<%
			if(session.getAttribute("name") == null){
				response.sendRedirect("login.jsp");
			}
		%>
		<div class="features">
			<h2>Hi, ${name}</h2>
			<h3>User ID: ${custID}</h3>
			<hr>
			<div class="menu">
				<button id="withDraw">Withdraw</button>
				<button id="deposit">Deposit</button>
				<button id="neft">Net Banking</button>

				<a href="transaction.jsp"><button>View Transaction History</button></a>
				<form action = "logout" method = "POST">
					<input type="submit" value="Log out">
				</form>
			</div>
			<hr>
			<div id="withdrawDiv" class="border">
				<form action = "withdraw" method = "POST" onsubmit="return amtt(this);">
					Enter Amount to be Withdrawn: <input type="text" name= "amt" required>
					<span>${withDrawMessage}</span><br><br>
					<input class="btn" type= "submit" value="Proceed">
					<br><br>
				</form>
			</div>
			<div id="depositDiv" class="border">
				<form action = "deposit" method = "POST" onsubmit="return amtt(this);">
					Enter Amount to be Deposited: <input type="text" name="amt" required><br>
					<span>${depositMessage}</span><br><br>
					<input class="btn" type="submit" value="Proceed">
					<br><br>
				</form>
			</div>
			<div id="neftDiv" class="border">
				<form action="neft" method="POST" onsubmit="return amtt(this);">
					Enter Recipient Account Number : <input type="text" name="acctNo" required><br><br>
					Enter Amount to be Transferred :<input type="text" name="amt" required><br>
					<span>${neftMessage}</span><br><br>
					<input class="btn" type="submit" value="Proceed">
					<br><br>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="js/script.js"></script>
		<script type="text/javascript" src="js/features.js"></script>
	</body>
</html>