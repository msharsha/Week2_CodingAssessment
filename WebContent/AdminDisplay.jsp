<%@page import="com.bean.Employee"%>
<%@page import="com.bean.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.apache.naming.factory.BeanFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<h1 align="center">
	EMPLOYEES AND THIER DETAIILS
</h1>
<%
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	EmpDao obj = (EmpDao)context.getBean("empdao");
	List<Employee> employeeList = new ArrayList<>();
	employeeList = obj.display();
	%>
	<table border=1 align=center style="text-align:center">
    <thead>
        <tr>
           <th>ID</th>
           <th>NAME</th>
           <th>AGE</th>
           <th>ROLE</th>
        </tr>
    </thead>
    <tbody> 
    	<%
    		for(Employee e: employeeList){
    	%>
    		<tr>
    		<td><%=e.getId() %></td>
    		<td><%=e.getName() %></td>
    		<td><%=e.getAge() %></td>
    		<td><%=e.getRole() %></td>
    		</tr>
    <%
    	}
    %>
    	
	</tbody>
	</table><br>
	<a href="AdminLogin.html" style="text-align:center">Back to Login Page</a>	
</body>
</html>