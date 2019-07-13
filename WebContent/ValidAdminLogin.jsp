<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<h1 align="center">Logged In Successfully</h1>
<hr>
<h2 align="center">
<%
	out.println("Welcome "+ request.getAttribute("loginName"));
%>
</h2>
<h2 align="center">	<a href="AdminInsert.html"style="text-align:center">Insert</a><br>
		<a href="AdminSearchU.jsp"style="text-align:center">Update</a><br>
		<a href="AdminSearchD.jsp"style="text-align:center">Delete</a><br>
		<a href="AdminDisplay.jsp"style="text-align:center">Display</a><br><br>
		<a href="AdminLogin.html" style="text-align:center">Back to Login Page</a>	
</h2>
</body>
</html>