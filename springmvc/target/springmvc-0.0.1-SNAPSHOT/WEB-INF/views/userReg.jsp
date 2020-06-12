<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Added to show values in jsp as older version being used here -->
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form action="registerUser" method="post">
		<pre>
	Id: <input type="text" name="id">
	Name: <input type="text" name="name">
	Email: <input type="text" name="email">
	<input type="submit" value="register">
</pre>
	</form>
</body>
</html>