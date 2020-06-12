<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="tech.nikant.springmvc.dto.Employee,java.util.List"%>
    
<!-- Importing JSTL library -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- Added to show values in jsp as older version being used here -->
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Display List</title>
</head>
<body>
	<!-- This is Using Scriplet tag -->
	<%
		List<Employee> list = (List<Employee>) request.getAttribute("employeeList");
		for(Employee e : list){
			out.print(e.getId());
			out.print(e.getName());
			out.print(e.getSalary());
		}
	%>
	<br/>
	<!-- This is using proper JSTL -->
	<c:forEach var="list" items="${employeeList}"> 
		<b><c:out value="${list.id}" /></b>
		<b><c:out value="${list.name}" /></b>
		<b><c:out value="${list.salary}" /></b>
		<br/>
	</c:forEach>
</body>
</html>