<html>
<head>

<!-- Added to show values in jsp while using ${} experssion as jsp is older version being used here -->
<%@ page isELIgnored="false" %>
<title>Hello</title>
</head>
<body>

	<%
	Integer id = (Integer)request.getAttribute("id");
	String name = (String)request.getAttribute("name");
	Integer salary = (Integer)request.getAttribute("salary");
	out.println("ID:- "+id);
	out.println("NAME:- "+name);
	out.println("SALARY:- "+salary);
	%>
	
	<br/>
	ID:- <em> ${id} </em>
	Name:- <em> ${name} </em>
	Salary:- <em> ${salary} </em>
</body>
</html>