<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Added to show values in jsp while using ${} experssion as jsp is older version being used here -->
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
<%= request.getAttribute("employee") %>
<br/>
Id: <b>${employee.id}</b>
Name: <b>${employee.name}</b>
Salary: <b>${employee.salary}</b>
</body>
</html>