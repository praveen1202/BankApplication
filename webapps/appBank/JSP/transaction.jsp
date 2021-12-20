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
