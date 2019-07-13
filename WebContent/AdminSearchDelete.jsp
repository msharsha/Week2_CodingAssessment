<%@page import="com.controller.EmpDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@page import="com.controller.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body bgcolor="#E6E6FA">
<h2 align="center">Delete Employee</h2>
<hr>
<h2 align="center">
<%
	out.println("<form action ='AdminDeleteServlet' method='POST'style='text-align:center'>");
	out.println("Employee Details :"+"<br>");
	out.println("ID : <input type='text' name='f1' value='"+request.getAttribute("eid") +"'/>"+"<br>");
	out.println("Name : <input type='text' name='f2' value='"+request.getAttribute("ename") +"'/>"+"<br>");
	out.println("Age : <input type='number' name='f3' value='"+request.getAttribute("eage") +"'/>"+"<br>");
	out.println("Password : <input type='password' name='f4' value='"+request.getAttribute("epwd") +"'/>"+"<br>");
	out.println("Role : <input type='text' name='f5' value='"+request.getAttribute("erole") +"'/>"+"<br>");
	out.println("<input type = 'submit' name='f6' value='DELETE'>");
	out.println("</form>");
%>
</h2>
</body>
</html>