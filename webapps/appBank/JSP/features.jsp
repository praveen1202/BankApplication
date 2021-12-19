
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!DOCTYPE html>
<html lang="en">
<head></head>
<body>
	<% 	
		response.setIntHeader("Refresh", 5);
		
		String name = request.getParameter("name").toString();
		out.println(name);
		String lab = request.getAttribute("lab").toString();
		out.println(lab);
	%>
	<%-- <c:out value = "${name}" /> --%>
</body>
</html>